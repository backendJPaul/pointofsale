package com.jpaul.service;

import com.jpaul.model.Color;
import com.jpaul.model.Size;

import java.util.List;

public interface ISizeService {
    List<Size> findAll();
    Size findById(Long _id);
    Size save(Size _size);

    Size update(Size _size);
    void delete(Long _id);
}
