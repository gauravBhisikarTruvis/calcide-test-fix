package com.calcite_new.sqlanalyzer.recommendation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rule_metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleMetadata {

    @Id
    @Column(name = "rule_id")
    private Integer ruleId;

    @Column(name = "application_code_change_required")
    private String applicationCodeChangeRequired;

    @Column(name = "recommendation")
    private String recommendation;

    @Column(name = "rule_description")
    private String ruleDescription;

    @Column(name = "category")
    private String category;

    @Column(name = "optimisation_category")
    private String optimisationCategory;

    @Column(name = "query_change_required")
    private String queryChangeRequired;

    @Column(name = "schema_change_required")
    private String schemaChangeRequired;

    @Column(name = "is_active")
    private Boolean isActive;
}

