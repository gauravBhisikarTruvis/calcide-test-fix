package com.calcite_new.core.repository;

import com.calcite_new.core.config.HibernateUtil;
import com.calcite_new.core.entity.ColumnEntity;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColumnRepository {
    // Changed logger to non-static for testability
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public List<ColumnEntity> fetchAllColumns() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                "FROM ColumnEntity", 
                ColumnEntity.class)
                .getResultList();
        } catch (Exception e) {
            logger.error("Error fetching columns", e);
            throw e;
        }
    }

    public List<ColumnEntity> findByTableName(String tableName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                "FROM ColumnEntity WHERE objectName = :tableName", 
                ColumnEntity.class)
                .setParameter("tableName", tableName)
                .getResultList();
        } catch (Exception e) {
            logger.error("Error fetching columns for table: {}", tableName, e);
            throw e;
        }
    }
}