<%@ page language="java" import="java.util.*,com.vo.Category" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deletePage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		function isdelete(){
			var $id = $("#btn").val();
			//创建xmlHttpRequest对象，前面没有var，说明是全局变量
			xmlHttpRequest = new XMLHttpRequest();
			//设置回调函数，函数中没有括号
			xmlHttpRequest.onreadystatechange=callback;
			//设置xmlHttpRequest对象的参数以及请求头
			var url="UseDao?target=deleteOne";//请求的url
			xmlHttpRequest.open("post", url);
			//采用post方式请求需要设置请求头
			xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//发送HTTP请求
			var data = "id="+$id;
			xmlHttpRequest.send(data);
		}
			
		function callback(){
			if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
				//y异步调用返回的数据
				var data = xmlHttpRequest.responseText;
				if($.trim(data)=="true"){
					$("#tip").html("删除成功")
				}else{
				$("#tip").html("删除失败！")
				}
			}
		}
		function deleteOK(){
		//var flag = confirm("确定要删除吗？");
			if(confirm("确定要删除吗？")){
				isdelete();
			}else{
				alert("已取消删除！");
			}
		}
	</script>

  </head>
  
  <body>
  <fieldset style="width: 600px;">
		<legend>点击删除商品</legend>
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
				<input type="hidden" value="<%= listCategory.get(i).getCid() %>" id="btn">
				<td><input type="button" value="删除" onclick="deleteOK()" ></td>
			</tr>
			<% 
			}
			 %>
		</table>
		<font color="red" id="tip"></font>
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
