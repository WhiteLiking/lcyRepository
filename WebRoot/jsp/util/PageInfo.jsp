<%@ page language="java" import="java.util.*,com.vo.Category,com.connect.util.PageInfo" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'PageInfo.jsp' starting page</title>
    
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
		    width:60%;
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
	
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		function isdelete(){
			var $id = $("#btn").html();
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
			  PageInfo info = (PageInfo)session.getAttribute("Info");
		        if(info==null){
		        	info = new PageInfo();
		        }
       
			List<Category> listCategory = (List<Category>)session.getAttribute("listCategory");
			for(int i=0;i<listCategory.size();i++){
				String ground  = "";
				if(listCategory.get(i).getGround()==0){
					ground = "已下架";
				}else{
					ground = "已上架";
				}
			%>
			<tr>
				<td id="btn"><%= listCategory.get(i).getCid()%></td>
				<td><%= listCategory.get(i).getCname() %></td>
				<td><%= listCategory.get(i).getCdec() %></td>
				<td><%= listCategory.get(i).getPrice() %></td>
				<td><%= listCategory.get(i).getVersion() %></td>
				<td><%= ground %></td>
				<td><%= listCategory.get(i).getQuantity() %></td>
				<td><a href="UseDao?target=updateOne&id=<%=listCategory.get(i).getCid()%>" target="myIframe">修改</a>
				/<a  href="UseDao?target=upGround&id=<%=listCategory.get(i).getCid()%>&currentPage=<%=info.getCurrentPage() %>" target="myIframe">上架</a>
				<a href="UseDao?target=downGround&id=<%=listCategory.get(i).getCid()%>&currentPage=<%=info.getCurrentPage() %>" target="myIframe">下架</a>
				/<input type="button" value="删除" onclick="deleteOK()" >
				</td>
			</tr>
			
			<% 
			}
			 %>
		</table>
       
        <a href="Info?target=info&cpage=<%=info.getCurrentPage()-1%>">上一页</a>
		/<a href="Info?target=info&cpage=<%=info.getCurrentPage()+1 %>">下一页</a>
		当前页<%=info.getCurrentPage() %>/总页<%=info.getTotalPage() %>
		<a href="Info?target=info&cpage=1">首页</a> <a href="Info?target=info&cpage=<%=info.getTotalPage() %>">尾页</a>
		<form action="Info?target=info" method="post"style="position: relative;left:300px;top:-20px">
		搜索页数<input type="text" name="cpage"style="width:40px">
		<input type="submit" value="搜索">
		</form>
		
		<% session.setAttribute("Info", info); %>
		<font color="red" id="tip"></font>
		
  </body>
</html>
