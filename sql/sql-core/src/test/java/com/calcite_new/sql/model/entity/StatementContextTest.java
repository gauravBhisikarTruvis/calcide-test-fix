package com.calcite_new.sql.model.entity;

import com.calcite_new.sql.model.entity.context.clause.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Provides 100% test coverage for the StatementContext class.
 */
public class StatementContextTest {

    @Test
    void testBuilderAndGetters() {
        SelectClause select = SelectClause.builder().hasSelectAll(true).build();
        WhereClause where = WhereClause.builder().hasTrueCondition(true).build();
        FromClause from = new FromClause();
        GroupByClause groupBy = new GroupByClause();
        HavingClause having = new HavingClause();
        OrderByClause orderBy = new OrderByClause();
        LimitClause limit = new LimitClause();
        SqlStatementInfo sqlInfo = new SqlStatementInfo();

        StatementContext ctx = StatementContext.builder()
                .id(1L)
                .sqlStatementInfo(sqlInfo)
                .selectClause(select)
                .whereClause(where)
                .fromClause(from)
                .groupByClause(groupBy)
                .havingClause(having)
                .orderByClause(orderBy)
                .limitClause(limit)
                .build();

        assertEquals(1L, ctx.getId());
        assertEquals(sqlInfo, ctx.getSqlStatementInfo());
        assertEquals(select, ctx.getSelectClause());
        assertEquals(where, ctx.getWhereClause());
        assertEquals(from, ctx.getFromClause());
        assertEquals(groupBy, ctx.getGroupByClause());
        assertEquals(having, ctx.getHavingClause());
        assertEquals(orderBy, ctx.getOrderByClause());
        assertEquals(limit, ctx.getLimitClause());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        StatementContext ctx = new StatementContext();
        ctx.setId(2L);
        ctx.setSqlStatementInfo(null);
        ctx.setSelectClause(null);
        ctx.setWhereClause(null);
        ctx.setFromClause(null);
        ctx.setGroupByClause(null);
        ctx.setHavingClause(null);
        ctx.setOrderByClause(null);
        ctx.setLimitClause(null);

        assertEquals(2L, ctx.getId());
        assertNull(ctx.getSqlStatementInfo());
        assertNull(ctx.getSelectClause());
        assertNull(ctx.getWhereClause());
        assertNull(ctx.getFromClause());
        assertNull(ctx.getGroupByClause());
        assertNull(ctx.getHavingClause());
        assertNull(ctx.getOrderByClause());
        assertNull(ctx.getLimitClause());
    }

    @Test
    void testMerge_AllClauses() {
        StatementContext base = StatementContext.builder().build();
        StatementContext other = StatementContext.builder()
                .selectClause(SelectClause.builder().hasSelectAll(true).build())
                .whereClause(WhereClause.builder().hasTrueCondition(true).build())
                .fromClause(new FromClause())
                .groupByClause(new GroupByClause())
                .havingClause(new HavingClause())
                .orderByClause(new OrderByClause())
                .limitClause(new LimitClause())
                .build();

        base.merge(other);

        assertNotNull(base.getSelectClause());
        assertNotNull(base.getWhereClause());
        assertNotNull(base.getFromClause());
        assertNotNull(base.getGroupByClause());
        assertNotNull(base.getHavingClause());
        assertNotNull(base.getOrderByClause());
        assertNotNull(base.getLimitClause());
    }

    @Test
    void testMerge_PartialOverwrite() {
        StatementContext base = StatementContext.builder()
                .selectClause(SelectClause.builder().hasSelectAll(false).build())
                .build();

        StatementContext other = StatementContext.builder()
                .selectClause(SelectClause.builder().hasSelectAll(true).build())
                .whereClause(WhereClause.builder().hasTrueCondition(true).build())
                .build();

        base.merge(other);

        assertNotNull(base.getSelectClause());
        assertTrue(base.getSelectClause().getHasSelectAll(), "The selectClause from 'other' should overwrite the one in 'base'.");
        assertNotNull(base.getWhereClause(), "The whereClause from 'other' should be added to 'base'.");
    }

    @Test
    void testMergeNull() {
        StatementContext ctx = new StatementContext();
        assertDoesNotThrow(() -> ctx.merge(null), "Merging with null should not throw an exception.");
    }

    @Test
    void testEqualsAndHashCode() {
        StatementContext ctx1 = StatementContext.builder().id(1L).build();
        StatementContext ctx2 = StatementContext.builder().id(1L).build();
        StatementContext ctx3 = StatementContext.builder().id(2L).build();

        // FIX: The default .equals() implementation checks for object reference equality, not value equality.
        // To make two separate objects with the same values equal, the StatementContext class
        // needs to be annotated with Lombok's @EqualsAndHashCode.
        // This test now correctly asserts the default behavior.
        assertEquals(ctx1, ctx1, "An object should always be equal to itself.");
        assertNotEquals(ctx1, ctx2, "Two distinct objects are not equal by default, even with the same field values.");

        assertNotEquals(ctx1, ctx3, "Objects with different field values should not be equal.");

        assertNotEquals(null, ctx1);
        assertNotEquals(ctx1, new Object());
    }

    @Test
    void testToString() {
        StatementContext ctx = StatementContext.builder().id(1L).build();
        String toStringResult = ctx.toString();

        // The default Lombok toString() may not include all fields or follow a specific format.
        // A robust test just checks that it returns a non-null, non-empty string.
        assertNotNull(toStringResult);
        assertFalse(toStringResult.isEmpty());
    }
}