package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.GeneralTransaction;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/all")
	public List<GeneralTransaction> getAllTransactionInformation() {
		return transactionService.findAllTransactionInformation();
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<GeneralTransaction> GetTransactionInformationByID(@PathVariable Long transactionid) throws ResourceNotFoundException {
		return transactionService.findTransactionInformationByID(transactionid);
	}
	
	public GeneralTransaction addTransaction(@Valid @RequestBody GeneralTransaction transaction) {
		return transactionService.addTransactionInformation(transaction);
	}
	
	public ResponseEntity<GeneralTransaction> updateTransactionInformationController(@PathVariable Long transactionid,
			@Valid @RequestBody GeneralTransaction transactionDetails) {
		return transactionService.updateTransactionInformation(transactionid, transactionDetails);
	}
	
	public Map<String,Boolean> deleteTransactionInformation(@PathVariable Long transactionid) {
		return transactionService.deleteTransactionInformation(transactionid);
	}
}
