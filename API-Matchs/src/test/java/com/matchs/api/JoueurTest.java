package com.matchs.api;

import com.matchs.api.Model.Joueur;
import com.matchs.api.Model.Match;
import com.matchs.api.Repository.JoueurRepository;
import com.matchs.api.Service.JoueurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JoueurTest {

	@Mock
	private JoueurRepository joueurRepository;
	@Mock
	private JoueurService joueurService;

	@InjectMocks
	JoueurService joueurServiceMock;

	@Spy
	private Joueur joueur1;


	@BeforeEach
	public void setup(){
		this.joueur1 = new Joueur();
	}

	@Test
	public void addJoueur(){
		//GIVEN
		when(joueurRepository.save(joueur1)).thenReturn(joueur1);
		//WHEN
		joueurServiceMock.addJoueur(joueur1);
		//THEN
		verify(joueurRepository).save(joueur1);
		assertEquals(joueurServiceMock.addJoueur(joueur1), joueur1);
	}

	@Test
	public void findJoueur(){
		//GIVEN
		when(joueurRepository.findById(joueur1.getId())).thenReturn(ofNullable(joueur1));
		//WHEN
		joueurServiceMock.findJoueur(joueur1.getId());
		//THEN
		verify(joueurRepository).findById(joueur1.getId());
		assertEquals(joueurServiceMock.findJoueur(joueur1.getId()), joueur1);

	}

	@Test
	public void createRandomJoueur(){
		Object obj = joueurServiceMock.createRandomJoueur();
		assertInstanceOf(Joueur.class,obj);
	}


}