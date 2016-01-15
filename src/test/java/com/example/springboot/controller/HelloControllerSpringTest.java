package com.example.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springboot.MockConfig;
import com.example.springboot.service.SystemNameService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MockConfig.class})
public class HelloControllerSpringTest {

	@Autowired
	SystemNameService systemNameService;
	
	@Test
	public void checkAop() {
		systemNameService.getSystemName();
	}
}
