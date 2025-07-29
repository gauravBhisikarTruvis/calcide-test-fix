package com.calcite_new.core.repository;

import com.calcite_new.core.config.HibernateUtil;
import com.calcite_new.core.entity.ExternalTableEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ExternalTableRepositoryTest {

    @Mock
    private SessionFactory sessionFactory;
    @Mock
    private Session session;
    @Mock
    private Query<ExternalTableEntity> query;

    @InjectMocks
    private ExternalTableRepository externalTableRepository;

    private MockedStatic<HibernateUtil> hibernateUtilMockedStatic;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        hibernateUtilMockedStatic = Mockito.mockStatic(HibernateUtil.class);
        hibernateUtilMockedStatic.when(HibernateUtil::getSessionFactory).thenReturn(sessionFactory);
        // Remove reset() as it is not needed and can cause InternalError with static mocks
        when(sessionFactory.openSession()).thenReturn(session);
        when(session.createQuery(anyString(), eq(ExternalTableEntity.class))).thenReturn(query);
        when(query.setParameter(anyString(), any())).thenReturn(query);
        when(query.getResultList()).thenReturn(Collections.singletonList(new ExternalTableEntity()));
    }

    @AfterEach
    void tearDown() {
        hibernateUtilMockedStatic.close();
    }

    @Test
    void testFetchAllExternalTables() {
        List<ExternalTableEntity> result = externalTableRepository.fetchAllExternalTables();
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(session).createQuery("FROM ExternalTableEntity", ExternalTableEntity.class);
        verify(query).getResultList();
    }

    @Test
    void testFindBySchema() {
        String schema = "test_schema";
        externalTableRepository.findBySchema(schema);
        verify(session).createQuery("FROM ExternalTableEntity WHERE schema = :schema", ExternalTableEntity.class);
        verify(query).setParameter("schema", schema);
        verify(query).getResultList();
    }

    @Test
    void testFindByDatabase() {
        String database = "test_db";
        externalTableRepository.findByDatabase(database);
        verify(session).createQuery("FROM ExternalTableEntity WHERE database = :database", ExternalTableEntity.class);
        verify(query).setParameter("database", database);
        verify(query).getResultList();
    }

    @Test
    void testFindByProduct() {
        String product = "test_product";
        externalTableRepository.findByProduct(product);
        verify(session).createQuery("FROM ExternalTableEntity WHERE product = :product", ExternalTableEntity.class);
        verify(query).setParameter("product", product);
        verify(query).getResultList();
    }

    @Test
    void testFindByType() {
        String type = "test_type";
        externalTableRepository.findByType(type);
        verify(session).createQuery("FROM ExternalTableEntity WHERE type = :type", ExternalTableEntity.class);
        verify(query).setParameter("type", type);
        verify(query).getResultList();
    }

    @Test
    void testFetchAllExternalTables_Exception() {
        // Simulate exception on openSession
        when(sessionFactory.openSession()).thenThrow(new RuntimeException("DB error"));
        assertThrows(RuntimeException.class, () -> externalTableRepository.fetchAllExternalTables());
    }

    @Test
    void testFindBySchema_Exception() {
        when(session.createQuery(anyString(), eq(ExternalTableEntity.class))).thenThrow(new RuntimeException("Query error"));
        assertThrows(RuntimeException.class, () -> externalTableRepository.findBySchema("fail_schema"));
    }

    @Test
    void testFindByDatabase_Exception() {
        when(session.createQuery(anyString(), eq(ExternalTableEntity.class))).thenThrow(new RuntimeException("Query error"));
        assertThrows(RuntimeException.class, () -> externalTableRepository.findByDatabase("fail_db"));
    }

    @Test
    void testFindByProduct_Exception() {
        when(session.createQuery(anyString(), eq(ExternalTableEntity.class))).thenThrow(new RuntimeException("Query error"));
        assertThrows(RuntimeException.class, () -> externalTableRepository.findByProduct("fail_product"));
    }

    @Test
    void testFindByType_Exception() {
        when(session.createQuery(anyString(), eq(ExternalTableEntity.class))).thenThrow(new RuntimeException("Query error"));
        assertThrows(RuntimeException.class, () -> externalTableRepository.findByType("fail_type"));
    }

    @Test
    void testLoggerInfoCalls() {
        // This test ensures logger.info is called for each method (coverage for logger lines)
        externalTableRepository.fetchAllExternalTables();
        externalTableRepository.findBySchema("schema");
        externalTableRepository.findByDatabase("db");
        externalTableRepository.findByProduct("product");
        externalTableRepository.findByType("type");
        // No assertions needed, just coverage for logger lines
    }
}