//package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.User;
//import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository.UserRepository;
//
//@Service
//public class UserService {
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	public List<User> findAllUsers() {
//		return userRepository.findAll();
//	}
//	
//	public ResponseEntity<Optional<User>> findUserById(@PathVariable Long userid) {
//		Optional<User> user = userRepository.findById(userid);
//		return ResponseEntity.ok().body(user);
//	}
//	
//	public User addUser(@RequestBody User user) {
//		return userRepository.save(user);
//	}
//	
//	public ResponseEntity<User> updateUser(@PathVariable Long userid, @RequestBody User userDetails) {
//		Optional<User> user = null;
//		try {
//			user = userRepository.findById(userid)
//		}
//	}
//}
