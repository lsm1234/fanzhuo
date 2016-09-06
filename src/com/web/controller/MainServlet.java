package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.entity.User;
import com.web.model.UserModel;
import com.web.model.impl.UserModelMySQLImpl;
import com.web.util.DBUtil;

public class MainServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		//接收所有请求
		req.setCharacterEncoding("utf-8");
		String methodName = req.getParameter("methodName");
		Class c = MainServlet.class;	
		try {
			Method m = c.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this,req,resp);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void login(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {	
		//控制层持有一个模型层对象
		UserModel userModel = new UserModelMySQLImpl();
		//取出表单数据
		String userName = req.getParameter("number");
		String userPass = req.getParameter("passWord");
		System.out.println("LoginServlet控制层");	
		User user = userModel.loadUserByName(userName);
		//利用上面的查询判断，并给出不同提示
		if(user !=null ){
			if(userPass.equals(user.getPassword())){
				//密码正确，登录 查询菜单
				List<Menu> menuList = userModel.loadMenusByUid(user.getUid());
				req.getSession().setAttribute("menuList", menuList);
				//用户存在
				HttpSession session=req.getSession();
				session.setAttribute("LoginUser", user);
			}else{
				req.setAttribute("name", "密码错误");
				req.getRequestDispatcher("view/MyJsp.jsp").forward(req, resp);
			}
//			String sql1 = "select * from biaodan where pass=?";
//			List<Object[]> list1 = DBUtil.DQL(sql1, new Object[]{userPass});
//			
//			if(list1.size()<1){
//			req.setAttribute("name", "密码错误");
//			req.getRequestDispatcher("view/index.jsp").forward(req, resp);
//			return;
//			}
//			
//			String sql2 = "select * from biaodan where name=?  and pass=?";
//			List<Object[]> list2 = DBUtil.DQL(sql2, new Object[]{userName,userPass});
//			if(list2.size()>0){
//				req.getSession().setAttribute("names", userName);
//				
//				req.getRequestDispatcher("view/Welcome.jsp").forward(req, resp);
//			}
			
		}else{
			req.setAttribute("name", "账号错误");
			req.getRequestDispatcher("view/MyJsp.jsp").forward(req, resp);
		}
	}
	public void testAJAX(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {	
		System.out.println("AJAX请求来了");
		
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write("{\"address\":\"重庆\"}");
		resp.getWriter().flush();
	}
	


	
}











