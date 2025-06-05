package com.calcite_new.sql.recommender.analyzer.querycontext;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SelectClause {

    private boolean isSelectAll;
    private boolean isDistinct;
    private List<String> unusedColumns;

}
