package com.calcite.sql.core.schema;

import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.Table;
import org.apache.calcite.schema.impl.AbstractTable;
import org.apache.calcite.sql.type.SqlTypeName;

public class InMemoryFoodmartSchema {

  public static SchemaPlus createInMemorySchema() {
    // Create root schema
    SchemaPlus rootSchema = CalciteSchema.createRootSchema(true).plus();

    // Create foodmart schema
    SchemaPlus foodmartSchema = rootSchema.add("foodmart", CalciteSchema.createRootSchema(true).plus());

    // Add tables to the foodmart schema
    addSalesFactTables(foodmartSchema);
    addInventoryFactTables(foodmartSchema);
    addAggregationTables(foodmartSchema);
    addDimensionTables(foodmartSchema);

    return rootSchema;
  }

  private static void addSalesFactTables(SchemaPlus schema) {
    // Sales Fact tables
    schema.add("sales_fact_1997", createSalesFactTable());
    schema.add("sales_fact_1998", createSalesFactTable());
    schema.add("sales_fact_dec_1998", createSalesFactTable());
  }

  private static void addInventoryFactTables(SchemaPlus schema) {
    // Inventory Fact tables
    schema.add("inventory_fact_1997", createInventoryFactTable());
    schema.add("inventory_fact_1998", createInventoryFactTable());
  }

  private static void addAggregationTables(SchemaPlus schema) {
    schema.add("agg_pl_01_sales_fact_1997", createAggPl01SalesFactTable());
    schema.add("agg_ll_01_sales_fact_1997", createAggLl01SalesFactTable());
    schema.add("agg_l_03_sales_fact_1997", createAggL03SalesFactTable());
    schema.add("agg_l_04_sales_fact_1997", createAggL04SalesFactTable());
    schema.add("agg_l_05_sales_fact_1997", createAggL05SalesFactTable());
    schema.add("agg_c_10_sales_fact_1997", createAggC10SalesFactTable());
    schema.add("agg_c_14_sales_fact_1997", createAggC14SalesFactTable());
    schema.add("agg_lc_100_sales_fact_1997", createAggLc100SalesFactTable());
    schema.add("agg_c_special_sales_fact_1997", createAggCSpecialSalesFactTable());
    schema.add("agg_g_ms_pcat_sales_fact_1997", createAggGMsPcatSalesFactTable());
    schema.add("agg_lc_06_sales_fact_1997", createAggLc06SalesFactTable());
  }

  private static void addDimensionTables(SchemaPlus schema) {
    schema.add("currency", createCurrencyTable());
    schema.add("account", createAccountTable());
    schema.add("category", createCategoryTable());
    schema.add("customer", createCustomerTable());
    schema.add("days", createDaysTable());
    schema.add("department", createDepartmentTable());
    schema.add("employee", createEmployeeTable());
    schema.add("employee_closure", createEmployeeClosureTable());
    schema.add("expense_fact", createExpenseFactTable());
    schema.add("position", createPositionTable());
    schema.add("product", createProductTable());
    schema.add("product_class", createProductClassTable());
    schema.add("promotion", createPromotionTable());
    schema.add("region", createRegionTable());
    schema.add("reserve_employee", createReserveEmployeeTable());
    schema.add("salary", createSalaryTable());
    schema.add("store", createStoreTable());
    schema.add("store_ragged", createStoreRaggedTable());
    schema.add("time_by_day", createTimeByDayTable());
    schema.add("warehouse", createWarehouseTable());
    schema.add("warehouse_class", createWarehouseClassTable());
  }

  private static Table createWarehouseClassTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        RelDataTypeFactory.Builder builder = typeFactory.builder();

        builder.add("warehouse_class_id", SqlTypeName.INTEGER).nullable(false);
        builder.add("description", SqlTypeName.VARCHAR).nullable(true);

