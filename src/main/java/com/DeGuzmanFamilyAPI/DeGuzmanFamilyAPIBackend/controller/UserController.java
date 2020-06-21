package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.User;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/app/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@GetMapping("/all")
	public List<User> getAllUserInformation() {
		return userService.findAllUsers();
	}
	
	@CrossOrigin
	@GetMapping("/user/{userid}") 
	public ResponseEntity<Optional<User>> getUserById(@PathVariable Long userid) {
		return userService.findUserById(userid);
	}
	
	@CrossOrigin
	@PostMapping("/add-user")
	public User addUser(@Valid @RequestBody User user) {
		return userService.addUser(user);
	}
	
//	@CrossOrigin
//	@PutMapping("/user/{userid}")
//	public ResponseEntity<User> updateUser(@PathVariable Long userid,
//			@Valid @RequestBody User userDetails) {
//		return userService.updateUser(userid, userDetails;)
//	}
	
	@CrossOrigin
	@DeleteMapping("/user/{userid}")
	public Map<String,Boolean> deleteUser(@PathVariable Long userid) {
		return userService.deleteUser(userid);
	}
}
