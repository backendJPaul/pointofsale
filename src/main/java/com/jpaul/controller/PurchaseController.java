package com.jpaul.controller;

import com.jpaul.model.Enterprise;
import com.jpaul.model.Purchase;
import com.jpaul.service.IEnterpriseService;
import com.jpaul.service.IPurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/purchase")
public class PurchaseController{

    private IPurchaseService iPurchaseService;

    @GetMapping
    public ResponseEntity<List<Purchase>> findAll() {
        List<Purchase> purchaseList = iPurchaseService.findAll();
        return new ResponseEntity<>(purchaseList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Purchase> findById(@PathVariable("id") Long _id) {
        Purchase purchase = iPurchaseService.findById(_id);
        return new ResponseEntity<>(purchase, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Purchase> save(@RequestBody Purchase _purchase) {
        Purchase purchase = iPurchaseService.save(_purchase);
        return new ResponseEntity<>(purchase, HttpStatus.CREATED);
    }
}
