<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	body,a{margin: 0px;padding: 0px;border: 0px}
	#head{width: 100%;height: 200px;background-color: gray;}
	#foot{width: 100%;height: 100%;}
	#left{width: 300px;height: 100%;float: left;background-color: blue;}
	#left a{display: block;background-color: red;text-decoration: none;}

	#content{width: 1049px;height: 100%;float: left}
	
	</style>

  </head>
  
  <body>
	<div id = "head">欢迎你！${username }  </div>
	<div id = "foot">
		<div id = "left">
			<ul>
			    <c:forEach items="${menuList}" var="m2">
			        <c:if test="${m2.level==2}">
			            <li>
			                <span>${m2.name}</span>
			                <ul>
			                    <c:forEach items="${menuList}" var="m3">
			                        <c:if test="${m3.parentid==m2.mid}">
			                            <li><a href="<%=basePath%>${m3.url}" target="info">${m3.name}</a></li>
			                        
			                        </c:if>			                    		                    
			                    </c:forEach>			                
			                </ul>
			            </li>			        
			        </c:if>
			    
			    </c:forEach>
			</ul>
		</div>
		<div id = "content" >
			<iframe name = "info" scrolling="auto" width="900px" height="500px"></iframe>
		</div>
	</div>

  </body>
</html>
