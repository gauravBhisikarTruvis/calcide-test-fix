package com.calcite_new.core.repository;

import com.calcite_new.core.entity.QueryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaQueryLogRepository extends JpaRepository<QueryLog, String> {
    List<QueryLog> findBySqlQueryContaining(String queryText);
}
