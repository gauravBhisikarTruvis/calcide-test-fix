package com.calcite_new.sql.relationextractor;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entity implements Serializable {

    private String database;
    private String schema;
    private String entityName;

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    private String location;
}
