<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			/*头部*/	
		  .top-1{
			position: relative;
			height: 32px;
			line-height: 32px;
			color: #999999;
			width: 960px;
			margin: 0 auto;
		  }
		 .top-12{
		 	position: absolute;
			right: 0;
			top: 0;
		 }
		 .top-12 a{
		 	color: #9999;
		 	text-decoration: none;
		 }
		 .top-12 a:hover{
		 	color: red;
		 }
		 .tips{
		 	font-style: normal;
			color: #dddddd;
			padding: 0 5px;
		 }
		 .top-2{
		 	border-bottom: 2px solid #e5e5e5;
			box-shadow: 0px 1px 2px rgba(0,0,0,0.1);
			padding-bottom: 15px;
		 }
		 .top-21{
		 	width: 960px;
            margin: 0 auto;
		 }
		 
		 .return{
		 width: 100px;
		 height: 40px;
		 background: deeppink;
		 border: 1px solid deeppink;
		 color: white;
		 text-decoration: none;
		 position: relative;
		 left: 80px;
		 color:18px;
		
		 }
		 .return:hover{
		 	color:white;
		 	background: pink;
		 }

		  .li1{
		     float: left;
		     font-size: large;
		     list-style: none;
		  }
		  .li1 a{
		    color: red;
		    padding-right: 10px;
		  }
 
		</style>
	</head>
	<body>
		<div style="background: white;height: 100px;">
			<div class="top-1">
				<div class="top-12">
				<div >
					<c:if test="${empty loginUser}">
		   	 	 	<li class="li1"><a href="UserServlet?action=loginUI" >你好，请登录 </a></li>
			        <li class="li1"><a href="UserServlet?action=registUI"  style="">免费注册 </a></li>
			    </c:if>
		   	 	  <c:if test="${not empty loginUser}"> 
			        <li class="li1"><a>欢迎您${loginUser.username}</a></li>  
			       <li class="li1"><a href="UserServlet?action=logOut" style="">退出 </a></li>
			     </c:if>
					</div>
					
				</div>
				
			</div>
			<div class="top-2">
				<div class="top-21">
					<img src="img1/20180829215142.png"/>
				</div>
			</div>
		<div class="success" style="font-size: 28px;">
			<p>恭喜你，支付成功!</p>
			<p style="position: relative;left: 30px;">是否返回首页？</p>
			<a href="HeadMainServlet?target=returnMainPage" class="return">返回</a>
		</div>
	</body>

  </head>
  
  <body>
   
  </body>
</html>
