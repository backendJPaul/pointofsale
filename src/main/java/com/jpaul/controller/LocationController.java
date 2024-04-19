package com.jpaul.controller;

import com.jpaul.model.Location;
import com.jpaul.service.ILocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/location")
public class LocationController{

    private ILocationService iLocationService;

    @GetMapping
    public ResponseEntity<List<Location>> findAll() {
        List<Location> locationList = iLocationService.findAll();
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Location> findById(@PathVariable("id") long id) {
        Location location = iLocationService.findById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location _location) {
        Location location = iLocationService.save(_location);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<Location> update(@RequestBody Location _location, @PathVariable ("id") long id) {
        Location location = iLocationService.update(_location, id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable ("id") long id) {
        iLocationService.delete(id);
        return HttpStatus.OK;
    }
}
