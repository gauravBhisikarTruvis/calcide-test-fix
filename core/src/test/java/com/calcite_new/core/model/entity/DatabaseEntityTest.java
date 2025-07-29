package com.calcite_new.core.model.entity;

import com.calcite_new.core.model.Identifier;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseEntityTest {
    static class DummyDatabaseEntity extends DatabaseEntity {
        public DummyDatabaseEntity() { super(Collections.emptyList(), null, 0L); }
        @Override public EntityKind getKind() { return EntityKind.TABLE; }
    }
    @Test
    void testDatabaseEntity() {
        DummyDatabaseEntity entity = new DummyDatabaseEntity();
        assertNotNull(entity);
        assertNotNull(String.valueOf(entity));
    }
}
