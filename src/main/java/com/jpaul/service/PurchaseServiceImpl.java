package com.jpaul.service;

import com.jpaul.model.Purchase;
import com.jpaul.repository.IPurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements IPurchaseService{

    IPurchaseRepository iPurchaseRepository;

    @Override
    public List<Purchase> findAll() {
        List<Purchase> purchaseList = iPurchaseRepository.findAll();
        return purchaseList;
    }

    @Override
    public Purchase findById(Long _id) {
        Optional<Purchase> purchaseOptional = iPurchaseRepository.findById(_id);
        return purchaseOptional.get();
    }

    @Override
    public Purchase save(Purchase _purchase) {
        Purchase purchase = iPurchaseRepository.save(_purchase);
        return purchase;
    }
}
