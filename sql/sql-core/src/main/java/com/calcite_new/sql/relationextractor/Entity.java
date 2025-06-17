package com.calcite_new.sql.relationextractor;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity entity)) return false;
        return Objects.equals(database, entity.database) &&
                Objects.equals(schema, entity.schema) &&
                Objects.equals(entityName, entity.entityName) &&
                entityType == entity.entityType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(database, schema, entityName, entityType);
    }
}
