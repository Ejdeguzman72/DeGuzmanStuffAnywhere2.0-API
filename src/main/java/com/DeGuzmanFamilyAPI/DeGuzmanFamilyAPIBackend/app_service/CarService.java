package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Car;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.CarRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.CarInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RunTrackerServiceInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;

@Service
public class CarService implements CarInterface {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RunTrackerServiceInterface.class);

	@Autowired
	private CarRepository carRepository;
	
	public List<Car> findAllCarInformation() {
		return carRepository.findAll();
	}
	
	public ResponseEntity<Car> findCarInformationById(@PathVariable long carid) throws ResourceNotFoundException {
		Car car = carRepository.findById(carid)
				.orElseThrow(() -> new ResourceNotFoundException("Car is not found with the id of " + carid));
		return ResponseEntity.ok().body(car);
	}
	
	public Car addCarInformation(@Valid @RequestBody Car car) {
		return carRepository.save(car);
	}
	
	public ResponseEntity<Car> updateCarInformation(@PathVariable long carid,
			@Valid @RequestBody Car carDetails) {
		Car car = null;
		try {
			car = carRepository.findById(carid)
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find car with ID: " + carid));
			car.setCapactity(carDetails.getCapactity());
			car.setMake(carDetails.getMake());
			car.setModel(carDetails.getModel());
			car.setTransmission(carDetails.getTransmission());
			car.setYear(carDetails.getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final Car updatedCarDetails = carRepository.save(car);
		return ResponseEntity.ok().body(updatedCarDetails);
	}
	
	public Map<String,Boolean> deleteCarInformation(@PathVariable long carid) {
		carRepository.deleteById(carid);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public long getCountofCars() {
		return carRepository.count();
	}

}
