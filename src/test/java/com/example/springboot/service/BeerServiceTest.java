package com.example.springboot.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springboot.Application;
import com.example.springboot.domain.Beer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Application.class, loader=SpringApplicationContextLoader.class)
public class BeerServiceTest {

	@Autowired
	BeerService beerService;
	
	@Test
	public void checkBeerAllBeers() {
		List<Beer> beers = beerService.allBeers();
		assertNotNull(beers);
	}
	
	@Test
	public void checkBeerAllBeersLimit() {
		List<Beer> beers = beerService.allBeers(10);
		assertEquals(10, beers.size());
	}
}
