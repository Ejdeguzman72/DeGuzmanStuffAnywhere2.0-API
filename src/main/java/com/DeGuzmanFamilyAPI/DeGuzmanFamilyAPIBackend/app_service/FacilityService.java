package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Facility;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.FacilityRepository;

@Service
public class FacilityService {

	@Autowired
	private FacilityRepository facilityRepository;
	
	@Cacheable(value = "facilityList")
	public List<Facility> findAllFacilityInformation() {
		return facilityRepository.findAll();
	}
}
