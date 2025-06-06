package com.calcite_new.sqlanalyzer.model.entity.context.clause;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.*;

import java.util.List;

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
    private boolean isExpensiveFunctionUsed;
    private boolean hasSubqueryInsideInClause;
}
