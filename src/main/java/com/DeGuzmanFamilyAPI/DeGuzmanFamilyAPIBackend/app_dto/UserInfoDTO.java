package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserInfoDTO {

	public int user_id;
	public String username; 
	public String password;
	public String name;
	public String email;
	public String userStatusDescr;
	public String roleDescr;
	
}
