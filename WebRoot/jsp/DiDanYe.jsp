<%@ page language="java" import="java.util.*,com.vo.ShopCar,com.vo.Orders" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		 <base href="<%=basePath%>">
    
    <title>订单页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<meta charset="UTF-8">
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
		
		<script src="js/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		function sendTime(){
			//发送Ajax到服务器
			xmlHttpRequest = new XMLHttpRequest();
			xmlHttpRequest.onreadystatechange=callback;
			var url="HeadMainServlet?target=sendTime";//请求的url
			xmlHttpRequest.open("post", url);
			xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//发送HTTP请求
			var data = "sendTime="+$("[type='radio']").val();
			xmlHttpRequest.send(data);
		}
		
		  
		</script>
		
	</head>
	<body>
		<div style="background: white;height: 100px;">
			<div class="top-1">
				<div class="top-12">
					<div style="background: white;">
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
					<img src="img1/20180829215142.png" style="position: relative;top:-10px"/>
					<div class="top-22">
						
						
					</div>
				</div>
			</div>
	<%List<Orders> order = (List<Orders>)session.getAttribute("productOrder");
			String name = "无";
			String address = "无";
			String phone = "无";
			if(order==null){
				order=new <Orders>ArrayList();
				
			}
			if(order!=null&&order.size()>0){
			name = order.get(0).getName();
			address = order.get(0).getAderss();	
			phone = order.get(0).getTelephone();
			}
			
	%>
		<!--订单信息 -->
		<div class="di">
			<!--地址 -->
			<div class="dizhi">
					<h2 class="title">1 地址选择</h2>
					<div class="address">
						<div class="address1">
							<div class="address_box">
								<span class="name">收件人：<%=name %></span>
								<span class="xg">
									
								</span>
							    <div class="number_phone">电话：<%=phone %></div>
							     <div class="detaile">地址：<%=address %></div><br>
							     <a href="jsp/xindizhi.jsp"style="position: relative;top:-90px;left:160px;text-decoration:none;">修改</a>
							</div>
						</div>	
						<div class="address2">
							<div class="f1">
								<a href="jsp/xindizhi.jsp" class="add">
									<i class="icon">+</i>
									<span >使用新地址</span>
								</a>
								
							</div>
						</div>
					</div>
			</div>
			<!--送货时间 -->
			<div class="songhuo">
				<div class="songhuo1">
					<h2 class="title">2 送货时间</h2>
					<div class="prefer_delivery_day" >
						<div class="clearfix">
							<div class="box1">
								<input readonly="" name="prefer_delivery_day" type="radio" >
								<label style="background: white;">仅工作日送货</label>
							</div>
							<div class="box">
								<input readonly="" name="prefer_delivery_day" type="radio">
								<label style="background: white;">仅周末送货</label>
							</div>
							<div class="box" >
								<input readonly="" checked="" name="prefer_delivery_day"  type="radio">
								<label style="background: white;">工作日/周末/假日均可</label>
							</div>
						</div>
					</div>
					
				</div>
		</div>
		     <!-- 商品清单-->
		     <div class="qindan"style="width: 960px;background: white;  border-bottom: 1px solid #ccc;">
		     	<div class="qindan1">
		     		<h2 class="title">3 商品清单
		     		
		     		  <a class="clear_cart_all" href="HeadMainPage?target=lookShopCar"style="background:white;float: right;font-weight: 100;font-size: 14px;color: red;margin-right: 40px;">返回修改购物车</a> 
		     		</h2>
		     		<div class="qroups" style="background: white;">
				<table class="car-groups"style="background: white;margin-bottom: 20px;">
					<thead>
						<tr>
							<th >
								<div class="car-groups-header"style="background: white;">
									聚美优品发货 
								</div>	
						    </th>
						    <th style="background: white;">聚美价（元）</th>
						    <th style="background: white;">数量</th>
						    <th style="background: white;">小计（元）</th>
						</tr>
					</thead>
					<%  List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar"); 
		     		if(shopCar==null){
		     		shopCar = new ArrayList<ShopCar>();
		     		}
		     		int totalPrice = 0;
		     		int totalquantity = 0;
		     		for(int i=0;i<shopCar.size();i++){
		     			String cname = shopCar.get(i).getCname();
		     			String cdec = shopCar.get(i).getCdec();
		     			int price = shopCar.get(i).getPrice();
		     			int quantity = shopCar.get(i).getQuantity();
		     			int prePrice = shopCar.get(i).getPrevPrice();
		     			String version = shopCar.get(i).getVersion();
		     			totalPrice = totalPrice+(quantity*price);
		     			totalquantity = totalquantity+quantity;
		     		
		     		%>
					<tbody>
						<tr class="car-item"style="background: white;">
							<td>
								<div class="car-item1"style="background: white;">
									
									<div class="car-item2"style="background: white;">
										<a class="car-item3" href="#" target="_blank" style="background: white;">
											<img src="img1/810215_60_60.jpg"alt="倩碧卓越润肤乳125ML(有油)"/>
										</a>
								         <span class="cart_item_global"style="background: white;">[极速免税]</span>
								         <a class="cart_item_link" title="倩碧卓越润肤乳125ML(有油)" href="#" target="_blank"style="background: white;"><%=cname %></a>
										<p class="sku_info"style="background: white;">  
											型号：<span class="cart_item_attribute"style="background: white;"><%=version %></span>
											   容量：<span class="cart_item_capacity"style="background: white;"><%=cdec %></span> 
										</p>
									</div>
								</div>
							</td>
							<td style="background: white;"> 
								<div class="cart_item_price"style="background: white;"> 
									<p class="jumei_price"style="background: white;"><%=price %>.00</p> 
									<p class="market_price "style="background: white;"><%=prePrice %>.00</p> 
								</div> 
							</td>
							<td style="text-align: center;position: relative;left: 25px;background: white;"> 
								<div class="cart_item_num "style="background: white;"> 
									<div class="item_quantity_editer"style="background: white;"> 
										<input class="item_quantity" value="<%=quantity %>" type="text"style="background: white;"> 
								</div> 
							</td>
							<td style="background: white;"> 
								<div class="cart_item_total"style="background: white;"> 
									<p class="item_total_price"style="background: white;"><%=quantity*price %>.00</p> 
									<p style="background: white;">省 <span class="item_saved_price"style="background: white;"><%= (prePrice-price)*quantity%>.00</span>
									</p> 
								</div>
							</td>
						</tr>
					</tbody>
					<tfoot>
					<%} %>
						<tr style="background:white;border: none;margin:none;"> 
							<td style="background:white"> 商品金额：
								<span class="group_total_price"style="background:white;">¥<%=totalPrice %>.00</span> 
							</td> 
						</tr>
					</tfoot>
					</table>
					</div>
		     		
		     	</div>
		     	
		    </div>
	     
		
	
           <div class="common_handler">
            	<div class="right_handler">
            		 共 <span class="total_amount"> <%=totalquantity %> </span> 件商品 
            		 商品应付总额：<span class="total_price">¥<%=totalPrice %>.00</span> 
            	 <a id="go_to_order" class="btn" href="HeadMainServlet?target=orderSure" target="_blank" >确认交易</a> 
            		 
            	</div> 
            	<a class="clear_cart_all" href="HeadMainPage?target=lookShopCar">返回修改购物车</a> 
            	<form id="form_to_order" action="" method="post" style="display: none;">
            		<input name="items_key" type="hidden">
            	</form>
            </div>
          </div>  
            <!--底部  -->
            <div id="footer_textarea">
        <div class="footer_con" id="footer_copyright">
            <p class="footer_copy_con">
                © 2013 北京创锐文化传媒有限公司 Jumei.com 保留一切权利。客服热线：400-123-8888 <br>
                    京公网安备 11010102001226 | <a href="#" target="_blank" rel="nofollow">京ICP证111033号</a> | <a href="#" target="_blank" rel="nofollow">食品流通许可证 SP1101051110165515（1-1）</a>
                | <a href="#" target="_blank">营业执照</a>
            </p>
            <p style="background:gainsboro">
            	<img src="img1/20180829220612.png" style="background:gainsboro;"/>
              
            </p>
          
        </div>
		
		
		
		
		
		<style type="text/css">
			*{
				background:#FAFAFA;
				padding: 0px;
				margin: 0px;
			}
		/*头部*/	
		
		  .top-1{
			position: relative;
			height: 25px;
			line-height: 25px;
			color: #999999;
			width: 960px;
			margin: 0 auto;
			background: white;
		  }
		 .top-12{
		 	position: absolute;
			right: 0;
			top: 0;
			background: white;
		 }
		 .top-12 a{
		 	color: #9999;
		 	text-decoration: none;
		 	background: white;
		 }
		 .top-12 a:hover{
		 	color: red;
		 }
		 .tips{
		 	font-style: normal;
			color: #dddddd;
			padding: 0 5px;
			background: white;
		 }
		 .top-2{
		 	border-bottom: 2px solid #e5e5e5;
			box-shadow: 0px 1px 2px rgba(0,0,0,0.1);
			padding-bottom: 15px;
			background: white;
		 }
		 .top-21{
		 	width: 960px;
            margin: 0 auto;
            background: white;
		 }
		 .top-22{
			      background: url(img1/order_path.png) no-repeat;
			     background-position: -2px -54px;
			      float: right;
					width: 377px;
					height: 48px;
					position: relative;
					top: 30px;
				
		 }
		 
		 /*订单*/
		/*地址*/
		.di{
			width: 960px;
			background: white;
			margin-left: 180px;
			margin-top: 20px;
			margin-bottom: 40px;
			
		}
		
		.dizhi {
			width:960px;
			background: white;
			border-bottom: 1px solid #ccc;
			
		}
		.title{
			line-height: 50px;
			width: 920px;
			font-size: 18px;
			font-family: "微软雅黑";
			font-weight: 700;
			color: black;
			background: white;
			margin-left: 20px;
			
		}
		.address{
			width:920px;
			margin-bottom: 15px;
			background: white;
			margin-left: 20px;
		}
		.address1{
			width:920px;
			height: 125px;
			background:white;
			
		}
		.address_box{
			line-height: 14px;
			background: url(img1/addr_bg.jpg) no-repeat;
            border-color: transparent;
			position: relative;
			float: left;
			width: 194px;
			height: 88px;
			border: 1px solid #ccc;
			margin-right: 4px;
			margin-bottom: 5px;
			color: #000;
			padding: 15px;
			cursor: pointer;
		}
		.name{
			width: 140x;
			white-space: nowrap;
			overflow: hidden;
			text-overflow: ellipsis;
			background: white;	
				
		}
		.detaile{
			text-overflow: ellipsis;
			overflow: hidden;
			height: 40px;
			line-height: 20px;
			background: white;
		}
		.number_phone{
			white-space: nowrap;
			overflow: hidden;
			text-overflow: ellipsis;
			margin-top: 5px;
			background: white;
			
		}
		.address_box1{
			position: relative;
			float: left;
			width: 194px;
			height: 88px;
			border: 1px solid #ccc;
			margin-right: 4px;
			margin-bottom: 5px;
			color: #000;
			padding: 15px;
			cursor: pointer;
			background: white;
			
		}
        .xg{
        	background: white;
        	position: relative;
        	left: 80px;
        }
        .xg a{
        	background: white;
        }
        .xg a:hover{
        	color: red;
        }
		.address2{
			width: 920px;
			height: 48px;
			background: white;
			
		}
		.f1{
			width: 120px;
			height: 28px;
			border: 1px solid gainsboro;
			position: relative;
			top:10px;
		}
		.add{
		         padding: 0 10px;
				height: 26px;
				line-height: 26px;
				border: 1px solid #cfcfcf;
				color: #333;
				display: inline-block;
				text-decoration: none;			

		}
		.icon{
			font-style: normal;
            font-weight: 700;
            line-height: 26px;
            color: #333;
		}
		/*送货时间*/
		.songhuo{
			width: 960px;
			height: 119px;
			border-bottom: 1px solid #ccc;
			background: white;
			
		}
		.songhuo1{
			margin-left: 20px;
			width: 920px;
			position: relative;
			height: 118px;
			background: white;
		}
		.prefer_delivery_day{
			padding-bottom: 30px;
			font-size: 12px;
			background: white;
		}
		.box1{
			height: 34px;
			line-height: 34px;
			border: 2px solid #6eaf4f;
			background: #e6f6de;
			padding-left: 9px;
			float: left;
            padding: 0 20px 0 10px;
            margin-right: 20px;
            background: white;
		}
		.box{
			height: 36px;
			line-height: 36px;
			border: 1px solid #ccc;
			float: left;
			padding: 0 20px 0 10px;
			margin-right: 20px;
			background: white;
		}
		
		/*-- 商品清单--*/
		.qindan1{
			margin-left: 20px;
			width: 920px;
			position: relative;
			background: white;
			
		}
		 .car-groups{
		 	width: 80%;
			margin: 10px 0 0;
			font-size: 12px;
			border: 1px solid #eee;
			border-collapse: collapse;
			border-spacing: 0;
			position: relative;
			left: 10%;
			background: white;
					 	
		 }
		 .car-groups th{
		 	height: 34px;
		 	width: 120px;
			padding: 0;
			text-align: center;
			font-weight: 400;
			border-bottom: 1px solid #eee;
			background: #fafafa;
			color: #000;
	
		 }
		 .car-groups-header{
		 	height: 34px;
			line-height: 34px;
			text-align: left;
			border-left: 5px solid #ed145b;
			font-weight:bolder;
            color: #000;
            font-size: 18px;
		 }
		 .car-item{
		 	border-collapse: collapse;
			border-bottom: 1px dotted #ddd;	
		 }
		 .car-item2{
		 	margin: 0 0 0 30px;
			padding: 20px 0 0;
			padding-left: 11px;
			text-decoration: none;
		 }
		  .car-item2 a{
		  	text-decoration: none;
		  	
		  }
		   .car-item2 a:hover{
		   	color: red;
		   }
		 .car-item3{
		 	    position: relative;
			    float: left;
			    width: 60px;
			    height: 60px;
			    margin: 0 10px 20px 0;
			    overflow: hidden;
			}
            .car-item3   a {
			    color: #ed145b;
			    text-decoration: none;
		 }
		 .cart_item_global{
		 	float: left;
			height: 18px;
			margin: 0 2px 0 0;
			line-height: 16px;
			color: #851b97;
		 }
		 .cart_item_link{
		 	display: inline-block;
			width: 250px;
			height: 18px;
			line-height: 16px;
			color: #000;
           white-space: nowrap;
			overflow: hidden;
			text-overflow: ellipsis;			
		 }
		 .sku_info{
		 	height: 22px;
			line-height: 22px;
			color: #999;
		 }
		 .cart_item_price{
		 	height: 60px;
			padding: 20px;
			text-align: center;
		 }
		 .jumei_price{
		 	margin-bottom: 3px;
			font-weight: 700;
			font-family: Arial,Helvetica;
		 }
		 .market_price {
		 	color: #999;
			text-decoration: line-through;
			font-family: Arial,Helvetica;
		 }
		 .cart_item_num{
		 	height: 60px;
			padding: 20px;
			text-align: center;
		 }
		 .item_quantity_editer {
		 	width: 94px;
		 	text-align: center;
		 }
		 .item_quantity{
		 	width: 30px;
			height: 20px;
			border: none;
           border-color: #e0e0e0;
            float: left;
			line-height: 20px;
			text-align: center;
			
		 }
		 .cart_item_total{
		 	height: 60px;
			padding: 20px;
			text-align: center;
		 }
		 .item_total_price{
		 	margin-bottom: 3px;
			color: #ed145b;
			font-weight: 700;
			font-family: Arial,Helvetica;
		 }
		 .group_total_price{
		 	margin-right: 10px;
			color: #ed145b;
			font-weight: 700;
			font-size: 14px;
			line-height: 30px;
			color:red;
			text-align: right;
		   
		 }
		
		
		 .common_handler{
		 	width: 960px;
			height: 48px;
			margin: 10px 30px;
			line-height: 48px;
			border: 1px solid #eee;
			background: white;
			position:relative;
			left:-30px;
		 }
		 .right_handler{
		 	float: right;
			height: 100%;
			background: white;
		 }
		 .total_amount{
		 	color: #ed145b;
			font-size: 14px;
			font-weight: 700;
			background: white;
		 }
		 .total_price{
		 	font-size: 18px;
		 	color: #ed145b;
            font-weight: 700;
            background: white;
		 }
		 .btn{
		 	background: deeppink;
			cursor: pointer;
			width: 145px;
			height: 100%;
			margin: 0 0 0 10px;
			font-size: 18px;
			display: inline-block;
			color: #fff;
			text-align: center;
			text-decoration: none;
		 }
		.cart_all_selector_wrapper {
		 	display: inline-block;
			margin: 0 0 0 15px;
		 }
		 .go_back_shopping{
		 	margin-left: 20px;
		 	color: #333;
		 	text-decoration: none;
		 	background: white;
		 }
		 
		  .go_back_shopping:hover{
		 	color: red;
		 }
		 .seperate_line{
		 	color: #999;
		 }
		 .clear_cart_all{
		 	margin: 0 2px;
			color: #333;
			text-decoration: none;
			background: white;
		 }
		 .clear_cart_all:hover{
		 	color: red;
		 }
		
		  
		  
		 
		  /*底部*/
		  #footer_textarea{
			overflow: hidden;
			width: 100%;
			margin-top: 0;
			border-top: 1px solid #ddd;
			font-size: 12px;
			background: gainsboro;
		  }
		   #footer_copyright{
		  	text-align: center;
			line-height: 20px;
			padding-bottom: 20px;
			color: #000;
			background: gainsboro;
		  }
		  .footer_con{
		  	width: 960px;
			margin: 0 auto;
			overflow: hidden;
			background: gainsboro;
		  }
		  .footer_copy_con{
		  	padding: 10px 0;
		  	background: gainsboro;
		  }
		 .footer_copy_con a{
		 	color: black;
		 	text-decoration: none;
		 	background: gainsboro;
		 }
		</style>
	</body>
</html>
