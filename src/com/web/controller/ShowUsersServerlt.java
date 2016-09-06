package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.util.DBUtil;



public class ShowUsersServerlt extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String sql = "select*from tb_user";
		List<Object[]>list = DBUtil.DQL(sql, null);
//		User user = new User();
		
		req.setAttribute("userinfo", list);	
//		resp.sendRedirect("show.jsp");
		req.getRequestDispatcher("view/welcom.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
		
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}


	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}


	@Override
	public void init(ServletConfig config) throws ServletException {
//		Enumeration<String > hh = config.getInitParameterNames();
		super.init(config);
	}


	
	
	
	
}
