package com.paris.api;

import com.paris.api.controllers.ParieController;
import com.paris.api.models.ParieModel;
import com.paris.api.services.ParieService;
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
	void pariedeleteParieByID() {
		ParieService parieServiceMock = mock(ParieService.class);
		ParieController parieController = new ParieController(parieServiceMock);
		ParieModel model = new ParieModel();
		parieController.deleteByID(1L);
		verify(parieServiceMock).deleteByID(1L);
	}

}
