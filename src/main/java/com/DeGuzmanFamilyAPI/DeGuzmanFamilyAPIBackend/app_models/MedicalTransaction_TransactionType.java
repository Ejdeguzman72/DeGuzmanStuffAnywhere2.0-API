package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "medical_transaction_transaction_type")
@CrossOrigin
public class MedicalTransaction_TransactionType {

	public Long medicalTransactionId;
	public long transactionTypeId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getMedicalTransactionId() {
		return medicalTransactionId;
	}
	public void setMedicalTransactionId(Long medicalTransactionId) {
		this.medicalTransactionId = medicalTransactionId;
	}
	public long getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	
	
}
