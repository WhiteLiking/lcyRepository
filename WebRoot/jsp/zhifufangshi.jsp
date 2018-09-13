<%@ page language="java" import="java.util.*,com.vo.ShopCar" pageEncoding="utf-8"%>
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
		<title>支付方式</title>
		<link href="css/weipay01.css" type="text/css" rel="stylesheet">
    	<link href="css/scanPay.css" type="text/css" rel="stylesheet">
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
		 
		 
		  /*底部*/
		  #footer_textarea{
			overflow: hidden;
			width: 100%;
			margin-top: 0;
			border-top: 1px solid #ddd;
			font-size: 12px;
			background: #FAFAFA;
		  }
		   #footer_copyright{
		  	text-align: center;
			line-height: 20px;
			padding-bottom: 20px;
			color: #000;
		  }
		  .footer_con{
		  	width: 960px;
			margin: 0 auto;
			overflow: hidden;
		  }
		  .footer_copy_con{
		  	padding: 10px 0;
		  }
		 .footer_copy_con a{
		 	color: black;
		 	text-decoration: none;
		 }
		 
		 /*支付*/
		.cart{	
			font-size: 18px;
			font-family: 'Microsoft YaHei', serif;
			width: 960px;
			height: 630px;
			background:white;
			margin-top: 100px;
			margin-left: 200px;
			margin-bottom: 30px;
			
		}
		.left{
			width: 360px;
			height: 500px;
			background: white;
			margin-left: 80px;
			position: relative;
			top:50px;	
			float: left;		
		}
		.left-box{
			width: 360px;
			height: 360px;
			background: white;
			border: 1px solid black;
			
		}
		
		.left-down{
			margin-left: 30px;
			
		}
		.price{
			color: deeppink;
		}
		.fanshi{
			font-size: 18px;
			margin-left: 200px;
		}
		.fanshi:hover{
			color: red;
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
		<div style="background: white;height: 60px;">
			<div class="top-1">
				<div class="top-12">
					<div >
				<c:if test="${empty loginUser}">
		   	 	 <a href="UserServlet?action=loginUI" >你好，请登录 </a>
			     <a href="UserServlet?action=registUI"  style="">免费注册 </a>
			    </c:if>
		   	 	  <c:if test="${not empty loginUser}"> 
			     <a>欢迎您${loginUser.username}</a>
			     <a href="UserServlet?action=logOut" style="">退出 </a>
			     </c:if>
					</div>
					
				</div>
				
			</div>
			<div class="top-2">
				<div class="top-21">
					<img src="img1/20180829215142.png"/>
				</div>
			</div>
		</div>
		
		<div class="cart">
			<div class="left">
				<div style="height: 30px;background: white;text-align: center;">微信支付</div>
				<div class="left-box">
					<!--
            
                    	<img src="img1/11.png"style="width:300px;height:300px;position: relative;top:30px;left: 30px;"/>*/
                    -->
					<div id="qr"style="position: relative;left:-110px;top:20px" >
					
						<div id="QRcode">
						</div>
						<div id="pay_phone">
							
						</div>
						
					</div>
					
				</div>
				<div class="left-down">
					<img src="img1/weixin-scan-icon.png"style="float: left;height: 80px;margin-top: 10px;margin-right: 10px;"/>
					<div style="float: left;color: deeppink;position: relative;top:20px;">
						<p>请使用微信"扫一扫"</p>
						<p>扫描二维码支付</p>
					</div>
					
				</div>
		<% List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			int allPrice = 0;
			for(int i=0;i<shopCar.size();i++){
				allPrice = allPrice+(shopCar.get(i).getPrice()*shopCar.get(i).getQuantity());
			}
			
			 %>
			</div>
			<div class="right"style="float: left;margin-left: 20px;margin-top: 80px;">
				<img src="img1/phone-bg.png"/>
			</div>
			
			  <div style="height: 30px;width: 960px;font-size: 18px;position: relative;top:580px;left:-500px;">
			  	应付金额：
				<span class="price">¥ <%=allPrice %>.00</span>	
			</div>
			
		</div>
		<a class="fanshi">>>请选择其他支付方式</a>
		
		
       <div id="footer_textarea">
        <div class="footer_con" id="footer_copyright">
            <p class="footer_copy_con">
                © 2013 北京创锐文化传媒有限公司 Jumei.com 保留一切权利。客服热线：400-123-8888 <br>
                    京公网安备 11010102001226 | <a href="#" target="_blank" rel="nofollow">京ICP证111033号</a> | <a href="#" target="_blank" rel="nofollow">食品流通许可证 SP1101051110165515（1-1）</a>
                | <a href="#" target="_blank">营业执照</a>
            </p>
            <p>
            	<img src="img1/20180826215518.png"/>
              
            </p>
        </div>
		</div>
		
		 <script src="js/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
	    <script type="text/javascript">
	    	$(function(){
	    		$("#tip1").hover(function(){
					$("#tip_content").css("display","block");
				},function(){
					$("#tip_content").css("display","none");
				})
				
				//生成二维码
				$("#QRcode").qrcode({
					render : "canvas",//也可以替换为table
					width : 320,
					height : 320,
					text : "helloWord" //二维码内置内容，如果时URL形式一般浏览器会自动加载
				})
				
				$("#QRcode").mouseover(function(){
					$("#pay_phone").css("display","block");
				})
				$("#qr").mouseout(function(){
					$("#pay_phone").css("display","none");
				})
				
	    	});
	    	
	    	//10秒后跳转到支付成功页面
	    	function change(){
	    		setTimeout(function(){
	    			location.assign("jsp/paySuccess.jsp");
 				},10000)}
	    	
	    	change();
 			
 			
	    		
	</script>
	</body>
   
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
