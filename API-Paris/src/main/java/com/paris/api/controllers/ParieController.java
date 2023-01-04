package com.paris.api.controllers;

import com.paris.api.models.CoteModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.services.ParieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Parie")
public class ParieController {

    private final ParieService service;

    @Autowired
    public ParieController(ParieService service){
        this.service = service;
    }
    @PostMapping("/create")
    public ParieModel createParie(@RequestParam ParieModel parie){
        return service.createParie(parie);
    }
    @PutMapping("/deleteByID/{id}")
    public String deleteByID(@RequestParam Long id){
        return service.deleteByID(id);
    }

    public ParieModel findByID(@RequestParam Long id, ParieModel parie){
        ParieModel model = this.service.findByID(id);
        return parie;
    }
    @GetMapping("/all")
    public static List<ParieModel> findAll() {
        List<ParieModel> paris = ParieService.all();
        return paris;
    }
    @GetMapping("/add")
    public ResponseEntity<Object> addParie(@RequestParam Long id){
        ParieModel model = this.service.addParie(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}