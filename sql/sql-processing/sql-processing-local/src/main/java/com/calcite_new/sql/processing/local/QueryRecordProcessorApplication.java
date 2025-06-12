package com.calcite_new.sql.processing.local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.calcite_new.sql.core.processor",
        "com.calcite_new.sql.processing.local",
        "com.calcite_new.core.data_ingestor",
        "com.calcite_new.core"
})
@EntityScan(basePackages = {
        "com.calcite_new.sql.model.entity",
        "com.calcite_new.core.data_ingestor.entity"
})
@EnableJpaRepositories(basePackages = {
        "com.calcite_new.sql.processing.local.repository",
        "com.calcite_new.core.data_ingestor.repository"
})
public class QueryRecordProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryRecordProcessorApplication.class, args);
    }
}
