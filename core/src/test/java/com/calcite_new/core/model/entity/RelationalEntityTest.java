package com.calcite_new.core.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.List;

class RelationalEntityTest {
    static class DummyRelationalEntity implements RelationalEntity {
        public EntityKind getKind() { return EntityKind.TABLE; }
        @Override
        public List<Column> getColumns() {
            return Collections.emptyList();
        }
        public String toString() { return String.valueOf(this.hashCode()); }
    }
    @Test
    void testRelationalEntity() {
        DummyRelationalEntity entity = new DummyRelationalEntity();
        assertNotNull(entity);
        assertNotNull(entity.toString());
        assertNotNull(entity.getColumns());
    }
}
