package com.jpaul.repository;

import com.jpaul.model.Product;
import com.jpaul.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    List<ProductDetail> findProductDetailByProductId(long id);
}
