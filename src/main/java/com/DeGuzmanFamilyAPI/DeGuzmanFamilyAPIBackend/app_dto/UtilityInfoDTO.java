package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_dto;

public class UtilityInfoDTO {

	public Long utility_id;
	public String name;
	public String phone;
	public String url;
	public String dueDate;
	public String type_description;
	
	public Long getUtility_id() {
		return utility_id;
	}
	public void setUtility_id(Long utility_id) {
		this.utility_id = utility_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getType_description() {
		return type_description;
	}
	public void setType_description(String type_description) {
		this.type_description = type_description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((type_description == null) ? 0 : type_description.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((utility_id == null) ? 0 : utility_id.hashCode());
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
		UtilityInfoDTO other = (UtilityInfoDTO) obj;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (type_description == null) {
			if (other.type_description != null)
				return false;
		} else if (!type_description.equals(other.type_description))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (utility_id == null) {
			if (other.utility_id != null)
				return false;
		} else if (!utility_id.equals(other.utility_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UtilityInfoDTO [utility_id=" + utility_id + ", name=" + name + ", phone=" + phone + ", url=" + url
				+ ", dueDate=" + dueDate + ", type_description=" + type_description + "]";
	}
	public UtilityInfoDTO(Long utility_id, String name, String phone, String url, String dueDate,
			String type_description) {
		super();
		this.utility_id = utility_id;
		this.name = name;
		this.phone = phone;
		this.url = url;
		this.dueDate = dueDate;
		this.type_description = type_description;
	}
	public UtilityInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
