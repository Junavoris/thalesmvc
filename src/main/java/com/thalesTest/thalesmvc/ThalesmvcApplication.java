package com.thalesTest.thalesmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ThalesmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThalesmvcApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(){
		return "Hello World que se dice";
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
