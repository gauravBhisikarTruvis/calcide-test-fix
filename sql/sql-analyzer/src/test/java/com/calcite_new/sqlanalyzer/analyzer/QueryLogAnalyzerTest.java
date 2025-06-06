package com.calcite_new.sqlanalyzer.analyzer;

import com.calcite_new.sqlanalyzer.model.entity.QueryAnalysisModel;
import com.calcite_new.sqlanalyzer.dto.QueryLog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueryLogAnalyzerTest {

    @Test
    public void testAnalyzeQueryLog() {
        QueryLog queryLog = QueryLog.builder()
                .logId("Q12345")
                .sessionId("S12345")
                .userName("stuti")
                .database("project1")
                .schema("foodmart")
                .sqlText("Delete from foodmart.employee where true;")
                .startTime(System.currentTimeMillis())
                .executionTime(500L)
                .build();

        QueryLogAnalyzer analyzer = new QueryLogAnalyzer();

        QueryAnalysisModel result = analyzer.analyze(queryLog);

        assertNotNull(result, "Analysis result should not be null");
    }
}