package com.shreyas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan({"com.shreyas"})
@EntityScan("com.shreyas")
@EnableJpaRepositories("com.shreyas")
public class PhotoManagerRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoManagerRestApplication.class, args);
	}
	
	@Component
	class PhotoManagerCommandLineRunner implements CommandLineRunner {

		@Override
		public void run(String... arg0) throws Exception {
			
		}
		
	}
}
