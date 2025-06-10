package com.calcite_new.sqlanalyzer.service;

import com.calcite_new.sqlanalyzer.analyzer.QueryLogAnalyzer;
import com.calcite_new.sqlanalyzer.dto.QueryLog;
import com.calcite_new.sqlanalyzer.model.entity.QueryAnalysisModel;
import com.calcite_new.sqlanalyzer.model.enums.QueryType;
import com.calcite_new.sqlanalyzer.repository.QueryAnalysisRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryAnalysisService {

    private final QueryLogAnalyzer queryLogAnalyzer;
    private final QueryAnalysisRepository queryAnalysisRepository;

    @Transactional
    public QueryAnalysisModel analyzeAndPersist(QueryLog queryLog) {
        QueryAnalysisModel model = queryLogAnalyzer.analyze(queryLog);
        return queryAnalysisRepository.save(model);
    }

    public QueryAnalysisModel save(QueryAnalysisModel model) {
        return queryAnalysisRepository.save(model);
    }
}