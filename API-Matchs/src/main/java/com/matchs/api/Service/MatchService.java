package com.matchs.api.Service;

import com.matchs.api.Model.Match;
import com.matchs.api.Repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class MatchService implements Serializable {
    // on crée l'attribut de class qui va contenir le repository
    private final MatchRepository repository;

    // on propose un constructeur, qui va recevoir une instance du repository fournie automatiquement par Spring
    public MatchService(MatchRepository repository) {
        this.repository = repository;
    }

    public Match findMatch(Long id) {
        return this.repository.findById(id).orElse(new Match(null, null));
    }

    public Match addMatch(Match model) {
        return this.repository.save(model);
    }

    public Match updMatch(Match model) {
        return this.repository.save(model);
    }

    public void delMatch(Long id) {
        this.repository.deleteById(id);
    }
}