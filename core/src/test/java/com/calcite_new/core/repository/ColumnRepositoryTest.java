package com.calcite_new.core.repository;

import com.calcite_new.core.config.HibernateUtil;
import com.calcite_new.core.entity.ColumnEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Provides 100% test coverage for the ColumnRepository class.
 */
@ExtendWith(MockitoExtension.class)
class ColumnRepositoryTest {

    @Mock
    private SessionFactory mockSessionFactory;
    @Mock
    private Session mockSession;
    @Mock
    private Query<ColumnEntity> mockQuery;
    @Mock
    private Logger mockLogger;

    private MockedStatic<HibernateUtil> mockedHibernateUtil;
    private MockedStatic<LoggerFactory> mockedLoggerFactory;

    @InjectMocks
    private ColumnRepository columnRepository;

    @BeforeEach
    void setUp() {
        // FIX: Correctly initialize static mocks before use.
        mockedHibernateUtil = Mockito.mockStatic(HibernateUtil.class);
        mockedLoggerFactory = Mockito.mockStatic(LoggerFactory.class);

        // FIX: Use the correct syntax for stubbing static methods.
        mockedHibernateUtil.when(HibernateUtil::getSessionFactory).thenReturn(mockSessionFactory);
        when(mockSessionFactory.openSession()).thenReturn(mockSession);

        // Mock the logger factory to return our mock logger
        mockedLoggerFactory.when(() -> LoggerFactory.getLogger(any(Class.class))).thenReturn(mockLogger);
    }

    @AfterEach
    void tearDown() {
        // Close the static mocks to prevent test leakage.
        mockedHibernateUtil.close();
        mockedLoggerFactory.close();
    }

    @Test
    void testFetchAllColumns_success() {
        List<ColumnEntity> expectedList = Collections.singletonList(new ColumnEntity());
        when(mockSession.createQuery("FROM ColumnEntity", ColumnEntity.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(expectedList);

        List<ColumnEntity> result = columnRepository.fetchAllColumns();

        assertEquals(expectedList, result);
        verify(mockSession, times(1)).close();
    }

    @Test
    void testFetchAllColumns_exception() {
        when(mockSession.createQuery("FROM ColumnEntity", ColumnEntity.class)).thenThrow(new RuntimeException("DB error"));

        Exception ex = assertThrows(RuntimeException.class, () -> columnRepository.fetchAllColumns());
        assertEquals("DB error", ex.getMessage());

        verify(mockLogger).error(eq("Error fetching columns"), any(RuntimeException.class));
        verify(mockSession, times(1)).close();
    }

    @Test
    void testFindByTableName_success() {
        String tableName = "test_table";
        List<ColumnEntity> expectedList = Collections.singletonList(new ColumnEntity());
        when(mockSession.createQuery("FROM ColumnEntity WHERE objectName = :tableName", ColumnEntity.class)).thenReturn(mockQuery);
        when(mockQuery.setParameter("tableName", tableName)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(expectedList);

        List<ColumnEntity> result = columnRepository.findByTableName(tableName);

        assertEquals(expectedList, result);
        verify(mockSession, times(1)).close();
    }

    @Test
    void testFindByTableName_exception() {
        String tableName = "bad_table";
        when(mockSession.createQuery("FROM ColumnEntity WHERE objectName = :tableName", ColumnEntity.class)).thenThrow(new RuntimeException("Query error"));

        Exception ex = assertThrows(RuntimeException.class, () -> columnRepository.findByTableName(tableName));
        assertEquals("Query error", ex.getMessage());

        verify(mockLogger).error(eq("Error fetching columns for table: {}"), eq(tableName), any(RuntimeException.class));
        verify(mockSession, times(1)).close();
    }
}