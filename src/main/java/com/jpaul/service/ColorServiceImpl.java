package com.jpaul.service;

import com.jpaul.exception.ResourceNotFoundException;
import com.jpaul.model.Color;
import com.jpaul.repository.IColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ColorServiceImpl implements IColorService {

    IColorRepository iColorRepository;

    @Override
    public List<Color> findAll() {
        List<Color> colorList = iColorRepository.findAll();
        return colorList;
    }

    @Override
    public Color findById(long id) {
        Optional<Color> optionalColor = iColorRepository.findById(id);
        return optionalColor.get();
    }

    @Override
    public Color save(Color _color) {
        Color color = iColorRepository.save(_color);
        return color;
    }

    @Override
    public Color update(Color _color) {
        Optional<Color> optionalColor = iColorRepository.findById(_color.getId());
        if(optionalColor.isPresent()){
            Color color = optionalColor.get();
            color.setIcon(_color.getIcon());
            color.setName(_color.getName());
            color.setUpdateField(_color.getUpdateField());
            color.setDeleteField(_color.getDeleteField());
            iColorRepository.save(color);
            return color;
        }
        else {
            throw new ResourceNotFoundException("Resource not found by id" + _color.getId());
        }

    }

    @Override
    public void delete(long id) {
        Optional<Color> optionalColor = iColorRepository.findById(id);
        if(optionalColor.isPresent()){
            iColorRepository.delete(optionalColor.get());
        }
        else {
            throw new ResourceNotFoundException("Resource not found by id" + id);
        }
    }
}
