package com.calcite_new.sql.model.entity.context.function;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionInfoTest {

    @Test
    void testFields() {
        FunctionInfo info = new FunctionInfo();
        info.setFunction("f");
        info.setIsDeterministic(true);
        assertEquals("f", info.getFunction());
        assertTrue(info.getIsDeterministic());
    }
}
