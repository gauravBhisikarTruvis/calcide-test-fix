package com.calcite_new.core.model.entity;

import com.calcite_new.core.model.Identifier;

import java.util.List;

public abstract class DatabaseEntity {
  private final List<Identifier> namespace;
  private final Identifier name;
  private final long createdTimestamp;

  protected DatabaseEntity(List<Identifier> namespace, Identifier name, long createdTimestamp) {
    this.namespace = namespace;
    this.name = name;
    this.createdTimestamp = createdTimestamp;
  }

  public List<Identifier> getNamespace() {
    return namespace;
  }

  public Identifier getName() {
    return name;
  }

  public long getCreatedTimestamp() {
    return createdTimestamp;
  }
}
