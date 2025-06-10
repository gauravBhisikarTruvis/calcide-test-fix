package com.calcite_new.sqlanalyzer.recommendation.controller;

import com.calcite_new.sqlanalyzer.recommendation.RuleExecutorRunner;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/rules")
@RequiredArgsConstructor
public class RuleExecutionController {

    private final RuleExecutorRunner ruleExecutorRunner;

    @PostMapping("/validate")
    public CompletableFuture<ResponseEntity<String>> validateRules() {
        return ruleExecutorRunner.validateSqlFilesForActiveRules()
                .thenApply(result -> {
                    if (result.success()) {
                        return ResponseEntity.ok("Validation succeeded: " + result.message());
                    } else {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Validation failed: " + result.message());
                    }
                });
    }

    @PostMapping("/run")
    public CompletableFuture<ResponseEntity<String>> runRules() {
        return ruleExecutorRunner.runRules()
                .thenApply(result -> {
                    if (result.success()) {
                        return ResponseEntity.ok("Rule execution succeeded: " + result.message());
                    } else {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Rule execution failed: " + result.message());
                    }
                });
    }
}