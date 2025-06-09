package com.calcite_new.sqlanalyzer.model.entity.context.clause;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WhereClause {
    private boolean hasPartitionFilter;
    private boolean hasClusteringFilter;
    private boolean hasTrueCondition;
    private boolean hasCaseInsensitiveComparison;
    private boolean hasInWithSubquery;
    private boolean hasInWithConstant;
}
