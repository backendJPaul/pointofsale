package com.jpaul.service;

import com.jpaul.model.Gender;

import java.util.List;

public interface IGenderService {
    List<Gender> findAll();
    Gender save(Gender _gender);
    Gender findById(long id);
    Gender update(Gender _gender);
    void delete(long _id);
}
