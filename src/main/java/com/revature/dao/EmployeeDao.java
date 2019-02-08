package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursements;

public interface EmployeeDao {

	//read all
	List<Employee> getAllEmployees();
	
	//read one
	Employee getEmployeeById(String id) throws SQLException;
	
	//create
	void createEmployee(Employee employee);
	
	//update
	void updateEmployee(Employee employee);
	
	//delete
	//Employee deleteEmployee(String id);

	List<Reimbursements> getReimbursements(String id);

	List<Reimbursements> getAllReimbursements();

	boolean submitReimbursement(Reimbursements reimbursements);

	List<Reimbursements> getPendingRmbs();

	List<Reimbursements> getOneReimbursement(Reimbursements reimbursements);
	
	
	
}
