package com.calcite_new.core.data_ingestor.config;

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
            
            // Load application.properties
            Properties props = new Properties();
            try (FileInputStream fis = new FileInputStream("C:/Users/Lenovo/Downloads/GitLab Repo/Calcide-new-PgToPojo/calcite-new/core/src/main/resources/application.properties")) {
                props.load(fis);
                logger.debug("Loaded application.properties successfully");
                
                // Set hibernate properties
                configuration.setProperties(props);
                
                // Add entity mappings
                String mappingClasses = props.getProperty("hibernate.mapping.classes", "");
                if (!mappingClasses.isEmpty()) {
                    for (String className : mappingClasses.split(",")) {
                        try {
                            Class<?> entityClass = Class.forName(className.trim());
                            configuration.addAnnotatedClass(entityClass);
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
