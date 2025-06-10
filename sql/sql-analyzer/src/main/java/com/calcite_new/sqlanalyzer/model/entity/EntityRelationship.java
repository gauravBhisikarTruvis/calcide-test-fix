package com.calcite_new.sqlanalyzer.model.entity;

import com.calcite_new.sqlanalyzer.relationextractor.RelationshipType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entity_relationship")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "database", column = @Column(name = "source_database")),
            @AttributeOverride(name = "schema", column = @Column(name = "source_schema")),
            @AttributeOverride(name = "entityName", column = @Column(name = "source_entity_name")),
            @AttributeOverride(name = "entityType", column = @Column(name = "source_entity_type")),
            @AttributeOverride(name = "location", column = @Column(name = "source_location"))
    })
    private com.calcite_new.sqlanalyzer.relationextractor.Entity sourceEntity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "database", column = @Column(name = "target_database")),
            @AttributeOverride(name = "schema", column = @Column(name = "target_schema")),
            @AttributeOverride(name = "entityName", column = @Column(name = "target_entity_name")),
            @AttributeOverride(name = "entityType", column = @Column(name = "target_entity_type")),
            @AttributeOverride(name = "location", column = @Column(name = "target_location"))
    })
    private com.calcite_new.sqlanalyzer.relationextractor.Entity targetEntity;

    @Enumerated(EnumType.STRING)
    private RelationshipType relationshipType;

    @ManyToOne
    @JoinColumn(name = "query_analysis_id")
    private QueryAnalysisModel queryAnalysisModel;

}