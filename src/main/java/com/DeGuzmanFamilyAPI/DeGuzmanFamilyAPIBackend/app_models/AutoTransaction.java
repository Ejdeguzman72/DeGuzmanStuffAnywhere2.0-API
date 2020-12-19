package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "auto_transactions")
@CrossOrigin
public class AutoTransaction {
	
	public Long autoTransaction_id;
	public String autoTransactionDate;
	public String shopName;
	public double amount;
//	public String person;
	public int transaction_type_id;
	public int person_id;
	public int car_id;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getAutoTransaction_id() {
		return autoTransaction_id;
	}
	public void setAutoTransaction_id(Long autoTransaction_id) {
		this.autoTransaction_id = autoTransaction_id;
	}
	public String getAutoTransactionDate() {
		return autoTransactionDate;
	}
	public void setAutoTransactionDate(String autoTransactionDate) {
		this.autoTransactionDate = autoTransactionDate;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTransaction_type_id() {
		return transaction_type_id;
	}
	public void setTransaction_type_id(int transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((autoTransactionDate == null) ? 0 : autoTransactionDate.hashCode());
		result = prime * result + ((autoTransaction_id == null) ? 0 : autoTransaction_id.hashCode());
		result = prime * result + car_id;
		result = prime * result + person_id;
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
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
		AutoTransaction other = (AutoTransaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (autoTransactionDate == null) {
			if (other.autoTransactionDate != null)
				return false;
		} else if (!autoTransactionDate.equals(other.autoTransactionDate))
			return false;
		if (autoTransaction_id == null) {
			if (other.autoTransaction_id != null)
				return false;
		} else if (!autoTransaction_id.equals(other.autoTransaction_id))
			return false;
		if (car_id != other.car_id)
			return false;
		if (person_id != other.person_id)
			return false;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		if (transaction_type_id != other.transaction_type_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AutoTransaction [autoTransaction_id=" + autoTransaction_id + ", autoTransactionDate="
				+ autoTransactionDate + ", shopName=" + shopName + ", amount=" + amount + ", transaction_type_id="
				+ transaction_type_id + ", person_id=" + person_id + ", car_id=" + car_id + "]";
	}
	public AutoTransaction(Long autoTransaction_id, String autoTransactionDate, String shopName, double amount,
			int transaction_type_id, int person_id, int car_id) {
		super();
		this.autoTransaction_id = autoTransaction_id;
		this.autoTransactionDate = autoTransactionDate;
		this.shopName = shopName;
		this.amount = amount;
		this.transaction_type_id = transaction_type_id;
		this.person_id = person_id;
		this.car_id = car_id;
	}
	public AutoTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
