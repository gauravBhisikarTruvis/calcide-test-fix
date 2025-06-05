package com.calcite_new.sql.recommender.analyzer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueryLogAnalyzerTest {

    @Test
    public void testProcessQueryLog() {
        QueryLog queryLog = QueryLog.builder()
                .queryId("Q12345")
                .sessionId("S12345")
                .userName("stuti")
                .database("project1")
                .schema("foodmart")
                .sqlText("Delete from foodmart.employee where true;")
                .startTime(System.currentTimeMillis())
                .executionTime(500L)
                .build();

        QueryLogAnalyzer analyzer = new QueryLogAnalyzer("BIG_QUERY");

        QueryAnalysisModel result = analyzer.process(queryLog);

        assertNotNull(result, "Analysis result should not be null");
    }
}