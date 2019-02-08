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

public class GetReimbursementServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();

	EmployeeDaoImp edi = new EmployeeDaoImp();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in getRmbSrvltforSingle");
		HttpSession session = req.getSession();
		// Give a personalized response
		Employee user = (Employee) session.getAttribute("user");
		String id = user.getId();
		System.out.println(id);
		//edi.getReimbursements(id);
		resp.setContentType("application/json");
		resp.getWriter().append(mapper.writeValueAsString(edi.getReimbursements(id)));
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
