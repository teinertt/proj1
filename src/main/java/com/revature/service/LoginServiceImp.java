package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.JDBCconnectionUtil;
import com.revature.data.DataSource;
import com.revature.model.Employee;

public class LoginServiceImp implements LoginService{

	private final DataSource dataSource = DataSource.getInstance();

	@Override
	public Employee attemptAuthentication(String username, String password) {
		for (Employee employee : dataSource.getEmployeeTable()) {
			if (employee.getUserName().equals(username) && getPassword(username, password).equals(password)) {	
				return employee;	
			}
		}
		return null;
	}
	

	private String getPassword(String username, String password) {
		try (Connection conn = JDBCconnectionUtil.getConnection())  {
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_USERNAME = (?) AND EMPLOYEE_PASSWORD = (?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);	
			ResultSet rs = ps.executeQuery();
			
				if (rs.next()) {
					return rs.getString("EMPLOYEE_PASSWORD");
				} 
				else {
					System.out.println("Failed to validate");
				}
		}
			catch (SQLException e) {
			
			}

		return null;
	}
}
