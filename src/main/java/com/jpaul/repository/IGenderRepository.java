package com.jpaul.repository;

import com.jpaul.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenderRepository extends JpaRepository<Gender, Long> {

}
