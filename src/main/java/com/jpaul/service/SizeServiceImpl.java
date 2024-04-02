package com.jpaul.service;

import com.jpaul.exception.ResourceNotFoundException;
import com.jpaul.model.Color;
import com.jpaul.model.Size;
import com.jpaul.repository.ISizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class SizeServiceImpl implements ISizeService{

    ISizeRepository iSizeRepository;

    @Override
    public List<Size> findAll() {
        return iSizeRepository.findAll();
    }

    @Override
    public Size findById(Long _id) {
        Optional<Size> optionalSize = iSizeRepository.findById(_id);
        return optionalSize.get();
    }

    @Override
    public Size save(Size _size) {
        return iSizeRepository.save(_size);

    }

    @Override
    public Size update(Size _size) {
        Optional<Size> optionalSize = iSizeRepository.findById(_size.getId());
        if(optionalSize.isPresent()){
            Size size = optionalSize.get();

            size.setName(_size.getName());
            size.setIcon(_size.getIcon());
            size.setUpdateField(_size.getUpdateField());
            size.setDeleteField(_size.getDeleteField());

            iSizeRepository.save(size);

            return size;
        }
        else{
            throw new ResourceNotFoundException("Resource not found by id "+ _size.getId() );
        }
    }

    @Override
    public void delete(Long _id) {
        Optional<Size> optionalSize = iSizeRepository.findById(_id);
        if(optionalSize.isPresent()){
            iSizeRepository.delete(optionalSize.get());
        }
        else {
            throw new ResourceNotFoundException("Resource not found by Id" + _id);
        }
    }
}
