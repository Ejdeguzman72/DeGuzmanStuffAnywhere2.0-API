package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models;

public class FileInfo {

	private String name;
	private String url;
	
	public FileInfo(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "FileInfo [name=" + name + ", url=" + url + ", getName()=" + getName() + ", getUrl()=" + getUrl()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
