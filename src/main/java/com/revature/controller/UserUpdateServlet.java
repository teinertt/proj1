package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImp;
import com.revature.model.Employee;
import com.revature.model.Reimbursements;

public class UserUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	EmployeeDaoImp edi = new EmployeeDaoImp();
	private final ObjectMapper mapper = new ObjectMapper();
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			// Give a personalized response
			Employee user = (Employee) session.getAttribute("user");
			System.out.println(user+ " " +"user");
			if (user == null) {
				System.out.println("user == null");
				resp.sendRedirect("/index.jps");
			} else {				
			resp.setContentType("application/json");
			Employee employee = mapper.readValue(req.getReader(), Employee.class);
			System.out.println("employee id" + employee.getId());
			edi.updateEmployee(employee);
			}
	}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
}
