package com.example.springboot.service;

import java.util.ArrayList;
import java.util.List;

import com.couchbase.client.protocol.views.Query;
import com.example.springboot.domain.Beer;
import com.example.springboot.repository.BeerRepository;

public class BeerRepositoryMock implements BeerRepository {

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Beer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Beer> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Beer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Beer> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beer findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Beer> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Beer> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beer> all(Query query) {
		List<Beer> beers = new ArrayList<Beer>();
		beers.add(createBeer(11.11f, "brewery1", "description1", "name1"));
		beers.add(createBeer(22.22f, "brewery2", "description2", "name2"));
		beers.add(createBeer(33.33f, "brewery3", "description3", "name3"));
		
		return beers;
	}
	
	private Beer createBeer(float abv, String brewery, String description, String name) {
		Beer beer = new Beer();
		beer.setAbv(abv);
		beer.setBrewery(brewery);
		beer.setDescription(description);
		beer.setName(name);
		
		return beer;
	}

}
