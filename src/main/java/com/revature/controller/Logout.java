package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		
		try {
			rd.forward(req, resp);
			req.getSession().invalidate();
		} catch (ServletException e) {
			System.out.println("forward failed to reach page");
			e.printStackTrace();
		}
	}
}
