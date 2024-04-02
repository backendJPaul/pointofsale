package com.jpaul.repository;

import com.jpaul.model.Color;
import com.jpaul.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISizeRepository extends JpaRepository<Size, Long> {

}
