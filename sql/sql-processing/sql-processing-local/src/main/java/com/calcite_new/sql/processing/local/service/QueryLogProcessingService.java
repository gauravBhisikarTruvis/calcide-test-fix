package com.calcite_new.sql.processing.local.service;

import com.calcite_new.core.entity.QueryLog;
import com.calcite_new.core.service.DataFetchService;
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
    private static final int CHUNK_SIZE = 300;

    @Transactional(readOnly = true)
    public void processQueryLogs() {
        List<QueryLog> queryLogs = dataFetchService.getAllQueryLogs();
        if (queryLogs.isEmpty()) {
            log.info("--- No query logs found to process ---");
            return;
        }

        int totalLogs = queryLogs.size();
        AtomicInteger totalProcessed = new AtomicInteger(0);
        log.info("--- Starting to process {} query logs ---", totalLogs);

        for (int i = 0; i < queryLogs.size(); i += CHUNK_SIZE) {
            int end = Math.min(i + CHUNK_SIZE, queryLogs.size());
            List<QueryLog> chunk = queryLogs.subList(i, end);

            try {
                processingOrchestrator.process(chunk);
                int currentProcessed = totalProcessed.addAndGet(chunk.size());
                log.info("--- Overall Progress: {}/{} logs processed ({}%) ---",
                        currentProcessed,
                        totalLogs,
                        String.format("%.2f", (currentProcessed * 100.0) / totalLogs));
            } catch (Exception e) {
                log.error("--- Error processing chunk {}-{}: {} ---",
                        i, end, e.getMessage(), e);
            }
        }

        log.info("=== Complete Processing Summary ===");
        log.info("Total logs processed: {}/{}", totalProcessed.get(), totalLogs);
        log.info("================================");
    }
}