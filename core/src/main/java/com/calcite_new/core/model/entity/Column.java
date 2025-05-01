package com.calcite_new.core.model.entity;

import com.calcite_new.core.model.Identifier;

public record Column(Identifier name, int ordinalPosition, DataType type, boolean nullable) { }
