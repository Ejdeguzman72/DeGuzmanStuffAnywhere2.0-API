package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.RestaurantType;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service.RestaurantTypeService;

@RestController
@RequestMapping("/app/restaurant-types")
@CrossOrigin
public class RestaurantTypeController {

	@Autowired
	private RestaurantTypeService restauarantTypeService;
	
	@GetMapping("/all")
	public List<RestaurantType> getAllRestaurantTypes() {
		return restauarantTypeService.findAllRestaurantType();
	}
	
	@GetMapping("/restaurant-type/{restaurantDescr}")
	public ResponseEntity<RestaurantType> getRestaurantTypeByName(@PathVariable String restaurantDescr) {
		ResponseEntity<RestaurantType> restaurantType = null;
		return restaurantType = restauarantTypeService.findRestaurantTypeByName(restaurantDescr);
	}
}
