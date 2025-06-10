package com.calcite_new.sqlanalyzer.recommendation.repository;

import com.calcite_new.sqlanalyzer.recommendation.entity.RuleMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RuleMetadataRepository extends JpaRepository<RuleMetadata, Long> {
    List<RuleMetadata> findByIsActiveTrue();
}
