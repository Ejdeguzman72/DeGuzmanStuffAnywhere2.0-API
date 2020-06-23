package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Person;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAllPersonInformation() {
		return personRepository.findAll();
	}
	
	public ResponseEntity<Optional<Person>> findPersonById(@PathVariable Long personid) {
		Optional<Person> person = personRepository.findById(personid);
		return ResponseEntity.ok().body(person);
	}
	
	public Person addPersonInformation(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}
	
	public ResponseEntity<Person> updatePersonInformation(@PathVariable Long personid,
			@Valid @RequestBody Person personDetails) {
		Person person = null;
		try {
			person = personRepository.findById(personid)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
			person.setAge(personDetails.getAge());
			person.setBirthdate(personDetails.getBirthdate());
			person.setEmail(personDetails.getEmail());
			person.setFirstname(personDetails.getFirstname());
			person.setLastname(personDetails.getLastname());
			person.setPhone(personDetails.getPhone());
			
		}
		catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		final Person updatedPersonInfo = personRepository.save(person);
		return ResponseEntity.ok().body(updatedPersonInfo);
	}
	
	public Map<String,Boolean> deletePersonInformation(@PathVariable Long personid) {
		personRepository.deleteById(personid);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
