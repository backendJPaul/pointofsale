package com.jpaul.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "material_type")
public class MaterialType implements Serializable {

    private static final long SerialVersionLONG = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private String icon;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String updateField = "update";

    @Column(nullable = false)
    private String deleteField = "delete";
}