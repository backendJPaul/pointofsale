package com.jpaul.controller;

import com.jpaul.model.Status;
import com.jpaul.service.IStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/status")
public class StatusController{

    IStatusService iStatusService;

    @GetMapping
    public ResponseEntity<List<Status>> findAll(){
        List<Status> statusList = iStatusService.findAll();
        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Status> findById(@PathVariable("id") long id) {

        Status status = iStatusService.findById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Status> save(@RequestBody Status _status) {
        return new ResponseEntity<>(iStatusService.save(_status), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Status> update(@PathVariable("id") long id, @RequestBody Status status) {
        status.setId(id);
        return new ResponseEntity<>(iStatusService.update(status),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable("id") long id) {
        iStatusService.delete(id);
        return HttpStatus.OK;
    }
}
