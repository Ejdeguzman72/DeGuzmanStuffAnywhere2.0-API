package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.ExerciseType;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Restaurant;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.RestaurantType;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.RestaurantRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.RestaurantTypeRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RestaurantInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RunTrackerServiceInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;

@Service
public class RestaurantService implements RestaurantInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(RunTrackerServiceInterface.class);
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private RestaurantTypeRepository restaurantTypeRepository;

	@Override
	@Cacheable(value = "restaurantList")
	public List<Restaurant> findAllRestaurants() {
		List<Restaurant> list = restaurantRepository.findAll();
		return list;
	}

	@Override
	@Cacheable(value = "restaurantById", key = "#restaurantId")
	public ResponseEntity<Restaurant> findRestaurantById(@PathVariable int restaurantid) throws ResourceNotFoundException {
		Restaurant restaurant = restaurantRepository.findById(restaurantid)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find Restaurant"));
		return ResponseEntity.ok().body(restaurant);
	}

	@CachePut(value = "restaurantList")
	public Restaurant addRestaurantInformation(@Valid Restaurant restaurant) throws ResourceNotFoundException {
		String name = restaurant.getName();
		LOGGER.info("Name: " + name.getClass(), name.getClass());
		String address = restaurant.getAddress();
		LOGGER.info("address: " + address.getClass(), address.getClass());
		String city = restaurant.getCity();
		LOGGER.info("city " + city.getClass(), city.getClass());
		String state = restaurant.getState();
		LOGGER.info("state: " + state.getClass(), state.getClass());
		String zip = restaurant.getZip();
		LOGGER.info("ZIP: " + zip.getClass(), zip.getClass());
		RestaurantType restaurantType = restaurantTypeRepository.findById(restaurant.getRestaurantType().getRestaurantTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find service type with ID: " + restaurant.getRestaurantType().getRestaurantTypeId()));
		LOGGER.info("Line 62 Restaurant Type: " + restaurantType.getClass(), restaurantType.getClass());
		Restaurant newRestaurant = new Restaurant(
				name,
				address,
				city,
				state,
				zip,
				restaurantType
			);
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
