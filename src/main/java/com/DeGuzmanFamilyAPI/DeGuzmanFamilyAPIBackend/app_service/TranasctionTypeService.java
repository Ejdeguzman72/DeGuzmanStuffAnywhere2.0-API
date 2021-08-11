package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.TransactionType;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.TransactionTypeRepository;

@Service
public class TranasctionTypeService {

	@Autowired
	private TransactionTypeRepository transactionTypeRepository;
	
	public List<TransactionType> findAllTransactioNTypes() {
		return transactionTypeRepository.findAll();
	}
}
