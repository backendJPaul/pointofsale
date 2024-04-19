package com.jpaul.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "location")
public class Location {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String icon;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Enterprise enterprise;

    @Column(nullable = false)
    private String updateField;

    @Column(nullable = false)
    private String deleteField;


}
