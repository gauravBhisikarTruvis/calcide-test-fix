package com.calcite_new.sql.processing.local.service;

import com.calcite_new.core.data_ingestor.entity.QueryLog;
import com.calcite_new.core.data_ingestor.service.DataFetchService;
import com.calcite_new.sql.processing.local.ProcessingOrchestrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueryLogProcessingService {

    private final DataFetchService dataFetchService;
    private final ProcessingOrchestrator processingOrchestrator;

    public void processQueryLogs() {
        List<QueryLog> queryLogs = dataFetchService.getAllQueryLogs();
        if (queryLogs.isEmpty()) {
            log.info("No query logs found to process");
            return;
        }

        int processedCount = 0;
        for (QueryLog queryLog : queryLogs) {
            try {
                processingOrchestrator.process(List.of(queryLog));
                processedCount++;
                log.info("Processed log {}. Total processed: {}/{}",
                        queryLog.getLogId(), processedCount, queryLogs.size());
            } catch (Exception e) {
                log.error("Error processing log {}: {}", queryLog.getLogId(), e.getMessage(), e);
            }
        }

        log.info("Completed processing {} query logs", processedCount);
    }
}