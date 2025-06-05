package com.calcite_new.sql.analyzer.model.context.function;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FunctionInfo {
    private String function;
    private boolean isDeterministic;
}
