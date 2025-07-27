package com.calcite_new.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = {"com.calcite_new.core.entity"})
@EnableJpaRepositories(basePackages = {"com.calcite_new.core.repository"})
public class JpaConfig {
    // JPA configuration will be automatically handled by Spring Boot
}
