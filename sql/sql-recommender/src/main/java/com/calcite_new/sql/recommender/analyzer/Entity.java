package com.calcite_new.sql.recommender.analyzer;

import lombok.Builder;

@Builder
public class Entity {
    private String database;
    private String schema;
    private String entityName;
    private EntityType entityType;
    private String location;
}
