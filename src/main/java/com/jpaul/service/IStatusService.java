package com.jpaul.service;

import com.jpaul.model.Status;

import java.util.List;

public interface IStatusService {
    List<Status> findAll();
    Status findById(long id);
    Status save(Status _status);
    Status update(Status _status);
    void delete(long _id);
}
