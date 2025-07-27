package com.calcite_new.core.repository;

import com.calcite_new.core.entity.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTableRepository extends JpaRepository<TableEntity, String> {
    List<TableEntity> findAll();
    List<TableEntity> findByDatabaseAndSchema(String database, String schema);
}
