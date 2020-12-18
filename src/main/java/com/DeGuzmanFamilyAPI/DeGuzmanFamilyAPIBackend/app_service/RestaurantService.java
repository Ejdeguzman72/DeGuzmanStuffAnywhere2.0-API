package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.HashMap;
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

	public Restaurant addRestaurantInformation(@Valid Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public ResponseEntity<Restaurant> updateRestaurantInformation(int restaurantid,
			@Valid Restaurant restaurantDetails) throws ResourceNotFoundException {
		Restaurant restaurant = restaurantRepository.findById(restaurantid)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find restaurant with id + " + restaurantid));
		try {
			restaurant.setAddress(restaurantDetails.getAddress());
			restaurant.setCity(restaurantDetails.getCity());
			restaurant.setName(restaurantDetails.getName());
			restaurant.setState(restaurantDetails.getState());
			restaurant.setZip(restaurantDetails.getZip());
			restaurant.setRestaurantType(restaurantDetails.getRestaurantType());
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		final Restaurant updatedRestaurantDetails = restaurantRepository.save(restaurant);
		return ResponseEntity.ok().body(updatedRestaurantDetails);
	}

	@Override
	public Map<Boolean, String> deleteRestaurantInformation(@PathVariable int restaurantid) {
		restaurantRepository.deleteById(restaurantid);
		Map<Boolean,String> response = new HashMap<>();
		response.put(Boolean.TRUE, "deleted");
		return response;
	}

	@Override
	public long getRestaurantCount() {
		return restaurantRepository.count();
	}


}
