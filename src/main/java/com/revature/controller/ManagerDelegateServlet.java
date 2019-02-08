package com.revature.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.delegate.LoginDelegate;
import com.revature.model.Employee;

public class ManagerDelegateServlet extends HttpServlet{

		private static final long serialVersionUID = 1L;
		
		
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			
				// Get our session information
				HttpSession session = req.getSession();
				// Give a personalized response
				Employee user = (Employee) session.getAttribute("user");
				System.out.println(user);
				System.out.println("in manager delegate servlet");
					if (user == null) {
						resp.sendRedirect("login");
					} else {
						System.out.println("fubar");
						RequestDispatcher rd = req.getRequestDispatcher("/manager_page.html");
						try {
							rd.forward(req, resp);
						} catch (ServletException e) {
							System.out.println("forward failed to reach page");
							e.printStackTrace();
						}
					}
					
					System.out.println("leaving manager delegate servlet");
		}
}
