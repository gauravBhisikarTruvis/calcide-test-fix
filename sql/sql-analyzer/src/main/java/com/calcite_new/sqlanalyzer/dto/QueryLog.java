package com.calcite_new.sqlanalyzer.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryLog {
        private String logId;
        private String product;        
        private String database;
        private String schema;
        private String sqlText;
        private String sessionId;        
        private String userName;        
        private Long startTime;        
        private Long executionTime;
}
