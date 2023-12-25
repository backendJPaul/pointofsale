package com.jpaul.service;

import com.jpaul.model.MaterialType;
import com.jpaul.repository.IMaterialTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MaterialTypeService implements IMaterialTypeService{

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
}
