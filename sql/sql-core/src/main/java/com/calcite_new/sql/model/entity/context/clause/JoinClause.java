package com.calcite_new.sql.model.entity.context.clause;

import com.calcite_new.core.model.entity.Entity;
import lombok.Getter;
import lombok.Setter;
import org.apache.calcite.sql.JoinType;

@Setter
@Getter
public class JoinClause {
    private Entity leftTable;
    private Entity rightTable;
    private JoinType joinType;
    private Boolean isEquiJoin;
    private String joinCondition;
    private Boolean isJoinOnStringColumn;
}
