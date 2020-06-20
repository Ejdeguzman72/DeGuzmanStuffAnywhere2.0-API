package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
	
	@RequestMapping("/test-message")
	public String appControllerMessage(String message) {
		return "App is successfully running on port 8080";
	}
}
