package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.GeneralTransaction;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service.TransactionService;

@RestController
@RequestMapping("/app/general-transaction")
@CrossOrigin
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/all")
	public List<GeneralTransaction> getAllTransactionInformation() {
		return transactionService.findAllTransactionInformation();
	}
	
	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<GeneralTransaction> GetTransactionInformationByID(@PathVariable Long transactionid) throws ResourceNotFoundException {
		return transactionService.findTransactionInformationByID(transactionid);
	}
	
	@PostMapping("/add-transaction-information")
	public GeneralTransaction addTransaction(@Valid @RequestBody GeneralTransaction transaction) {
		return transactionService.addTransactionInformation(transaction);
	}
	
	@PutMapping("/transaction/{transactionId}")
	public ResponseEntity<GeneralTransaction> updateTransactionInformationController(@PathVariable Long transactionid,
			@Valid @RequestBody GeneralTransaction transactionDetails) {
		return transactionService.updateTransactionInformation(transactionid, transactionDetails);
	}
	
	@DeleteMapping("/transaction/{transactionId}")
	public Map<String,Boolean> deleteTransactionInformation(@PathVariable Long transactionid) {
		return transactionService.deleteTransactionInformation(transactionid);
	}
}
