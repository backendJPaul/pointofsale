package com.jpaul.service;

import com.jpaul.exception.ResourceNotFoundException;
import com.jpaul.model.Gender;
import com.jpaul.repository.IGenderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenderServiceImpl implements IGenderService{

    private IGenderRepository iGenderRepository;
    @Override
    public List<Gender> findAll() {
        return iGenderRepository.findAll();
    }

    @Override
    public Gender save(Gender _gender) {
        return iGenderRepository.save(_gender);
    }

    @Override
    public Gender findById(long _id) {
        Optional<Gender> genderOptional = iGenderRepository.findById(_id);
        return genderOptional.get();
    }

    @Override
    public Gender update(Gender _gender) {
        Optional<Gender> genderOptional = iGenderRepository.findById(_gender.getId());

        if(genderOptional.isPresent()){
            Gender gender = genderOptional.get();
            gender.setName(_gender.getName());
            gender.setUpdateField(_gender.getUpdateField());
            gender.setDeleteField(_gender.getDeleteField());
            iGenderRepository.save(gender);
            return gender;
        }
        else {
            throw new ResourceNotFoundException("Resource not found by id "+ _gender.getId());
        }
    }

    @Override
    public void delete(long _id) {
        Optional<Gender> genderOptional = iGenderRepository.findById(_id);
        if(genderOptional.isPresent()){
            this.iGenderRepository.delete(genderOptional.get());
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + genderOptional.get());
        }
    }
}
