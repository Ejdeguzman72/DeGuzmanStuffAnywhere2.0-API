package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "AUTO_TRANSACTIONS")
@CrossOrigin
public class AutoTransaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8676869382585836353L;
	public Long autoTransaction_id;
	public String autoTransactionDate;
	public double amount;
	
	public AutoShop autoShop;
	
	public Users user;
	
	public TransactionType transactionType;
	
	public Car car;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auto_transaction_id")
	public Long getAutoTransaction_id() {
		return autoTransaction_id;
	}
	public void setAutoTransaction_id(Long autoTransaction_id) {
		this.autoTransaction_id = autoTransaction_id;
	}
	@Column(name = "auto_transaction_date")
	public String getAutoTransactionDate() {
		return autoTransactionDate;
	}
	public void setAutoTransactionDate(String autoTransactionDate) {
		this.autoTransactionDate = autoTransactionDate;
	}
	
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auto_shop_id")
	public AutoShop getAutoShop() {
		return autoShop;
	}
	public void setAutoShop(AutoShop autoShop) {
		this.autoShop = autoShop;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
	@JoinColumn(name = "car_id")
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
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
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((autoShop == null) ? 0 : autoShop.hashCode());
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
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (autoShop == null) {
			if (other.autoShop != null)
				return false;
		} else if (!autoShop.equals(other.autoShop))
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
		return "AutoTransaction [autoTransaction_id=" + autoTransaction_id + ", autoTransactionDate="
				+ autoTransactionDate + ", autoShop=" + autoShop + ", amount=" + amount + ", user=" + user
				+ ", transactionType=" + transactionType + ", car=" + car + "]";
	}
	public AutoTransaction(Long autoTransaction_id, String autoTransactionDate, AutoShop autoShop, double amount,
			Users user, TransactionType transactionType, Car car) {
		super();
		this.autoTransaction_id = autoTransaction_id;
		this.autoTransactionDate = autoTransactionDate;
		this.autoShop = autoShop;
		this.amount = amount;
		this.user = user; 
		this.transactionType = transactionType;
		this.car = car;
	}
	
	public AutoTransaction(String autoTransactionDate, AutoShop autoShop, double amount,
			Users user, TransactionType transactionType, Car car) {
		super();
		this.autoTransactionDate = autoTransactionDate;
		this.autoShop = autoShop;
		this.amount = amount;
		this.user = user; 
		this.transactionType = transactionType;
		this.car = car;
	}
	
	public AutoTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
