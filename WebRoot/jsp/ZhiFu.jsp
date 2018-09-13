<%@ page language="java" import="java.util.*,com.vo.Orders" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	 <base href="<%=basePath%>">
    <title>My JSP 'mainPage.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta charset="UTF-8">
		<title>支付页</title>
		<style type="text/css">
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
		  <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	  <script type="text/javascript">
  		 function payment(){
			alert("支付成功！");
		}
	</script>	
		
		
		
	</head>
	<body>
	<% List<Orders> order = (List<Orders>)session.getAttribute("productOrder");
		int allPrice = 0;
		String address = "";
		for(int i=0;i<order.size();i++){
			allPrice = allPrice+order.get(i).getPrice()*order.get(i).getPsum();
			address = order.get(i).getAderss();
		}
	
	%>
	
		<div style="background: white;height: 100px;">
			<div class="top-1">
				<div class="top-12">
					<div >
				<c:if test="${empty loginUser}">
		   	 	 	<li class="li1"><a href="UserServlet?action=loginUI" >你好，请登录 </a></li>
			        <li class="li1"><a href="UserServlet?action=registUI"  style="">免费注册 </a></li>
			    </c:if>
			    
		   	 	  <c:if test="${not empty loginUser}"> 
			        <li class="li1"><a>欢迎您 , ${loginUser.username}</a></li>  
			       <li class="li1"><a href="UserServlet?action=logOut" style="">退出 </a></li>
			     </c:if>
					</div>
					
				</div>
				
			</div>
			<div class="top-2">
				<div class="top-21">
					<img src="img1/20180829215142.png"/>
					<div class="top-22">
						
					</div>
				</div>
			</div>
			
		<div class="cart">
			<h2 class="title" >最后一步，请尽快付款！</h2>
			<div class="cart-1">
				<div class="f1">
					<span style="text-align: center;line-height: 64px;" >应付金额</span>
					<span class="price" >
					<span data-reactid=".0.0.2.0.1.0">¥</span>
					<span id="JS_pay_total_amount" ><%=allPrice%>.00</span>
					</span>
				</div>
				<div class="f2">
					<p class="address">收货信息：<%=address%></p>
					<p class="time">送货时间： 工作日/周末/假日均可</p>
				</div>
			</div>
			
			<div class="cart-2">
			 <div>
			 	<input id="id1535296269189" checked=""  type="radio">
			 	<label class="tit" for="id1535296269189">支付宝/微信支付</label>
			 	<div style="display:inline;" >
			 		
			 	</div>
			 </div>
		
			<div >
				<ul style="height: 60px;width: 926px;">
					<li class="cart-21">
						<div class="bd_wrap" data-reactid=".0.0.8.0.0.2.$0.0.1.0.$0.0">
							<input name="gateway" id="Alipay" value="Alipay" checked="" data-reactid=".0.0.8.0.0.2.$0.0.1.0.$0.0.0" type="radio"style="position: relative;top:-10px;">
							<label class="bg" for="Alipay" data-reactid=".0.0.8.0.0.2.$0.0.1.0.$0.0.1">
							</label>
						</div>
					</li>
					
					<li class="cart-22">
						<div class="bd_wrap" data-reactid=".0.0.8.0.0.2.$0.0.1.0.$1.0">
							<input name="gateway" id="WeixinQRCodeWeb" value="WeixinQRCodeWeb" data-reactid=".0.0.8.0.0.2.$0.0.1.0.$1.0.0" type="radio"style="position: relative;top:-10px;">
							<label class="bg-1" for="WeixinQRCodeWeb" data-reactid=".0.0.8.0.0.2.$0.0.1.0.$1.0.1">
						    </label>
						</div>
					</li>
				</ul>
			
			</div>
			</div>
			<div style="float: right;">
				<a href="HeadMainServlet?target=clearPayment" class="submit_btn" id="JS_btn_confirm_pay" data-reactid=".0.0.9.0.0.0">立即支付</a>
			</div>
		
		</div>
		
			
		
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
            <script>function change_urlknet(eleId){
            	var str= document.getElementById(eleId).href;
            	var str1 =str.substring(0,(str.length-6));
            	str1+=RndNum(6);document.getElementById(eleId).href=str1;
            }function RndNum(k)
            {var rnd="";for (var i=0;i<k;i++){rnd+=Math.floor(Math.random()*10);}return rnd;
            }</script>
        </div>
		</div>
		
		
		
		
		
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
		 .top-22{
			      background: url(img1/order_path.png) no-repeat;
			      background-position: -2px -158px;
			      float: right;
					width: 377px;
					height: 48px;
					position: relative;
					top: 30px;
				
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
		 	width: 960px;
			margin: 0 auto;
			padding: 25px 22px 0 22px;
			color: #000;
			background: #fff;
			zoom: 1;
			overflow: visible;
			background: white;
		 }
		 .title{
		 	line-height: 50px;
			font-weight: 700;
			height: 50px;
			color: #000;
			font-family: "微软雅黑";
		}
		.cart-1{
			height: 50px;
			padding: 22px 2px;
			margin: 10px 0 15px 0;
			border: 1px solid #ccc;
			overflow: hidden;
		}
		.f1{
			height: 64px;
			width: 200px;
			text-align: center;
			line-height: 64px;
			border-right: 2px solid deeppink;
			   float: left;
		}
		.price{
			color: #ed415b;
			font-weight: 700;
			font-size: 18px;
			text-align: center;
            line-height: 64px;
		}
		.f2{
			width: 611px;
            padding: 10px 0 10px 40px;
            font-size: 12px;
           float: left;
           position: relative;
           top:-10px;
		}
		.cart-2{
			height: 150px;
			padding: 22px 2px;
			margin: 10px 0 15px 0;
			border: 2px solid deeppink;
			overflow: hidden;
			background: papayawhip;
		}
		.cart-21{
			background: #fff;
			border: 1px solid #ccc;
			float: left;
			margin: 27px 15px 0 15px;
			width: 188px;
			padding: 0;
			list-style: none;
		}
		.bg{
			border: none;
			background-position: 0 -1575px;
			background: url(img1/gateway_bg_v7.jpg);
			height: 38px;
			width: 130px;
			display: inline-block;
			cursor: pointer;
		
		}
		.cart-22{
			background: #fff;
			border: 1px solid #ccc;
			float: left;
			margin: 27px 15px 0 15px;
			width: 188px;
			padding: 0;
			list-style: none;
		}
		.bg-1{
		    border: none;
			height: 38px;
			width: 130px;
			display: inline-block;
			cursor: pointer;
			background:url(img1/20180827001150.png);
		}
		.submit_btn{
			display: inline-block;
			background: #f8296d;
			border: 1px solid #fc6e9d;
			height: 40px;
			line-height: 40px;
			text-decoration: none;
			color: #fff;
			font-size: 20px;
			font-weight: 700;
			width: 170px;
			text-align: center;
		}
		</style>
	</body>
</html>
