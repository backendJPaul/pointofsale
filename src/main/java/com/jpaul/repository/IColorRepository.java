package com.jpaul.repository;

import com.jpaul.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColorRepository extends JpaRepository<Color, Long> {

}
