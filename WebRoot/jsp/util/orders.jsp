<%@ page language="java" import="java.util.*,com.vo.Orders" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orders.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		    *{
	       text-decoration:none;
	    }
		    table {
		    width:70%;
		    background:#ccc;
		    margin: 0px none;
		     border-collapse:collapse;
		     position:relative
		     left:20px;
		     }
			 th, td {height:25px;line-height:25px;text-align:center;border:1px solid #ccc;}
			 th {background:deeppink;font-weight:normal;color:white}
			 tr {background:#fff;}
			 tr:hover {background:pink;}
			 td  {color:block;text-decoration:none;}
			  a:hover {color:#06f;text-decoration:underline;}
			  input{
			 	 background:#fff;
			 	 color:#06f;
			  } 
			 
</style>

  </head>
  
  <body>
 
    <table id="Table" frame="border" rules="all">
			<tr>
				
				<th style="width:80px">商品编号</th>
				<th style="width:80px">商品名称</th>
				<th style="width:80px">商品单价</th>
				<th style="width:80px">商品数量</th>
				<th style="width:80px">收件人</th>
				<th style="width:100px">电话</th>
				<th style="width:150px">收件地址</th>
				<th style="width:80px">用户名</th>
				<th style="width:150px">操作<th>
			</tr>
			<%   List<Orders> order = (List<Orders>)request.getAttribute("order");
 			for(int i=0;i<order.size();i++){
 			int oid = order.get(i).getOid();
 			String pname = order.get(i).getOname();
 			int price = order.get(i).getPrice();
 			int psum = order.get(i).getPsum();
 			String name = order.get(i).getName();
 			String telephone = order.get(i).getTelephone();
 			String address = order.get(i).getAderss();
 			String userno = order.get(i).getUserno();
 
  %>
			<tr>
				<td><%=oid %></td>
				<td><%=pname %></td>
				<td><%=price %></td>
				<td><%=psum %></td>
				<td><%=name %></td>
				<td><%=telephone %></td>
				<td><%=address %></td>
				<td><%=userno %></td>
				<td><a href="Info?target=updateOrderRequest&oid=<%=oid %>&userno=<%=userno %>" target="myIframe">修改</a>
				/<a href="Info?target=deleteOrders&oid=<%= oid%>">删除</a></td>
				
				</td>
			</tr>
	<%} %>
  </body>
</html>
