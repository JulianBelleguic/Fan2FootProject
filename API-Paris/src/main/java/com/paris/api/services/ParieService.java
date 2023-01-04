package com.paris.api.services;

import com.paris.api.models.CoteModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.info_match;
import com.paris.api.repository.CoteRepository;
import com.paris.api.repository.ParieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Objects;

@Service
public class ParieService implements Serializable {

    private final ParieRepository repository;
    private final CoteRepository coteRepository;

    public ParieService (ParieRepository repository,CoteRepository coteRepository){
        this.coteRepository = coteRepository;
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
        CoteModel coteA = new CoteModel(null, calculChances(response.getScore_eq1(), response.getScore_eq2(), "A"));
        this.coteRepository.save(coteA);
        CoteModel coteB = new CoteModel(null, calculChances(response.getScore_eq1(), response.getScore_eq2(), "B"));
        this.coteRepository.save(coteB);
        CoteModel coteN = new CoteModel(null, calculChances(response.getScore_eq1(), response.getScore_eq2(), "N"));
        this.coteRepository.save(coteN);
        newParie.setIdCoteA(coteA);
        newParie.setIdCoteB(coteB);
        newParie.setIdCoteN(coteN);
        return this.repository.save(newParie);
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

        Float result = null;
        float chanceN = (float) ((50 - (delta / 2)) / 100);
        float chanceA = (float) (((50 + (delta / 2)) / 100) * ((50 + (delta / 2)) / 100));
        float chanceB = (float) (((50 + (delta / 2)) / 100) * ((50 - (delta / 2)) / 100));

        if (Objects.equals(call, "A")) {
            result = chanceA;
        } 
        else if (Objects.equals(call, "B")) {
            result = chanceB;
        }
        else if (Objects.equals(call, "N")) {
            result = chanceN;
        }
        return result;
    }
}