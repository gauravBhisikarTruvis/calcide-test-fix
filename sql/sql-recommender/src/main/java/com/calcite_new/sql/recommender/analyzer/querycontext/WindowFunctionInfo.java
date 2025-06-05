package com.calcite_new.sql.recommender.analyzer.querycontext;

import java.util.List;

public class WindowFunctionInfo {
    private String functionName;
    private List<String> partitionByCol;
    private List<String> orderByCol;

}
