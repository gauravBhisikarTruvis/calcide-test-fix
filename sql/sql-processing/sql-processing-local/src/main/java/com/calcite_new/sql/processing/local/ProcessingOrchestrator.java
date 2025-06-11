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
                    // Stage 1: Process the record on the processing pool
                    .supplyAsync(() -> processor.process(record), processingExecutor)
                    // Stage 2: Pass the result to the batcher. The batcher itself will use
                    // its own executor to run the actual persistence task.
                    .thenAccept(persister::addAll)
                    .exceptionally(ex -> {
                      log.error("Failed to process record: {}", ex.getMessage(), ex);
                      return null; // Mark future as complete despite error
                    }))
            .toList();

    // Wait for all processing tasks to be submitted to the persister
    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

    // Flush any remaining records in the final, partial batch
    log.info("All records processed. Flushing remaining records.");
    persister.flush();

    // Wait for all persistence tasks to complete
    log.info("Waiting for all persistence tasks to complete.");
    persister.waitForCompletion();

    log.info("All processing and persistence complete.");
  }

  @PreDestroy
  public void shutdown() {
    log.info("Shutting down ProcessingOrchestrator executors.");
    shutdownExecutor(processingExecutor, "Processing");
    shutdownExecutor(persistenceExecutor, "Persistence");
  }

  private void shutdownExecutor(ExecutorService executor, String name) {
    try {
      executor.shutdown();
      if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
        executor.shutdownNow();
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
          log.error("{} executor did not terminate", name);
        }
      }
    } catch (InterruptedException e) {
      executor.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }

}