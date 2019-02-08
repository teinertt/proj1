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

public class GetPendingReimbursements extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();

	EmployeeDaoImp edi = new EmployeeDaoImp();
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			Employee user = (Employee) session.getAttribute("user");
			if (user == null) {
				System.out.println("user == null");
				resp.sendRedirect("/index.jps");
			} 
			else {
				System.out.println("in ELSE of GetPendingReimbursements");
			resp.setContentType("application/json");
			resp.getWriter().append(mapper.writeValueAsString(edi.getPendingRmbs()));
				
			}
			System.out.println("leaving getRmbservlet");
	
		}
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
}
