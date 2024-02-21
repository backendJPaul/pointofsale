package com.jpaul.controller;

import com.jpaul.model.MaterialType;
import com.jpaul.service.IMaterialTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/materialType")
public class MaterialTypeController {
    private IMaterialTypeService iMaterialTypeService;

    @GetMapping
    public ResponseEntity<List<MaterialType>> findAll(){
        List<MaterialType> materialTypeList = iMaterialTypeService.findAll();
        return new ResponseEntity<>(materialTypeList, HttpStatus.OK);
    }

    @GetMapping({"id"})
    public ResponseEntity<MaterialType> findById(@PathVariable("id") Long id){
        MaterialType materialType = iMaterialTypeService.findById(id);
        return new ResponseEntity<>(materialType, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaterialType> save(@RequestBody MaterialType _materialType){
        MaterialType materialType = iMaterialTypeService.save(_materialType);
        return new ResponseEntity<>(materialType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialType> update(@PathVariable Long id, @RequestBody MaterialType _materialType){
        _materialType.setId(id);
        return new ResponseEntity<>(iMaterialTypeService.update(_materialType), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable long id){
        this.iMaterialTypeService.delete(id);
        return HttpStatus.OK;
    }
}
