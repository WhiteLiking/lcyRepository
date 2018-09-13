<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	<style type="text/css">
	  /* 页面首部 */
	  *{
				
				margin: 0px;
				padding: 0px;
			}
			body{
				background-color: #FFFFFF;
				
			}
			.header_container{
			
			}
			#logo{
				
				width: 960px;
				margin: 0px auto;
			/*	background-color: gainsboro;*/
				height: 100px;
				
			}
			#home{
				display: block;
				line-height: 85px;
				height: 85px;
				width: 360px;
				float: left;
			}
   .head_loge_box
   {
   	float:right;
   	padding-top: 20px;
   	width: ;
   	
   }
   
   .head_loge_box a{
   	display: block;
   	width: 110px;
   	height: 34px;
   	margin-right: 34px;
   	float: left;
   	
   	
   }
   .top_link1{
   	background: url(img/header_corn_new_v2.png);;
   	background-position-x: 0px;
   	background-position-y: 1px;
   	
   }
   
   .top_link2{
   	background: url(img/header_corn_new_v2.png);;
   	background-position-x: 0px;
   	background-position-y: -31px;
   }
   
   .top_link3{
   	background: url(img/header_corn_new_v2.png);;
   	background-position-x: 0px;
   	background-position-y: -62px;
   	
   }
   /*  页面身体*/								
			#body{
				height: 350px;
				color: #555555;
			}
			#shibai{
				margin-left: 350px;
				font-size: small;
			}
			#imgsuse{
				width: 250px;
				height: 250px;
			}
			b{
				margin-bottom: 180px;
			}
	/*页面尾部  */
	  #footer_container {
	padding-top: 500px;
	
	overflow: hidden;
	border-top: 1px solid #ccc;
	background: #fff;
	font-family: "微软雅黑",tahoma,arial,’Hiragino Sans GB',’\5b8b\4f53',sans-serif;
	position: relative;
	bottom: -1px;
}
.footer_white #footer_copyright {
	background: #fff;
	color: #868484;
	text-align: center;
	font-weight: 300;
}
#footer_copyright {
	background: url(../images/newindex_footer_bg.png) #404040 center top repeat-x;
	line-height: 20px;
	padding-bottom: 80px;
	color: #ccc;
}
#footer_copyright {
	line-height: 20px;
	padding-bottom: 20px;
	
}.footer_con {
	width: 1090px;
	margin: 0 auto;
	overflow: hidden;
}.footer_white #footer_copyright {

	text-align: center;
}.footer_white #footer_copyright {
	
	text-align: center;
}#footer_copyright {
	line-height: 20px;
	
}.footer_white #footer_copyright a {
	color: #000;
}#footer_copyright .logo01, #footer_copyright .logo03, #footer_copyright .logo04 {
	cursor: default;
}#footer_copyright .footer_copy_logo {
	width: 126px;
	height: 50px;
	overflow: hidden;
	display: inline-block;
	margin-right: 8px;
	background: url(img/footer_btm_icon.png) no-repeat;
	
}.footer_white .footer_copy_logo {
	border-bottom: 1px solid #d7d7d7;
}
#footer_copyright .logo01 {
	/*background-position: 0 -168px;*/
}
#footer_copyright .logo02 {
	background-position: -128px;
}
#footer_copyright .logo03 {
	background-position:-251px;
}
#footer_copyright .logo04 {
	background-position:-378px;
}
#footer_copyright .logo04 {
	background-position:-507px;
}
.textbox_ui input {
	-webkit-box-shadow: none;
	box-shadow: none;
	border: 1px solid #CFCFCF;
	background-color: #fff;
	vertical-align: middle;
	padding: 10px 30px;
	line-height: 1.5;
	font-size: 14px;
	outline: 0;
	height: auto;
	width: 284px;
}
 .textbox_ui {
	margin-bottom: 26px;
}
 .dynamic1 {
	background-image: url(img/sign.png);
	background-repeat: no-repeat;
	
}
 .dynamic2 {
	background-image: url(img/sign.png);
	background-repeat: no-repeat;
	background-position-x:0px;
	background-position-y:-50px;
}
input[type="reset"], input[type="submit"], input[type="submit"] {
	border: 1px solid #F9477A;
	display: inline-block;
	font-family: inherit;
	word-break: keep-all;
	background: #F8296D;
	white-space: nowrap;
	font-weight: 400;
	text-align: center;
	line-height: 40px;
	font-weight: 700;
	font-size: 14px;
	cursor: pointer;
	padding: 0 30px;
	height: 40px;
	color: #fff;
	border: 0;
}
.iconAccout a {
	text-indent: -9999px;
	background-image: url(img/icon_light.jpg);
	background-repeat: no-repeat;
	display: inline-block;
	width: 43px;
	height: 43px;
	margin-right: 12px;
	float: left;
}
.iconAccout .a1 {
	background-position: 0 0;
}
.iconAccout .a2 {
	background-position: -57px 0;
}
.iconAccout .a3 {
	background-position: -114px 0;
}.iconAccout .a4 {
	background-position: -169px 0;
}
.iconAccout .a5 {
	background-position: -224px 0;
}

p{
	padding-bottom: 28px;
}
.iconAccout{
	padding-top: 28px;
}
		</style> 
  </head>
  <body>
     <%@ include file="/WEB-INF/JMhead.jsp" %>
		<div id="body">
			<div id="shibai">
		
				<c:choose>
				  <c:when test="${msg eq 1}">
				   <img src="img/sosec.jpg" id="imgsuse"/><b>恭喜您注册成功，请留意您的邮箱进行激活</b>
				  </c:when>
				  <c:when test="${msg eq 2}">
				    <img src="img/shibai.jpg"/><b>激活失败，请重新激活！</b>
				  </c:when>
				  <c:otherwise >
				    <img src="img/denglushibai.jpg"  style="width:320px;height:250px;"/><b>注册失败，请返回重新<a href="UserServlet?action=registUI" style="color: red;">注册</a></b>
				  </c:otherwise>
				</c:choose>
			</div>
		</div>	
 		<%@ include file="/WEB-INF/JMend.jsp" %>
  </body>
</html>
