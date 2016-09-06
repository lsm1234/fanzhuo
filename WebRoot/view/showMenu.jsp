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
    
    <title>My JSP 'showMenu.jsp' starting page</title>
    
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
    $(function(){
        $('#dg').datagrid({
            url:'showMenus.do?methodName=showMenus&pageNo=1&pageSize=10',
            frozenColumns:[[{field:'hh',checkbox:true}]],
            rownumbers:true,
            striped:true,
            pagination:true,
            columns:[[
                {field:'mid',hidden:true},    
			    {field:'name',title:'菜单名称',width:100,align:'center'},    
			    {field:'url',title:'菜单URL',width:300,align:'center'},    
			    {field:'isshow',title:'首页是否展示',width:100,align:'center'}, 
                {field:'level',title:'菜单级别',width:100,align:'center'},
                {field:'parentName',title:'父级菜单',width:100,align:'center'},
            ]]
        });
        var pager = $('#dg').datagrid("getPager");
        pager.pagination({
            onSelectPage:function(pageNumber,pageSize){
                $('#dg').datagrid('loading');
                $.post("showMenus.do",{
                    methodName:'showMenus',
                    pageNo:pageNumber,
                    pageSize:pageSize
                },function(data){
                    $("#dg").datagrid("loadData",{
                        rows:data.rows,
                        total:data.total
                    });
                },"json");
                $('#dg').datagrid('loaded');
            }
        });      
    });
    </script>
  </head>
  
  <body>
      <table id="dg"></table> 
  </body>
</html>
