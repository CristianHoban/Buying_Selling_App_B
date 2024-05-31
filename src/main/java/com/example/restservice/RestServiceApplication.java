package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class RestServiceApplication {
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*")
						.allowedHeaders("*")
						.exposedHeaders("*");
			}
		};
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
}

//@SpringBootApplication
//public class RestServiceApplication implements CommandLineRunner {
//
//
//	@Autowired
//	HelloController c;
//	public static void main(String[] args) {
//		SpringApplication.run(RestServiceApplication.class, args);
//		System.out.println("dada");
//
//	}
//	@Override
//	public void run(String... args) throws Exception {
//		String result = c.hello();
//		System.out.println("Response from HelloController: " + result);
//	}
//
//}
