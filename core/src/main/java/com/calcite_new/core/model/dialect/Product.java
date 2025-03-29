package com.calcite_new.core.model.dialect;

public enum Product {
  BIG_QUERY("BigQuery"),;

  final String productName;

  Product(String productName) {
    this.productName = productName;
  }

  static Product get(String productName) {
    for (Product product : Product.values()) {
      if (product.productName.equals(productName)) {
        return product;
      }
    }
    throw new IllegalArgumentException("Unknown product name: " + productName);
  }
}
