package com.calcite_new.core.model.entity;

import com.calcite_new.core.dialect.Dialect;
import com.calcite_new.core.model.Identifier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class ColumnTest {
    @Test
    void testColumn() {
        Identifier id = Mockito.mock(Identifier.class);
        com.calcite_new.core.model.entity.DataType dt = Mockito.mock(com.calcite_new.core.model.entity.DataType.class);
        Column col = new Column(id, 1, dt, true);
        assertNotNull(col);
        assertNotNull(col.toString());
    }
}
