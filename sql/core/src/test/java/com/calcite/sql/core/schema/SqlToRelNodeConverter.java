package com.calcite.sql.core.schema;

import com.calcite.sql.parser.BigQuerySqlParser;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.plan.volcano.VolcanoPlanner;
import org.apache.calcite.prepare.CalciteCatalogReader;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.validate.SqlValidator;
import org.apache.calcite.sql.validate.SqlValidatorUtil;
import org.apache.calcite.sql2rel.SqlToRelConverter;
import org.apache.calcite.sql2rel.StandardConvertletTable;
import org.apache.calcite.tools.Frameworks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

import static com.calcite.sql.core.schema.InMemoryFoodmartSchema.createInMemorySchema;

public class SqlToRelNodeConverter {

  public static void main(String[] args) throws Exception {
    // Example SQL query
//    String sql = "SELECT * FROM EMPLOYEE";
//    String sql = "SELECT EMPLOYEE_ID, FULL_NAME FROM EMPLOYEE";
    String sql = "SELECT CAST(FULL_NAME AS STRING) FROM EMPLOYEE";
    SqlNode sqlNode = new BigQuerySqlParser().parse(sql);

    System.out.println(sqlNode);

    // Create a RelNode from the SQL query
    RelNode relNode = convertSqlToRel(sqlNode);

    // Print the RelNode as a tree
    System.out.println(RelOptUtil.toString(relNode));
  }

  public static RelNode convertSqlToRel(SqlNode sqlNode) throws Exception {
    // Create a Calcite connection
    Properties props = new Properties();
    Connection connection = DriverManager.getConnection("jdbc:calcite:", props);
    CalciteConnection calciteConnection = connection.unwrap(CalciteConnection.class);

    // Get the root schema
//    SchemaPlus rootSchema = calciteConnection.getRootSchema();

    // Add a JDBC schema (assuming you have a DataSource to your database)
    // This is just an example - you'd configure this with your actual DataSource
//    DataSource dataSource = null; // Replace with your actual DataSource
//    rootSchema.add("hr", JdbcSchema.create(rootSchema, "hr", dataSource, null, null));

    SchemaPlus rootSchema = createInMemorySchema();

    // Create a Frameworks.ConfigBuilder
    Frameworks.ConfigBuilder configBuilder = Frameworks.newConfigBuilder()
        .defaultSchema(rootSchema);

    // Parse the SQL query to get a SqlNode
//    SqlParser.Config parserConfig = SqlParser.Config.DEFAULT;
//    SqlParser parser = SqlParser.create(sql, parserConfig);
//    SqlNode sqlNode = new BigQuerySqlParser().parse(sql);

    // Create a SqlValidator
    RelDataTypeFactory typeFactory = calciteConnection.getTypeFactory();
    CalciteCatalogReader catalogReader = new CalciteCatalogReader(
        CalciteSchema.from(rootSchema),
        List.of("FOODMART"),
        typeFactory,
        org.apache.calcite.config.CalciteConnectionConfig.DEFAULT);

    SqlValidator validator = SqlValidatorUtil.newValidator(
        SqlStdOperatorTable.instance(),
//        new SqlStdOperatorTable() {
//          @Override
//          public void lookupOperatorOverloads(SqlIdentifier opName, @Nullable SqlFunctionCategory category, SqlSyntax syntax, List<SqlOperator> operatorList, SqlNameMatcher nameMatcher) {
//            SqlOperator operator = new SqlFunction(opName.getSimple(), SqlKind.OTHER_FUNCTION,
//                null,
//                null,
//                null,
//                category);
//            operatorList.add(operator);
//          }
//        },
        catalogReader,
        typeFactory,
        SqlValidator.Config.DEFAULT);

    // Validate the SqlNode
    SqlNode validatedSqlNode = validator.validate(sqlNode);

    // Create a RelOptCluster
    VolcanoPlanner planner = new VolcanoPlanner();
    RelOptCluster cluster = RelOptCluster.create(
        planner,
        new RexBuilder(typeFactory));

    // Create a SqlToRelConverter
    SqlToRelConverter.Config converterConfig = SqlToRelConverter.config()
        .withTrimUnusedFields(true)
        .withExpand(false);

    SqlToRelConverter sqlToRelConverter = new SqlToRelConverter(
        null, // ViewExpander - null for this example
        validator,
        catalogReader,
        cluster,
        StandardConvertletTable.INSTANCE,
        converterConfig);

    // Convert the validated SqlNode to a RelNode
    RelRoot relRoot = sqlToRelConverter.convertQuery(validatedSqlNode, false, true);
    return relRoot.rel;
  }

//  // Helper inner class for CalciteConnectionConfig
//  private static class CalciteConnectionConfig implements CalciteConnectionConfig {
//    public static final CalciteConnectionConfig DEFAULT = new CalciteConnectionConfig();
//
//    @Override
//    public boolean autoTemp() { return false; }
//
//    @Override
//    public boolean materializationsEnabled() { return false; }
//
//    @Override
//    public boolean createMaterializations() { return false; }
//
//    @Override
//    public boolean forceMaterializations() { return false; }
//
//    @Override
//    public String model() { return ""; }
//
//    @Override
//    public String lex() { return "JAVA"; }
//
//    @Override
//    public String quoting() { return "DOUBLE_QUOTE"; }
//
//    @Override
//    public String conformance() { return "DEFAULT"; }
//
//    @Override
//    public boolean sparkFallback() { return false; }
//
//    @Override
//    public String fun() { return "STANDARD"; }
//
//    @Override
//    public <T> T typeSystem(Class<T> typeSystemClass, T defaultTypeSystem) { return defaultTypeSystem; }
//
//    // Implement other required methods based on the interface...
//    // This is a simplified implementation for the example
//  }
}