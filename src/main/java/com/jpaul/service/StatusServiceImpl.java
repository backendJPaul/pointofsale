package com.jpaul.service;

import com.jpaul.exception.ResourceNotFoundException;
import com.jpaul.model.Status;
import com.jpaul.repository.IStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements IStatusService{

    private IStatusRepository iStatusRepository;
    @Override
    public List<Status> findAll() {
        return iStatusRepository.findAll();
    }

    @Override
    public Status findById(long _id) {
        Optional<Status> optionalStatus = iStatusRepository.findById(_id);
        if(optionalStatus.isPresent()){
            return optionalStatus.get();
        }
        else {
            throw new ResourceNotFoundException("Resource not found by Id" + _id);
        }
    }

    @Override
    public Status save(Status _status) {
        return iStatusRepository.save(_status);
    }

    @Override
    public Status update(Status _status) {
        Optional<Status> optionalStatus  = iStatusRepository.findById(_status.getId());
        if(optionalStatus.isPresent()){
            Status status = optionalStatus.get();
            status.setIcon(_status.getIcon());
            status.setName(_status.getName());
            status.setUpdateField(_status.getUpdateField());
            status.setDeleteField(_status.getDeleteField());
            iStatusRepository.save(status);
            return status;
        }
        else {
            throw new ResourceNotFoundException("Resource not found by id" + _status.getId());
        }
    }

    @Override
    public void delete(long _id) {
        Optional<Status> optionalStatus = iStatusRepository.findById(_id);
        if(optionalStatus.isPresent()){
            iStatusRepository.delete(optionalStatus.get());

        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + _id);
        }
    }
}
