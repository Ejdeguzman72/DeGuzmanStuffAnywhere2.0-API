package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "medical_transactions")
@CrossOrigin
public class MedicalTransaction {

	public Long medicalTransaction_Id;
	public int facillity_id;
	public String medical_transaction_date;
	public double amount;
	public int transaction_type_id;
	public int person_id;
	
	@OneToOne(targetEntity = Facility.class, cascade = CascadeType.ALL)
	@JoinColumn(name="medical_transaction_facility_fk", referencedColumnName = "facility_id")
	public List<Facility> facility;
	
	@OneToMany(targetEntity = TransactionType.class, cascade = CascadeType.ALL)
	@JoinColumn(name="medical_transaction_transaction_type_fk", referencedColumnName="transaction_type_id")
	public List<TransactionType> transactionTypes;
	
	@ManyToOne(targetEntity = Person.class,  cascade = CascadeType.ALL)
	@JoinColumn(name="medical_transaction_person", referencedColumnName="person_id")
	public List<Person> person;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medical_transaction_id")
	public Long getMedicalTransaction_Id() {
		return medicalTransaction_Id;
	}
	public void setMedicalTransaction_Id(Long medicalTransaction_Id) {
		this.medicalTransaction_Id = medicalTransaction_Id;
	}
	@Column(name = "facility")
	public int getFacillity_id() {
		return facillity_id;
	}
	public void setFacillity_id(int facillity_id) {
		this.facillity_id = facillity_id;
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
	@Column(name = "transaction_type_id")
	public int getTransaction_type_id() {
		return transaction_type_id;
	}
	public void setTransaction_type_id(int transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}
	@Column(name = "person_id")
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + facillity_id;
		result = prime * result + ((medicalTransaction_Id == null) ? 0 : medicalTransaction_Id.hashCode());
		result = prime * result + ((medical_transaction_date == null) ? 0 : medical_transaction_date.hashCode());
		result = prime * result + person_id;
		result = prime * result + transaction_type_id;
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
		if (facillity_id != other.facillity_id)
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
		if (person_id != other.person_id)
			return false;
		if (transaction_type_id != other.transaction_type_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MedicalTransaction [medicalTransaction_Id=" + medicalTransaction_Id + ", facillity_id=" + facillity_id
				+ ", medical_transaction_date=" + medical_transaction_date + ", amount=" + amount
				+ ", transaction_type_id=" + transaction_type_id + ", person_id=" + person_id + "]";
	}
	public MedicalTransaction(Long medicalTransaction_Id, int facillity_id, String medical_transaction_date,
			double amount, int transaction_type_id, int person_id) {
		super();
		this.medicalTransaction_Id = medicalTransaction_Id;
		this.facillity_id = facillity_id;
		this.medical_transaction_date = medical_transaction_date;
		this.amount = amount;
		this.transaction_type_id = transaction_type_id;
		this.person_id = person_id;
	}
	public MedicalTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
}
