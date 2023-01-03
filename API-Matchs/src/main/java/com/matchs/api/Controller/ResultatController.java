package com.matchs.api.Controller;

import com.matchs.api.Model.Match;
import com.matchs.api.Model.Resultat;
import com.matchs.api.Service.MatchService;
import com.matchs.api.Service.ResultatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/resultat")
public class ResultatController {

    private final ResultatService service;

    public ResultatController(ResultatService service) {
        this.service = service;
    }

    @GetMapping("/getbyid")
    public ResponseEntity<Resultat> getMatch(@RequestParam Long id){
        Resultat model = this.service.findResultat(id);
        if (Objects.isNull(model.getId_resultat())) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity(model, HttpStatus.OK);
        }
    }

//    @GetMapping("/add/{id_eq1}/{id_eq2}")
//    public ResponseEntity<Object> addMatchById(@PathVariable ("id_eq1") Long id_equipe1,@PathVariable ("id_eq2") Long id_equipe2) {
//        Match new_model = new Match();
//        Match model = this.service.addMatchById(new_model, id_equipe1, id_equipe2);
//        return new ResponseEntity(model, HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<Object> addResultat(@RequestBody Resultat p_model){
        Resultat model = this.service.addResultat(p_model);
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @PostMapping("/upd")
    public ResponseEntity<Object> updResultat(@RequestBody Resultat p_model){
        Resultat model = this.service.updResultat(p_model);
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @GetMapping("/del")
    public ResponseEntity<Object> delMatch(@RequestParam Long id){
        this.service.delResultat(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Object> findResultat(@RequestParam Long id){
        Resultat model = this.service.findResultat(id);
        return new ResponseEntity(model, HttpStatus.OK);
    }

}
