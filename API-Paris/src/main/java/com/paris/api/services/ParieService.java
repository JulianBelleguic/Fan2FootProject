package com.paris.api.services;

import com.paris.api.models.ParieModel;
import com.paris.api.models.info_match;
import com.paris.api.repository.ParieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Objects;

@Service
public class ParieService implements Serializable {

    private final ParieRepository repository;

    public ParieService (ParieRepository repository){
        this.repository = repository;
    }

    public ParieModel findByID(Long id) {
        return this.repository.findById(id).orElse(new ParieModel());
    }

    public ParieModel createParie(ParieModel model) {
        return this.repository.save(model);
    }

    public String deleteByID(Long id){
        repository.deleteById(id);
        return "Parieur supprimer";
    }

    public ParieModel addParie(Long id){
        //info_match result = new info_match(null,null,null,null,null);
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl  = "http://localhost:8080/api/match/scores";
        info_match response = restTemplate.getForObject(fooResourceUrl + "?id=" + id, info_match.class);
        System.out.println(response);
        ParieModel newParie = new ParieModel(null, null, null,null,null);
        assert response != null;
        newParie.setIdMatch(response.getId_match());
        return null;
    }

    private static Float calculChances (Integer score1, Integer score2, String call) {
        Integer scoreA, scoreB;
        if (score1 >= score2) {
            scoreA = score1;
            scoreB = score2;
        }
        else {
            scoreA = score2;
            scoreB = score1;
        }
        int delta = scoreA - scoreB;

        Float chanceNulle = (float) ((50 - (delta / 2)) / 100);
        Float chanceA = (float) (((50 + (delta / 2)) / 100) * ((50 + (delta / 2)) / 100));
        Float chanceB = (float) (((50 + (delta / 2)) / 100) * ((50 - (delta / 2)) / 100));
    }

}