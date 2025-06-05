package com.calcite_new.sql.recommender.analyzer.querycontext;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FunctionInfo {
    private String function;
    private boolean isDeterministic;
}
