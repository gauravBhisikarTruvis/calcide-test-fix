package com.calcite_new.sql.model.entity.context.function;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WindowFunctionInfoTest {

    @Test
    void testFields() {
        WindowFunctionInfo info = new WindowFunctionInfo();
        info.setFunctionName("win");
        info.setPartitionByCol(List.of("a"));
        info.setOrderByCol(List.of("b"));
        assertEquals("win", info.getFunctionName());
        assertEquals(List.of("a"), info.getPartitionByCol());
        assertEquals(List.of("b"), info.getOrderByCol());
    }
}
