package com.paris.api;

import com.paris.api.controllers.ParieController;
import com.paris.api.controllers.ParieurController;
import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.repository.ParieurRepository;
import com.paris.api.services.AssoPariParieurService;
import com.paris.api.services.ParieService;
import com.paris.api.services.ParieurService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

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
	}
	@Test
	void parieDeleteParieByID() {
		ParieService parieServiceMock = mock(ParieService.class);
		ParieController parieController = new ParieController(parieServiceMock);
		ParieModel model = new ParieModel();
		parieController.deleteByID(1L);
		verify(parieServiceMock).deleteByID(1L);
	}
	@Test
	void parieurAdd() {
		ParieurService parieurServiceMock = mock(ParieurService.class);
		ParieurService parieurService = mock(ParieurService.class);
		AssoPariParieurService asso = mock(AssoPariParieurService.class);
		ParieController parieController = mock(ParieController.class);
		ParieurController parieurController = new ParieurController(parieurService, asso, parieController);
		ParieurModel parieur = new ParieurModel();
		parieurController.addParieur(parieur);
		verify(parieurServiceMock).addParieur(parieur);
	}

}
