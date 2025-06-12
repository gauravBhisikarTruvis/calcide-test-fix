/*
package com.calcite_new.sql.processing.local.service;

import com.calcite_new.core.data_ingestor.entity.QueryLog;
import com.calcite_new.core.data_ingestor.service.DataFetchService;
import com.calcite_new.sql.processing.local.ProcessingOrchestrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueryLogProcessingService {

    private final DataFetchService dataFetchService;
    private final ProcessingOrchestrator processingOrchestrator;
    private static final int BATCH_SIZE = 100;

    public void processBatchedQueryLogs() {
        List<QueryLog> queryLogs = dataFetchService.getAllQueryLogs();
        if (queryLogs.isEmpty()) {
            log.info("No query logs found to process");
            return;
        }

        AtomicInteger processedCount = new AtomicInteger(0);
        List<List<QueryLog>> batches = createBatches(queryLogs, BATCH_SIZE);

        batches.forEach(batch -> {
            try {
                processingOrchestrator.process(batch);
                processedCount.addAndGet(batch.size());
                log.info("Processed batch of {} records. Total processed: {}/{}",
                        batch.size(), processedCount.get(), queryLogs.size());
            } catch (Exception e) {
                log.error("Error processing batch: {}", e.getMessage(), e);
            }
        });

        log.info("Completed processing {} query logs", processedCount.get());
    }

    private List<List<QueryLog>> createBatches(List<QueryLog> logs, int batchSize) {
        List<List<QueryLog>> batches = new ArrayList<>();
        for (int i = 0; i < logs.size(); i += batchSize) {
            batches.add(logs.subList(i, Math.min(i + batchSize, logs.size())));
        }
        return batches;
    }
}*/
