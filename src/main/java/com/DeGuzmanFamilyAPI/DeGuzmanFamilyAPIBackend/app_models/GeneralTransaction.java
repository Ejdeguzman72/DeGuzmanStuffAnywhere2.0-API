package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "general_transaction")
@CrossOrigin
@EntityListeners(AuditingEntityListener.class)
public class GeneralTransaction {

	private long transaction_id;
	private double amount;
	private String paymentDate;
	private String entity;
	private int transaction_type_id;
	private int person_id;
	
	@OneToMany(targetEntity = TransactionType.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "trasaction_transaction_type_fk", referencedColumnName = "transaction_type_id")
	public List<TransactionType> transactionType;
	
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "transaction_person_fk", referencedColumnName = "person_id")
	public List<Person> person;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Column(name = "payment_date")
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Column(name = "entity")
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
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
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + person_id;
		result = prime * result + (int) (transaction_id ^ (transaction_id >>> 32));
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
		if (person_id != other.person_id)
			return false;
		if (transaction_id != other.transaction_id)
			return false;
		if (transaction_type_id != other.transaction_type_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GeneralTransaction [transaction_id=" + transaction_id + ", amount=" + amount + ", paymentDate="
				+ paymentDate + ", entity=" + entity + ", transaction_type_id=" + transaction_type_id + ", person_id="
				+ person_id + "]";
	}
	public GeneralTransaction(long transaction_id, double amount, String paymentDate, String entity,
			int transaction_type_id, int person_id) {
		super();
		this.transaction_id = transaction_id;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.entity = entity;
		this.transaction_type_id = transaction_type_id;
		this.person_id = person_id;
	}
	public GeneralTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}