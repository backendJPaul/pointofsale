package com.jpaul.repository;

import com.jpaul.model.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialTypeRepository extends JpaRepository<MaterialType,Long> {
}
