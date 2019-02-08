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

public class SubmitReimbursementServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	EmployeeDaoImp edi = new EmployeeDaoImp();
	private final ObjectMapper mapper = new ObjectMapper();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			// Give a personalized response
			Employee user = (Employee) session.getAttribute("user");
			if (user == null) {
				System.out.println("user == null");
				resp.sendRedirect("/index.jps");
			} else {				
			resp.setContentType("application/json");
			Reimbursements reimbursement = mapper.readValue(req.getReader(), Reimbursements.class);
			System.out.println("reimbursement id" + reimbursement.getId());
			edi.submitReimbursement(reimbursement);
			}
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
}
