package com.jpaul.model;


import com.jpaul.enums.EColor;
import com.jpaul.enums.ESize;
import com.jpaul.enums.EStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

@Entity
@Data
@Table(name = "product_detail")
public class ProductDetail {

    private static final long SerialVersionLONG = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String icon;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double purchasePrice;

    @Column(nullable = false)
    private double salePrice;

    @Column(nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "product_detail_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private String updateField = "update";

    @Column(nullable = false)
    private String deleteField = "delete";
}
