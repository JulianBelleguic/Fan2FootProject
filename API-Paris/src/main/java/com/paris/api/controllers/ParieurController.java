package com.paris.api.controllers;

import com.paris.api.models.CoteModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.services.ParieurService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Parieur")
public class ParieurController {

    private final ParieurService service;
    @Autowired
    public ParieurController(ParieurService service){
        this.service = service;
    }
    @PostMapping("/create")
    public ParieurModel createParieur(@RequestBody ParieurModel parieur){
        return service.createParieur(parieur);
    }
    @PutMapping("/deleteByID/{id}")
    public String deleteByID(@RequestParam Long id){
        return service.deleteByID(id);
    }

    @PutMapping("/findByID/{id}")
    public ParieurModel searchById(@RequestParam Long id){
        ParieurModel model = this.service.findParieur(id);
        return model;
    }
}