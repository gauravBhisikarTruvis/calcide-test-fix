package com.calcite_new.sql.recommender.analyzer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class EntityRelationship {
    private RelationshipType type;
    private Entity sourceEntity;
    private Entity targetEntity;
}

