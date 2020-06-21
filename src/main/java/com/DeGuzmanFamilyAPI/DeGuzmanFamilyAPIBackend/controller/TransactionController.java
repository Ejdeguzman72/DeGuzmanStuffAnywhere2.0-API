package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.Transaction;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	public List<Transaction> getAllTransactionInformation() {
		return transactionService.findAllTransactionInformation();
	}
	
	public ResponseEntity<Transaction> GetTransactionInformationByID(@PathVariable Long transactionid) throws ResourceNotFoundException {
		return transactionService.findTransactionInformationByID(transactionid);
	}
	
	public Transaction addTransaction(@Valid @RequestBody Transaction transaction) {
		return transactionService.addTransactionInformation(transaction);
	}
	
	public ResponseEntity<Transaction> updateTransactionInformationController(@PathVariable Long transactionid,
			@Valid @RequestBody Transaction transactionDetails) {
		return transactionService.updateTransactionInformation(transactionid, transactionDetails);
	}
	
	public Map<String,Boolean> deleteTransactionInformation(@PathVariable Long transactionid) {
		return transactionService.deleteTransactionInformation(transactionid);
	}
}
