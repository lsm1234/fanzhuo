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
import javax.servlet.http.HttpSession;

import com.web.entity.User;
import com.web.model.UserModel;
import com.web.model.impl.UserModelMySQLImpl;
import com.web.util.DBUtil;

public class LoginServerlt extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("utf-8");
		String username = req.getParameter("userName");
		String password = req.getParameter("passWord");
		
		String sql1 = "select * from person where number = ?  ";
		Object[]m1={ username};
		List<Object[]> list1 = DBUtil.DQL(sql1,m1);
		
		Object[]m2={ username, password };
		String sql2 = "select * from person where number = ? and password =? ";
		List<Object[]> list2 = DBUtil.DQL(sql2,m2);
	
		if(list1.size()==0){
			req.setAttribute("usernameInexist", "对不起哈，此账号不存在哦！");
			req.getRequestDispatcher("view/index.jsp").forward(req, resp);
		}else if(list2.size()==0){
			req.setAttribute("passwordError", "密码错误！");
			req.getRequestDispatcher("view/index.jsp").forward(req, resp);
		}else {
			User longinUser = new User(username, password, (String)(list2.get(0)[3]));
		     //建立session对象 获取用户的数据
			 HttpSession session = req.getSession();
		        session.setAttribute("longinUser", longinUser);
		     //请求派发
			req.getRequestDispatcher("view/Welcom.jsp").forward(req, resp);		
		}
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
