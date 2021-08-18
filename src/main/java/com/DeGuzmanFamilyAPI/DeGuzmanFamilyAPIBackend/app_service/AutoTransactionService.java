package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.AutoShop;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.AutoTransaction;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Car;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.TransactionType;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Users;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.AutoShopRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.AutoTransactionRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.CarRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.TransactionTypeRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.UserRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.AutoTransactionInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RunTrackerServiceInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger.AutoTrxLogger;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.message.LoggerMessage;

@Service
public class AutoTransactionService implements AutoTransactionInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(RunTrackerServiceInterface.class);
	
	@Autowired
	private AutoTransactionRepository autoTransactionRepository;
	
	@Autowired
	private AutoShopRepository autoShopRepository;
	
	@Autowired
	private TransactionTypeRepository transactionTypeRepository;
	
	@Autowired
	private UserRepository usersRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	// returns the Auto transactions in a list
	@Cacheable(value = "autoTransactionList")
	public List<AutoTransaction> findAllAutoTransactionInformation() {
		List<AutoTransaction> autoTrxList = autoTransactionRepository.findAll();
		if (autoTrxList.isEmpty() || autoTrxList.size() == 0) {
			LOGGER.warn(LoggerMessage.GET_ALL_AUTO_TRX_INFO_ERROR_MESSAGE + ": " + autoTrxList.size());
		}
		else {
			LOGGER.info(LoggerMessage.GET_ALL_AUTO_TRX_INFO_MESSAGE + ": " + autoTrxList.size());
		}
		return autoTransactionRepository.findAll();
	}
	
	// based on the pathvariable thrown, this returns the AutoTransaction object that has the corresponding ID
	@Cacheable(value = "autoTrasactionById", key = "#autoTransactionId")
	public ResponseEntity<AutoTransaction> findAutoTranasctionInformationById(@PathVariable Long autoTransactionId) throws ResourceNotFoundException {
		AutoTransaction autoTransactions = autoTransactionRepository.findById(autoTransactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		if (autoTransactionId == null || autoTransactionId <= 0) {
			LOGGER.warn(LoggerMessage.GET_AUTO_TRX_INFO_BY_ID_ERROR_MESSAGE + ": " + autoTransactionId);
		}
		else {
			LOGGER.info(LoggerMessage.GET_AUTO_TRX_INFO_BY_ID_MESSAGE + ": " + autoTransactionId);
		}
		return ResponseEntity.ok().body(autoTransactions);
	}
	
	// creates an AutoTransaction object based off the fields that are filled.
	@CachePut(value = "autoTransactionList")
	public AutoTransaction addAutoTransactionInformation(@Valid @RequestBody AutoTransaction autoTransaction) throws ResourceNotFoundException {
		if (autoTransaction == null) {
			LOGGER.warn(LoggerMessage.ADD_AUTO_TRX_INFO_ERROR_MESSAGE);
		}
		else {
			LOGGER.info(LoggerMessage.ADD_AUTO_TRX_INFO_MESSAGE + ": " + autoTransaction.amount);
		}
		
		String autoTransactionDate = autoTransaction.autoTransactionDate;
		double amount = autoTransaction.amount;
		AutoShop autoShop = autoShopRepository.findById(autoTransaction.getAutoShop().getAutoshopId())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find"));
		Users user = usersRepository.findById(autoTransaction.getUser().getUserid())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find"));
		TransactionType transactionType = transactionTypeRepository.findById(autoTransaction.getTransactionType().getTransactionTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find"));
		Car car = carRepository.findById(autoTransaction.getCar().getCarid())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot Find"));
		
		AutoTransaction newAutoTransaction = new AutoTransaction(autoTransactionDate,autoShop,amount,user,transactionType,car);
		
		return autoTransactionRepository.save(newAutoTransaction);
	}
	
	// updates the AutoTransaction based on the id number entered. Once the fields are updated, then a new Auto
	// Transaction object is created.
	@CachePut(value = "transactionById",  key = "#autoTransactionId")
	public ResponseEntity<AutoTransaction> updateTransactionInformation(@PathVariable Long autoTransactionId,
			@Valid @RequestBody AutoTransaction autoTransactionDetails) {
		AutoTransaction autoTransaction = null;
		try {
			autoTransaction = autoTransactionRepository.findById(autoTransactionId)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
			if (autoTransactionId == null || autoTransactionId <= 0) {
				LOGGER.warn(LoggerMessage.GET_AUTO_TRX_INFO_BY_ID_ERROR_MESSAGE);
			}
			
			autoTransaction.setAutoTransactionDate(autoTransactionDetails.getAutoTransactionDate());
			
			autoTransaction.setAmount(autoTransactionDetails.getAmount());
			
			autoTransaction.setAutoShop(autoShopRepository.findById(autoTransactionDetails.getAutoShop().getAutoshopId())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find")));
			
			autoTransaction.setUser(usersRepository.findById(autoTransactionDetails.getUser().getUserid())
					.orElseThrow(() -> new ResourceNotFoundException("Cannot Find")));
			
			autoTransaction.setTransactionType(transactionTypeRepository.findById(autoTransactionDetails.getTransactionType().getTransactionTypeId())
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find")));
			
			autoTransaction.setCar(carRepository.findById(autoTransactionDetails.getCar().getCarid())
					.orElseThrow(() -> new ResourceNotFoundException("Cannot Find")));
			
		}
		catch (ResourceNotFoundException e) {
			e.printStackTrace();
			LOGGER.warn(LoggerMessage.UPDATE_AUTO_TRX_INFO_ERROR_MESSAGE + ": " + autoTransactionId);
		}
		final AutoTransaction updatedAutoTransactionDetails = autoTransactionRepository.save(autoTransaction);
		LOGGER.info(LoggerMessage.UPDATE_AUTO_TRX_INFO_MESSAGE + ": " + updatedAutoTransactionDetails.amount);
		return ResponseEntity.ok().body(updatedAutoTransactionDetails);
	}
	
	//deletes the AutoTransaction object based off the id number passed. A HashMap is created in order to 
	// return a string and confirm  that the entity was deleted. 
	public Map<String,Boolean> deleteAutoTransactionInformation(@PathVariable Long autoTransactionId) {
		autoTransactionRepository.deleteById(autoTransactionId);
		if (autoTransactionId == null || autoTransactionId <= 0) {
			LOGGER.warn(LoggerMessage.DELETE_AUTO_TRX_INFO_ERROR_MESSAGE);
		}
		else {
			LOGGER.info(LoggerMessage.DELETE_AUTO_TRX_MESSAGE + ": " + autoTransactionId);
		}
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}

	@Override
	public long getCountOfAutoTransactions() {
		return autoTransactionRepository.count();
	}
}
