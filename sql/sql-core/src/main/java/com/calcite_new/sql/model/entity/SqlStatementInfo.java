package com.calcite_new.sql.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.calcite_new.sql.model.enums.StatementType;
import com.calcite_new.sql.model.enums.StatementStatus;
import com.calcite_new.sql.model.enums.ErrorDescription;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logId;
    private String statementId;
    private String database;
    private String schema;
    private String sessionId;
    private String userName;

    @Enumerated(EnumType.STRING)
    private StatementStatus statementStatus;

    @Embedded
    private ErrorDescription errorDescription;

    @Enumerated(EnumType.STRING)
    private StatementType statementType;

    private Long queryExecutionTime;

    @OneToMany(mappedBy = "sqlStatementInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntityRelationship> entityRelationships;

    @OneToOne(mappedBy = "sqlStatementInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private StatementContext statementContext;

    public void setEntityRelationships(List<EntityRelationship> entityRelationships) {
        this.entityRelationships = entityRelationships != null ? entityRelationships : new ArrayList<>();
        for (EntityRelationship er : this.entityRelationships) {
            er.setSqlStatementInfo(this);
        }
    }

    public void setStatementContext(StatementContext context) {
        this.statementContext = context;
        if (context != null) {
            context.setSqlStatementInfo(this);
        }
    }

    public void setErrorDescription(ErrorDescription errorDescription) {
        if (this.statementStatus == StatementStatus.ERROR || this.statementStatus == StatementStatus.PARSE_ERROR) {
            this.errorDescription = errorDescription;
        } else {
            this.errorDescription = null;
        }
    }

    // Convenience method to set error description from exception
    public void setErrorDescription(Exception exception) {
        if (this.statementStatus == StatementStatus.ERROR || this.statementStatus == StatementStatus.PARSE_ERROR) {
            this.errorDescription = ErrorDescription.of(exception);
        } else {
            this.errorDescription = null;
        }
    }

    // Convenience method to set error description from string
    public void setErrorDescription(String errorMessage) {
        if (this.statementStatus == StatementStatus.ERROR || this.statementStatus == StatementStatus.PARSE_ERROR) {
            this.errorDescription = ErrorDescription.of(errorMessage);
        } else {
            this.errorDescription = null;
        }
    }
}