package com.jpaul.service;

import com.jpaul.model.ProductDetail;
import com.jpaul.repository.IProductDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductDetailServiceImpl implements IProductDetailService{

    IProductDetailRepository iProductDetailRepository;

    @Override
    public List<ProductDetail> findAll() {
        List<ProductDetail> productDetailList = iProductDetailRepository.findAll();
        return productDetailList;
    }

    @Override
    public ProductDetail findById(Long id) {
        Optional<ProductDetail> productDetail = iProductDetailRepository.findById(id);
        return productDetail.get();
    }

    @Override
    public ProductDetail save(ProductDetail _productDetail) {
        ProductDetail productDetail = iProductDetailRepository.save(_productDetail);
        return productDetail;
    }

    @Override
    public ProductDetail update(Long id, ProductDetail _productDetail) {
        ProductDetail productDetail = iProductDetailRepository.findById(id).get();
        productDetail.setDescription(_productDetail.getDescription());
        productDetail.setPurchasePrice(_productDetail.getPurchasePrice());
        productDetail.setSalePrice(_productDetail.getSalePrice());
        productDetail.setStock(_productDetail.getStock());
        productDetail.setColor(_productDetail.getColor());
        productDetail.setSize(_productDetail.getSize());
        productDetail.setProduct(_productDetail.getProduct());

        iProductDetailRepository.save(productDetail);
        System.out.println(productDetail.toString());

        return null;
    }
}
