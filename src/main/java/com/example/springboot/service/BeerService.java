package com.example.springboot.service;

import java.util.List;

import com.example.springboot.domain.Beer;

public interface BeerService {

    List<Beer> allBeers();
    List<Beer> allBeers(int limit);
}
