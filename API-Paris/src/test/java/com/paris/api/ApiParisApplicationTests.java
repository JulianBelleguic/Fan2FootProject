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
	void addParie() {
		ParieService parieServiceMock = mock(ParieService.class);
		ParieController parieModel = new ParieController(parieServiceMock);
		Long idMatch = 1L;
		Float scoreEqip1 = 0f;
		Float scoreEqip2 = 0f;
		parieModel.addParie(idMatch, scoreEqip1, scoreEqip2);
		verify(parieServiceMock).addParie(1L, 0f, 0f);
	}


}
