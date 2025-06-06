package com.calcite_new.sqlanalyzer.model.entity.context.clause;

import com.calcite_new.sqlanalyzer.relationextractor.Entity;
import lombok.Getter;
import lombok.Setter;
import org.apache.calcite.sql.JoinType;

@Setter
@Getter
public class JoinClause {
    private Entity leftTable;
    private Entity rightTable;
    private JoinType joinType;
    private boolean isEquiJoin;
    private String joinCondition;
    private boolean isJoinOnStringColumn;
}
