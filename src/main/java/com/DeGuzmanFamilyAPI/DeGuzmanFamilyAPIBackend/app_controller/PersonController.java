package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Person;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service.PersonService;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/person-info")
@CrossOrigin
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/all")
	public List<Person> getAllPersonInformation() throws SecurityException, IOException {
		return personService.findAllPersonInformation();
	}
	
	@RequestMapping("/person/{personid}")
	public Person addPersonInformation(@Valid @RequestBody Person person) throws SecurityException, IOException {
		return personService.addPersonInformation(person);
	}
	
//	@RequestMapping("/contacts")
//	public List<Person> getAllPersonContactInformation() {
//		return personService.findAllPersonContactInfo();
//	}
	
	@PostMapping("/add-person-information")
	public ResponseEntity<Person> findPersonInformationById(@PathVariable Long personid) throws SecurityException, ResourceNotFoundException, IOException {
		return personService.findPersonById(personid);
	}
	
	@PutMapping("/person/{personid}")
	public ResponseEntity<Person> updatePersonInfoCOntroller(@PathVariable Long personid,
			@Valid @RequestBody Person personDetails) throws SecurityException, IOException {
		return personService.updatePersonInformation(personid, personDetails);
	}
	
	@DeleteMapping("/person/{personid")
	public Map<String,Boolean> deletePersonInformation(@PathVariable Long personid) throws SecurityException, IOException {
		return personService.deletePersonInformation(personid);
	}
}
