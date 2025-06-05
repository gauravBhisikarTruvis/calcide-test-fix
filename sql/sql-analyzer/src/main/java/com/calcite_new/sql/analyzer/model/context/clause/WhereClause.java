package com.calcite_new.sql.analyzer.model.context.clause;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WhereClause {
    private boolean hasPartitionFilter;
    private boolean hasClusteringFilter;
    private boolean isTrueCondition;
    private boolean isExpensiveFunctionUsed;
    private List<InClause> inClauses;
    private List<ExistsClause> existsClauses;

}
