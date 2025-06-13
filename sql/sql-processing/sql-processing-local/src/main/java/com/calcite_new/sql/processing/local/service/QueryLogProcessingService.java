package com.calcite_new.sql.processing.local.service;

import com.calcite_new.core.data_ingestor.entity.QueryLog;
import com.calcite_new.core.data_ingestor.service.DataFetchService;
import com.calcite_new.sql.processing.local.ProcessingOrchestrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueryLogProcessingService {

    private final DataFetchService dataFetchService;
    private final ProcessingOrchestrator processingOrchestrator;

    @Transactional(readOnly = true)
    public void processQueryLogs() {
        List<QueryLog> queryLogs = dataFetchService.getAllQueryLogs();
        if (queryLogs.isEmpty()) {
            log.info("--- No query logs found to process ---");
            return;
        }

        AtomicInteger processedCount = new AtomicInteger(0);
        int totalLogs = queryLogs.size();

        queryLogs.forEach(queryLog -> {
            try {
                processingOrchestrator.process(List.of(queryLog));
                log.info("--- Processed log {}. Total processed: {}/{} ---",
                        queryLog.getLogId(), processedCount.incrementAndGet(), totalLogs);
            } catch (Exception e) {
                log.error("--- Error processing log {}: {} ---", queryLog.getLogId(), e.getMessage(), e);
            }
        });

        log.info("--- Completed processing {} out of {} query logs ---", processedCount.get(), totalLogs);
    }
}