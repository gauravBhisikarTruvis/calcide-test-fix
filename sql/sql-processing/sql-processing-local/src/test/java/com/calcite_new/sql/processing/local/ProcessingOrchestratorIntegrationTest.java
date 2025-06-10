package com.calcite_new.sql.processing.local;

import com.calcite_new.sql.core.processor.QueryRecordProcessor;
import com.calcite_new.sql.model.QueryRecord;
import com.calcite_new.sql.model.entity.SqlStatementInfo;
import com.calcite_new.sql.model.enums.QueryStatus;
import com.calcite_new.sql.model.enums.QueryType;
import com.calcite_new.sql.processing.local.repository.SqlStatementInfoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        classes = QueryRecordProcessorApplication.class
)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProcessingOrchestratorIntegrationTest {

    @Autowired
    private QueryRecordProcessor processor;

    @Autowired
    private BatchPersister persister;

    @Autowired
    private SqlStatementInfoRepository repository;

    private ProcessingOrchestrator orchestrator;

    @BeforeAll
    void setup() {
        ExecutorService persistenceExecutor = Executors.newSingleThreadExecutor();

        persister.configure(1, persistenceExecutor);

        orchestrator = new ProcessingOrchestrator(processor, persister);
        orchestrator.init();

    }

    @BeforeEach
    void cleanDb() {
        repository.deleteAll();
    }

    @Test
    void testRecordsAreStoredInDb() {
        // given
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

        // when
        orchestrator.process(List.of(record));

        // then
        List<SqlStatementInfo> persisted = repository.findAll();
        assertEquals(1, persisted.size());

        SqlStatementInfo info = persisted.get(0);
        assertEquals("stuti", info.getUserName());
        assertEquals("DELETE", info.getQueryType().name());
    }
}
