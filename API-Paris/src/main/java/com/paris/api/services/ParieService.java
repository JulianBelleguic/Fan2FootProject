package com.paris.api.services;

import com.paris.api.models.ParieModel;
import com.paris.api.models.info_match;
import com.paris.api.repository.ParieRepository;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Service
public class ParieService implements Serializable {

    private static ParieRepository repository;

    public ParieService (ParieRepository repository){
        ParieService.repository = repository;
    }

    public ParieModel findByID(Long id) {
        return repository.findById(id).orElse(new ParieModel(null, null, 0,0,0));
    }
    @GetMapping("/all")
    public static List<ParieModel> all() {
        return repository.findAll();
    }

    public ParieModel createParie(ParieModel model) {
        return repository.save(model);
    }

    public String deleteByID(Long id){
        repository.deleteById(id);
        return "Parieur supprimer";
    }

    public ParieModel addParie(Long id){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl  = "http://localhost:8080/api/match/scores";
        info_match response = restTemplate.getForObject(fooResourceUrl + "?id=" + id, info_match.class);
        ParieModel newParie = new ParieModel(null, null, 0,0,0);
        assert response != null;
        newParie.setIdMatch(response.getId_match());
        newParie.setCoteA(calculChances(response.getScore_eq1(), response.getScore_eq2(), "A"));
        newParie.setCoteB(calculChances(response.getScore_eq1(), response.getScore_eq2(), "B"));
        newParie.setCoteN(calculChances(response.getScore_eq1(), response.getScore_eq2(), "N"));
        return repository.save(newParie);
    }

    private static Float calculChances (Integer score1, Integer score2, String call) {
        float chanceA, chanceB;
        Float result = null;

        int delta = Math.abs(score1 - score2);


        float chanceNulle = (float) ((50 - (delta / 2.0)) / 100.0);

        if (score1 >= score2) {
            chanceA = (float) (((50 + (delta / 2.0)) / 100.0) * ((50 + (delta / 2)) / 100.0));
            chanceB = (float) (((50 + (delta / 2.0)) / 100) * ((50 - (delta / 2)) / 100.0));
        }
        else {
            chanceA = (float) (((50 + (delta / 2.0)) / 100.0) * ((50 - (delta / 2)) / 100.0));
            chanceB = (float) (((50 + (delta / 2.0)) / 100) * ((50 + (delta / 2)) / 100.0));
        }


        if (Objects.equals(call, "A")) {

            result = Precision.round(1 / chanceA, 2);
        }
        else if (Objects.equals(call, "B")) {
            result = Precision.round(1 / chanceB, 2);
        }
        else if (Objects.equals(call, "N")) {
            result = Precision.round(1 / chanceNulle, 2);
        }
        return result;
    }

}