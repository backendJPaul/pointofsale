package com.jpaul.service;

import com.jpaul.exception.ResourceNotFoundException;
import com.jpaul.model.Product;
import com.jpaul.model.Purchase;
import com.jpaul.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService{

    private IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optionalProduct = iProductRepository.findById(id);
        return optionalProduct.get();
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public Product update(Product _product) {
        Optional<Product> product = iProductRepository.findById(_product.getId());
        if(product.isPresent()){
            Product productTemp = product.get();
            productTemp.setIcon(_product.getIcon());
            productTemp.setName(_product.getName());
            productTemp.setCategory(_product.getCategory());
            productTemp.setDescription(_product.getDescription());
            productTemp.setGender(_product.getGender());
            productTemp.setMaterialType(_product.getMaterialType());
            productTemp.setEnterprise(_product.getEnterprise());
            productTemp.setUrlImg(_product.getUrlImg());
            productTemp.setIconAddProductDetail(_product.getIconAddProductDetail());
            productTemp.setUpdateField(_product.getUpdateField());
            productTemp.setDeleteField(_product.getDeleteField());
            iProductRepository.save(productTemp);
            return productTemp;
        }
        else{
            throw new ResourceNotFoundException("Resource not found by id" + _product.getId());
        }
    }

    @Override
    public void delete(long id) {
        Optional<Product> productOptional = iProductRepository.findById(id);
        if(productOptional.isPresent()){
            this.iProductRepository.delete(productOptional.get());
        }
        else{
            throw new ResourceNotFoundException("Resource not found by id" + id);
        }
    }
}
