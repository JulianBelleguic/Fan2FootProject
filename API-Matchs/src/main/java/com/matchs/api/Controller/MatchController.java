package com.matchs.api.Controller;

import com.matchs.api.Model.Match;
import com.matchs.api.Model.info_match;
import com.matchs.api.Service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @GetMapping("/getbyid")
    public ResponseEntity<Match> getMatch(@RequestParam Long id){
        Match model = this.service.findMatch(id);
        if (Objects.isNull(model.getId_match())) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity(model, HttpStatus.OK);
        }
    }

    @GetMapping("/result/{id_match}")
    public ResponseEntity<Object> addResultat(@PathVariable ("id_match") Long id_match) {
        Match model = this.service.addResultat(id_match, this.service.createResult());
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @GetMapping("/add/{id_eq1}/{id_eq2}")
    public ResponseEntity<Object> addMatchById(@PathVariable ("id_eq1") Long id_equipe1,@PathVariable ("id_eq2") Long id_equipe2) {
        Match new_model = new Match();
        Match model = this.service.addMatch(new_model, id_equipe1, id_equipe2);
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @PostMapping("/upd")
    public ResponseEntity<Object> updMatch(@RequestBody Match p_model){
        Match model = this.service.updMatch(p_model);
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @GetMapping("/del")
    public ResponseEntity delMatch(@RequestParam Long id){
        this.service.delMatch(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/scores")
    public ResponseEntity<Object> envoiScores(@RequestParam Long id){
        info_match model = this.service.envoiScores(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
