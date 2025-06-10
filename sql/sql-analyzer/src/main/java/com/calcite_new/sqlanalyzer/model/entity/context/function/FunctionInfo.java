package com.calcite_new.sqlanalyzer.model.entity.context.function;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FunctionInfo {
    private String function;
    private Boolean isDeterministic;
}
