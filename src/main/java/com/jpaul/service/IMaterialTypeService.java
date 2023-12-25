package com.jpaul.service;

import com.jpaul.model.MaterialType;

import java.util.List;

public interface IMaterialTypeService{
    List<MaterialType> findAll();
    MaterialType save(MaterialType materialType);
    MaterialType findById(long id);
}
