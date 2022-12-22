package com.paris.api.services;

import com.paris.api.models.CoteModel;
import com.paris.api.repository.CoteRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class CoteService implements Serializable {

    private final CoteRepository repository;

    public CoteService (CoteRepository repository){
        this.repository = repository;
    }

    public CoteModel findCote(Long id) {
        return this.repository.findById(id).orElse(new CoteModel());
    }

    public CoteModel addCote(CoteModel model) {
        return this.repository.save(model);
    }

}