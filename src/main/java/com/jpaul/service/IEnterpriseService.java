package com.jpaul.service;

import com.jpaul.model.Enterprise;

import java.util.List;

public interface IEnterpriseService {
    List<Enterprise> findAll();
    Enterprise findById(Long id);
    Enterprise save(Enterprise _enterprise);
    Enterprise update(Enterprise _enterprise);
    void delete(long id);


}
