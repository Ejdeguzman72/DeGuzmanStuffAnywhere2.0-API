package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.authentication_service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.Lookup_Values.RoleValues;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.Lookup_Values.UserStatusValues;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Users;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.RoleRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.UserRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.UserStatusRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.UsernameException;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = Logger.getLogger(JwtUserDetailsService.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserStatusRepository userStatusRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public static Date date = new Date();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		User activeUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
		
		return activeUser;
	}
	
	public Users checkingLoggingInUser(String username) {
		Users userLoggingIn = userRepository.findUserByUsername(username);
		return userLoggingIn;
	}
	
	public boolean getAllUsernames(String username) {
		
		List<Users> usersList = userRepository.findAll();
		List<String> usernameList;
		boolean result = false;
		 
		usernameList = usersList.stream().map(Users::getUsername).collect(Collectors.toList());
		
		if (usernameList.contains(username)) {
			result = true;
		}
		
		return result;
	}
	
	public Users save(Users user) throws ResourceNotFoundException, UsernameException {
		Users newUser = new Users();
		
		String username = user.getUsername();
		
		if (getAllUsernames(username)) {
			throw new UsernameException("Username Exists already!");
		} 
		
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		newUser.setRole(roleRepository.findById(RoleValues.DEGUZMANSTUFFANYWHERE_BASIC_USER)
				.orElseThrow(() -> new  ResourceNotFoundException("cannot find")));
		newUser.setUserStatus(userStatusRepository.findById(UserStatusValues.DEGUZMANSTUFFANYWHERE_PENDING)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot Find")));
		if (newUser.username == null
				|| newUser.password == null
				// || newUser.role_id == 0
				//|| newUser.user_status_id == 0
				) {
			LOGGER.warn(String.format("User is null/incorrect entries"));
		} else {
			LOGGER.info(String.format("User has been saved: " + newUser.username));
		}
		return userRepository.save(newUser);
	}
	
	public void checkUserinDB(String username) throws UsernameException {
		List<Users> usersList = userRepository.findAll();
		
		if (usersList.contains(username)) {
			throw new UsernameException("Username already exists");
		}
	}
}
