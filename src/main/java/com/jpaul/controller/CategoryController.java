package com.jpaul.controller;

import com.jpaul.model.Category;
import com.jpaul.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api/categories")
public class CategoryController{

    private ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categoryList = iCategoryService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @GetMapping({"id"})
    public ResponseEntity<Category> findById(@PathVariable("id") Long id) {
        Category category = iCategoryService.findById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category _category) {
        Category category = iCategoryService.save(_category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}