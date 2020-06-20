package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeGuzmanFamilyApiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeGuzmanFamilyApiBackendApplication.class, args);
		int port = 8080;
		
		System.out.println("You are using port: " + port);
	}

}
