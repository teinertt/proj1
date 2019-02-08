package com.revature;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.EmployeeService;
import com.revature.service.EmployeeServiceImp;
import com.revature.service.UserService;
import com.revature.service.UserServiceImp;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	// Command and Mediator Design Pattern
	
	private static final EmployeeService employeeService = new EmployeeServiceImp();
	private static final UserService userService = new UserServiceImp();
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		if (request.getRequestURI().contains("employees"))
			return employeeService.process(request, response);
		else if (request.getRequestURI().contains("users"))
			return userService.process(request, response);
		else 
			return "Not yet implemented";
	}
}
