package com.example.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.example.springboot.repository.BeerRepository;
import com.example.springboot.service.BeerRepositoryMock;

@Configuration("mockConfig")
@ComponentScan(basePackages={"com.example.springboot.service", "com.example.springboot.common", "com.example.springboot.web", "com.example.springboot.controller"})
@Import(value=AppConfig.class)
public class MockConfig {

	@Bean
    public static BeerRepository beerRepository() {
        return new BeerRepositoryMock();
    }
	
}
