package com.shreyas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

	@Bean
	public RestOperations createRestTemplate() {
		return new RestTemplate();
	}
	
//	@Bean
//	public RestOperations createRestTemplate(final ClientHttpRequestFactory clientHttpRequestFactory) {
//		return new RestTemplate(clientHttpRequestFactory);
//	}
//	
//	@Bean
//	public ClientHttpRequestFactory createClientHttpRequestFactory(
//							@Value("${connect.timeout}") final int connectTimeout,
//							@Value("${read.timeout}") final int readTimeout) {
//	
//		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		httpRequestFactory.setConnectTimeout(connectTimeout);
//	    httpRequestFactory.setReadTimeout(readTimeout);
//		return httpRequestFactory;
//	}

}
