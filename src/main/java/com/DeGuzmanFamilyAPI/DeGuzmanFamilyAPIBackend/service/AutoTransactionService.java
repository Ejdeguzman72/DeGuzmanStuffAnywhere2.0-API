package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.AutoTransaction;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository.AutoTransactionRepository;

@Service
public class AutoTransactionService {

	@Autowired
	private AutoTransactionRepository autoTransactionRepository;
	
	// returns the Auto transactions in a list
	public List<AutoTransaction> findAllAutoTransactionInformation() {
		return autoTransactionRepository.findAll();
	}
	
	// based on the pathvariable thrown, this returns the AutoTransaction object that has the corresponding ID
	public ResponseEntity<AutoTransaction> findAutoTransactionInformationById(@PathVariable Long autoTransactionId) throws ResourceNotFoundException {
		AutoTransaction autoTransactions = autoTransactionRepository.findById(autoTransactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		return ResponseEntity.ok().body(autoTransactions);
	}
	
	// creates an AutoTransaction object based off the fields that are filled.
	public AutoTransaction addAutoTransactionInformation(@Valid @RequestBody AutoTransaction autoTransaction) {
		return autoTransactionRepository.save(autoTransaction);
	}
	
	// updates the AutoTransaction based on the id number entered. Once the fields are updated, then a new Auto
	// Transaction object is created.
	public ResponseEntity<AutoTransaction> updateAutoTransactionInformation(@PathVariable Long autoTransactionId,
			@Valid @RequestBody AutoTransaction autoTransactionDetails) {
		AutoTransaction autoTransaction = null;
		try {
			autoTransaction = autoTransactionRepository.findById(autoTransactionId)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
			autoTransaction.setAmount(autoTransactionDetails.getAmount());
			autoTransaction.setAutoTransactionDate(autoTransactionDetails.getAutoTransactionDate());
			autoTransaction.setCarid(autoTransactionDetails.getCarid());
			autoTransaction.setShopId(autoTransactionDetails.getShopId());
			autoTransaction.setTransactionTypeId(autoTransactionDetails.getTransactionTypeId());
		}
		catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		final AutoTransaction updatedAutoTransactionDetails = autoTransactionRepository.save(autoTransaction);
		return ResponseEntity.ok().body(updatedAutoTransactionDetails);
	}
	
	//deletes the AutoTransaction object based off the id number passed. A HashMap is created in order to 
	// return a string and confirm  that the entity was deleted. 
	public Map<String,Boolean> deleteAutoTransactionInformation(@PathVariable Long autoTransactionId) {
		autoTransactionRepository.deleteById(autoTransactionId);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}
}
