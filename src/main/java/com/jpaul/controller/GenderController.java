package com.jpaul.controller;

import com.jpaul.model.Gender;
import com.jpaul.service.IGenderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gender")
@AllArgsConstructor
public class GenderController {
    IGenderService iGenderService;

    @GetMapping
    public ResponseEntity<List<Gender>> findAll(){
        List<Gender> genderList = iGenderService.findAll();
        return new ResponseEntity<>(genderList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Gender> save(@RequestBody Gender _gender){
        Gender gender = iGenderService.save(_gender);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Gender> findById(@PathVariable long id){
        Gender gender = iGenderService.findById(id);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Gender> update(@RequestBody Gender _gender, @PathVariable long id){
        Gender gender = _gender;
        gender.setId(id);
        System.out.println(gender);
        iGenderService.update(_gender);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable long id){
        this.iGenderService.delete(id);
        return HttpStatus.OK;
    }

}
