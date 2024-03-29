package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Users;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.UserRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.UserStatusRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RunTrackerServiceInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger.MasterLogger;

@Service
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RunTrackerServiceInterface.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserStatusRepository userStatusRepository;
	
	private MasterLogger masterLogger;
	
	// returns all users in a list in a list
	@Cacheable(value = "userList")
	public List<Users> findAllUsers() {
		return userRepository.findAll();
	}
	
	public List<Users> findPendingUsers() {
		return userRepository.findAllPendingUsers();
	}
	
	// based on the pathvariable thrown, this returns the Users object that has the corresponding ID
	@Cacheable(value = "userById", key = "#userId")
	public ResponseEntity<Optional<Users>> findUserById(@PathVariable Long userid) {
		Optional<Users> user = userRepository.findById(userid);
		return ResponseEntity.ok().body(user);
	}
	
	// creates an Users object based off the fields that are filled.
	@CachePut(cacheNames="userList")
	public Users addUser(@Valid @RequestBody Users user) {
		return userRepository.save(user);
	}
	
	// updates the Users based on the id number entered. Once the fields are updated, then a new Auto
		// Transaction object is created.
	public ResponseEntity<Users> updateUser(@PathVariable Long userid,
			@Valid @RequestBody Users userDetails) {
		Users user = null;
		try {
			user = userRepository.findById(userid)
					.orElseThrow(() -> new ResourceNotFoundException("not found"));
			user.setUsername(userDetails.getUsername());
			user.setPassword(userDetails.getPassword());
		}
		catch (ResourceNotFoundException e){
			e.printStackTrace();
		}
		final Users updatedUser = userRepository.save(user);
		return ResponseEntity.ok().body(updatedUser);
	}
	
	public Map<String,Boolean> deleteUser(@PathVariable long userid) {
		userRepository.deleteById(userid);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}
	
	public Map<String,Boolean> deleteAllUsers() {
		List<Users> listOfUsers = new ArrayList<>();
		userRepository.deleteAll();
		Map<String,Boolean> responseMap = new HashMap<>();
		
		if (listOfUsers.size() == 0) {
			responseMap.put("Deleted",Boolean.TRUE);
		} else {
			responseMap.put("User were not deleted. Please check again", Boolean.FALSE);
		}
		
		return responseMap;
	}
	
	public List<Users> getAllUsersInformation() {
		return userRepository.findAllUsersInformation();
	}
	
	public boolean getAllUsernames(String username) {
		
		List<Users> usersList = userRepository.findAll();
		List<String> usernameList;
		boolean result = false;
		
		usernameList = usersList.stream().map(Users::getUsername).collect(Collectors.toList());
		
		if (usernameList.contains(username.trim())) {
			result = true;
		}
		
		return result;
	}
}
