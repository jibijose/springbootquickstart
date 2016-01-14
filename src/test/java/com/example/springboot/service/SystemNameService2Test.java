package com.example.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springboot.Application;
import com.example.springboot.service.SystemNameService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SystemNameService2Test {
	
	@Autowired
	SystemNameService systemNameService;
	
	@Test
	public void checkSpringService() {
		System.out.println(systemNameService.getSystemName());
	}

}
