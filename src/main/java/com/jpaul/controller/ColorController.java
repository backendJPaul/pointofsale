package com.jpaul.controller;

import com.jpaul.model.Color;
import com.jpaul.service.IColorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/color")

public class ColorController{

    private IColorService iColorService;
    @GetMapping
    public ResponseEntity<List<Color>> findAll() {
        List<Color> colorList = iColorService.findAll();
        return new ResponseEntity<>(colorList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Color> findById(@PathVariable("id") long id) {
        Color color = iColorService.findById(id);
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Color> save(@RequestBody Color _color) {
        Color color = iColorService.save(_color);
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Color> update(@PathVariable("id") Long id,@RequestBody Color _color) {
        _color.setId(id);
        Color color = iColorService.update(_color);
        return new ResponseEntity<>(color, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable long id) {
        iColorService.delete(id);
        return HttpStatus.OK;


    }
}
