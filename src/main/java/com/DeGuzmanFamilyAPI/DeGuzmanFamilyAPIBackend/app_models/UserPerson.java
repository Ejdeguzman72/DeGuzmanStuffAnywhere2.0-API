package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "user_person")
@CrossOrigin
@EntityListeners(AuditingEntityListener.class)
public class UserPerson {

	private Long userid;
	private Long personid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getPersonid() {
		return personid;
	}
	public void setPersonid(Long personid) {
		this.personid = personid;
	}
	
	@OneToOne(fetch =  FetchType.LAZY,
			optional = false)
	@JoinColumn(name = "userid", nullable = false)
	private Users user;
}
