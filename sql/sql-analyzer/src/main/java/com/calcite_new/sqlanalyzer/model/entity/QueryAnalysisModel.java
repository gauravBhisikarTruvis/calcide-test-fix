package com.calcite_new.sqlanalyzer.model.entity;

import com.calcite_new.sqlanalyzer.model.enums.QueryStatus;
import com.calcite_new.sqlanalyzer.model.enums.QueryType;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "query_analysis")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryAnalysisModel {

    @Id
    private String logId;
    private String statementId;
    private String database;
    private String schema;
    private String sessionId;
    private String userName;

    @Enumerated(EnumType.STRING)
    private QueryStatus queryStatus;

    @Enumerated(EnumType.STRING)
    private QueryType queryType;

    private Long queryExecutionTime;

    @OneToMany(mappedBy = "queryAnalysisModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntityRelationship> entityRelationships;


    @OneToOne(mappedBy = "queryAnalysisModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private QueryContext queryContext;
}

