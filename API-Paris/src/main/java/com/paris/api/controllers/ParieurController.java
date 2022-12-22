package com.paris.api.controllers;

import com.paris.api.models.ParieurModel;
import com.paris.api.services.ParieurService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Parieur")
public class ParieurController {

    private final ParieurService service;

    public ParieurController(ParieurService service){
        this.service = service;
    }

    @GetMapping("/searchByID")
    public ResponseEntity<ParieurModel> searchById(@RequestParam Long id){
        ParieurModel model = this.service.findParieur(id);
        if (model.getId() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity(model, HttpStatus.OK);
        }
    }
}