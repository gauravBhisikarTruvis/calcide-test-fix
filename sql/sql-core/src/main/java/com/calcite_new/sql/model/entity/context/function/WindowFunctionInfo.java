package com.calcite_new.sql.model.entity.context.function;

import java.util.List;

public class WindowFunctionInfo {

    private String functionName;
    private List<String> partitionByCol;
    private List<String> orderByCol;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<String> getPartitionByCol() {
        return partitionByCol;
    }

    public void setPartitionByCol(List<String> partitionByCol) {
        this.partitionByCol = partitionByCol;
    }

    public List<String> getOrderByCol() {
        return orderByCol;
    }

    public void setOrderByCol(List<String> orderByCol) {
        this.orderByCol = orderByCol;
    }
}
