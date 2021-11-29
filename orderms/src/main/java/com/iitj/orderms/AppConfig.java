package com.iitj.orderms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Sampler defaultSampler() {
	    return Sampler.ALWAYS_SAMPLE;
	}

}
