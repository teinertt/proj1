package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.utils.JDBCconnectionUtil;
import com.revature.data.DataSource;
import com.revature.exception.EmployeeNotFoundException;
import com.revature.model.Employee;
import com.revature.model.Reimbursements;

public class EmployeeDaoImp implements EmployeeDao{

	private final DataSource dataSource = DataSource.getInstance();
	
	//SELECT * FROM EMPLOYEES;
	@Override
	public List<Employee> getAllEmployees() {
		try (Connection conn = JDBCconnectionUtil.getConnection()) {
					System.out.println("in EmployeeDao.getAllEmployees");	
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM EMPLOYEES";

			ResultSet results = stmt.executeQuery(sql);
			List<Employee> allEmployees = new ArrayList<>();
			
			
			while (results.next()) {
				allEmployees.add(new Employee(
						results.getString("EMPLOYEE_ID"),
						results.getString("EMPLOYEE_NAME"), 
						results.getString("EMPLOYEE_USERNAME"),
						results.getString("EMPLOYEE_EMAIL"),
						results.getString("TITLE")));	
			}
			
			return allEmployees;
				
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return dataSource.getEmployeeTable();
		return null;
	}

	//SELECT * FROM EMPLOYEES WHERE ID = ?;
	@Override
	public Employee getEmployeeById(String id) throws SQLException {
		try (Connection conn = JDBCconnectionUtil.getConnection()) {
		System.out.println("in EmployeeDao.getAllEmployees");	
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, id);
		
		ResultSet results = ps.executeQuery();
		while (results.next()) {
			return new Employee(
					results.getString("EMPLOYEE_ID"),
					results.getString("EMPLOYEE_NAME"), 
					results.getString("EMPLOYEE_USERNAME"),
					results.getString("EMPLOYEE_EMAIL"),
					results.getString("TITLE"));
		
		}
		
		return null;
	}
	}
	@Override
	public void createEmployee(Employee employee) {
			Employee emp = employee;
		try (Connection conn = JDBCconnectionUtil.getConnection()) {
			String sql = "{call INSERT_EMPLOYEE (?,?,?,?,?)}";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2,  emp.getUserName());
			ps.setString(3, emp.getPassword());
			ps.setString(4,  emp.getEmail());
			ps.setString(5,  emp.getTitle());
			

			if(ps.executeUpdate() > 0) {
				System.out.println("\nYou are now registered");
				
			} 
			else {
				throw new SQLException();
			}
		}
		catch (SQLException e) {
			e.getStackTrace();
		}
					
	}

	@Override
	public void updateEmployee(Employee employee) {
		Employee emp = employee;
		try (Connection conn = JDBCconnectionUtil.getConnection()) {
			String sql = "{call UPDATE_EMPLOYEE (?,?,?,?)}";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setString(3,  emp.getUserName());
			ps.setString(4, emp.getEmail());
			
				System.out.println("Id" + " " + emp.getId());
				System.out.println("Email" + " " + emp.getEmail());
			if(ps.executeUpdate() > 0) {
				System.out.println("\nData Updated");
			
			} 
			else {
				throw new SQLException();
			}
		}
		catch (SQLException e) {
			e.getStackTrace();
		}
	
	}

	
	@Override
	public List<Reimbursements> getReimbursements(String id) {
		try (Connection conn = JDBCconnectionUtil.getConnection()) {
			System.out.println("in EmployeeDao.getReimbursements");	
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEE_ID = (?)";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, id);
			List<Reimbursements> getRmb = new ArrayList<>();
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				getRmb.add(new Reimbursements(
						results.getString("EMPLOYEE_ID"),
						results.getString("EMPLOYEE_NAME"), 
						results.getString("REIMBURSEMENT_NUMBER"),
						results.getString("REIMBURSEMENT_STATUS"),
						results.getString("REIMBURSEMENT_AMOUNT"),
						results.getString("MANAGED_BY")));
			}
			return getRmb;
			}catch(SQLException e) {
				e.getStackTrace();
			}
		return null;
	}

	@Override
	public List<Reimbursements> getAllReimbursements() {
		try (Connection conn = JDBCconnectionUtil.getConnection()) {
			System.out.println("in EmployeeDao.getAllReimbursements");	
			String sql = "SELECT * FROM REIMBURSEMENTS";
			PreparedStatement ps = conn.prepareCall(sql);
			
			List<Reimbursements> allEmployees = new ArrayList<>();
			
			ResultSet results = ps.executeQuery();
			
			while (results.next()) {
				allEmployees.add(new Reimbursements(
						results.getString("EMPLOYEE_ID"),
						results.getString("EMPLOYEE_NAME"), 
						results.getString("REIMBURSEMENT_NUMBER"),
						results.getString("REIMBURSEMENT_STATUS"),
						results.getString("REIMBURSEMENT_AMOUNT"),
						results.getString("MANAGED_BY")));	
			}
				
					return allEmployees;
				
			}catch(SQLException e) {
				e.getStackTrace();
			}
		
		return null;
		
	}
	
	
	@Override
	public boolean submitReimbursement(Reimbursements reimbursement) {
			Reimbursements rmb = reimbursement;
		System.out.println("in submit rmb");
		try (Connection conn = JDBCconnectionUtil.getConnection()) {
			String sql = "{call INSERT_REIMBURSEMENT (?,?,?)}";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, rmb.getId());
			ps.setString(2,  rmb.getName());
			ps.setString(3,  rmb.getReimbursementAmount());
			
			System.out.println(rmb.getId() + rmb.getName() + rmb.getReimbursementAmount());
			System.out.println("before executeUpdate");
			System.out.println(sql);
			if(ps.executeUpdate() > 0) {
				System.out.println("\nSubmission Complete");
				return true;
			} 
			else {
				throw new SQLException();
			}
		}
		catch (SQLException e) {
		e.getStackTrace();
		}
					
		return false;
	}

	
	@Override
	public List<Reimbursements> getPendingRmbs() {
		try (Connection conn = JDBCconnectionUtil.getConnection()) {
			System.out.println("in EmployeeDao.getPendingRmbs");
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIMBURSEMENT_STATUS = 'PENDING'";
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Reimbursements> getPend = new ArrayList<>();
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				getPend.add(new Reimbursements(
						results.getString("EMPLOYEE_ID"),
						results.getString("EMPLOYEE_NAME"), 
						results.getString("REIMBURSEMENT_NUMBER"),
						results.getString("REIMBURSEMENT_STATUS"),
						results.getString("REIMBURSEMENT_AMOUNT"),
						results.getString("MANAGED_BY")));
			}
			return getPend;
			}catch(SQLException e) {
				e.getStackTrace();
			}
		return null;
	}
	
	
	@Override
	public List<Reimbursements> getOneReimbursement(Reimbursements reimbursement) {
				System.out.println(reimbursement.getId());
		try (Connection conn = JDBCconnectionUtil.getConnection()) {
			System.out.println("in EmployeeDao.getOneReimbursement");	
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIMBURSEMENT_STATUS = 'PENDING' AND EMPLOYEE_ID = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, reimbursement.getId());
			List<Reimbursements> getRmb = new ArrayList<>();
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				getRmb.add(new Reimbursements(
						results.getString("EMPLOYEE_ID"),
						results.getString("EMPLOYEE_NAME"), 
						results.getString("REIMBURSEMENT_NUMBER"),
						results.getString("REIMBURSEMENT_STATUS"),
						results.getString("REIMBURSEMENT_AMOUNT"),
						results.getString("MANAGED_BY")));
			}
			System.out.println("Returning getRmb");
			System.out.println(getRmb);
			return getRmb; 
			}catch(SQLException e) {
				e.getStackTrace();
			}
		return null;
	}
	
}
