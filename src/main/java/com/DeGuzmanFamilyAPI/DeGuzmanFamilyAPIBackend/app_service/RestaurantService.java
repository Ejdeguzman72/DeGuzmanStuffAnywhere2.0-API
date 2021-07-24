package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.ExerciseType;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Restaurant;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.RestaurantType;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.RestaurantRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.RestaurantTypeRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RestaurantInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;

@Service
public class RestaurantService implements RestaurantInterface {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private RestaurantTypeRepository restaurantTypeRepository;

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

	public Restaurant addRestaurantInformation(@Valid Restaurant restaurant) throws ResourceNotFoundException {
		String name = restaurant.getName();
		String address = restaurant.getAddress();
		String city = restaurant.getCity();
		String state = restaurant.getState();
		String zip = restaurant.getZip();
		RestaurantType restaurantType = restaurantTypeRepository.findById(restaurant.getRestaurantType().getRestaurantTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find exercise type with ID: " + restaurant.getRestaurantType().getRestaurantTypeId()));
		Restaurant newRestaurant = new Restaurant(name,address,city,state,zip,restaurantType);
		return restaurantRepository.save(newRestaurant);
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
			restaurant.setRestaurantType(restaurantTypeRepository.findById(restaurantDetails.getRestaurantType().getRestaurantTypeId())
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find")));
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
