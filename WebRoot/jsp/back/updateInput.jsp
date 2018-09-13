<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateInput.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		function isUpdate(){
			
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
				var data = "flag=成功！";
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
		
	</script>

  </head>
  
  <body>
   <fieldset style="width: 500px;">
		<legend>修改商品</legend>
		<form action="UseDao?target=updateInputOver" method="post" enctype="multipart/form-data">
		
		<b>商品名称：</b><input type="text" value="输入名称" name="cname"/><br />
		<b>商品描述：</b><input type="text" value="输入描述" name="cdec"/><br />
		<b>商品单价：</b><input type="text" value="输入单价" name="price"/><br />
		<b>商品型号：</b><input type="text" value="输入型号" name="version"/><br />
		<b>是否上架：</b><input type="text" value="0-下架 /1-上架" name="ground"/><br />
		<b>库存数量：</b><input type="text" value="输入数量" name="quantity"/><br />
		<b>库存数量：</b><input type="file" name="ps"/><br />
		<input type="submit" value="确认修改" onclick="isUpdate()"/><font color="red" id="tip"></font>
		</form>
		</fieldset>
		<script type="text/javascript">
			var a ;
			window.onload=function(){
				a= document.getElementsByTagName("input")
				a[0].onfocus=checkIn0;
				a[0].onblur=checkOut0;
				a[1].onfocus=checkIn1;
				a[1].onblur=checkOut1;
				a[2].onfocus=checkIn2;
				a[2].onblur=checkOut2;
				a[3].onfocus=checkIn3;
				a[3].onblur=checkOut3;
				a[4].onfocus=checkIn4;
				a[4].onblur=checkOut4;
				a[5].onfocus=checkIn5;
				a[5].onblur=checkOut5;
			}

/************************************************************************/			
			function checkIn0(){
				if(a[0].value=="输入名称"){
					a[0].value="";
				}
			}
			function checkOut0(){
				if(a[0].value==""){
					a[0].value="输入名称";
				}
			}
/*************************************************************************/
			function checkIn1(){
				if(a[1].value=="输入描述"){
					a[1].value="";
				}
			}
			function checkOut1(){
				if(a[1].value==""){
					a[1].value="输入描述";
				}
			}
/*************************************************************************/
			function checkIn2(){
				if(a[2].value=="输入单价"){
					a[2].value="";
				}
			}
			function checkOut2(){
				if(a[2].value==""){
					a[2].value="输入单价";
				}
			}
/*************************************************************************/
			function checkIn3(){
				if(a[3].value=="输入型号"){
					a[3].value="";
				}
			}
			function checkOut3(){
				if(a[3].value==""){
					a[3].value="输入型号";
				}
			}
/**************************************************************************/
			function checkIn4(){
				if(a[4].value=="0-下架 /1-上架"){
					a[4].value="";
				}
			}
			function checkOut4(){
				if(a[4].value==""){
					a[4].value="0-下架 /1-上架";
				}
			}
/**************************************************************************/
				function checkIn5(){
				if(a[5].value=="输入数量"){
					a[5].value="";
				}
			}
			function checkOut5(){
				if(a[5].value==""){
					a[5].value="输入数量";
				}
			}
/**************************************************************************/
		</script>
  </body>
</html>
