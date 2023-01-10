package com.matchs.api.Controller;

import com.matchs.api.Mapstruct.DTO.MatchGetDto;
import com.matchs.api.Mapstruct.Mapper.MapStructMapper;
import com.matchs.api.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/api/match")
public class MatchController {

    private MapStructMapper mapstructMapper;

    private MatchRepository matchRepository;

    @Autowired
    public MatchController(
            MapStructMapper mapstructMapper,
            MatchRepository matchRepository
    ) {
        this.mapstructMapper = mapstructMapper;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchGetDto> getById(
            @PathVariable(value = "id") Long id
    ) {
        return new ResponseEntity<>(
                mapstructMapper.MatchtoMatchGetDto(
                        MatchRepository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }
    /*
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


    @GetMapping("/add/{id_eq1}/{id_eq2}")
    public ResponseEntity<Object> addMatchById(@PathVariable ("id_eq1") Long id_equipe1,@PathVariable ("id_eq2") Long id_equipe2) {
        Match new_model = new Match();
        Match model = this.service.addMatchById(new_model, id_equipe1, id_equipe2);
        return new ResponseEntity(model, HttpStatus.OK);
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
    */

}
