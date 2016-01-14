package com.example.springboot.domain;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.junit.Assert;

@RunWith(BlockJUnit4ClassRunner.class)
public class BeerTest {

	@Test
	public void checkBeerObject() {
		Beer beer = new Beer();
		assertNotNull(beer);
		
		beer.setAbv(10.01f);
		beer.setBrewery("brewery");
		beer.setDescription("description");
		beer.setName("name");
		
		Assert.assertEquals(10.01f, beer.getAbv(), 0.0f);
		Assert.assertEquals("brewery", beer.getBrewery());
		Assert.assertEquals("description", beer.getDescription());
		Assert.assertEquals("name", beer.getName());
		
		Assert.assertNotNull(beer.toString());
	}
}
