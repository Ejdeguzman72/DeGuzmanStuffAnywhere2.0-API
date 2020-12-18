package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Restaurant;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.RestaurantRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RestaurantInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;

@Service
public class RestaurantService implements RestaurantInterface {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public List<Restaurant> findAllRestaurants() {
		List<Restaurant> list = restaurantRepository.findAll();
		return list;
	}

	@Override
	public ResponseEntity<Restaurant> findRestaurantById(@PathVariable int restaurantid) throws ResourceNotFoundException {
		Restaurant restaurant = restaurantRepository.findById(restaurantid)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find Restaurant"));
		return ResponseEntity.ok().body(restaurant);
	}

	@Override
	public Restaurant addRestaurantInformation(@Valid Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Restaurant> updateRestaurantInformation(int restaurantid,
			@Valid Restaurant restaurantDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Boolean, String> deleteRestaurantInformation(int restaurantid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRestaurantCount() {
		// TODO Auto-generated method stub
		return 0;
	}


}
