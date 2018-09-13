<%@ page language="java" import="java.util.*,com.vo.Category" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePage.jsp' starting page</title>
    
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
    <fieldset style="width: 600px;">
		<legend>点击修改商品</legend>
   		<table id="Table" frame="border" rules="all">
			<tr>
				
				<th>商品编号</th>
				<th>商品名称</th>
				<th>商品描述</th>
				<th>商品单价</th>
				<th>商品型号</th>
				<th>是否上架</th>
				<th>库存量</th>
				<th>操作<th>
			</tr>
			<%
			List<Category> listCategory = (List<Category>)request.getAttribute("listCategory");
			for(int i=0;i<listCategory.size();i++){
			%>
			<tr>
				<td><%= listCategory.get(i).getCid() %></td>
				<td><%= listCategory.get(i).getCname() %></td>
				<td><%= listCategory.get(i).getCdec() %></td>
				<td><%= listCategory.get(i).getPrice() %></td>
				<td><%= listCategory.get(i).getVersion() %></td>
				<td><%= listCategory.get(i).getGround() %></td>
				<td><%= listCategory.get(i).getQuantity() %></td>
				<td><a href="UseDao?target=updateOne&id=<%=listCategory.get(i).getCid()%>" target="myIframe">修改</a></td>
			</tr>
			<% 
			}
			 %>
		</table>
		</fieldset>
		<% 
		if(listCategory.size()==0){
			%>
			<b><%="根据该条件未找到任何商品！" %></b>
			<% 	
			}
			%>
  </body>
</html>
