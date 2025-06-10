package com.calcite_new.sql.processing.local;

import com.calcite_new.sql.core.processor.QueryRecordProcessor;
import com.calcite_new.sql.model.QueryRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProcessingOrchestrator {

  private final QueryRecordProcessor processor;
  private final BatchPersister persister;

  private ExecutorService processingExecutor;
  private ExecutorService persistenceExecutor;

  private static final int DEFAULT_BATCH_SIZE = 10;

  @PostConstruct
  public void init() {
    int processingThreads = Runtime.getRuntime().availableProcessors();
    processingExecutor = Executors.newFixedThreadPool(processingThreads);
    persistenceExecutor = Executors.newSingleThreadExecutor();

    persister.configure(DEFAULT_BATCH_SIZE, persistenceExecutor);

    log.info("ProcessingOrchestrator initialized with {} processing threads and batch size {}.",
            processingThreads, DEFAULT_BATCH_SIZE);
  }

  public void process(List<QueryRecord> records) {
    log.info("Starting processing of {} records...", records.size());

    List<CompletableFuture<Void>> futures = records.stream()
            .map(record -> CompletableFuture
                    .supplyAsync(() -> processor.process(record), processingExecutor)
                    .thenAccept(persister::addAll)
                    .exceptionally(ex -> {
                      log.error("Failed to process record: {}", ex.getMessage(), ex);
                      return null;
                    }))
            .toList();

    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

    log.info("All records processed. Flushing remaining records.");
    persister.flush();

    log.info("Waiting for all persistence tasks to complete.");
    persister.waitForCompletion();

    log.info("All processing and persistence complete.");
  }

  @PreDestroy
  public void shutdown() {
    log.info("Shutting down ProcessingOrchestrator executors.");

    processingExecutor.shutdown();
    persistenceExecutor.shutdown();

    try {
      if (!processingExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
        processingExecutor.shutdownNow();
      }
      if (!persistenceExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
        persistenceExecutor.shutdownNow();
      }
    } catch (InterruptedException e) {
      processingExecutor.shutdownNow();
      persistenceExecutor.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }
}