<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath",basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script  src="<%=basePath%>js/jquery-1.7.1.js" type="text/javascript"></script>
	<script type="text/javascript">
	    
	    $(function(){
	        $(".d").click(function(){
	            //方法1         
	            //$.ajax({                
	            //    url     : '<%=basePath%>testAJAX.do?methodName=testAJAX',
	            //    success : function(data){
	            //        alert(data);
	            //    }
	            // }); 
	            //方法2 
	            //$.get('${basePath}testAJAX.do',{methodName:'testAJAX'},function(data){
	            //   alert(data);
	            //},"text");
	            //方法3 
	            //$.getJSON('${basePath}testAJAX.do',{methodName:'testAJAX'},function(data){
	            //    alert(data.address);
	            //}); 
	            //方法4
	            $.post('${basePath}testAJAX.do',{methodName:'testAJAX'},function(o){
	                //将json格式的字符串转换为json对象
	                //var o = eval("("+data+")");    
	                alert(o.address);
	            },"json"); 
	                    
	        });
	    });
	      
	</script>

  </head>
  
  <body>    
      <input class="d" type="button" value="测试"/>
  </body>
</html>
