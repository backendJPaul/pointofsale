package com.jpaul.service;

import com.jpaul.exception.ResourceNotFoundException;
import com.jpaul.model.Category;
import com.jpaul.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.get();
    }

    @Override
    public Category save(Category _category) {
        return categoryRepository.save(_category);
    }

    @Override
    public Category update(Category _category) {
        Optional<Category> category = this.categoryRepository.findById(_category.getId());
        if(category.isPresent()){
            Category categoryTemp = category.get();
            categoryTemp.setIcon(_category.getIcon());
            categoryTemp.setName(_category.getName());
            categoryRepository.save(categoryTemp);
            return categoryTemp;
        }
        else {
            throw new ResourceNotFoundException("Record not found with id :" +  _category.getId());
        }
    }
    @Override
    public Category delete(Long id) {
        return categoryRepository.;
    }
}



