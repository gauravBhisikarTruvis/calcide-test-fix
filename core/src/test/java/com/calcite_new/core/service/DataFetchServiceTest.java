package com.calcite_new.core.service;

import com.calcite_new.core.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DataFetchServiceTest {
    private DataFetchService service;
    private TableRepository tableRepo = mock(TableRepository.class);
    private ViewRepository viewRepo = mock(ViewRepository.class);
    private QueryLogRepository queryLogRepo = mock(QueryLogRepository.class);
    private ColumnRepository columnRepo = mock(ColumnRepository.class);
    private ExternalTableRepository externalTableRepo = mock(ExternalTableRepository.class);
    private FunctionRepository functionRepo = mock(FunctionRepository.class);
    private IndicesRepository indicesRepo = mock(IndicesRepository.class);
    private MacroRepository macroRepo = mock(MacroRepository.class);
    private PartitionRepository partitionRepo = mock(PartitionRepository.class);
    private ProcedureRepository procedureRepo = mock(ProcedureRepository.class);

    @BeforeEach
    void setup() {
        service = new DataFetchService(
                queryLogRepo,
                tableRepo,
                columnRepo,
                viewRepo,
                externalTableRepo,
                functionRepo,
                indicesRepo,
                macroRepo,
                partitionRepo,
                procedureRepo
        );
    }

    @Test
    void testGetAllTables() {
        when(tableRepo.fetchAllTables()).thenReturn(List.of());
        assertDoesNotThrow(() -> service.getAllTables());
        verify(tableRepo, times(1)).fetchAllTables();
    }

    @Test
    void testGetAllViews() {
        when(viewRepo.fetchAllViews()).thenReturn(List.of());
        assertDoesNotThrow(() -> service.getAllViews());
        verify(viewRepo, times(1)).fetchAllViews();
    }
}
