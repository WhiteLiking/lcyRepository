<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testAjax.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		function isExist(){
			var $mobie = $("#bie").val();
			if($mobie==null||$mobie.length!=11){
				$("#tip").html("请正确输入")
			}else{
				//创建xmlHttpRequest对象，前面没有var，说明是全局变量
				xmlHttpRequest = new XMLHttpRequest();
				//设置回调函数，函数中没有括号
				xmlHttpRequest.onreadystatechange=callback;
				//设置xmlHttpRequest对象的参数以及请求头
				var url="TestServlet";//请求的url
				xmlHttpRequest.open("post", url);
				//采用post方式请求需要设置请求头
				xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				//发送HTTP请求
				var data = "moble="+$mobie;
				xmlHttpRequest.send(data);
			}
			
			function callback(){
				if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
					//y异步调用返回的数据
					var data = xmlHttpRequest.responseText;
					if($.trim(data)=="true"){
						$("#tip").html("已存在")
					}else{
					$("#tip").html("成功！")
					}
				}
			}
		}
	</script>

  </head>
  
  <body>
    
    	<input type="text" id="bie">
    	<font color="red" id="tip"></font>
    	<input type="button" value="提交" onclick="isExist()">
   
  </body>
</html>
