package com.calcite_new.core.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntityKindTest {
    @Test
    void testEntityKindEnum() {
        for (EntityKind kind : EntityKind.values()) {
            assertNotNull(kind.name());
            assertNotNull(kind.toString());
        }
    }
}
