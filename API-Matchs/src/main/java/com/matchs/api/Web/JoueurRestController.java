package com.matchs.api.Web;

import ch.qos.logback.core.model.Model;
import com.matchs.api.Controller.JoueurController;
import com.matchs.api.Model.AppUser;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Joueur;
import com.matchs.api.Model.Match;
import com.matchs.api.Repository.AppUserRepository;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Repository.JoueurRepository;
import com.matchs.api.Repository.MatchRepository;
import com.matchs.api.Service.AccountServiceImpl;
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

    private EquipeRepository equipeRepository;

    private MatchRepository matchRepository;

    private JoueurController joueurController;


    @GetMapping(path = "/AppSpring")
    public String page(){
        return "AppSpring";
    }

    @RequestMapping("/Acceuil")
    public String Acceuil() {
        return "Acceuil";
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

    @GetMapping("/delete")
    public String delete(Long id, String rechercher, int page) {
        joueurRepository.deleteById(id);
        return "redirect:/joueur?page="+page+"&rechercher="+rechercher;
        //return "redirect:/Acceuil";
    }


    @GetMapping(path = "/equipe")
    public String DisplayEquipe(ModelMap model){
        List<Equipe> equipes=equipeRepository.findAll();
        model.addAttribute("listEquipes",equipes);

        return "equipe";
    }

    @GetMapping(path = "/match")
    public String DisplayMatch(ModelMap model){
        List<Match> matchs = matchRepository.findAll();
        model.addAttribute("listMatch",matchs);

        return "match";
    }
//







    @RequestMapping("/GenJoueurs")
    public String GenJoueurs() {
        joueurController.createRandomJoueur();
        return "AppSpring";
    }

    @RequestMapping("/AddEquipeToJoueur")
    public String AddEquipeToJoueur() {
        joueurController.updateEquipe(1L,1L);
        return "AppSpring";
    }

}
