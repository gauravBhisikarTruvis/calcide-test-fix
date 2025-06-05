package com.calcite_new.sql.analyzer.model.context.function;

import java.util.List;

public class WindowFunctionInfo {
    private String functionName;
    private List<String> partitionByCol;
    private List<String> orderByCol;

}
