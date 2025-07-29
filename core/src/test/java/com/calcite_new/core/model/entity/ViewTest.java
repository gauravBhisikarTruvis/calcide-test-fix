package com.calcite_new.core.model.entity;

import com.calcite_new.core.model.Identifier;
import com.calcite_new.core.model.entity.Column;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    @Test
    void testView() {
        Identifier id = Mockito.mock(Identifier.class);
        Column col = Mockito.mock(Column.class);
        View view = new View(Collections.singletonList(id), id, Collections.singletonList(col), "sql", 1L);
        assertNotNull(view);
        assertNotNull(view.toString());
    }
}
