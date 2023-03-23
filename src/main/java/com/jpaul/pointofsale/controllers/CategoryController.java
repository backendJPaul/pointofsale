package com.jpaul.pointofsale.controllers;

import com.jpaul.pointofsale.dao.DAOManager;
import com.jpaul.pointofsale.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    DAOManager daoManager = new DAOManager();

    @GetMapping("api/category")
    public List<Category> fetch()throws Exception{
        Category category = new Category();
        category.setIdCatalogStatus(1);

        return daoManager.getDAOCategory().fetch(category);
    }

    @GetMapping("api/category/{id}")
    public Category gotoId(@PathVariable int id)throws Exception{
        Category category = new Category();
        category.setIdCategory(id);
        category.setIdCatalogStatus(1);
        return daoManager.getDAOCategory().gotoId(category);
    }

    @PostMapping("api/category/")
    public Category save(@RequestBody Category category)throws Exception{
        return daoManager.getDAOCategory().save(category);
    }

    @PutMapping("api/category/")
    public Category update(@RequestBody Category category)throws Exception{
        return daoManager.getDAOCategory().update(category);
    }

    @DeleteMapping("api/category/")
    public Category delete(@RequestBody Category category)throws Exception{
        return daoManager.getDAOCategory().delete(category);
    }

    @PostMapping ("api/category/search/")
    public List<Category> search(@RequestBody Category category)throws Exception{
        return daoManager.getDAOCategory().search(category);
    }
}
