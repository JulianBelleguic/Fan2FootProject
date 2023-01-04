package com.paris.api.controllers;

import com.paris.api.models.CoteModel;
import com.paris.api.services.CoteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController 
@RequestMapping("/cote")
public class CoteController {
    
    private final CoteService service;
    @Autowired
    public CoteController(CoteService service){
        this.service = service;
    }

    @PostMapping("/create")
    @Operation(summary = "Create one 'cote'.", description = "Create one 'cote' from the provided Body.")
    public CoteModel createCote(@RequestBody CoteModel cote){
        return service.createCote(cote);
    }
    @PutMapping("/deleteById/{id}")
    @Operation(summary = "Delete one 'cote'.", description = "Delete one 'cote' from the provided Id.")
    public String deleteCote(Long id, CoteModel cote){
        return service.deleteByID(id);
    }

    @GetMapping("/findByID")
    @Operation(summary = "Get one 'cote'.", description = "Get one 'cote' from the provided Id.")
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