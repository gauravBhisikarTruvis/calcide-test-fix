package com.calcite_new.core.model;

import com.calcite_new.core.model.entity.DatabaseEntity;
import com.calcite_new.core.model.entity.Table;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Namespace {
  private final Identifier name;
  private Map<Identifier, Namespace> children = new ConcurrentHashMap<>();
  private EntityMap<Table> tables = new EntityMap<>();

  public Namespace(Identifier name) {
    this.name = name;
  }

  public void addTable(Table table) {
    tables.put(table);
  }

  public Table getTable(Identifier name) {
    return tables.get(name);
  }

  public Namespace getNamespace(Identifier name) {
    return children.get(name);
  }

  Namespace getOrAddNamespace(Identifier name) {
    return children.computeIfAbsent(name, Namespace::new);
  }

  private record Key(Identifier name, long createdTimestamp) implements Comparable<Key> {

    @Override
    public int compareTo(Key other) {
      int cmp = name.getNormalizedName().compareTo(other.name.getNormalizedName());
      if (cmp != 0) {
        return cmp;
      }
      return Long.compare(createdTimestamp, other.createdTimestamp);
    }

  }

  private static class EntityMap<V extends DatabaseEntity> {
    private final NavigableMap<Key, V> entities = new ConcurrentSkipListMap<>();

    public V get(Identifier name) {
      Key key = new Key(name, System.currentTimeMillis());
      return entities.get(key);
    }

    public void put(V entity) {
      Key key = new Key(entity.getName(), entity.getCreatedTimestamp());
      entities.put(key, entity);
    }
  }
}
