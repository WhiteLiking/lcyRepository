<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deleteProduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="styles.css">
	<style type="text/css">
	  	body {
				font: 14px/100% Arial, Verdana, "宋体";
				 
			}
		.shanchu{
		     font: 14px/100% Arial, Verdana, "宋体";
		     font-weight: bold;
		      padding:30px;
		      position: relative;
		     top: 20px;
				
		}
		.shanchu1{
		    position: relative;
		    top:50px;
		    left:100px;
		    border: 1px solid peachpuff;
		    line-height: 30px;
		     width:260px;
		}
		.tianjiao{
		  border: 1px solid peachpuff;
		  margin-bottom: 20px;
		  float:right;
		  text-align: 30px;
		  width: 100px;
		  height: 40px;
		  background: deeppink;
		  color:white;
		  font-size:16px;
		  position: relative;
		  right:80px;
		  top:180px;
		  cursor: pointer;

		}
		.tianjiao:hover{
		   background:white;
		   color:red;
		}
	
	</style>
	

  </head>
  
  <body>
        <fieldset style="width: 500px; border: 2px solid deeppink;height:350px">
		<legend>删除商品</legend>
          <form action="UseDao?target=deleteProduct" method="post" target="myIframe">
			<b class="shanchu">输入要删除的商品id/名称/描述/价格：</b><br />
			<input class="shanchu1" type="text" value="商品id/名称/描述/价格" id="in" name="dele"/>
			 <input class="tianjiao" type="submit" value="删除" />
		</form>
		</fieldset>
		
	<script type="text/javascript">
			var In;
			window.onload=function(){
				In = document.getElementById("in")
				In.onfocus = checkIn;
				In.onblur = checkOut;
			}
			function checkIn(){
				if(In.value=="商品id/名称/描述/价格"){
					In.value = "";
				}
			}
			function checkOut(){
				if(In.value==""){
					In.value = "商品id/名称/描述/价格";
				}
			}
		</script>
  </body>
</html>
