package com.revature.service;

import com.revature.model.Employee;

public interface LoginService {
	
	Employee attemptAuthentication(String username, String password);
}
