package com.calcite_new.core;
import com.calcite_new.core.config.RepositoryConfig;
import com.calcite_new.core.service.DataDisplayService;
import com.calcite_new.core.service.DataFetchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        try {
            // Initialize configuration
            RepositoryConfig repositoryConfig = new RepositoryConfig();

            // Initialize servicesS
            DataFetchService dataFetchService = new DataFetchService(
                    repositoryConfig.getQueryLogRepo(),
                    repositoryConfig.getTableRepo(),
                    repositoryConfig.getColumnRepo(),
                    repositoryConfig.getViewRepo(),
                    repositoryConfig.getExternalTableRepo(),
                    repositoryConfig.getFunctionRepo(),
                    repositoryConfig.getIndicesRepo(),
                    repositoryConfig.getMacroRepo(),
                    repositoryConfig.getPartitionRepo(),
                    repositoryConfig.getProcedureRepo()
            );

            logger.info("Starting data fetch...");

            // Process data
            processData(dataFetchService);

            // Display counts at the end
            logger.info("=== Final Row Counts ===");
            DataDisplayService displayService = new DataDisplayService(dataFetchService);
            displayService.displayAllData();

        } catch (Exception e) {
            logger.error("Error during execution", e);
            System.exit(1);
        }
    }

    private static void processData(DataFetchService dataFetchService) {
        // Get all data (this will do the actual fetching)
        dataFetchService.getAllTables();
        dataFetchService.getAllColumns();
        dataFetchService.getAllViews();
        dataFetchService.getAllExternalTables();
        dataFetchService.getAllFunctions();
        dataFetchService.getAllIndices();
        dataFetchService.getAllMacros();
        dataFetchService.getAllPartitions();
        dataFetchService.getAllProcedures();
    }
}