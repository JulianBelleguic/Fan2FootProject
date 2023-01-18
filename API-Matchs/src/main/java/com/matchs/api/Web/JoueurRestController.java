package com.matchs.api.Web;

import ch.qos.logback.core.model.Model;
import com.matchs.api.Controller.JoueurController;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Joueur;
import com.matchs.api.Model.Match;
import com.matchs.api.Model.Resultat;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Repository.JoueurRepository;
import com.matchs.api.Repository.MatchRepository;
import com.matchs.api.Repository.ResultatRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class JoueurRestController {

    private JoueurRepository joueurRepository;

    private JoueurController joueurController;

    private MatchRepository matchRepository;

    private ResultatRepository resultatRepository;


    @GetMapping(path = "/AppSpring")
    public String page(){
        return "AppSpring";
    }

    @RequestMapping("/Menu")
    public String Menu() {
        return "Menu";
    }

    @RequestMapping("/Affichage")
    public String Affichage() {
        return "Affichage";
    }

    @GetMapping(path = "/match")
    public String DisplayMatch(ModelMap model){
        List<Match> matchs = matchRepository.findAll();
        model.addAttribute("listMatch",matchs);

        return "match";
    }

    @GetMapping(path = "/resultat")
    public String DisplayResultats(ModelMap model){
        List<Resultat> resultats = resultatRepository.findAll();
        model.addAttribute("listResultat",resultats);

        return "resultat";
    }
    @GetMapping(path = "/joueur")
    public String DisplayJoueurs(ModelMap model,
                                 @RequestParam(name = "page",defaultValue = "0") int page,
                                 @RequestParam(name = "size",defaultValue = "5")int size,
                                 @RequestParam(name = "rechercher",defaultValue = "")String rechercher){
        Page<Joueur> pagejoueurs=joueurRepository.findByNomContains(rechercher, PageRequest.of(page,size));
        model.addAttribute("listJoueurs",pagejoueurs.getContent());
        model.addAttribute("pages", new int [pagejoueurs.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("rechercher", rechercher);
        return "joueur";
    }

    @RequestMapping("/GenJoueurs")
    public String GenJoueurs(String rechercher, int page) {
        joueurController.createRandomJoueur();
        return "redirect:/joueur?page="+page+"&rechercher="+rechercher;
    }

    @GetMapping("/deleteJoueur")
    public String deleteJoueur(Long id, String rechercher, int page) {
        joueurRepository.deleteById(id);
        return "redirect:/joueur?page="+page+"&rechercher="+rechercher;
        //return "redirect:/Acceuil";
    }

    @RequestMapping("/AddEquipeToJoueur")
    public String AddEquipeToJoueur() {
        joueurController.updateEquipe(1L,1L);
        return "AppSpring";
    }




}