        return builder.build();
      }
    };
  }

  private static Table createWarehouseTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        RelDataTypeFactory.Builder builder = typeFactory.builder();

        builder.add("warehouse_id", SqlTypeName.INTEGER).nullable(false);
        builder.add("warehouse_class_id", SqlTypeName.INTEGER).nullable(true);
        builder.add("stores_id", SqlTypeName.INTEGER).nullable(true);
        builder.add("warehouse_name", SqlTypeName.VARCHAR).nullable(true);
        builder.add("wa_address1", SqlTypeName.VARCHAR).nullable(true);
        builder.add("wa_address2", SqlTypeName.VARCHAR).nullable(true);
        builder.add("wa_address3", SqlTypeName.VARCHAR).nullable(true);
        builder.add("wa_address4", SqlTypeName.VARCHAR).nullable(true);
        builder.add("warehouse_city", SqlTypeName.VARCHAR).nullable(true);
        builder.add("warehouse_state_province", SqlTypeName.VARCHAR).nullable(true);
        builder.add("warehouse_postal_code", SqlTypeName.VARCHAR).nullable(true);
        builder.add("warehouse_country", SqlTypeName.VARCHAR).nullable(true);
        builder.add("warehouse_owner_name", SqlTypeName.VARCHAR).nullable(true);
        builder.add("warehouse_phone", SqlTypeName.VARCHAR).nullable(true);
        builder.add("warehouse_fax", SqlTypeName.VARCHAR).nullable(true);

        return builder.build();
      }
    };
  }

  private static Table createTimeByDayTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        RelDataTypeFactory.Builder builder = typeFactory.builder();

        builder.add("time_id", SqlTypeName.INTEGER).nullable(false);
        builder.add("the_date", SqlTypeName.TIMESTAMP).nullable(true);
        builder.add("the_day", SqlTypeName.VARCHAR).nullable(true);
        builder.add("the_month", SqlTypeName.VARCHAR).nullable(true);
        builder.add("the_year", SqlTypeName.SMALLINT).nullable(true);
        builder.add("day_of_month", SqlTypeName.SMALLINT).nullable(true);
        builder.add("week_of_year", SqlTypeName.INTEGER).nullable(true);
        builder.add("month_of_year", SqlTypeName.SMALLINT).nullable(true);
        builder.add("quarter", SqlTypeName.VARCHAR).nullable(true);
        builder.add("fiscal_period", SqlTypeName.VARCHAR).nullable(true);

        return builder.build();
      }
    };
  }

  private static Table createStoreRaggedTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        RelDataTypeFactory.Builder builder = typeFactory.builder();

        builder.add("store_id", SqlTypeName.INTEGER).nullable(false);
        builder.add("store_type", SqlTypeName.VARCHAR).nullable(true);
        builder.add("region_id", SqlTypeName.INTEGER).nullable(true);
        builder.add("store_name", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_number", SqlTypeName.INTEGER).nullable(true);
        builder.add("store_street_address", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_city", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_state", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_postal_code", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_country", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_manager", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_phone", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_fax", SqlTypeName.VARCHAR).nullable(true);
        builder.add("first_opened_date", SqlTypeName.TIMESTAMP).nullable(true);
        builder.add("last_remodel_date", SqlTypeName.TIMESTAMP).nullable(true);
        builder.add("store_sqft", SqlTypeName.INTEGER).nullable(true);
        builder.add("grocery_sqft", SqlTypeName.INTEGER).nullable(true);
        builder.add("frozen_sqft", SqlTypeName.INTEGER).nullable(true);
        builder.add("meat_sqft", SqlTypeName.INTEGER).nullable(true);
        builder.add("coffee_bar", SqlTypeName.BOOLEAN).nullable(true);
        builder.add("video_store", SqlTypeName.BOOLEAN).nullable(true);
        builder.add("salad_bar", SqlTypeName.BOOLEAN).nullable(true);
        builder.add("prepared_food", SqlTypeName.BOOLEAN).nullable(true);
        builder.add("florist", SqlTypeName.BOOLEAN).nullable(true);

        return builder.build();
      }
    };
  }

  private static Table createStoreTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        RelDataTypeFactory.Builder builder = typeFactory.builder();

        builder.add("store_id", SqlTypeName.INTEGER).nullable(false);
        builder.add("store_type", SqlTypeName.VARCHAR).nullable(true);
        builder.add("region_id", SqlTypeName.INTEGER).nullable(true);
        builder.add("store_name", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_number", SqlTypeName.INTEGER).nullable(true);
        builder.add("store_street_address", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_city", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_state", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_postal_code", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_country", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_manager", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_phone", SqlTypeName.VARCHAR).nullable(true);
        builder.add("store_fax", SqlTypeName.VARCHAR).nullable(true);
        builder.add("first_opened_date", SqlTypeName.TIMESTAMP).nullable(true);
        builder.add("last_remodel_date", SqlTypeName.TIMESTAMP).nullable(true);
        builder.add("store_sqft", SqlTypeName.INTEGER).nullable(true);
        builder.add("grocery_sqft", SqlTypeName.INTEGER).nullable(true);
        builder.add("frozen_sqft", SqlTypeName.INTEGER).nullable(true);
        builder.add("meat_sqft", SqlTypeName.INTEGER).nullable(true);
        builder.add("coffee_bar", SqlTypeName.BOOLEAN).nullable(true);
        builder.add("video_store", SqlTypeName.BOOLEAN).nullable(true);
        builder.add("salad_bar", SqlTypeName.BOOLEAN).nullable(true);
        builder.add("prepared_food", SqlTypeName.BOOLEAN).nullable(true);
        builder.add("florist", SqlTypeName.BOOLEAN).nullable(true);

        return builder.build();

      }
    };
  }

  private static Table createSalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("product_id", SqlTypeName.INTEGER)
            .add("time_id", SqlTypeName.INTEGER)
            .add("customer_id", SqlTypeName.INTEGER)
            .add("promotion_id", SqlTypeName.INTEGER)
            .add("store_id", SqlTypeName.INTEGER)
            .add("store_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales", SqlTypeName.DECIMAL, 10, 4)
            .build();
      }
    };
  }

  private static Table createInventoryFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("product_id", SqlTypeName.INTEGER)
            .add("time_id", SqlTypeName.INTEGER).nullable(true)
            .add("warehouse_id", SqlTypeName.INTEGER).nullable(true)
            .add("store_id", SqlTypeName.INTEGER).nullable(true)
            .add("units_ordered", SqlTypeName.INTEGER).nullable(true)
            .add("units_shipped", SqlTypeName.INTEGER).nullable(true)
            .add("warehouse_sales", SqlTypeName.DECIMAL, 10, 4).nullable(true)
            .add("warehouse_cost", SqlTypeName.DECIMAL, 10, 4).nullable(true)
            .add("supply_time", SqlTypeName.SMALLINT).nullable(true)
            .add("store_invoice", SqlTypeName.DECIMAL, 10, 4).nullable(true)
            .build();
      }
    };
  }

  private static Table createAggPl01SalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("product_id", SqlTypeName.INTEGER)
            .add("time_id", SqlTypeName.INTEGER)
            .add("customer_id", SqlTypeName.INTEGER)
            .add("store_sales_sum", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost_sum", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales_sum", SqlTypeName.DECIMAL, 10, 4)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createAggLl01SalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("product_id", SqlTypeName.INTEGER)
            .add("time_id", SqlTypeName.INTEGER)
            .add("customer_id", SqlTypeName.INTEGER)
            .add("store_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createAggL03SalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("time_id", SqlTypeName.INTEGER)
            .add("customer_id", SqlTypeName.INTEGER)
            .add("store_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createAggL04SalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("time_id", SqlTypeName.INTEGER)
            .add("store_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("customer_count", SqlTypeName.INTEGER)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createAggL05SalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("product_id", SqlTypeName.INTEGER)
            .add("customer_id", SqlTypeName.INTEGER)
            .add("promotion_id", SqlTypeName.INTEGER)
            .add("store_id", SqlTypeName.INTEGER)
            .add("store_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createAggC10SalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("month_of_year", SqlTypeName.SMALLINT)
            .add("quarter", SqlTypeName.VARCHAR, 30)
            .add("the_year", SqlTypeName.SMALLINT)
            .add("store_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("customer_count", SqlTypeName.INTEGER)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createAggC14SalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("product_id", SqlTypeName.INTEGER)
            .add("customer_id", SqlTypeName.INTEGER)
            .add("store_id", SqlTypeName.INTEGER)
            .add("promotion_id", SqlTypeName.INTEGER)
            .add("month_of_year", SqlTypeName.SMALLINT)
            .add("quarter", SqlTypeName.VARCHAR, 30)
            .add("the_year", SqlTypeName.SMALLINT)
            .add("store_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createAggLc100SalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("product_id", SqlTypeName.INTEGER)
            .add("customer_id", SqlTypeName.INTEGER)
            .add("quarter", SqlTypeName.VARCHAR, 30)
            .add("the_year", SqlTypeName.SMALLINT)
            .add("store_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createAggCSpecialSalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("product_id", SqlTypeName.INTEGER)
            .add("promotion_id", SqlTypeName.INTEGER)
            .add("customer_id", SqlTypeName.INTEGER)
            .add("store_id", SqlTypeName.INTEGER)
            .add("time_month", SqlTypeName.SMALLINT)
            .add("time_quarter", SqlTypeName.VARCHAR, 30)
            .add("time_year", SqlTypeName.SMALLINT)
            .add("store_sales_sum", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost_sum", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales_sum", SqlTypeName.DECIMAL, 10, 4)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createAggGMsPcatSalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("gender", SqlTypeName.VARCHAR, 30)
            .add("marital_status", SqlTypeName.VARCHAR, 30)
            .add("product_family", SqlTypeName.VARCHAR, 30)
            .add("product_department", SqlTypeName.VARCHAR, 30)
            .add("product_category", SqlTypeName.VARCHAR, 30)
            .add("month_of_year", SqlTypeName.SMALLINT)
            .add("quarter", SqlTypeName.VARCHAR, 30)
            .add("the_year", SqlTypeName.SMALLINT)
            .add("store_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("customer_count", SqlTypeName.INTEGER)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createAggLc06SalesFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("time_id", SqlTypeName.INTEGER)
            .add("city", SqlTypeName.VARCHAR, 30)
            .add("state_province", SqlTypeName.VARCHAR, 30)
            .add("country", SqlTypeName.VARCHAR, 30)
            .add("store_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("store_cost", SqlTypeName.DECIMAL, 10, 4)
            .add("unit_sales", SqlTypeName.DECIMAL, 10, 4)
            .add("fact_count", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createCurrencyTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("currency_id", SqlTypeName.INTEGER)
            .add("date", SqlTypeName.DATE)
            .add("currency", SqlTypeName.VARCHAR, 30)
            .add("conversion_ratio", SqlTypeName.DECIMAL, 10, 4)
            .build();
      }
    };
  }

  private static Table createAccountTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("account_id", SqlTypeName.INTEGER)
            .add("account_parent", SqlTypeName.INTEGER)
            .add("account_description", SqlTypeName.VARCHAR, 30)
            .add("account_type", SqlTypeName.VARCHAR, 30)
            .add("account_rollup", SqlTypeName.VARCHAR, 30)
            .add("Custom_Members", SqlTypeName.VARCHAR, 255)
            .build();
      }
    };
  }

  private static Table createCategoryTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("category_id", SqlTypeName.VARCHAR, 30)
            .add("category_parent", SqlTypeName.VARCHAR, 30)
            .add("category_description", SqlTypeName.VARCHAR, 30)
            .add("category_rollup", SqlTypeName.VARCHAR, 30)
            .build();
      }
    };
  }

  private static Table createCustomerTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("customer_id", SqlTypeName.INTEGER)
            .add("account_num", SqlTypeName.BIGINT)
            .add("lname", SqlTypeName.VARCHAR, 30)
            .add("fname", SqlTypeName.VARCHAR, 30)
            .add("mi", SqlTypeName.VARCHAR, 30)
            .add("address1", SqlTypeName.VARCHAR, 30)
            .add("address2", SqlTypeName.VARCHAR, 30)
            .add("address3", SqlTypeName.VARCHAR, 30)
            .add("address4", SqlTypeName.VARCHAR, 30)
            .add("city", SqlTypeName.VARCHAR, 30)
            .add("state_province", SqlTypeName.VARCHAR, 30)
            .add("postal_code", SqlTypeName.VARCHAR, 30)
            .add("country", SqlTypeName.VARCHAR, 30)
            .add("customer_region_id", SqlTypeName.INTEGER)
            .add("phone1", SqlTypeName.VARCHAR, 30)
            .add("phone2", SqlTypeName.VARCHAR, 30)
            .add("birthdate", SqlTypeName.DATE)
            .add("marital_status", SqlTypeName.VARCHAR, 30)
            .add("yearly_income", SqlTypeName.VARCHAR, 30)
            .add("gender", SqlTypeName.VARCHAR, 30)
            .add("total_children", SqlTypeName.SMALLINT)
            .add("num_children_at_home", SqlTypeName.SMALLINT)
            .add("education", SqlTypeName.VARCHAR, 30)
            .add("date_accnt_opened", SqlTypeName.DATE)
            .add("member_card", SqlTypeName.VARCHAR, 30)
            .add("occupation", SqlTypeName.VARCHAR, 30)
            .add("houseowner", SqlTypeName.VARCHAR, 30)
            .add("num_cars_owned", SqlTypeName.INTEGER)
            .add("fullname", SqlTypeName.VARCHAR, 60)
            .build();
      }
    };
  }

  private static Table createDaysTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("day", SqlTypeName.INTEGER)
            .add("week_day", SqlTypeName.VARCHAR, 30)
            .build();
      }
    };
  }

  private static Table createDepartmentTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("department_id", SqlTypeName.INTEGER)
            .add("department_description", SqlTypeName.VARCHAR, 30)
            .build();
      }
    };
  }

  private static Table createEmployeeTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("employee_id", SqlTypeName.INTEGER)
            .add("full_name", SqlTypeName.VARCHAR, 30)
            .add("first_name", SqlTypeName.VARCHAR, 30)
            .add("last_name", SqlTypeName.VARCHAR, 30)
            .add("position_id", SqlTypeName.INTEGER)
            .add("position_title", SqlTypeName.VARCHAR, 30)
            .add("store_id", SqlTypeName.INTEGER)
            .add("department_id", SqlTypeName.INTEGER)
            .add("birth_date", SqlTypeName.DATE)
            .add("hire_date", SqlTypeName.TIMESTAMP)
            .add("end_date", SqlTypeName.TIMESTAMP)
            .add("salary", SqlTypeName.DECIMAL, 10, 4)
            .add("supervisor_id", SqlTypeName.INTEGER)
            .add("education_level", SqlTypeName.VARCHAR, 30)
            .add("marital_status", SqlTypeName.VARCHAR, 30)
            .add("gender", SqlTypeName.VARCHAR, 30)
            .add("management_role", SqlTypeName.VARCHAR, 30)
            .build();
      }
    };
  }

  private static Table createEmployeeClosureTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("employee_id", SqlTypeName.INTEGER)
            .add("supervisor_id", SqlTypeName.INTEGER)
            .add("distance", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createExpenseFactTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("store_id", SqlTypeName.INTEGER)
            .add("account_id", SqlTypeName.INTEGER)
            .add("exp_date", SqlTypeName.TIMESTAMP)
            .add("time_id", SqlTypeName.INTEGER)
            .add("category_id", SqlTypeName.VARCHAR, 30)
            .add("currency_id", SqlTypeName.INTEGER)
            .add("amount", SqlTypeName.DECIMAL, 10, 4)
            .build();
      }
    };
  }

  private static Table createPositionTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("position_id", SqlTypeName.INTEGER)
            .add("position_title", SqlTypeName.VARCHAR, 30)
            .add("pay_type", SqlTypeName.VARCHAR, 30)
            .add("min_scale", SqlTypeName.DECIMAL, 10, 4)
            .add("max_scale", SqlTypeName.DECIMAL, 10, 4)
            .add("management_role", SqlTypeName.VARCHAR, 30)
            .build();
      }
    };
  }

  private static Table createProductTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("product_class_id", SqlTypeName.INTEGER)
            .add("product_id", SqlTypeName.INTEGER)
            .add("brand_name", SqlTypeName.VARCHAR, 60)
            .add("product_name", SqlTypeName.VARCHAR, 60)
            .add("SKU", SqlTypeName.BIGINT)
            .add("SRP", SqlTypeName.DECIMAL, 10, 4)
            .add("gross_weight", SqlTypeName.DOUBLE)
            .add("net_weight", SqlTypeName.DOUBLE)
            .add("recyclable_package", SqlTypeName.BOOLEAN)
            .add("low_fat", SqlTypeName.BOOLEAN)
            .add("units_per_case", SqlTypeName.SMALLINT)
            .add("cases_per_pallet", SqlTypeName.SMALLINT)
            .add("shelf_width", SqlTypeName.DOUBLE)
            .add("shelf_height", SqlTypeName.DOUBLE)
            .add("shelf_depth", SqlTypeName.DOUBLE)
            .build();
      }
    };
  }

  private static Table createProductClassTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("product_class_id", SqlTypeName.INTEGER)
            .add("product_subcategory", SqlTypeName.VARCHAR, 30)
            .add("product_category", SqlTypeName.VARCHAR, 30)
            .add("product_department", SqlTypeName.VARCHAR, 30)
            .add("product_family", SqlTypeName.VARCHAR, 30)
            .build();
      }
    };
  }

  private static Table createPromotionTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("promotion_id", SqlTypeName.INTEGER)
            .add("promotion_district_id", SqlTypeName.INTEGER)
            .add("promotion_name", SqlTypeName.VARCHAR, 30)
            .add("media_type", SqlTypeName.VARCHAR, 30)
            .add("cost", SqlTypeName.DECIMAL, 10, 4)
            .add("start_date", SqlTypeName.TIMESTAMP)
            .add("end_date", SqlTypeName.TIMESTAMP)
            .build();
      }
    };
  }

  private static Table createRegionTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("region_id", SqlTypeName.INTEGER)
            .add("sales_city", SqlTypeName.VARCHAR, 30)
            .add("sales_state_province", SqlTypeName.VARCHAR, 30)
            .add("sales_district", SqlTypeName.VARCHAR, 30)
            .add("sales_region", SqlTypeName.VARCHAR, 30)
            .add("sales_country", SqlTypeName.VARCHAR, 30)
            .add("sales_district_id", SqlTypeName.INTEGER)
            .build();
      }
    };
  }

  private static Table createReserveEmployeeTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("employee_id", SqlTypeName.INTEGER)
            .add("full_name", SqlTypeName.VARCHAR, 30)
            .add("first_name", SqlTypeName.VARCHAR, 30)
            .add("last_name", SqlTypeName.VARCHAR, 30)
            .add("position_id", SqlTypeName.INTEGER)
            .add("position_title", SqlTypeName.VARCHAR, 30)
            .add("store_id", SqlTypeName.INTEGER)
            .add("department_id", SqlTypeName.INTEGER)
            .add("birth_date", SqlTypeName.TIMESTAMP)
            .add("hire_date", SqlTypeName.TIMESTAMP)
            .add("end_date", SqlTypeName.TIMESTAMP)
            .add("salary", SqlTypeName.DECIMAL, 10, 4)
            .add("supervisor_id", SqlTypeName.INTEGER)
            .add("education_level", SqlTypeName.VARCHAR, 30)
            .add("marital_status", SqlTypeName.VARCHAR, 30)
            .add("gender", SqlTypeName.VARCHAR, 30)
            .build();
      }
    };
  }

  private static Table createSalaryTable() {
    return new AbstractTable() {
      @Override
      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.builder()
            .add("pay_date", SqlTypeName.TIMESTAMP)
            .add("employee_id", SqlTypeName.INTEGER)
            .add("department_id", SqlTypeName.INTEGER)
            .add("currency_id", SqlTypeName.INTEGER)
            .add("salary_paid", SqlTypeName.DECIMAL, 10, 4)
            .add("overtime_paid", SqlTypeName.DECIMAL, 10, 4)
            .add("vacation_accrued", SqlTypeName.DOUBLE)
            .add("vacation_used", SqlTypeName.DOUBLE)
            .build();
      }
    };
  }

//  private static Table createStoreTable() {
//    return new AbstractTable() {
//      @Override
//      public RelDataType getRowType(RelDataTypeFactory typeFactory) {
//        return typeFactory.builder()
//            .add("store_id", SqlTypeName.INTEGER)
//            .add("store_type", SqlTypeName.VARCHAR, 30, true)
//            .add("region_id", SqlTypeName.INTEGER, true)
//            .add("store_name", SqlTypeName.VARCHAR, 30, true)
//            .add("store_number", SqlTypeName.INTEGER, true)
//            .add("store_street_address", SqlTypeName.VARCHAR, 30, true)
//            .add("store_city", SqlTypeName.VARCHAR, 30, true)
//            .add("store_state", SqlTypeName.VARCHAR, 30, true)
//            .add("store_postal_code", SqlTypeName.VARCHAR, 30, true)
//            .add("store_country", SqlTypeName.VARCHAR, 30, true)
//            .add("store_manager",
}