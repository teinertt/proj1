package com.revature;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Employee;
import com.revature.service.LoginService;
import com.revature.service.LoginServiceImp;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final LoginService service = new LoginServiceImp();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");
		System.out.println("in loginServlet");
		Employee attempting = service.attemptAuthentication(username, password);
		
		if (attempting != null) {
			req.getSession().setAttribute("name", attempting.getName());
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
	}
}
