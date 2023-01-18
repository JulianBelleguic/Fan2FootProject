package com.paris.api;

import com.paris.api.controllers.AssoPariParieurController;
import com.paris.api.controllers.ParieController;
import com.paris.api.controllers.ParieurController;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.services.AssoPariParieurService;
import com.paris.api.services.ParieService;
import com.paris.api.services.ParieurService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ApiParisApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void ParieAddParie() {
		ParieService parieServiceMock = mock(ParieService.class);
		ParieController parieController = new ParieController(parieServiceMock);
		Long idMatch = 1L;
		Float scoreEqip1 = 0f;
		Float scoreEqip2 = 0f;
		parieController.addParie(idMatch, scoreEqip1, scoreEqip2);
		verify(parieServiceMock).addParie(1L, 0f, 0f);
	}
	@Test
	void parieCreateParie() {
		ParieService parieServiceMock = mock(ParieService.class);
		ParieController parieController = new ParieController(parieServiceMock);
		ParieModel model = new ParieModel();
		parieController.createParie(model);
		verify(parieServiceMock).createParie(model);
		/*		parieController.addByJSON(model);
		verify(parieServiceMock).createPari(model);*/
	}
	@Test
	void parieDeleteParieByID() {
		ParieService parieServiceMock = mock(ParieService.class);
		ParieController parieController = new ParieController(parieServiceMock);
		parieController.deleteByID(1L);
		verify(parieServiceMock).deleteByID(1L);
		/*		parieController.delByID(1L);
		verify(parieServiceMock).delByID(1L);*/
	}
	@Test
	void parieurAdd() {
		ParieurService parieurServiceMock = mock(ParieurService.class);
		AssoPariParieurService asso = mock(AssoPariParieurService.class);
		ParieController parieController = mock(ParieController.class);
		ParieurController parieurController = new ParieurController(parieurServiceMock, asso, parieController);
		ParieurModel parieur = new ParieurModel();
		parieurController.addParieur(parieur);
		verify(parieurServiceMock).addParieur(parieur);
	}
	@Test
	void parieurDeleteByID() {
		ParieurService parieurServiceMock = mock(ParieurService.class);
		AssoPariParieurService asso = mock(AssoPariParieurService.class);
		ParieController parieController = mock(ParieController.class);
		ParieurController parieurController = new ParieurController(parieurServiceMock, asso, parieController);
		parieurController.deleteByID(1L);
		verify(parieurServiceMock).deleteByID(1L);
	}
	@Test
	void parieurAjouterArgent() {
		ParieurService parieurServiceMock = mock(ParieurService.class);
		AssoPariParieurService asso = mock(AssoPariParieurService.class);
		ParieController parieController = mock(ParieController.class);
		ParieurController parieurController = new ParieurController(parieurServiceMock, asso, parieController);
		parieurController.ajouterArgent(1L, 10);
		verify(parieurServiceMock).saveBalance(1L, 10);
	}
	@Test
	void parieurSoustraireArgent() {
		ParieurService parieurServiceMock = mock(ParieurService.class);
		AssoPariParieurService asso = mock(AssoPariParieurService.class);
		ParieController parieController = mock(ParieController.class);
		ParieurController parieurController = new ParieurController(parieurServiceMock, asso, parieController);
		parieurController.soustraireBalance(1L, 10);
		verify(parieurServiceMock).soustraireBalance(1L, 10);
	}

	@Test
	void parieurAdditionArgent() {
		ParieurService parieurServiceMock = mock(ParieurService.class);
		AssoPariParieurService asso = mock(AssoPariParieurService.class);
		ParieController parieController = mock(ParieController.class);
		ParieurController parieurController = new ParieurController(parieurServiceMock, asso, parieController);
		parieurController.additionnerBalance(1L, 10);
		verify(parieurServiceMock).additionnerBalance(1L, 10);
	}

	// CELUI LÀ POSE PROBLÈME
/*	@Test
	void AssoParier() {

		AssoPariParieurRepository assoRepository = mock(AssoPariParieurRepository.class);
		ParieService parieService = mock(ParieService.class);
		ParieurService parieurService = mock(ParieurService.class);
		ParieurController parieurController = mock(ParieurController.class);
		AssoPariParieurService assoService = new AssoPariParieurService(assoRepository, parieService, parieurService, parieurController);
		AssoPariParieurController assoController = new AssoPariParieurController(assoService);
		ParieurModel parieur = new ParieurModel();
		parieur.setBalance(20);
		parieur.setId(1L);
		assoController.parier(parieur.getId(), 1L,10, "A");
		verify(assoService).parier(parieur.getId(),1L,10, "A");
	}*/

}
