package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface EmployeeService {

		Object process(HttpServletRequest request, HttpServletResponse response);
}
