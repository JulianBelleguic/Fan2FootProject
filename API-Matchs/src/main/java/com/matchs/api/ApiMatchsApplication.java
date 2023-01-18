package com.matchs.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matchs.api.Model.Joueur;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ApiMatchsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMatchsApplication.class, args);
	}
	Joueur jack = new Joueur();


}
