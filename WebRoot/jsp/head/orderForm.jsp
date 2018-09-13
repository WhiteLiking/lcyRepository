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
    <title>My JSP 'orderForm.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
  </head>
  
  <body>
  
  <!-- ######################################################################################################################### -->
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
					<img src="img1/20180826171959.png"/>
					<div class="top-22">
						
					</div>
				</div>
			</div>
			
			<div class="qroups">
				<table class="car-groups">
					<thead>
						<tr>
							<th >
								<div class="car-groups-header">
									<input type="checkbox" name="checkbox" />
<!-- ***************************************************************************************************************************** -->
<!-- 订单详情页！ -->							
									聚美优品发货 
								</div>	
						    </th>
						    <th >聚美价（元）</th>
						    <th >数量</th>
						    <th >小计（元）</th>
						    <th >操作</th>
						</tr>
					</thead>
					<tbody>
						<tr class="car-item">
							<td>
								<div class="car-item1">
									<input type="checkbox" name="checkbox" id="checkbox" style="float: left;margin: 40px 0 0 8px;"/>
									<div class="car-item2">
										<a class="car-item3" href="#" target="_blank" >
											<img src="img1/810215_60_60.jpg"alt="倩碧卓越润肤乳125ML(有油)"/>
										</a>
								         <span class="cart_item_global">[极速免税]</span>
								         <a class="cart_item_link" title="倩碧卓越润肤乳125ML(有油)" href="#" target="_blank">倩碧卓越润肤乳125ML(有油)</a>
										<p class="sku_info">  
											型号：<span class="cart_item_attribute">有油</span>
											   容量：<span class="cart_item_capacity">125ML</span> 
										</p>
									</div>
								</div>
							</td>
							<td> 
								<div class="cart_item_price"> 
									<p class="jumei_price">198.00</p> 
									<p class="market_price ">295.00</p> 
								</div> 
							</td>
							<td style="text-align: center;position: relative;left: 25px;"> 
								<div class="cart_item_num "> 
									<div class="item_quantity_editer" data-item-key="702000468_ht180825p810215t2"> 
										<span class="decrease_one">-</span> 
										<input class="item_quantity" value="1" type="text"> 
											<span class="increase_one ">+</span> </div>
								</div> 
							</td>
							<td> 
								<div class="cart_item_total"> 
									<p class="item_total_price">198.00</p> 
									<p>省 <span class="item_saved_price">97.00</span>
									</p> 
								</div>
							</td>
							<td> 
								<div class="cart_item_option"> 
									<a class="icon_small"  href="#" title="删除"></a>
			
									</a> 
								</div> 
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr style="background: #fafafa;"> 
							<td colspan=" 5 "> 商品金额：
								<span class="group_total_price">¥0.00</span> 
							</td> 
						</tr>
					</tfoot>
				</table>
				
			</div>
 <!-- *************************************************************************************************************************** -->
            <div class="dizhi w">
			<div>
				<hr/>
				<form class="form-horizontal" style="border: 2px solid gainsboro;width: 80%;position: relative;left: 10%;">
					<div class="form-group">
						<label for="username" class="col-sm-1 control-label">地址</label>
						<div class="col-sm-5">
							<input type="text"  id="username" placeholder="请输入收货地址">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-1 control-label">收货人</label>
						<div class="col-sm-5">
							<input type="password" id="inputPassword3" placeholder="请输收货人">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-1 control-label">电话</label>
						<div class="col-sm-5">
							<input type="password"  id="confirmpwd" placeholder="请输入联系方式">
						</div>
					</div>
				</form>

				<hr/>

			
			</div>
		</div>
            
           <div class="common_handler">
            	<div class="right_handler">
            		 共 <span class="total_amount"> 0 </span> 件商品 
            		 商品应付总额：<span class="total_price">¥0.00</span> 
            		 <a id="go_to_order" class="btn" href="#"target="_blank">确认交易</a> 
            	</div> 
            	<a class="clear_cart_all" href="ShopCar.html">返回修改购物车</a> 
            	<form id="form_to_order" action="" method="post" style="display: none;">
            		<input name="items_key" type="hidden">
            	</form>
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
  
  
  
 <!-- ####################################################################################################################### --> 
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
			     background-position: -2px -54px;
			      float: right;
					width: 377px;
					height: 48px;
					position: relative;
					top: 30px;
				
		 }
		 
		 /*订单*/
		 .car-groups{
		 	width: 80%;
			margin: 10px 0 0;
			font-size: 12px;
			border: 1px solid #eee;
			border-collapse: collapse;
			border-spacing: 0;
			position: relative;
			left: 10%;
					 	
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
		 	width: 74px;
		 	text-align: center;
		 }
		 .decrease_one {
            font-size: 16px;
            border: 1px solid #e0e0e0;
            background: url(img1/cart_num_editer_bg.jpg)repeat-x 0 0 transparent;
            float: left;
			width: 20px;
			height: 20px;
			line-height: 20px;
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
		.increase_one  {
		 	font-size: 16px;
			border: 1px solid #e0e0e0;
			background: url(img1/cart_num_editer_bg.jpg)repeat-x 0 0 transparent;
			 float: left;
			width: 20px;
			height: 20px;
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
		 .cart_item_option{
		 	 height: 60px;
			padding: 20px;
			text-align: center;
		 }
		 .icon_small{
		 	background:url(img1/icons.png) no-repeat;
			background-position: -7px -27px;
			cursor: pointer;
			display: inline-block;
			width: 18px;
			height: 18px;
			line-height: 18px;
			font-style: normal;
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
		 	width: 80%;
			height: 48px;
			margin: 10px 0;
			line-height: 48px;
			border: 1px solid #eee;
			background: #fafafa;
			position:relative;
			left: 10%;
		 }
		 .right_handler{
		 	float: right;
			height: 100%;
		 }
		 .total_amount{
		 	color: #ed145b;
			font-size: 14px;
			font-weight: 700;
		 }
		 .total_price{
		 	font-size: 18px;
		 	color: #ed145b;
            font-weight: 700;
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
	</style>
		
  </body>
</html>
