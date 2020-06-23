package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models;

public class AutoTransactionFileInfo {

	private String autoTransactionFileName;
	private String autoTransactionFileUrl;
	
	public String getAutoTransactionFileName() {
		return autoTransactionFileName;
	}
	public void setAutoTransactionFileName(String autoTransactionFileName) {
		this.autoTransactionFileName = autoTransactionFileName;
	}
	public String getAutoTransactionFileUrl() {
		return autoTransactionFileUrl;
	}
	public void setAutoTransactionFileUrl(String autoTransactionFileUrl) {
		this.autoTransactionFileUrl = autoTransactionFileUrl;
	}
	
	public AutoTransactionFileInfo(String autoTransactionFileName, String autoTransactionFileUrl) {
		super();
		this.autoTransactionFileName = autoTransactionFileName;
		this.autoTransactionFileUrl = autoTransactionFileUrl;
	}
}
