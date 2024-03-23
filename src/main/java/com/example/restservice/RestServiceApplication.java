package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication implements CommandLineRunner {


	@Autowired
	HelloController c;
	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
		System.out.println("dada");

	}
	@Override
	public void run(String... args) throws Exception {
		String result = c.hello();
		System.out.println("Response from HelloController: " + result);
	}

}
