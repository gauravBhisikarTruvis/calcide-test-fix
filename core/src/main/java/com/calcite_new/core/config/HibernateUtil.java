package com.calcite_new.core.config;

import com.calcite_new.core.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            logger.info("Initializing Hibernate SessionFactory");
            Configuration configuration = new Configuration();
            
            // Load application.properties from classpath
            Properties props = new Properties();
            try (java.io.InputStream is = HibernateUtil.class.getClassLoader()
                    .getResourceAsStream("application.properties")) {
                if (is == null) {
                    throw new RuntimeException("Cannot find application.properties in classpath");
                }
                props.load(is);
                logger.debug("Loaded application.properties from classpath successfully");
                
                // Set hibernate properties
                configuration.setProperties(props);
                
                // Add entity mappings
                configuration.addAnnotatedClass(TableEntity.class);
                configuration.addAnnotatedClass(ColumnEntity.class);
                configuration.addAnnotatedClass(ViewEntity.class);
                configuration.addAnnotatedClass(FunctionEntity.class);
                configuration.addAnnotatedClass(ProcedureEntity.class);
                configuration.addAnnotatedClass(MacroEntity.class);
                configuration.addAnnotatedClass(ExternalTableEntity.class);
                configuration.addAnnotatedClass(IndicesEntity.class);
                configuration.addAnnotatedClass(PartitionEntity.class);
                configuration.addAnnotatedClass(QueryLog.class);







                // Optional: Keep the dynamic loading from properties as fallback
                String mappingClasses = props.getProperty("hibernate.mapping.classes", "");
                if (!mappingClasses.isEmpty()) {
                    for (String className : mappingClasses.split(",")) {
                        try {
                            if (!className.trim().isEmpty()) {
                                Class<?> entityClass = Class.forName(className.trim());
                                configuration.addAnnotatedClass(entityClass);
                            }
                        } catch (ClassNotFoundException e) {
                            logger.error("Could not load entity class: {}", className, e);
                            throw new RuntimeException("Failed to load entity class: " + className, e);
                        }
                    }
                }
            } catch (IOException e) {
                logger.error("Could not load application.properties", e);
                throw new RuntimeException("Could not load application.properties", e);
            }
            
            logger.info("Building SessionFactory");
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("Initial SessionFactory creation failed", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        logger.info("Shutting down Hibernate SessionFactory");
        getSessionFactory().close();
    }
}
