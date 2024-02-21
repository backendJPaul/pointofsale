package com.jpaul.service;

import com.jpaul.exception.ResourceNotFoundException;
import com.jpaul.model.MaterialType;
import com.jpaul.repository.IMaterialTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MaterialTypeServiceImpl implements IMaterialTypeService{

    IMaterialTypeRepository iMaterialTypeRepository;

    @Override
    public List<MaterialType> findAll() {
        List<MaterialType> materialTypes = iMaterialTypeRepository.findAll();
        return materialTypes;
    }

    @Override
    public MaterialType save(MaterialType _materialType) {
        MaterialType materialType = iMaterialTypeRepository.save(_materialType);
        return materialType;
    }

    @Override
    public MaterialType findById(long id) {
        Optional<MaterialType> optionalMaterialType = iMaterialTypeRepository.findById(id);
        return optionalMaterialType.get();
    }

    @Override
    public MaterialType update(MaterialType _materialType) {
        Optional<MaterialType> materialType = iMaterialTypeRepository.findById(_materialType.getId());
        if(materialType.isPresent()){
            MaterialType materialTypeTemp = materialType.get();
            materialTypeTemp.setIcon(_materialType.getIcon());
            materialTypeTemp.setName(_materialType.getName());
            iMaterialTypeRepository.save(materialTypeTemp);
            return materialTypeTemp;
        }
        else{
            throw new ResourceNotFoundException("Resource not found with id " + _materialType.getId());
        }
    }
    @Override
    public void delete(long id) {
        Optional<MaterialType> optionalMaterialType = iMaterialTypeRepository.findById(id);
        if(optionalMaterialType.isPresent()){
            iMaterialTypeRepository.delete(optionalMaterialType.get());
        }
        else{
            throw new ResourceNotFoundException("Resource not found with id" + id);
        }
    }
}
