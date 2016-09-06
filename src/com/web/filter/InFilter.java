package com.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

public class InFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("拜拜");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {		
		// TODO Auto-generated method stub
		System.out.println("过滤了");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		
		
		User user = (User)req.getSession().getAttribute("loginUser");

		if(null == user ){
			System.out.println("哈哈");
			req.getSession().setAttribute("regError", "对不起，你还没有登陆哦！");
			PrintWriter out = rep.getWriter();
			out.write("<script type = 'text/javascript'>window.top.location.href='index.jsp';</script> ");
		}else{
			chain.doFilter(req, rep);
		}

		
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化了");
	}

}
