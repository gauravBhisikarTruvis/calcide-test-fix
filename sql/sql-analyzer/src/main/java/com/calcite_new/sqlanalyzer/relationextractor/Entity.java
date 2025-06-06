package com.calcite_new.sqlanalyzer.relationextractor;

import jakarta.persistence.*;
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
