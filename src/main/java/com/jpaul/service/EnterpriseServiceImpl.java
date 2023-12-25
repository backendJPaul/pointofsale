package com.jpaul.service;

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
        List<Enterprise> enterpriseList = iEnterpriseRepository.findAll();
        return enterpriseList;
    }

    @Override
    public Enterprise findById(Long id) {
        Optional<Enterprise> enterpriseOptional = iEnterpriseRepository.findById(id);
        return enterpriseOptional.get();
    }

    @Override
    public Enterprise save(Enterprise _enterprise) {
        Enterprise enterprise = iEnterpriseRepository.save(_enterprise);
        return enterprise;
    }
}
