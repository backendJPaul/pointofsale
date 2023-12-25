package com.jpaul.repository;

import com.jpaul.model.Enterprise;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
