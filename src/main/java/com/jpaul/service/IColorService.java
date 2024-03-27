package com.jpaul.service;

import com.jpaul.model.Color;

import java.util.List;

public interface IColorService {

    public List<Color> findAll();
    public Color findById(long id);
    public Color save(Color _color);
    public Color update(Color color);
    public void delete(long id);

}
