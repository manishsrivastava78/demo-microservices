package com.example.demo.model.response;

public class UserRest {
	private String fName;
	private String lName;
	
	public UserRest(String fName,String lName) {
		this.fName=fName;
		this.lName=lName;
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	
}
