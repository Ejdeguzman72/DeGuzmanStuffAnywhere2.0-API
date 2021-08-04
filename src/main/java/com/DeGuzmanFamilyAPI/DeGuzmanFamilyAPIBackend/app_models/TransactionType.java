package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "TRANSACTION_TYPE")
@CrossOrigin
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class TransactionType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3284448543761009503L;
	public long transaction_type_id;
	public String transaction_type_descr;
	
	public List<AutoTransaction> transactionType;
	
	public List<GeneralTransaction> generalTransaction;
	
	public List<MedicalTransaction> medicalTransaction;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_type_id")
	public long getTransactionTypeId() {
		return transaction_type_id;
	}
	public void setTransactionTypeId(long transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}
	@Column(name = "transaction_type_descr")
	public String getDescr() {
		return transaction_type_descr;
	}
	public void setDescr(String transaction_type_descr) {
		this.transaction_type_descr = transaction_type_descr;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy="transactionType")
	@JsonIgnore
	public List<AutoTransaction> getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(List<AutoTransaction> transactionType) {
		this.transactionType = transactionType;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy="transactionType")
	@JsonIgnore
	public List<GeneralTransaction> getGeneralTransaction() {
		return generalTransaction;
	}
	public void setGeneralTransaction(List<GeneralTransaction> generalTransaction) {
		this.generalTransaction = generalTransaction;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy="transactionType")
	@JsonIgnore
	public List<MedicalTransaction> getMedicalTransaction() {
		return medicalTransaction;
	}
	public void setMedicalTransaction(List<MedicalTransaction> medicalTransaction) {
		this.medicalTransaction = medicalTransaction;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generalTransaction == null) ? 0 : generalTransaction.hashCode());
		result = prime * result + ((medicalTransaction == null) ? 0 : medicalTransaction.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		result = prime * result + ((transaction_type_descr == null) ? 0 : transaction_type_descr.hashCode());
		result = prime * result + (int) (transaction_type_id ^ (transaction_type_id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionType other = (TransactionType) obj;
		if (generalTransaction == null) {
			if (other.generalTransaction != null)
				return false;
		} else if (!generalTransaction.equals(other.generalTransaction))
			return false;
		if (medicalTransaction == null) {
			if (other.medicalTransaction != null)
				return false;
		} else if (!medicalTransaction.equals(other.medicalTransaction))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		if (transaction_type_descr == null) {
			if (other.transaction_type_descr != null)
				return false;
		} else if (!transaction_type_descr.equals(other.transaction_type_descr))
			return false;
		if (transaction_type_id != other.transaction_type_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionType [transaction_type_id=" + transaction_type_id + ", transaction_type_descr="
				+ transaction_type_descr + ", transactionType=" + transactionType + ", generalTransaction="
				+ generalTransaction + ", medicalTransaction=" + medicalTransaction + "]";
	}
	public TransactionType(long transaction_type_id, String transaction_type_descr,
			List<AutoTransaction> transactionType, List<GeneralTransaction> generalTransaction,
			List<MedicalTransaction> medicalTransaction) {
		super();
		this.transaction_type_id = transaction_type_id;
		this.transaction_type_descr = transaction_type_descr;
		this.transactionType = transactionType;
		this.generalTransaction = generalTransaction;
		this.medicalTransaction = medicalTransaction;
	}
	public TransactionType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
