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

        System.out.println(_enterprise);
        Optional<Enterprise> enterprise = iEnterpriseRepository.findById(_enterprise.getId());
        System.out.println(enterprise);
        if(enterprise.isPresent()){
            Enterprise enterpriseTemp = enterprise.get();
            enterpriseTemp.setIcon(_enterprise.getIcon());
            enterpriseTemp.setName(_enterprise.getName());
            enterpriseTemp.setTelephone(_enterprise.getTelephone());
            enterpriseTemp.setUpdateField(_enterprise.getUpdateField());
            enterpriseTemp.setDeleteField(_enterprise.getDeleteField());
            System.out.println(enterpriseTemp);

            iEnterpriseRepository.save(enterpriseTemp);
            return enterpriseTemp;
        }
        else{
            throw new ResourceNotFoundException("Record not found with id" +  _enterprise.getId());
        }


    }

    @Override
    public void delete(long id) {
        Optional<Enterprise> enterprise = iEnterpriseRepository.findById(id);
        if(enterprise.isPresent()){
            this.iEnterpriseRepository.delete(enterprise.get());
        }
        else {
            throw new ResourceNotFoundException("Record not found with id" + id);
        }
    }
}
