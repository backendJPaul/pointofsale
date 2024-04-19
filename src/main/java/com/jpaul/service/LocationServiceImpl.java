package com.jpaul.service;

import com.jpaul.exception.ResourceNotFoundException;
import com.jpaul.model.Location;
import com.jpaul.repository.ILocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LocationServiceImpl implements ILocationService{

    private ILocationRepository iLocationRepository;

    @Override
    public List<Location> findAll() {
        return iLocationRepository.findAll();
    }

    @Override
    public Location findById(long id) {
        Optional<Location> locationOptional = iLocationRepository.findById(id);
        if(locationOptional.isPresent()){
            return locationOptional.get();
        }
        else{
            throw new ResourceNotFoundException("Resource not found by id" + id);
        }
    }

    @Override
    public Location save(Location location) {
        return iLocationRepository.save(location);
    }

    @Override
    public Location update(Location _location, long id) {
        Optional<Location> optionalLocation = iLocationRepository.findById(id);
        if(optionalLocation.isPresent()){
            Location location = optionalLocation.get();

            location.setIcon(_location.getIcon());
            location.setEnterprise(_location.getEnterprise());
            location.setUpdateField(_location.getUpdateField());
            location.setDeleteField(_location.getDeleteField());

            iLocationRepository.save(location);
            return location;
        }
        else {
            throw new ResourceNotFoundException("Resource not found by id" + id);
        }

    }

    @Override
    public void delete(long id) {
        Optional<Location> optionalLocation = iLocationRepository.findById(id);
        if(optionalLocation.isPresent()){
            Location location = optionalLocation.get();
            iLocationRepository.delete(location);
        }
    }
}
