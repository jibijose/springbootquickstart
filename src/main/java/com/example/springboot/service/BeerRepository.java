package com.example.springboot.service;

import com.couchbase.client.protocol.views.Query;
import com.example.springboot.domain.Beer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, String> {

    List<Beer> all(Query query);

}
