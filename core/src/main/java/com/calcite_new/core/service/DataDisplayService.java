package com.calcite_new.core.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataDisplayService {
    private static final Logger logger = LoggerFactory.getLogger(DataDisplayService.class);
    private final DataFetchService dataFetchService;

    public DataDisplayService(DataFetchService dataFetchService) {
        this.dataFetchService = dataFetchService;
    }

    public void displayAllData() {
        logger.info("Query logs rows: {}", dataFetchService.getAllQueryLogs().size());
        logger.info("Tables rows: {}", dataFetchService.getAllTables().size());
        logger.info("Columns rows: {}", dataFetchService.getAllColumns().size());
        logger.info("Views rows: {}", dataFetchService.getAllViews().size());
        logger.info("External tables rows: {}", dataFetchService.getAllExternalTables().size());
        logger.info("Functions rows: {}", dataFetchService.getAllFunctions().size());
        logger.info("Indices rows: {}", dataFetchService.getAllIndices().size());
        logger.info("Macros rows: {}", dataFetchService.getAllMacros().size());
        logger.info("Partitions rows: {}", dataFetchService.getAllPartitions().size());
        logger.info("Procedures rows: {}", dataFetchService.getAllProcedures().size());
    }
}
