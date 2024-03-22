package com.jpaul.controller;

import com.jpaul.model.ProductDetail;
import com.jpaul.service.IProductDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/productDetail")
public class ProductDetailController{

    private IProductDetailService iProductDetailService;

    @GetMapping
    public ResponseEntity<List<ProductDetail>> findAll() {
        List<ProductDetail> productDetailList = iProductDetailService.findAll();
        return new ResponseEntity<>(productDetailList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDetail> findById(@PathVariable("id") Long id) {
        ProductDetail productDetail = iProductDetailService.findById(id);
        return new ResponseEntity<>(productDetail, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ProductDetail> save(@RequestBody ProductDetail _productDetail) {
        ProductDetail productDetail = iProductDetailService.save(_productDetail);
        return new ResponseEntity<>(productDetail, HttpStatus.CREATED);
    }

    @PostMapping("{id}")
    public ResponseEntity<ProductDetail> update(@PathVariable("id") Long id, @RequestBody ProductDetail productDetail1){
        ProductDetail productDetail = iProductDetailService.update(productDetail1);
        return new ResponseEntity<>(productDetail, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable Long id){
        this.iProductDetailService.delete(id);
        return HttpStatus.OK;
    }


}
