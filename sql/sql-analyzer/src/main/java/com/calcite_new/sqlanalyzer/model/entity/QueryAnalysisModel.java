package com.calcite_new.sqlanalyzer.model.entity;

import com.calcite_new.sqlanalyzer.model.enums.QueryStatus;
import com.calcite_new.sqlanalyzer.model.enums.QueryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

