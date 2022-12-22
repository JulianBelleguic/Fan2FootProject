package com.matchs.api.Controller;

import com.matchs.api.Model.Match;
import com.matchs.api.Service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/match")
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


    @PostMapping("/add")
    public ResponseEntity<Object> addMatch(@RequestBody Match p_model){
        Match model = this.service.addMatch(p_model);
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @PostMapping("/upd")
    public ResponseEntity<Object> updMatch(@RequestBody Match p_model){
        Match model = this.service.updMatch(p_model);
        return new ResponseEntity(model, HttpStatus.OK);
    }



}
