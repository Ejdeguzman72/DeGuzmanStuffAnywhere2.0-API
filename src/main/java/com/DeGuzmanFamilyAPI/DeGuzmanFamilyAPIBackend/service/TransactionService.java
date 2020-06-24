package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.GeneralTransaction;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	// returns the general transactions in a list
	public List<GeneralTransaction> findAllTransactionInformation() {
		return transactionRepository.findAll();
	}
	
	// based on the pathvariable thrown, this returns the General Transaction object that has the corresponding ID
	public ResponseEntity<GeneralTransaction> findTransactionInformationByID(@PathVariable long transactionid) throws ResourceNotFoundException {
		GeneralTransaction transaction = transactionRepository.findById(transactionid)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		return ResponseEntity.ok().body(transaction);
	}
	
	// creates an GeneralTransaction object based off the fields that are filled.
	public GeneralTransaction addTransactionInformation(@Valid @RequestBody GeneralTransaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	// updates the GeneralTransaction based on the id number entered. Once the fields are updated, then a new Auto
		// Transaction object is created.
	public ResponseEntity<GeneralTransaction> updateTransactionInformation(@PathVariable Long transactionid,
			@Valid @RequestBody GeneralTransaction transactionDetails) {
		GeneralTransaction transaction = null;
		try {
			transaction = transactionRepository.findById(transactionid)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
			transaction.setAmount(transactionDetails.getAmount());
			transaction.setPaymentDate(transactionDetails.getPaymentDate());
			transaction.setTransasction_type(transactionDetails.getTransasction_type());
		}
		catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		final GeneralTransaction updatedTransaction = transactionRepository.save(transaction);
		return ResponseEntity.ok().body(updatedTransaction);
	}
	
	public Map<String,Boolean> deleteTransactionInformation(@PathVariable Long transactionid) {
		transactionRepository.deleteById(transactionid);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
