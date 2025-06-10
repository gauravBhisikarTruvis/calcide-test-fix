package com.calcite_new.sqlanalyzer.repository;

import com.calcite_new.sqlanalyzer.model.entity.QueryAnalysisModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryAnalysisRepository extends JpaRepository<QueryAnalysisModel, String> {
/*    List<QueryAnalysisModel> findByQueryTypeAndQueryContext_WhereClause_HasTrueCondition(
            QueryType queryType, Boolean hasTrueCondition);*/
}
