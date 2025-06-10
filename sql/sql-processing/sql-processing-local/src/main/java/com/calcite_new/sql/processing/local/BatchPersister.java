package com.calcite_new.sql.processing.local;

import com.calcite_new.sql.model.entity.SqlStatementInfo;
import com.calcite_new.sql.processing.local.repository.SqlStatementInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

@Slf4j
@Component
@RequiredArgsConstructor
public class BatchPersister {

  private final SqlStatementInfoRepository repository;

  private ExecutorService persistenceExecutor;
  private int batchSize;

  private final List<SqlStatementInfo> currentBatch = new ArrayList<>();
  private final List<CompletableFuture<Void>> persistenceFutures = new CopyOnWriteArrayList<>();

  public void configure(int batchSize, ExecutorService persistenceExecutor) {
    this.batchSize = batchSize;
    this.persistenceExecutor = persistenceExecutor;
  }

  /**
   * Adds a records to the batch and triggers persistence if the batch is full.
   * This method MUST be synchronized to ensure thread-safe access to the batch list.
   */
  public synchronized void addAll(List<SqlStatementInfo> records) {
    currentBatch.addAll(records);
    if (currentBatch.size() >= batchSize) {
      submitPersistenceTask();
    }
  }

  /**
   * Persists any remaining records in the current batch.
   * This MUST be called after all processing is complete.
   */
  public synchronized void flush() {
    if (!currentBatch.isEmpty()) {
      submitPersistenceTask();
    }
  }

  private void submitPersistenceTask() {
    List<SqlStatementInfo> batchToPersist = new ArrayList<>(currentBatch);
    currentBatch.clear();

    CompletableFuture<Void> persistenceFuture = CompletableFuture.runAsync(() -> {
      try {
        persistBatch(batchToPersist);
      } catch (Exception e) {
        log.error("Error persisting batch: {}", e.getMessage(), e);
      }
    }, persistenceExecutor);

    persistenceFutures.add(persistenceFuture);
  }

  /**
   * Waits for all submitted persistence tasks to complete.
   */
  public void waitForCompletion() {
    CompletableFuture.allOf(persistenceFutures.toArray(new CompletableFuture[0])).join();
  }

  /**
   * Simulates a blocking database batch insert operation.
   */
  private void persistBatch(List<SqlStatementInfo> batch) {
    if (batch.isEmpty()) return;

    try {
      repository.saveAll(batch);
      log.info("Persisted batch of {} records. Sample ID: {}", batch.size(), batch.get(0).getLogId());
    } catch (Exception e) {
      log.error("Failed to persist batch of {} records: {}", batch.size(), e.getMessage(), e);
    }
  }
}
