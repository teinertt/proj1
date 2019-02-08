package com.revature.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Employee {

	private String id;
	private String name;
	private String userName;
	
	
	private String password;
	
	private String email;
	private String title;
	private String reimbursementNumber;
	private String reimbursementStatus;
	private String reimbursementAmount;
	private String managedBy;
	
	
	public Employee() {

	}


	public Employee(String id, String name, String userName, String email, String title) {
		
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.title = title;
	}
	
	public Employee(String id, String name, String reimbursementNumber, String reimbursementStatus, String reimbursementAmount, String managedBy) {
		
		this.id = id;
		this.name = name;
		this.reimbursementNumber = reimbursementNumber;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementAmount = reimbursementAmount;
		this.managedBy = managedBy;
	}


	public String getId() {
		return id;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getReimbursementNumber() {
		return reimbursementNumber;
	}


	public void setReimbursementNumber(String reimbursementNumber) {
		this.reimbursementNumber = reimbursementNumber;
	}


	public String getReimbursementStatus() {
		return reimbursementStatus;
	}


	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}


	public String getReimbursementAmount() {
		return reimbursementAmount;
	}


	public void setReimbursementAmount(String reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}


	public String getManagedBy() {
		return managedBy;
	}


	public void setManagedBy(String managedBy) {
		this.managedBy = managedBy;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", email="
				+ email + ", title=" + title + "]";
	}
	
}
