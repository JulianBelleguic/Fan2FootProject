package com.paris.api.services;

import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.repository.AssoPariParieurRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AssoPariParieurService implements Serializable {

    private final AssoPariParieurRepository repository;

    public AssoPariParieurService (AssoPariParieurRepository repository){
        this.repository = repository;
    }

    public AssoParisParieurModel findAssoParisParieur(Long id) {
        return this.repository.findById(id).orElse(new AssoParisParieurModel());
    }

    public AssoParisParieurModel addAssoParisParieur(AssoParisParieurModel model) {
        return this.repository.save(model);
    }

}