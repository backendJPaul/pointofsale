package com.jpaul.model;

import com.jpaul.enums.EGender;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable {
    private static final long serialVersionLONG = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String urlImg;

    @Enumerated(EnumType.STRING)
    EGender eGender;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "material_type_id", nullable = false)
    private MaterialType materialType;

    @Column(nullable = false)
    private String updateField = "update";

    @Column(nullable = false)
    private String deleteField = "delete";
}
