package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "medical_transactions")
@CrossOrigin
public class MedicalTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 938725339019416975L;
	public Long medicalTransaction_Id;
	public String medical_transaction_date;
	public double amount;
	
	public Facility facility;
	
	public TransactionType transactionType;

	public Users user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medical_transaction_id")
	public Long getMedicalTransaction_Id() {
		return medicalTransaction_Id;
	}
	public void setMedicalTransaction_Id(Long medicalTransaction_Id) {
		this.medicalTransaction_Id = medicalTransaction_Id;
	}
	@Column(name = "medical_transaction_date")
	public String getMedicalTransactionDate() {
		return medical_transaction_date;
	}
	public void setMedicalTransactionDate(String medical_transaction_date) {
		this.medical_transaction_date = medical_transaction_date;
	}
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_type_id")
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((facility == null) ? 0 : facility.hashCode());
		result = prime * result + ((medicalTransaction_Id == null) ? 0 : medicalTransaction_Id.hashCode());
		result = prime * result + ((medical_transaction_date == null) ? 0 : medical_transaction_date.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		MedicalTransaction other = (MedicalTransaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (facility == null) {
			if (other.facility != null)
				return false;
		} else if (!facility.equals(other.facility))
			return false;
		if (medicalTransaction_Id == null) {
			if (other.medicalTransaction_Id != null)
				return false;
		} else if (!medicalTransaction_Id.equals(other.medicalTransaction_Id))
			return false;
		if (medical_transaction_date == null) {
			if (other.medical_transaction_date != null)
				return false;
		} else if (!medical_transaction_date.equals(other.medical_transaction_date))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MedicalTransaction [medicalTransaction_Id=" + medicalTransaction_Id + ", medical_transaction_date="
				+ medical_transaction_date + ", amount=" + amount + ", facility=" + facility + ", transactionType="
				+ transactionType + ", user=" + user + "]";
	}
	public MedicalTransaction(Long medicalTransaction_Id, String medical_transaction_date, double amount,
			Facility facility, TransactionType transactionType, Users user) {
		super();
		this.medicalTransaction_Id = medicalTransaction_Id;
		this.medical_transaction_date = medical_transaction_date;
		this.amount = amount;
		this.facility = facility;
		this.transactionType = transactionType;
		this.user = user;
	}
	
	public MedicalTransaction(String medical_transaction_date, double amount,
			Facility facility, TransactionType transactionType, Users user) {
		super();
		this.medical_transaction_date = medical_transaction_date;
		this.amount = amount;
		this.facility = facility;
		this.transactionType = transactionType;
		this.user = user;
	}
	public MedicalTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
