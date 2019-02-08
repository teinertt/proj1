package com.revature.delegate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;
import com.revature.service.LoginService;
import com.revature.service.LoginServiceImp;

public class LoginDelegate {
	public LoginServiceImp ls = new LoginServiceImp();
		
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Employee user = ls.attemptAuthentication(username, password);
		if(user == null) {
			System.out.println("login == null");
			resp.sendRedirect("login"); 
		} else {
			
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			
			if(user.getTitle().equals("Manager")) {
				System.out.println("Going to " + user.getTitle() + " page");
				RequestDispatcher rd = req.getRequestDispatcher("/manager_page.html");
				try {
					System.out.println("in try of requestDispatcher in manager LoginDelegate ");
					rd.forward(req, resp);
				} catch (ServletException e) {
					System.out.println("forward failed to reach page");
					e.printStackTrace();
				}
			}else {
				System.out.println("Going to " + user.getTitle() + " page");
				RequestDispatcher rd = req.getRequestDispatcher("/employee_page.html");
				try {
					System.out.println("in try of requestDispatcher in employee logindelegate");
					rd.forward(req, resp);
				} catch (ServletException e) {
					System.out.println("forward failed to reach page");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null) {
			req.getRequestDispatcher("static/login.html").forward(req,resp);
		} else {
			resp.sendRedirect("home");
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().invalidate();
		resp.sendRedirect("login");
	}
}