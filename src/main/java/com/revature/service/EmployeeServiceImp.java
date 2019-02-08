package com.revature.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImp;
import com.revature.exception.EmployeeNotFoundException;
import com.revature.model.Employee;

public class EmployeeServiceImp implements EmployeeService{

	private final EmployeeDao dao = new EmployeeDaoImp();
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Object process(HttpServletRequest request, HttpServletResponse response) {
		if (request.getMethod().equals("GET")) {
			// GET ALL LOGIC
			String[] path = request.getRequestURI().split("/");
			if (path.length == 4) {		// execute if the request is /ServletExample/rest/todos
				return dao.getAllEmployees();
			}
			// GET ONE LOGIC
			if (path.length == 5) {		// execute if request looks like /ServletExamples/rest/todos/3
				try {
					String employeeId = String.valueOf(path[4]);
					try {
						return dao.getEmployeeById(employeeId);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NumberFormatException e) {
					return "Cannot convert " + path[4] + " into a number";
				} catch (EmployeeNotFoundException e) {
					return e.getMessage();
				}
			}
		}
		
		if (request.getMethod().equals("POST")) {
			// CREATE LOGIC
			if (request.getHeader("Content-Type").equals("application/json")) {
				try {
					Employee emp = mapper.readValue(request.getReader(), Employee.class);
					//return dao.createEmployee(emp);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				// 415 is an Unsupported Media Type
				response.sendError(415, "Please create using application/json");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
