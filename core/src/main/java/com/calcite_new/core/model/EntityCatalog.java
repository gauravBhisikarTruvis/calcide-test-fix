package com.calcite_new.core.model;

import com.calcite_new.core.model.entity.DatabaseEntity;
import com.calcite_new.core.model.entity.Table;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EntityCatalog {
  private Map<Identifier, Namespace> products = new ConcurrentHashMap<>();

  DatabaseEntity getEntity(List<Identifier> qualifiedName) {
    if (qualifiedName.size() < 2) {
      throw new IllegalArgumentException("Qualified name must have at least two parts");
    }
    Namespace namespace = getNamespace(qualifiedName.subList(0, qualifiedName.size() - 1));
    return namespace.getTable(qualifiedName.get(qualifiedName.size() - 1));
  }

  public void addEntity(DatabaseEntity entity) {
    List<Identifier> namespace = entity.getNamespace();
    Namespace ns = getOrAddNamespace(namespace);
    ns.addTable((Table) entity);
  }

  private Namespace getOrAddNamespace(List<Identifier> namespace) {
    Namespace ns = products.computeIfAbsent(namespace.get(0), Namespace::new);
    for (Identifier nsName : namespace.subList(1, namespace.size())) {
      ns = ns.getOrAddNamespace(nsName);
    }
    return ns;
  }

  private Namespace getNamespace(List<Identifier> identifiers) {
    if (identifiers.isEmpty()) {
      throw new IllegalArgumentException("Namespace must have at least one part");
    }
    Namespace ns = products.get(identifiers.get(0));
    for (Identifier nsName : identifiers.subList(1, identifiers.size())) {
      checkNamespace(ns, nsName, identifiers);
      ns = ns.getNamespace(nsName);
    }
    checkNamespace(ns, identifiers.get(identifiers.size() - 1), identifiers);
    return ns;
  }

  private static void checkNamespace(Namespace namespace, Identifier nsName, List<Identifier> identifiers) {
    if (namespace == null) {
      throw new IllegalArgumentException("Unknown name: " + nsName + " in namespace: " + identifiers);
    }
  }

}
