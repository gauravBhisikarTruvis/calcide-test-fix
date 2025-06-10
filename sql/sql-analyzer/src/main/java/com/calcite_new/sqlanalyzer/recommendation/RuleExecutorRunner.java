package com.calcite_new.sqlanalyzer.recommendation;

import com.calcite_new.sqlanalyzer.recommendation.entity.RuleMetadata;
import com.calcite_new.sqlanalyzer.recommendation.repository.RuleMetadataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class RuleExecutorRunner {

    private final RuleMetadataRepository ruleMetadataRepository;
    private final RuleSqlRegistry ruleSqlRegistry;
    private final JdbcTemplate jdbcTemplate;

    @Async
    public CompletableFuture<ValidationResult> validateSqlFilesForActiveRules() {
        log.info("Starting async validation of SQL files for active rules...");

        List<RuleMetadata> activeRules = ruleMetadataRepository.findByIsActiveTrue();
        List<Integer> missingRules = activeRules.stream()
                .map(RuleMetadata::getRuleId)
                .filter(ruleCode -> ruleSqlRegistry.getSqlForRule(ruleCode).isEmpty())
                .toList();

        if (!missingRules.isEmpty()) {
            String errorMsg = "Missing SQL files for rules: " +
                    missingRules.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", "));
            log.error(errorMsg);
            return CompletableFuture.completedFuture(new ValidationResult(false, errorMsg));
        }
        log.info("All active rule SQL files are present.");
        return CompletableFuture.completedFuture(new ValidationResult(true,
                "All SQL files validated successfully."));
    }

    @Async
    public CompletableFuture<RunResult> runRules() {
        List<RuleMetadata> activeRules = ruleMetadataRepository.findByIsActiveTrue();

        List<String> failedRules = new ArrayList<>();
        for (RuleMetadata rule : activeRules) {
            Integer ruleCode = rule.getRuleId();

            Optional<String> maybeSql = ruleSqlRegistry.getSqlForRule(ruleCode);
            if (maybeSql.isEmpty()) {
                log.warn("No SQL found for rule {}. Skipping execution.", ruleCode);
                continue;
            }

            String sql = maybeSql.get();
            try {
                jdbcTemplate.execute(sql);
                log.info("Rule [{}] executed successfully. Output table created/populated.", ruleCode);
            } catch (DataAccessException dae) {
                log.error("DataAccessException while executing rule [{}]: {}", ruleCode, dae.getMessage(), dae);
                failedRules.add(ruleCode + " (DataAccessException: " + dae.getMessage() + ")");
            } catch (Exception e) {
                log.error("Error while executing rule [{}]: {}", ruleCode, e.getMessage(), e);
                failedRules.add(ruleCode + " (Exception: " + e.getMessage() + ")");
            }
        }

        if (failedRules.isEmpty()) {
            log.info("Finished executing all active rule scripts successfully.");
            return CompletableFuture.completedFuture(new RunResult(true,
                    "All rules executed successfully."));
        } else {
            String failureMsg = "Some rules failed: " + String.join(", ", failedRules);
            log.error(failureMsg);
            return CompletableFuture.completedFuture(new RunResult(false, failureMsg));
        }
    }

    public record ValidationResult(boolean success, String message) {}

    public record RunResult(boolean success, String message) {}
}
