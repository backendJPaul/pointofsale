package com.jpaul.service;

import com.jpaul.exception.ResourceNotFoundException;
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
    public List<ProductDetail> findByProduct(long id) {

        return null;
    }

    @Override
    public ProductDetail save(ProductDetail _productDetail) {
        ProductDetail productDetail = iProductDetailRepository.save(_productDetail);
        return productDetail;
    }

    @Override
    public ProductDetail update(ProductDetail _productDetail) {

        Optional<ProductDetail> productOptional = iProductDetailRepository.findById(_productDetail.getId());
        if(productOptional.isPresent()){

            ProductDetail productDetail = productOptional.get();

            productDetail.setDescription(_productDetail.getDescription());
            productDetail.setPurchasePrice(_productDetail.getPurchasePrice());
            productDetail.setSalePrice(_productDetail.getSalePrice());
            productDetail.setStock(_productDetail.getStock());
            productDetail.setColor(_productDetail.getColor());
            productDetail.setSize(_productDetail.getSize());
            productDetail.setProduct(_productDetail.getProduct());
            productDetail.setStatus(_productDetail.getStatus());

            iProductDetailRepository.save(productDetail);

            return productDetail;
        }
        else {
            throw new ResourceNotFoundException("Resource not found by id" + _productDetail.getId());
        }
    }

    @Override
    public ProductDetail delete(Long id) {
        Optional<ProductDetail> productDetailOptional = iProductDetailRepository.findById(id);
        if(productDetailOptional.isPresent()){
            iProductDetailRepository.delete(productDetailOptional.get());
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + productDetailOptional.get().getId());
        }
        return null;
    }
}
