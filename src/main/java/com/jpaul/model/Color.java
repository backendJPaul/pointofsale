package com.jpaul.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "color")
public class Color{
    private static final long serialVersionLONG = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String icon;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String updateField;

    @Column(nullable = false)
    private String deleteField;
}