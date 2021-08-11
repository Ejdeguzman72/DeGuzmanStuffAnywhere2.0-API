package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Facility;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service.FacilityService;

@RestController
@RequestMapping("/app/facility")
@CrossOrigin
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@GetMapping("/all")
	public List<Facility> getAllFacilityInformation() {
		return facilityService.findAllFacilityInformation();
	}

}
