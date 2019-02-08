package com.revature.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.utils.JDBCconnectionUtil;

public class DataSource {

		private static DataSource instance = new DataSource();
		private final List<Employee> employees = new ArrayList<>();
		
		private DataSource() {
			
			
		}
		
		public static DataSource getInstance() {
			
				if (instance == null) {
					instance = new DataSource();
			}
			return instance;
		}
		
		
		public List<Employee> getEmployeeTable() {
			
			try (Connection conn = JDBCconnectionUtil.getConnection()) {
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
	
		return null;
		}
}
