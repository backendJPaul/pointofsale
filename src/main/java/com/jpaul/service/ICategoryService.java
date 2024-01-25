package com.jpaul.service;

import com.jpaul.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category _category);
    Category update(Category _category);
    void delete(Long id);
}
