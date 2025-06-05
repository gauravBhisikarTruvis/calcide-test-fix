package com.calcite_new.sql.analyzer.model;

import com.calcite_new.sql.analyzer.model.constants.QueryStatus;
import com.calcite_new.sql.analyzer.model.constants.QueryType;
import com.calcite_new.sql.analyzer.relationextractor.EntityRelationship;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class QueryAnalysisModel {

    private String database;
    private String schema;
    private String sessionId;
    private String userName;
    private QueryStatus queryStatus;
    private List<EntityRelationship> entityRelationships;
    private QueryType queryType;
    private String queryId;
    private Long queryExecutionTime;
    private QueryContext queryContext;


}

