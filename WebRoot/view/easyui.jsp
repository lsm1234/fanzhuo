<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath",basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'easyui.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	    function addTab(title,url){
      	    $("#t").tabs("add",{
      	        title:title,
      	        selected:true,
      	        closable:true,
      	        content:"<iframe style='width:100%;height:100%' src='"+url+"'></iframe>"   
			});
 		  }
	    	
	</script>
  </head>
  
  <body class="easyui-layout">
         
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>           
    <div data-options="region:'west',title:'West',split:true" style="width:100px;">
        <ul id="tt" class="easyui-tree">   
		    <!--<li>   
		        <span>网页</span>   		         
		        <ul>   
		            <li>   
		                <span><a href="javascript:addTab('百度','http://www.baidu.com');">百度</a></span>   
		            </li>   
		            <li>   
		                <span><a href="javascript:addTab('优酷','http://www.youku.com');">优酷</a></span>   
		            </li>   
		            <li>   
		                <span><a href="javascript:addTab('爱奇艺','http://www.iqiyi.com');">爱奇艺</a></span>   
		            </li>   
		        </ul>   
		    </li> -->
		    <c:forEach items="${menuList}" var="m2">
			        <c:if test="${m2.level==2}">
			            <li>
			                <span>${m2.name}</span>
			                <ul>
			                    <c:forEach items="${menuList}" var="m3">
			                        <c:if test="${m3.parentid==m2.mid}">
			                            <li><a href="javascript:void(0);" onclick="addTab('${m3.name}','${basePath}${m3.url}');">${m3.name}</a></li>			                        
			                        </c:if>			                    		                    
			                    </c:forEach>			                
			                </ul>
			            </li>			        
			        </c:if>			    
			    </c:forEach>		      		            
		</ul>  	        
    </div>   
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
    	<div id="t" class="easyui-tabs"style="width:500px;height:250px;" data-options="fit:true"></div>   			
    </div>       
  </body>
</html>
