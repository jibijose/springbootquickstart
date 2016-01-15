package com.example.springboot;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories()
public class CouchConfig extends AbstractCouchbaseConfiguration {

	@Override
	protected List<String> bootstrapHosts() {
		return Collections.singletonList("127.0.0.1");
	}

	@Override
	protected String getBucketName() {
		return "beer-sample";
	}

	@Override
	protected String getBucketPassword() {
		return "";
	}

//	@Bean
//	public LocalValidatorFactoryBean validator() {
//		return new LocalValidatorFactoryBean();
//	}
//
//	@Bean
//	public ValidatingCouchbaseEventListener validationEventListener() {
//		return new ValidatingCouchbaseEventListener(validator());
//	}

}
