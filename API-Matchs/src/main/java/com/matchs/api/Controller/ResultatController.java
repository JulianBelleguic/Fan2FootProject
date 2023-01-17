package com.matchs.api.Controller;


import com.matchs.api.Model.Resultat;
import com.matchs.api.Repository.ResultatRepository;
import com.matchs.api.Service.ResultatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/resultat")
public class ResultatController {

    private final ResultatService service;
    private final ResultatRepository repository;

    public ResultatController(ResultatService service, ResultatRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Resultat> getMatch(@PathVariable Long id){
        Resultat model = this.service.findResultat(id);
        if (Objects.isNull(model.getId_resultat())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
    }

    @PutMapping("/add")
    public ResponseEntity<Object> addResultat(@RequestBody Resultat p_model){
        Resultat model = this.service.addResultat(p_model);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updResultat(@RequestBody Resultat model){
        if (!repository.existsById(model.getId_resultat())) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            service.updResultat(model);
            return new ResponseEntity<>(model,HttpStatus.OK);
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Object> delMatch(@PathVariable Long id){
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            service.delResultat(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
