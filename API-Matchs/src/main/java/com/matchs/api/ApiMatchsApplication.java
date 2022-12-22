package com.matchs.api;

import com.matchs.api.Repository.JoueurRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matchs.api.Model.Match;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Resultat;
import com.matchs.api.Model.Joueur;

@SpringBootApplication
public class ApiMatchsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMatchsApplication.class, args);
	}
	Joueur jack = new Joueur();

}
