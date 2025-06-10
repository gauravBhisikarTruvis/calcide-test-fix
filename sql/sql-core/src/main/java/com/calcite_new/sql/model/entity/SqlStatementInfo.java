package com.calcite_new.sql.model.entity;

import java.util.List;

import com.calcite_new.sql.model.enums.QueryStatus;
import com.calcite_new.sql.model.enums.QueryType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sql_statement_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SqlStatementInfo {

    @Id
    private String logId;
    private String statementId;
    private String database;
    private String schema;
    private String sessionId;
    private String userName;

    @Enumerated(EnumType.STRING)
    private QueryStatus queryStatus;

    @Enumerated(EnumType.STRING)
    private QueryType queryType;

    private Long queryExecutionTime;

    @OneToMany(mappedBy = "sqlStatementInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntityRelationship> entityRelationships;


    @OneToOne(mappedBy = "sqlStatementInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private QueryContext queryContext;
}

