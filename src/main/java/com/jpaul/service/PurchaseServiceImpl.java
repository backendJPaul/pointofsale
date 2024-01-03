package com.jpaul.service;

import com.jpaul.model.ProductDetail;
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
    IProductDetailService iProductDetailService;

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
        ProductDetail productDetail = _purchase.getProductDetail();

        productDetail.setStock(productDetail.getStock() + purchase.getStock());

        return purchase;
    }

    @Override
    public Purchase update(Long id, Purchase _purchase) {
        return null;
    }
}
