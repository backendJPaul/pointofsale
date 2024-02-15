package com.jpaul.service;

import com.jpaul.exception.ResourceNotFoundException;
import com.jpaul.model.Enterprise;
import com.jpaul.repository.IEnterpriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnterpriseServiceImpl implements IEnterpriseService{
    IEnterpriseRepository iEnterpriseRepository;
    @Override
    public List<Enterprise> findAll() {
        return iEnterpriseRepository.findAll();
    }

    @Override
    public Enterprise findById(Long id) {
        Optional<Enterprise> enterpriseOptional = iEnterpriseRepository.findById(id);
        return enterpriseOptional.get();
    }

    @Override
    public Enterprise save(Enterprise _enterprise) {
        return iEnterpriseRepository.save(_enterprise);

    }

    @Override
    public Enterprise update(Enterprise _enterprise) {
        Optional<Enterprise> enterprise = iEnterpriseRepository.findById(_enterprise.getId());
        if(enterprise.isPresent()){
            Enterprise enterpriseTemp = enterprise.get();
            enterpriseTemp.setIcon(enterprise.get().getIcon());
            enterpriseTemp.setName(enterprise.get().getName());
            enterpriseTemp.setTelephone(enterprise.get().getTelephone());
            enterpriseTemp.setUpdateField(enterprise.get().getUpdateField());
            enterpriseTemp.setDeleteField(enterprise.get().getDeleteField());
            return enterpriseTemp;
        }
        else{
            throw new ResourceNotFoundException("Record not found with id" +  _enterprise.getId());
        }


    }

    @Override
    public void delete(long id) {

    }
}
