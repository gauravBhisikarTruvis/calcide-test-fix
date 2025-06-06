package com.calcite_new.sqlanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.calcite_new.sqlanalyzer")
public class SqlAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlAnalyzerApplication.class, args);
    }
}
