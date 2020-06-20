package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "transaction_type")
@CrossOrigin
public class TransactionType {
	
	public long transactionTypeId;
	public String descr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
}
