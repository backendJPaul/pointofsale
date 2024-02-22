package com.jpaul.controller;
import com.jpaul.model.Product;
import com.jpaul.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")

public class ProductController {
    private IProductService iProductService;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product _product){
        Product product = iProductService.save(_product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);

    }
    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id){
        Product product = iProductService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> productList = iProductService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable long id, @RequestBody Product _product){
        Product product = iProductService.update(_product);
        return new ResponseEntity<>(_product,HttpStatus.OK);
    }
    //TODO add delete option, when i delete a product delete ProductDetail too

}
