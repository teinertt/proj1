package com.revature.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Reimbursements {
	private String id;
	private String name;
	private String reimbursementNumber;
	private String reimbursementStatus;
	private String reimbursementAmount;
	private String managedBy;
	
	public Reimbursements() {
		
	}


	@Override
	public String toString() {
		return "Reimbursements [id=" + id + ", name=" + name + ", reimbursementNumber=" + reimbursementNumber
				+ ", reimbursementStatus=" + reimbursementStatus + ", reimbursementAmount=" + reimbursementAmount
				+ ", managedBy=" + managedBy + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((managedBy == null) ? 0 : managedBy.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reimbursementAmount == null) ? 0 : reimbursementAmount.hashCode());
		result = prime * result + ((reimbursementNumber == null) ? 0 : reimbursementNumber.hashCode());
		result = prime * result + ((reimbursementStatus == null) ? 0 : reimbursementStatus.hashCode());
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
		Reimbursements other = (Reimbursements) obj;
		if (id != other.id)
			return false;
		if (managedBy == null) {
			if (other.managedBy != null)
				return false;
		} else if (!managedBy.equals(other.managedBy))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reimbursementAmount == null) {
			if (other.reimbursementAmount != null)
				return false;
		} else if (!reimbursementAmount.equals(other.reimbursementAmount))
			return false;
		if (reimbursementNumber == null) {
			if (other.reimbursementNumber != null)
				return false;
		} else if (!reimbursementNumber.equals(other.reimbursementNumber))
			return false;
		if (reimbursementStatus == null) {
			if (other.reimbursementStatus != null)
				return false;
		} else if (!reimbursementStatus.equals(other.reimbursementStatus))
			return false;
		return true;
	}


	public Reimbursements(String id, String name, String reimbursementNumber, String reimbursementStatus,
			String reimbursementAmount, String managedBy) {
		super();
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

}
