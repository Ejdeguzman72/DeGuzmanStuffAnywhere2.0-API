package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.User;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public ResponseEntity<Optional<User>> findUserById(@PathVariable Long userid) {
		Optional<User> user = userRepository.findById(userid);
		return ResponseEntity.ok().body(user);
	}
	
	public User addUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
//	public ResponseEntity<User> updateUser(@PathVariable Long userid,
//			@Valid @RequestBody User userDetails) {
//		Optional<User> user = null;
//		try {
//			user = userRepository.findById(userid);
//			user.setUsername(userDetails.getUsername());
//			user.setPassword(userDetails.getPassword());
//		}
//		catch (ResourceNotFoundException e){
//			e.printStackTrace();
//		}
//		final User updatedUser = userRepository.save(user);
//		return ResponseEnity.ok().body(updatedUser);
//	}
	
	public Map<String,Boolean> deleteUser(@PathVariable long userid) {
		userRepository.deleteById(userid);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}
}
