package com.ibm.entity;

public class Employee {
	
	private String id;
	private String name;
	private String lnId;
        private String empAcctID;

    public String getEmpAcctID() {
        return empAcctID;
    }
	
	

	public String getId() {
		return id;
	}

    public void setEmpAcctID(String empAcctID) {
        this.empAcctID = empAcctID;
    }

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLnId() {
		return lnId;
	}

	public void setLnId(String lnId) {
		this.lnId = lnId;
	}	
	
	
}

