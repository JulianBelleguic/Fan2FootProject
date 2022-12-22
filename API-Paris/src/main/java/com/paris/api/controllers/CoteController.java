package com.paris.api.controllers;

import com.paris.api.models.CoteModel;
import com.paris.api.services.CoteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController 
@RequestMapping("/Cote")
public class CoteController {
    
    private final CoteService service;
    @Autowired
    public CoteController(CoteService service){
        this.service = service;
    }

    @GetMapping("/searchByID")
    public ResponseEntity<CoteModel> searchById(@RequestParam Long id){
        CoteModel model = this.service.findCote(id);
        if (model.getId() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity(model, HttpStatus.OK);
        }
    }
}