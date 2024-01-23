package com.jpaul.service;

import com.jpaul.model.ProductDetail;

import java.util.List;

public interface IProductDetailService {
    List<ProductDetail> findAll();
    ProductDetail findById(Long id);
    ProductDetail save(ProductDetail _productDetail);
    ProductDetail update(Long id, ProductDetail _productDetail);
}