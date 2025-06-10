/*
package com.calcite_new.sql.processing.local;

import com.calcite_new.sql.core.processor.QueryRecordProcessor;
import com.calcite_new.sql.model.QueryRecord;
import com.calcite_new.sql.model.entity.SqlStatementInfo;
import com.calcite_new.sql.model.enums.QueryStatus;
import com.calcite_new.sql.model.enums.QueryType;
import com.calcite_new.sql.processing.local.repository.SqlStatementInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProcessingOrchestratorTest {

    private QueryRecordProcessor processor;
    private SqlStatementInfoRepository repository;

    private BatchPersister persister;
    private ProcessingOrchestrator orchestrator;

    @BeforeEach
    void setup() {
        processor = new QueryRecordProcessor();
        persister = new BatchPersister(repository);
        orchestrator = new ProcessingOrchestrator(processor, persister);
        orchestrator.init(); // simulate Spring lifecycle
    }

    @Test
    public void testProcess_withValidRecords() {
        QueryRecord record = QueryRecord.builder()
                .logId("query123")
                .sessionId("session123")
                .userName("stuti")
                .database("project1")
                .schema("foodmart")
                .sqlText("DELETE FROM foodmart.employee WHERE TRUE;")
                .startTime(System.currentTimeMillis())
                .executionTime(500L)
                .build();
        List<SqlStatementInfo> mockResult = List.of(SqlStatementInfo.builder()
                .database("project1")
                .schema("foodmart")
                .sessionId("session123")
                .userName("user1")
                .queryStatus(QueryStatus.SUCCESS)
                .queryType(QueryType.DELETE)
                .logId("query123")
                .queryExecutionTime(1000L)
                .build());


        orchestrator.process(List.of(record));

        verify(repository, atLeastOnce()).saveAll(any());

    }
}
*/
