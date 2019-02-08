package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImp;
import com.revature.delegate.HomeDelegate;
import com.revature.delegate.LoginDelegate;

public class RequestHelper {
	private ManagerDelegateServlet mds = new ManagerDelegateServlet();
	private EmployeeDelegateServlet eds = new EmployeeDelegateServlet();
	private HomeDelegate hd = new HomeDelegate();
	private LoginDelegate ld = new LoginDelegate();
	private EmployeeDaoImp edi = new EmployeeDaoImp();
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String switchString = req.getRequestURI().substring(req.getContextPath().length()+1);
		while(switchString.indexOf("/")>0) {
			switchString = switchString.substring(0, switchString.indexOf("/"));
			
		}
		switch(switchString) {
		case "FrontController": ld.login(req, resp); break;
		case "home": hd.goHome(req, resp); break;
		case "login": if("POST".equals(req.getMethod())) {
			ld.login(req, resp);
		} else {
			ld.getPage(req, resp);
		} break;
		case "employeeDelegateServlet": eds.doGet(req, resp); break;
		case "managerDelegateServlet": mds.doGet(req, resp); break;
		case "logout": ld.logout(req, resp); break;
		//case "submitReimbursement": edi.submitReimbursement();
		default: System.out.println("defaults and breaks");break;
		}
	}
}
