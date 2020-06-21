package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.Person;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository.PersonRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service.PersonService;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/person-info")
@CrossOrigin
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/all")
	public List<Person> getAllPersonInformation() {
		return personService.findAllPersonInformation();
	}
	
	@RequestMapping("/person/{personid}")
	public Person addPersonInformation(@Valid @RequestBody Person person) {
		return personService.addPersonInformation(person);
	}
	
	@PostMapping("/add-person-information")
	public ResponseEntity<Optional<Person>> findPersonInformationById(@PathVariable Long personid) {
		return personService.findPersonById(personid);
	}
	
	@DeleteMapping("/person/{personid")
	public Map<String,Boolean> deletePersonInformation(@PathVariable Long personid) {
		return personService.deletePersonInformation(personid);
	}
}
