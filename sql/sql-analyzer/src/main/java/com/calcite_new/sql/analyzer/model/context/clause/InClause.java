package com.calcite_new.sql.analyzer.model.context.clause;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InClause {
    private boolean isStringLiteral;
    private boolean isSubquery;
}
