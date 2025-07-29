package com.calcite_new.core.model.entity;

import com.calcite_new.core.model.Identifier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    @Test
    void testTable() {
        Identifier id = Mockito.mock(Identifier.class);
        Column col = Mockito.mock(Column.class);
        Table table = new Table(Collections.singletonList(id), id, Collections.singletonList(col), 1L);
        assertNotNull(table);
        assertNotNull(table.toString());
    }
}
