package com.paris.api.controllers;

import com.paris.api.models.ParieModel;
import com.paris.api.services.ParieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Parie")
public class ParieController {

    private final ParieService service;

    public ParieController(ParieService service){
        this.service = service;
    }

    @GetMapping("/searchByID")
    public ResponseEntity<ParieModel> searchById(@RequestParam Long id){
        ParieModel model = this.service.findParie(id);
        if (model.getId() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity(model, HttpStatus.OK);
        }
    }
}