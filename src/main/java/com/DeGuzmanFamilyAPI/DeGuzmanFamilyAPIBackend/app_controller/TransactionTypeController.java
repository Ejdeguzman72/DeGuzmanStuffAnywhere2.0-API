package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.TransactionType;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service.TranasctionTypeService;

@RestController
@RequestMapping("/app/transaction-types")
@CrossOrigin
public class TransactionTypeController {

	@Autowired
	private TranasctionTypeService transactionTypeService;
	
	@GetMapping("/all")
	public List<TransactionType> getAllTransactionTypeInformation() {
		return transactionTypeService.findAllTransactioNTypes();
	}
}
