/*
package com.calcite_new.sql.recommender;

import org.apache.calcite.schema.*;
import org.apache.calcite.schema.impl.AbstractTable;
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.rel.type.*;
import org.apache.calcite.tools.Frameworks;

import java.util.*;

public class FoodmartSchemaLoader {

    public static SchemaPlus loadFoodmartSchema() {
        SchemaPlus rootSchema = Frameworks.createRootSchema(true);
        RelDataTypeFactory typeFactory = new SqlTypeFactoryImpl(RelDataTypeSystem.DEFAULT);

        rootSchema.add("customer", createCustomerTable(typeFactory));
        rootSchema.add("product", createProductTable(typeFactory));
        rootSchema.add("sales_fact", createSalesFactTable(typeFactory));
        rootSchema.add("time_by_day", createTimeByDayTable(typeFactory));
        rootSchema.add("store", createStoreTable(typeFactory));
        rootSchema.add("employee", createEmployeeTable(typeFactory));
        rootSchema.add("department", createDepartmentTable(typeFactory));

        return rootSchema;
    }

    private static Table createCustomerTable(RelDataTypeFactory typeFactory) {
        return createTable(typeFactory, Map.of(
                "customer_id", SqlTypeName.INTEGER,
                "full_name", SqlTypeName.VARCHAR,
                "gender", SqlTypeName.VARCHAR,
                "birthdate", SqlTypeName.DATE,
                "email", SqlTypeName.VARCHAR
        ));
    }

    private static Table createProductTable(RelDataTypeFactory typeFactory) {
        return createTable(typeFactory, Map.of(
                "product_id", SqlTypeName.INTEGER,
                "product_name", SqlTypeName.VARCHAR,
                "category", SqlTypeName.VARCHAR,
                "brand_name", SqlTypeName.VARCHAR
        ));
    }

    private static Table createSalesFactTable(RelDataTypeFactory typeFactory) {
        return createTable(typeFactory, Map.of(
                "sales_id", SqlTypeName.INTEGER,
                "product_id", SqlTypeName.INTEGER,
                "customer_id", SqlTypeName.INTEGER,
                "store_id", SqlTypeName.INTEGER,
                "time_id", SqlTypeName.INTEGER,
                "sales_amount", SqlTypeName.DECIMAL
        ));
    }

    private static Table createTimeByDayTable(RelDataTypeFactory typeFactory) {
        return createTable(typeFactory, Map.of(
                "time_id", SqlTypeName.INTEGER,
                "the_date", SqlTypeName.DATE,
                "day_of_week", SqlTypeName.VARCHAR
        ));
    }

    private static Table createStoreTable(RelDataTypeFactory typeFactory) {
        return createTable(typeFactory, Map.of(
                "store_id", SqlTypeName.INTEGER,
                "store_name", SqlTypeName.VARCHAR,
                "store_type", SqlTypeName.VARCHAR
        ));
    }

    private static Table createEmployeeTable(RelDataTypeFactory typeFactory) {
        return createTable(typeFactory, Map.of(
                "employee_id", SqlTypeName.INTEGER,
                "full_name", SqlTypeName.VARCHAR,
                "position_title", SqlTypeName.VARCHAR,
                "department_id", SqlTypeName.INTEGER,
                "hire_date", SqlTypeName.DATE,
                "department_name", SqlTypeName.VARCHAR
                ));
    }

    private static Table createDepartmentTable(RelDataTypeFactory typeFactory) {
        return createTable(typeFactory, Map.of(
                "department_id", SqlTypeName.INTEGER,
                "department_name", SqlTypeName.VARCHAR,
                "manager_id", SqlTypeName.INTEGER
        ));
    }

    private static Table createTable(RelDataTypeFactory typeFactory, Map<String, SqlTypeName> fields) {
        RelDataTypeFactory.Builder builder = new RelDataTypeFactory.Builder(typeFactory);
        for (Map.Entry<String, SqlTypeName> entry : fields.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        RelDataType rowType = builder.build();

        return new AbstractTable() {
            @Override
            public RelDataType getRowType(RelDataTypeFactory factory) {
                return rowType;
            }
        };
    }
}
*/
