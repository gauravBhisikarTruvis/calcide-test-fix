package com.calcite_new.core.resolver;

import com.calcite_new.core.model.EntityCatalog;
import com.calcite_new.core.model.EntityQualifier;
import com.calcite_new.core.model.SchemaWrapper;
import com.calcite_new.core.model.entity.DatabaseEntity;
import com.calcite_new.core.model.entity.Table;

/**
 * EntityResolver is responsible for resolving entities in the catalog.
 * It provides methods to resolve entities based on their qualifiers.
 */
public class EntityResolver {
  private final EntityCatalog catalog;

  public EntityResolver(EntityCatalog catalog) {
    this.catalog = catalog;
  }

  public DatabaseEntity resolve(EntityQualifier qualifier) {
    Table table = catalog.getTable(qualifier);
    if (table == null) {
      throw new IllegalArgumentException("Entity not found: " + qualifier);
    }
    return table;
  }

  public SchemaWrapper getSchema() {
    return new SchemaWrapper(catalog);
  }
}
