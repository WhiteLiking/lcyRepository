<%@ page language="java" import="java.util.*,com.vo.Category"  pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
 	<% 
 		List<Category> listCategory = (List<Category>)request.getAttribute("listCategory");
 		for(int i=0;i<listCategory.size();i++){
 	 %>
 	 <img alt="" src="<%=listCategory.get(i).getPsPath() %>">
 	 <font><%=listCategory.get(i).getCdec() %></font>
 	
 	 <%} %>>
  </body>
</html>
