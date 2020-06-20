package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models;

public class TransactionType {
	
	public long transactionTypeId;
	public String descr;
	
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
