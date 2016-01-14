package com.example.springboot.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.springboot.domain.Beer;
import com.example.springboot.service.BeerService;

@RunWith(MockitoJUnitRunner.class)
public class BeerControllerTest {

	private MockMvc mvc;
	
	@Mock
	private BeerService beerService;
	
	@InjectMocks
	private BeerController beerController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(beerController).build();
	}

	@Test
	public void getBeers() throws Exception {
		when(beerService.allBeers()).thenReturn(new ArrayList<Beer>());
		
		mvc.perform(MockMvcRequestBuilders.get("/beer")).andExpect(status().isOk());
	}
}
