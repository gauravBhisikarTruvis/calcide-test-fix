package com.calcite_new.sqlanalyzer.controller;

import com.calcite_new.sqlanalyzer.dto.QueryLog;
import com.calcite_new.sqlanalyzer.model.entity.QueryAnalysisModel;
import com.calcite_new.sqlanalyzer.service.QueryAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/query-analysis")
public class QueryAnalysisController {

    private final QueryAnalysisService queryAnalysisService;

    @PostMapping("/analyze")
    public ResponseEntity<String> analyzeQuery(@RequestBody QueryLog log) {
        QueryAnalysisModel saved = queryAnalysisService.analyzeAndPersist(log);
        return ResponseEntity.ok("Saved ID: " + saved.getLogId());
    }

    @PostMapping("/save")
    public QueryAnalysisModel save(@RequestBody QueryAnalysisModel model) {
        return queryAnalysisService.save(model);
    }
}
