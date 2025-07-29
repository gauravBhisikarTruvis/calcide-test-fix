package com.calcite_new.core.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    static class DummyEntity implements Entity {
        // Removed @Override annotations, since Entity has no methods
        public EntityKind getKind() { return EntityKind.TABLE; }
        public String toString() { return String.valueOf(this.hashCode()); }
    }
    @Test
    void testEntity() {
        DummyEntity entity = new DummyEntity();
        assertNotNull(entity);
        assertNotNull(entity.toString());
    }
}
