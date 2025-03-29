package com.calcite_new.core.model.entity;

import com.calcite_new.core.model.Identifier;

import java.util.List;

public class Table extends DatabaseEntity {

  public Table(List<Identifier> namespace, Identifier name, long createdTimestamp) {
    super(namespace.stream().toList(), name, createdTimestamp);
  }

}
