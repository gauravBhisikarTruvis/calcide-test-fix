package com.calcite_new.sqlanalyzer.analyzer;

import com.calcite_new.sqlanalyzer.dto.QueryLog;
import com.calcite_new.sqlanalyzer.model.entity.QueryAnalysisModel;
import com.calcite_new.sqlanalyzer.model.enums.QueryStatus;
import com.calcite_new.sqlanalyzer.repository.QueryAnalysisRepository;
import com.calcite_new.sqlanalyzer.service.QueryAnalysisService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class QueryLogAnalyzerIntegrationTest {

    @Autowired
    private QueryAnalysisRepository queryAnalysisRepository;

    @Autowired
    private QueryAnalysisService queryAnalysisService;

    @Test
    @Transactional
    public void testAnalyzeQueryAndPersist() {
        // given
        String sql = """
                INSERT INTO foodmart.sales_fact_1998 (product_id, customer_id, amount)
                SELECT product_id, customer_id, SUM(store_sales)
                FROM foodmart.sales_fact_1997
                WHERE store_sales > 10
                GROUP BY product_id, customer_id
                """;

        QueryLog queryLog = QueryLog.builder()
                .logId(UUID.randomUUID().toString())
                .sqlText(sql)
                .database("foodmart")
                .schema("public")
                .sessionId("session_abc123")
                .userName("test_user")
                .build();

        // when
        QueryAnalysisModel model = queryAnalysisService.analyzeAndPersist(queryLog);

        // then
        assertThat(model).isNotNull();
        assertThat(model.getQueryStatus()).isEqualTo(QueryStatus.SUCCESS);
        assertThat(model.getEntityRelationships()).isNotEmpty();
        assertThat(model.getQueryContext()).isNotNull();
        assertThat(model.getQueryContext().getSelectClause()).isNotNull();

        // verify persistence
        List<QueryAnalysisModel> allModels = queryAnalysisRepository.findAll();

        assertFalse(allModels.isEmpty());

        boolean sessionIdFound = allModels.stream()
                .anyMatch(qam -> qam.getSessionId().equals(queryLog.getSessionId()));

        assertTrue(sessionIdFound);
    }
}
