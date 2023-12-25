package com.jpaul.service;

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
}
