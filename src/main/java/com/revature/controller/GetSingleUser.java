package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImp;
import com.revature.model.Employee;

public class GetSingleUser extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	private final ObjectMapper mapper = new ObjectMapper();

	EmployeeDaoImp edi = new EmployeeDaoImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// Get our session information
		HttpSession session = req.getSession();
		// Give a personalized response
		Employee user = (Employee) session.getAttribute("user");
		System.out.println(session.getAttribute("user"));
		String id = user.getId();
		try {
			edi.getEmployeeById(id);
			resp.setContentType("application/json");
			resp.getWriter().append(mapper.writeValueAsString(edi.getEmployeeById(id)));
		}
			catch(SQLException e) {
			e.getStackTrace();
			}
	}
}
