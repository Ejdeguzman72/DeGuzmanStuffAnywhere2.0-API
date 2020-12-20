package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "transaction_type")
@CrossOrigin
@EntityListeners(AuditingEntityListener.class)
public class TransactionType {
	
	public long transaction_type_id;
	public String descr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_type_id")
	public long getTransactionTypeId() {
		return transaction_type_id;
	}
	public void setTransactionTypeId(long transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}
	@Column(name = "descr")
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
}
