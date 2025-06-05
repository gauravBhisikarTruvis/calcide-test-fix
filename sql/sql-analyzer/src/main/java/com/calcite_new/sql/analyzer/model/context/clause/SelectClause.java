package com.calcite_new.sql.analyzer.model.context.clause;

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
