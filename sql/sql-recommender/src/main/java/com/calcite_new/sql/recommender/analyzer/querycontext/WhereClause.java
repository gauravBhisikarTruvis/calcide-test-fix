package com.calcite_new.sql.recommender.analyzer.querycontext;

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
