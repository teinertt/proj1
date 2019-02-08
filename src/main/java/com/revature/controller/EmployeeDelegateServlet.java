package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;

public class EmployeeDelegateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// Get our session information
		HttpSession session = req.getSession();
		// Give a personalized response
		Employee user = (Employee) session.getAttribute("user");
		System.out.println("in employee delegate servlet");
		if (user == null) {
			resp.sendRedirect("/index.jps");
		} else {
			//need something here  --  send to employee page
		}
		System.out.println("leaving employee delegate servlet");
	}
	
}
