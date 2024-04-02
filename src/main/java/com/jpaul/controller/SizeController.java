package com.jpaul.controller;

import com.jpaul.model.Size;
import com.jpaul.service.ISizeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/size")
public class SizeController {

    private ISizeService iSizeService;

    @GetMapping
    public ResponseEntity<List<Size>> findAll() {
        List<Size> sizeList = iSizeService.findAll();
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Size> findById(@PathVariable("id") long _id) {
        Size size = iSizeService.findById(_id);
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Size> save(@RequestBody Size _size) {
        Size size = iSizeService.save(_size);
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Size> update(@PathVariable("id") long id, @RequestBody Size _size) {
        Size size = iSizeService.save(_size);

        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable Long id) {
        iSizeService.delete(id);
        return HttpStatus.OK;
    }
}
