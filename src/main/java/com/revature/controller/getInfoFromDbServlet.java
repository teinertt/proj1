package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.MasterDispatcher;
import com.revature.dao.EmployeeDaoImp;
import com.revature.model.Employee;

public class getInfoFromDbServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();

	EmployeeDaoImp edi = new EmployeeDaoImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In getInfoServlet");
		// Get our session information
				HttpSession session = req.getSession();
				// Give a personalized response
				Employee user = (Employee) session.getAttribute("user");
				System.out.println();
				if (user == null) {
					System.out.println("user == null");
					RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
					try {
						rd.forward(req, resp);
						req.getSession().invalidate();
					} catch (ServletException e) {
						System.out.println("forward failed to reach page");
						e.printStackTrace();
					}
				} else {				
				edi.getAllEmployees();
				resp.setContentType("application/json");
				resp.getWriter().append(mapper.writeValueAsString(edi.getAllEmployees()));
					
				}
				System.out.println("leaving getinfoservlet");
		}
	
	
}
