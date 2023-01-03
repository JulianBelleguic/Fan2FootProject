package com.paris.api.services;

import com.paris.api.models.CoteModel;
import com.paris.api.repository.CoteRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CoteService implements Serializable {

    private final CoteRepository repository;

    public CoteService (CoteRepository repository){
        this.repository = repository;
    }

    public CoteModel findCote(Long id) {
        return this.repository.findById(id).orElseThrow();
    }

    public List<CoteModel> findAll() {
        return repository.findAll();
    }

    public CoteModel createCote(CoteModel model) {
        return this.repository.save(model);
    }

    public String deleteByID(Long id){
        repository.deleteById(id);
        return "Cote supprimer";
    }

}