<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
        <p style="color:#c00;">${msg }</p>
        <form action="<%=basePath%>addMenu.do" method="post">
            <input type="hidden" name="methodName" value="addMenu"/>
            <table>
                <tr>
                    <td><label for="name">菜单名称:</label></td>
                    <td><input type="text" name="name" id="name"/></td>
                </tr>  
                <tr>
                    <td><label for="url">地址:</label></td>
                    <td><input type="text" name="url" id="url"/></td>
                </tr>  
                <tr>
                    <td><label>是否展示:</label></td>
                    <td>
                        <input type="radio" name="isshow" value="1"/>
                    <input type="radio" name="isshow" value="2"/> 
                    </td>
                </tr>              
            </table>
        </form>         
  </body>
</html>
