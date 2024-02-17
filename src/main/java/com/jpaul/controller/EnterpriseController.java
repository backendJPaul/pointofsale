package com.jpaul.controller;

import com.jpaul.model.Enterprise;
import com.jpaul.service.IEnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enterprise")
@AllArgsConstructor
public class EnterpriseController{

    IEnterpriseService iEnterpriseService;

    @GetMapping
    public ResponseEntity<List<Enterprise>> findAll() {
        List<Enterprise> enterpriseList = iEnterpriseService.findAll();
        return new ResponseEntity<>(enterpriseList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Enterprise> findById(@PathVariable Long id) {
        Enterprise enterprise = iEnterpriseService.findById(id);
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Enterprise> save(@RequestBody Enterprise _enterprise) {
        Enterprise enterprise = iEnterpriseService.save(_enterprise);
        return new ResponseEntity<>(enterprise, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Enterprise> update(@PathVariable long id, @RequestBody Enterprise _enterprise){
        System.out.println(_enterprise);
       _enterprise.setId(id);
       return new ResponseEntity<>(iEnterpriseService.update(_enterprise), HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable long id){
        this.iEnterpriseService.delete(id);
        return HttpStatus.OK;
    }
}
