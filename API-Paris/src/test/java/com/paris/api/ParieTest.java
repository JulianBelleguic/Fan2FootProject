package com.paris.api;

import com.paris.api.controllers.ParieController;
import com.paris.api.models.ParieModel;
import com.paris.api.repository.ParieRepository;
import com.paris.api.repository.ParieurRepository;
import com.paris.api.services.ParieService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ParieTest{

	@Mock
	private ParieRepository parieRepository;


	@InjectMocks
	ParieService parieServiceMock;
	@Spy
	private ParieModel pari1;
	@Spy
	private ArrayList<ParieModel> listPari;

	@BeforeEach
	public void setup(){
		this.pari1 = new ParieModel();
		this.listPari =new ArrayList<>();
		listPari.add(pari1);
	}

	@Test
	public void findAll(){
		//GIVEN
		when(parieRepository.findAll()).thenReturn(listPari);
		//WHEN
		parieServiceMock.all();
		//THEN
		verify(parieRepository).findAll();
		assertEquals(parieServiceMock.all(), listPari);
	}

	@Test
	public void findById(){
		when(parieRepository.findById(1L)).thenReturn(Optional.ofNullable(pari1));
		parieServiceMock.findByID(1L);
		verify(parieRepository).findById(1L);
		assertEquals(parieServiceMock.findByID(1L), pari1);
	}
}