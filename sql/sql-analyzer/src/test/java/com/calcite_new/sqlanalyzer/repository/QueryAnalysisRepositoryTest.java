package com.calcite_new.sqlanalyzer.repository;


import com.calcite_new.sqlanalyzer.model.entity.QueryAnalysisModel;
import com.calcite_new.sqlanalyzer.model.entity.QueryContext;
import com.calcite_new.sqlanalyzer.model.entity.context.clause.WhereClause;
import com.calcite_new.sqlanalyzer.model.enums.QueryStatus;
import com.calcite_new.sqlanalyzer.model.enums.QueryType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QueryAnalysisRepositoryTest {

/*    @Autowired
    private QueryAnalysisRepository repository;

    @Test
    public void testSaveAndFindDeleteWithTrueCondition() {
        QueryAnalysisModel model = QueryAnalysisModel.builder()
                .database("project1")
                .schema("foodmart")
                .sessionId("session123")
                .userName("user1")
                .queryStatus(QueryStatus.SUCCESS)
                .queryType(QueryType.DELETE)
                .logId("query123")
                .queryExecutionTime(1000L)
                .build();

        WhereClause whereClause = WhereClause.builder()
                .hasTrueCondition(true)
                .build();

        QueryContext context = QueryContext.builder()
                .whereClause(whereClause)
                .queryAnalysisModel(model)
                .build();

        model.setQueryContext(context);

        repository.save(model);

        List<QueryAnalysisModel> result = repository.findByQueryTypeAndQueryContext_WhereClause_HasTrueCondition(QueryType.DELETE, true);
        assertThat(result).isNotEmpty();
        assertThat(result.getFirst().getLogId()).isEqualTo("query123");
    }*/
}
