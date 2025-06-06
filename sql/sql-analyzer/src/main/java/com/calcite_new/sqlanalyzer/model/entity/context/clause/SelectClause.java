package com.calcite_new.sqlanalyzer.model.entity.context.clause;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.List;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SelectClause {

    private boolean isSelectAll;
    private boolean isDistinct;
    private List<String> unusedColumns;

}
