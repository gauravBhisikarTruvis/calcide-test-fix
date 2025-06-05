package com.calcite_new.sql.analyzer.relationextractor;

import org.apache.calcite.sql.SqlIdentifier;

import java.util.List;

public class RelationshipExtractor {

    public static Entity createEntity(SqlIdentifier identifier, String defaultDb, String defaultSchema) {
        String db = identifier.names.size() == 3 ? identifier.names.getFirst() : defaultDb;
        String schema = identifier.names.size() >= 2 ? identifier.names.get(identifier.names.size() - 2) : defaultSchema;
        String table = identifier.names.get(identifier.names.size() - 1);

        return Entity.builder()
                .database(db)
                .schema(schema)
                .entityName(table)
                .entityType(EntityType.TABLE)
                .build();
    }

    public static void createAccess(SqlIdentifier identifier, String userName, String defaultDb, String defaultSchema, List<EntityRelationship> relations) {
        Entity tableEntity = createEntity(identifier, defaultDb, defaultSchema);
        Entity userEntity = Entity.builder()
                .entityName(userName)
                .entityType(EntityType.USER)
                .build();

        relations.add(EntityRelationship.builder()
                .type(RelationshipType.ACCESSES)
                .sourceEntity(userEntity)
                .targetEntity(tableEntity)
                .build());
    }

    public static void createDependsOn(SqlIdentifier targetId, SqlIdentifier sourceId, String defaultDb, String defaultSchema, List<EntityRelationship> relations) {
        Entity target = createEntity(targetId, defaultDb, defaultSchema);
        Entity source = createEntity(sourceId, defaultDb, defaultSchema);

        relations.add(EntityRelationship.builder()
                .type(RelationshipType.DEPENDS_ON)
                .sourceEntity(target)
                .targetEntity(source)
                .build());
    }
}
