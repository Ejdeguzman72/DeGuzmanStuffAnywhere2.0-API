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
	
	public Long autoTransactionId;
	public Long carid;
	public String autoTransactionDate;
	public Long shopId;
	public Long transactionTypeId;
	public double amount;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getAutoTransactionId() {
		return autoTransactionId;
	}
	public void setAutoTransactionId(Long autoTransactionId) {
		this.autoTransactionId = autoTransactionId;
	}
	public Long getCarid() {
		return carid;
	}
	public void setCarid(Long carid) {
		this.carid = carid;
	}
	public String getAutoTransactionDate() {
		return autoTransactionDate;
	}
	public void setAutoTransactionDate(String autoTransactionDate) {
		this.autoTransactionDate = autoTransactionDate;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Long getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(Long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((autoTransactionDate == null) ? 0 : autoTransactionDate.hashCode());
		result = prime * result + ((autoTransactionId == null) ? 0 : autoTransactionId.hashCode());
		result = prime * result + ((carid == null) ? 0 : carid.hashCode());
		result = prime * result + ((shopId == null) ? 0 : shopId.hashCode());
		result = prime * result + ((transactionTypeId == null) ? 0 : transactionTypeId.hashCode());
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
		if (autoTransactionId == null) {
			if (other.autoTransactionId != null)
				return false;
		} else if (!autoTransactionId.equals(other.autoTransactionId))
			return false;
		if (carid == null) {
			if (other.carid != null)
				return false;
		} else if (!carid.equals(other.carid))
			return false;
		if (shopId == null) {
			if (other.shopId != null)
				return false;
		} else if (!shopId.equals(other.shopId))
			return false;
		if (transactionTypeId == null) {
			if (other.transactionTypeId != null)
				return false;
		} else if (!transactionTypeId.equals(other.transactionTypeId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AutoTransactions [autoTransactionId=" + autoTransactionId + ", carid=" + carid
				+ ", autoTransactionDate=" + autoTransactionDate + ", shopId=" + shopId + ", transactionTypeId="
				+ transactionTypeId + ", amount=" + amount + "]";
	}
	
	public AutoTransaction() {
		super();
	
	}
	
}
