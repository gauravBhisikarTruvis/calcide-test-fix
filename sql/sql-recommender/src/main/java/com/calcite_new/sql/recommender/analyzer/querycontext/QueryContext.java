package com.calcite_new.sql.recommender.analyzer.querycontext;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class QueryContext {
    private SelectClause selectClause;
    private WhereClause whereClause;
    private FromClause fromClause;
    private GroupByClause groupByClause;
    private HavingClause havingClause;
    private OrderByClause orderByClause;
    private LimitClause limitClause;
    private List<WithClause> cteDefinitions;
    private List<JoinInfo> joins;
    private List<WindowFunctionInfo> windowFunctions;
    private List<FunctionInfo> functionList;

    public void merge(QueryContext other) {
        if (other == null) return;
        if (other.selectClause != null) this.selectClause = other.selectClause;
        if (other.whereClause != null) this.whereClause = other.whereClause;
        if (other.groupByClause != null) this.groupByClause = other.groupByClause;
        if (other.havingClause != null) this.havingClause = other.havingClause;
        if (other.orderByClause != null) this.orderByClause = other.orderByClause;
        if (other.limitClause != null) this.limitClause = other.limitClause;
    }
}
