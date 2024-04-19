package com.jpaul.service;

import com.jpaul.model.Location;

import java.util.List;

public interface ILocationService {
    public List<Location> findAll();
    public Location findById(long id);
    public Location save(Location location);
    public Location update(Location location, long id);
    void delete(long id);

}
