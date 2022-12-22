package com.matchs.api.Controller;

import com.matchs.api.Service.JoueurService;
import org.springframework.web.bind.annotation.*;
import com.matchs.api.Model.Joueur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/joueur")
public class JoueurController {

    private final JoueurService service;

    public JoueurController(JoueurService service) {
        this.service = service;
    }

    @GetMapping("/getbyid")
    public ResponseEntity<Joueur> add(@RequestParam Long id){
        Joueur model = this.service.findJoueur(id);
        if (model.getId() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity(model, HttpStatus.OK);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Object> update(@RequestBody Joueur p_model){
        Joueur model = this.service.addJoueur(p_model);
        return new ResponseEntity(model, HttpStatus.OK);
    }
}
