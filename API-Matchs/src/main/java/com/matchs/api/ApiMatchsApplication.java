package com.matchs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matchs.api.Model.Matchs;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Resultats;
import com.matchs.api.Model.Joueurs;

@SpringBootApplication
public class ApiMatchsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMatchsApplication.class, args);
	}

}
