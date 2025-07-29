package com.calcite_new.sql.model.entity;

import com.calcite_new.sql.relationextractor.Entity;
import com.calcite_new.sql.relationextractor.RelationshipType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntityRelationshipTest {

    @Test
    void testBuilderAndGetters() {
        Entity source = new Entity();
        Entity target = new Entity();
        EntityRelationship er = EntityRelationship.builder()
                .id(10L)
                .sourceEntity(source)
                .targetEntity(target)
                .relationshipType(RelationshipType.DEPENDS_ON)
                .sqlStatementInfo(null)
                .build();
        assertEquals(10L, er.getId());
        assertEquals(source, er.getSourceEntity());
        assertEquals(target, er.getTargetEntity());
        assertEquals(RelationshipType.DEPENDS_ON, er.getRelationshipType());
        assertNull(er.getSqlStatementInfo());
    }

    @Test
    void testSetters() {
        EntityRelationship er = new EntityRelationship();
        er.setId(2L);
        er.setSourceEntity(null);
        er.setTargetEntity(null);
        er.setRelationshipType(null);
        er.setSqlStatementInfo(null);
        assertEquals(2L, er.getId());
        assertNull(er.getSourceEntity());
        assertNull(er.getTargetEntity());
        assertNull(er.getRelationshipType());
        assertNull(er.getSqlStatementInfo());
    }
}
