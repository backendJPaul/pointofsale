package com.jpaul.service;

import com.jpaul.model.Product;

import java.util.List;


public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);

}
