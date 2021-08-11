package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.util;

public class StringFormatter {

	public String formatPhoneNumber(String phone) {
		String phoneNumberFormat = null;
		if (phone.length() > 0) {
			phoneNumberFormat = phone.substring(0,2);
		}
		return phoneNumberFormat;
	}
}
