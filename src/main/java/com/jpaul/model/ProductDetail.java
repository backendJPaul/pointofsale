package com.jpaul.model;


import com.jpaul.enums.EColor;
import com.jpaul.enums.ESize;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "productDetail")
public class ProductDetail {

    private static final long SerialVersionLONG = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    EColor color;

    @Enumerated(EnumType.STRING)
    ESize size;

    @ManyToOne
    @JoinColumn(name = "productDetail_id", nullable = false)
    private Product product;

}
