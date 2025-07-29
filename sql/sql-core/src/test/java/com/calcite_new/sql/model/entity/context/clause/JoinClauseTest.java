package com.calcite_new.sql.model.entity.context.clause;

import com.calcite_new.core.model.entity.Entity;
import org.apache.calcite.sql.JoinType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JoinClauseTest {

    @Test
    void testFields() {
        JoinClause clause = new JoinClause();
        Entity left = null;
        Entity right = null;
        clause.setLeftTable(left);
        clause.setRightTable(right);
        clause.setJoinType(JoinType.INNER);
        clause.setIsEquiJoin(true);
        clause.setJoinCondition("cond");
        clause.setIsJoinOnStringColumn(false);
        assertNull(clause.getLeftTable());
        assertNull(clause.getRightTable());
        assertEquals(JoinType.INNER, clause.getJoinType());
        assertTrue(clause.getIsEquiJoin());
        assertEquals("cond", clause.getJoinCondition());
        assertFalse(clause.getIsJoinOnStringColumn());
    }
}
