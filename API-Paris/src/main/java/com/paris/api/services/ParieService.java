package com.paris.api.services;

import com.paris.api.models.ParieModel;
import com.paris.api.repository.ParieRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ParieService implements Serializable {

    private final ParieRepository repository;

    public ParieService (ParieRepository repository){
        this.repository = repository;
    }

    public ParieModel findByID(Long id) {
        return this.repository.findById(id).orElse(new ParieModel());
    }

    public ParieModel createParie(ParieModel model) {
        return this.repository.save(model);
    }

    public String deleteByID(Long id){
        repository.deleteById(id);
        return "Parieur supprimer";
    }


}