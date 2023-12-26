package com.jpaul.service;

import com.jpaul.model.Purchase;

import java.util.List;

public interface IPurchaseService {
    List<Purchase> findAll();
    Purchase findById(Long id);
    Purchase save(Purchase _purchase);
    Purchase update(Long id, Purchase _purchase);
}
