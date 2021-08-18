package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Person;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.PersonRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RunTrackerServiceInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger.PersonInfoLogger;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.message.LoggerMessage;

@Service
public class PersonService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RunTrackerServiceInterface.class);

	@Autowired
	private PersonRepository personRepository;
	
	// returns all Person information in a list
	@Cacheable(value = "personList")
	public List<Person> findAllPersonInformation() throws SecurityException, IOException {
		List<Person> personList = personRepository.findAll();
		System.out.println(personList.size());
		if (personList.isEmpty() || personList.size() == 0) {
			LOGGER.warn(LoggerMessage.GET_ALL_PERSON_INFO_ERROR_MESSAGE);
		}
		
		else {
			LOGGER.info(LoggerMessage.GET_ALL_PERSON_INFO + ":" + " " + personList.size());
		}
		return personRepository.findAll();
	}
	
	// based on the pathvariable thrown, this returns the Person object that has the corresponding ID
	@Cacheable(value = "personById", key = "#personId")
	public ResponseEntity<Person> findPersonById(@PathVariable Long personid) throws ResourceNotFoundException, SecurityException, IOException {
		Person person = personRepository.findById(personid)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find"));
		
		if (personid == null) {
			LOGGER.warn(LoggerMessage.GET_PERSON_INFO_BY_ID_ERROR_MESSAGE + " " + personid + " " + ":" + person);
		}
		
		else {
			LOGGER.info(LoggerMessage.GET_PERSON_INFO_BY_ID + personid + " " + "," + " " + person.firstname + " " + person.lastname);
		}
		return ResponseEntity.ok().body(person);
	}
	
	// creates an Person object based off the fields that are filled.
	@CachePut(value = "personList")
	public Person addPersonInformation(@Valid @RequestBody Person person) throws SecurityException, IOException {
		Person personInfo = personRepository.save(person);
		
		if (personInfo == null) {
			LOGGER.warn(LoggerMessage.ADD_PERSON_INFO_ERROR_MESSAGE);
		}
		
		else {
			LOGGER.info(LoggerMessage.ADD_PERSON_INFO + " " + personInfo.firstname + " " + personInfo.getLastname());
		}
	
		return personInfo;
	}
	
	// updates the Person based on the id number entered. Once the fields are updated, then a new Auto
		// Transaction object is created.
	public ResponseEntity<Person> updatePersonInformation(@PathVariable Long personid,
			@Valid @RequestBody Person personDetails) throws SecurityException, IOException {
		Person person = null;
		try {
			person = personRepository.findById(personid)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
			person.setBirthdate(personDetails.getBirthdate());
			person.setEmail(personDetails.getEmail());
			person.setFirstname(personDetails.getFirstname());
			person.setLastname(personDetails.getLastname());
			person.setPhone(personDetails.getPhone());
			
		}
		catch (ResourceNotFoundException e) {
			e.printStackTrace();
			if (personid == null || personid == 0) {
				LOGGER.error(LoggerMessage.UPDATE_PERSON_INFO_ERROR_MESSAGE + ":" + " " + "Invalid ID / Null ID " + personid);
			}
		}
		final Person updatedPersonInfo = personRepository.save(person);
		LOGGER.info(LoggerMessage.UPDATE_PERSON_INFO + ":" + " " + "Person ID No: " + updatedPersonInfo.person_id + " " + updatedPersonInfo.firstname + " " + updatedPersonInfo.lastname);
		return ResponseEntity.ok().body(updatedPersonInfo);
	}
	
	public Map<String,Boolean> deletePersonInformation(@PathVariable Long personid) throws SecurityException, IOException {
		personRepository.deleteById(personid);
		
		if (personid == null || personid == 0) {
			LOGGER.warn(LoggerMessage.DELETE_PERSON_INFO_ERROR_MESSAGE + ": " + personid);
		} 
		
		else {
			LOGGER.info(LoggerMessage.DELETE_PERSON_INFO + ": " + personid);
		}
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	// returns the count of person information  that is stored
	public long getCountOfPersonInformation() {
		return personRepository.count();
	}
}
