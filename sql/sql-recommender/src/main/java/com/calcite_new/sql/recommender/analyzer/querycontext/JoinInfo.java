package com.calcite_new.sql.recommender.analyzer.querycontext;

import com.calcite_new.sql.recommender.analyzer.Entity;
import lombok.Getter;
import lombok.Setter;
import org.apache.calcite.sql.JoinType;

@Setter
@Getter
public class JoinInfo {
    private Entity leftTable;
    private Entity rightTable;
    private JoinType joinType;
    private boolean isEquiJoin;
    private String joinCondition;
    private boolean isJoinOnStringColumn;
}
