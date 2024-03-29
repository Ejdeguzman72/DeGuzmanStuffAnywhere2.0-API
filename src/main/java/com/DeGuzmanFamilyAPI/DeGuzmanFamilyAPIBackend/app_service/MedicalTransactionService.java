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

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Facility;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.MedicalTransaction;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.TransactionType;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Users;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.FacilityRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.MedicalTransactionRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.TransactionTypeRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.UserRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.MedicalTransactionInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RunTrackerServiceInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger.MedicalTrxLogger;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.message.LoggerMessage;

@Service
public class MedicalTransactionService implements MedicalTransactionInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(RunTrackerServiceInterface.class);
	
	@Autowired
	private MedicalTransactionRepository medicalTransactionRepository;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private TransactionTypeRepository transactionTypeRepository;
	
	@Autowired
	private UserRepository usersRepository;
	
	// returns the Medical transactions in a list
	@Override
	@Cacheable(value = "medicalTrasactionList")
	public List<MedicalTransaction> findAllMedicalTransactionInformation() {
		List<MedicalTransaction> medicalTrxList = medicalTransactionRepository.findAll();
		if (medicalTrxList.isEmpty() || medicalTrxList.size() == 0) {
			LOGGER.warn(LoggerMessage.GET_ALL_MEDICAL_TRX_ERROR_MESSAGE);
		}
		else {
			LOGGER.info(LoggerMessage.GET_ALL_MEDICAL_TRX_INFO_MESSAGE);
		}
		return medicalTransactionRepository.findAll();
	}
	
	// based on the pathvariable thrown, this returns the Medical Transaction object that has the corresponding ID
	@Override
	@Cacheable(value = "medicaTrasactionById", key = "#medicalTransactionId")
	public ResponseEntity<MedicalTransaction> findMedicalTransactionInformationById(@PathVariable Long medicalTransactionId) throws ResourceNotFoundException {
		MedicalTransaction medicalTransaction = medicalTransactionRepository.findById(medicalTransactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		if (medicalTransactionId == null || medicalTransactionId == 0) {
			LOGGER.error(LoggerMessage.GET_MEDICAL_TRX_BY_ID_ERROR_MESSAGE + ": " + medicalTransactionId);
		}
		else  {
			LOGGER.info(LoggerMessage.GET_MEDICAL_TRX_BY_ID_INFO_MESSAGE);
		}
		return ResponseEntity.ok().body(medicalTransaction);
	}
	
	// creates an MedicalTransaction object based off the fields that are filled.
	@Override
	@CachePut(value = "medicalTrasactionList")
	public MedicalTransaction addMedicalTransactionInformation(@Valid @RequestBody MedicalTransaction medicalTransaction) throws ResourceNotFoundException {
		if (medicalTransaction == null) {
			LOGGER.warn(LoggerMessage.ADD_MEDICAL_TRX_ERROR_MESSAGE);
		}
		else {
			LOGGER.info(LoggerMessage.ADD_MEDICAL_TRX_INFORMATION_INFO_MESSAGE + ": " + medicalTransaction.amount + " " + medicalTransaction.medical_transaction_date);
		}
		String medicalTRansactionDate = medicalTransaction.medical_transaction_date;
		double amount = medicalTransaction.amount;
		
		Facility facility = facilityRepository.findById((int) medicalTransaction.getUser().getUserid())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find"));
		Users user = usersRepository.findById(medicalTransaction.getUser().getUserid())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find"));
		TransactionType transactionType = transactionTypeRepository.findById(medicalTransaction.getTransactionType().getTransactionTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find"));
		MedicalTransaction newMedicalTrx = new MedicalTransaction(medicalTRansactionDate,amount,facility,transactionType,user);
		return medicalTransactionRepository.save(newMedicalTrx);
	}
	
	// updates the MedicalTransaction based on the id number entered. Once the fields are updated, then a new Auto
		// Transaction object is created.
	@Override
	public ResponseEntity<MedicalTransaction> updateMedicalTransaction(@PathVariable Long medicalTransactionId,
			@Valid @RequestBody MedicalTransaction medicalTransactionDetails) {
		MedicalTransaction medicalTransaction = null;
		try {
			medicalTransaction = medicalTransactionRepository.findById(medicalTransactionId)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
			if (medicalTransactionId == null || medicalTransactionId == 0) {
				LOGGER.warn(LoggerMessage.GET_MEDICAL_TRX_BY_ID_ERROR_MESSAGE);;
			}
			else {
				LOGGER.info(LoggerMessage.GET_MEDICAL_TRX_BY_ID_INFO_MESSAGE + ": " + medicalTransactionId);
			}
			medicalTransaction.setAmount(medicalTransactionDetails.getAmount());
			medicalTransaction.setMedicalTransactionDate(medicalTransactionDetails.getMedicalTransactionDate());
			medicalTransaction.setFacility(facilityRepository.findById((int) medicalTransaction.getUser().getUserid())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find")));
			medicalTransaction.setTransactionType(transactionTypeRepository.findById(medicalTransaction.getTransactionType().getTransactionTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find")));
			medicalTransaction.setUser(usersRepository.findById(medicalTransaction.getUser().getUserid())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find")));
			MedicalTrxLogger.medicalTrxLogger.info("Currently updating medical transcation information for ID");
		}
		catch (ResourceNotFoundException e)  {
			e.printStackTrace();
		}
		final MedicalTransaction updatedMedicalTransaction = medicalTransactionRepository.save(medicalTransaction);
		LOGGER.info(LoggerMessage.UPDATE_AUTO_TRX_INFO_MESSAGE + updatedMedicalTransaction.amount + updatedMedicalTransaction.medical_transaction_date);
		return ResponseEntity.ok().body(updatedMedicalTransaction);
	}
	
	@Override
	@CachePut(value = "medicalTrasactionList")
	public Map<String,Boolean> deleteMedicalTraansactionInformation(@PathVariable Long medicalTransactionId) {
		medicalTransactionRepository.deleteById(medicalTransactionId);
		if (medicalTransactionId == null || medicalTransactionId == 0) {
			LOGGER.warn(LoggerMessage.DELETE_MEDICAL_TRX_ERROR_MESSAGE);
		}
		else {
			LOGGER.info(LoggerMessage.DELETE_MEDICAL_TRX_INFORMATION_INFO_MESSAGE + ": " + medicalTransactionId);
		}
		Map<String,Boolean> response = new HashMap<>();
		response.put("Medical Transaction deleted", Boolean.TRUE);
		return response;
	}

	@Override
	public long getCountOfMedicalTransactions() {
		return medicalTransactionRepository.count();
	}
}
