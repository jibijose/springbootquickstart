package com.example.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.example.springboot.repository.BeerRepository;
import com.example.springboot.service.BeerRepositoryMock;

@Configuration("mockConfig")
@ComponentScan(basePackages={"com.example.springboot.service"})
public class MockConfig {

	@Bean
    public static BeerRepository beerRepository() {
        return new BeerRepositoryMock();
    }
	
}
