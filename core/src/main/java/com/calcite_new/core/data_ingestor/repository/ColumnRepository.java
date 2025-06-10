package com.calcite_new.core.data_ingestor.repository;


import com.calcite_new.core.data_ingestor.config.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.calcite_new.core.data_ingestor.entity.*;
import java.util.List;

public class ColumnRepository {
    private static final Logger logger = LoggerFactory.getLogger(ColumnRepository.class);

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