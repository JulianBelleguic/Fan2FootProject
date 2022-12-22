package com.paris.api.services;

import com.paris.api.models.ParieurModel;
import com.paris.api.repository.ParieurRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ParieurService implements Serializable {

    private final ParieurRepository repository;

    public ParieurService (ParieurRepository repository){
        this.repository = repository;
    }

    public ParieurModel findParieur(Long id) {
        return this.repository.findById(id).orElse(new ParieurModel());
    }

    public ParieurModel addParieur(ParieurModel model) {
        return this.repository.save(model);
    }

}