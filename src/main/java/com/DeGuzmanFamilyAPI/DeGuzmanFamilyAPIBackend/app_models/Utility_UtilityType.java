package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "utility_utility_type")
@CrossOrigin
public class Utility_UtilityType {

	public Long utilityid;
	public Long utilityTypeId;
	
	public Long getUtilityid() {
		return utilityid;
	}
	public void setUtilityid(Long utilityid) {
		this.utilityid = utilityid;
	}
	public Long getUtilityTypeId() {
		return utilityTypeId;
	}
	public void setUtilityTypeId(Long utilityTypeId) {
		this.utilityTypeId = utilityTypeId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((utilityTypeId == null) ? 0 : utilityTypeId.hashCode());
		result = prime * result + ((utilityid == null) ? 0 : utilityid.hashCode());
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
		Utility_UtilityType other = (Utility_UtilityType) obj;
		if (utilityTypeId == null) {
			if (other.utilityTypeId != null)
				return false;
		} else if (!utilityTypeId.equals(other.utilityTypeId))
			return false;
		if (utilityid == null) {
			if (other.utilityid != null)
				return false;
		} else if (!utilityid.equals(other.utilityid))
			return false;
		return true;
	}
	
	
	
}
