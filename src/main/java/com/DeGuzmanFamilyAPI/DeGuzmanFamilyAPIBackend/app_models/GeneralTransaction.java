package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "general_transaction")
@CrossOrigin
@EntityListeners(AuditingEntityListener.class)
public class GeneralTransaction {

	private long transactionId;
	private double amount;
	private String paymentDate;
	private String entity;
	private String person;
	private int transaction_type_id;
	private int person_id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public int getTransaction_type_id() {
		return transaction_type_id;
	}
	public void setTransaction_type_id(int transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + person_id;
		result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
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
		GeneralTransaction other = (GeneralTransaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (person_id != other.person_id)
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transaction_type_id != other.transaction_type_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GeneralTransaction [transactionId=" + transactionId + ", amount=" + amount + ", paymentDate="
				+ paymentDate + ", entity=" + entity + ", person=" + person + ", person_id=" + person_id
				+ ", transaction_type_id=" + transaction_type_id + "]";
	}
	public GeneralTransaction(long transactionId, double amount, String paymentDate, String entity, String person,
			int person_id, int transaction_type_id) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.entity = entity;
		this.person = person;
		this.person_id = person_id;
		this.transaction_type_id = transaction_type_id;
	}
	public GeneralTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}