<%@ page language="java" import="java.util.*,com.vo.Category,com.vo.ShopCar" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		
		<title>聚美首页</title>
		
		   <link rel="stylesheet" type="text/css" href="css/page.css" />
		   <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		   <link rel="stylesheet" type="text/css" href="css/myChart.css" />
		
			
	</head>
	<body>
	    <div class="topbu">
		  <div class="w">
		  	<div class="f1">
		  		<img src="img1/sy.png"style="background: #e3e4e5;"/>
				    <a href="#"target="_blank">聚美首页</a>
				    <img src="img1/tb.png"style="background: #e3e4e5;position: relative;"/>
				    <a href="#"target="_blank">北京</a>
		   	 </div>
		   	 <div class="f2">
		   	 	<c:if test="${empty loginUser}">
		   	 	 <a href="UserServlet?action=loginUI" >你好，请登录 </a>
			     <a href="UserServlet?action=registUI"  style="">免费注册 </a>
			    </c:if>
		   	 	  <c:if test="${not empty loginUser}"> 
			     <a>欢迎您${loginUser.username}</a>
			     <a href="UserServlet?action=logOut" style="">退出 </a>
			     </c:if>
			     <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			     <a href="#"target="_blank">正品查询 </a>
			     <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			      <a href="#"target="_blank">我的订单 </a>
			        <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			        <a href="#"target="_blank">订单查询</a>
			       <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			        <a href="#"target="_blank">收藏的品牌 </a>
			       <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			        <a href="#"target="_blank">我的聚美
			      <img src="img1/jt.png"style="position: relative;"/>
			      </a>
			       <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			         <a href="#"target="_blank">手机聚美 </a>
			       <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			        <a href="#"target="_blank">更多
			      <img src="img1/jt.png"style="position: relative;"/>
			      </a>     
		   	 </div>
		   </div>
		</div>
				
		<div id="middle">

			<!--放logo和水平导航-->
			<div id="middleLogoAndHorizontalNav">
				<div id="logo">
					<div id="logoImageDiv">
						<img src="img1/20180825132229.png" style="height: 80px;position: relative;left: 20px;top: -10px;"/>
					</div>
					<div id="searchDiv">
						<div id="searchDiv2">
							<form action="#" method="post">
								<input type="text" class="searchInput" id="search" name="search" value="保湿" />
								<button class="searchButton">搜索</button>
							</form>
						</div>

						<div id="searchBelow">

							<a class="style-red" href="#">保湿</a>
							<a href="#">面膜</a>
							<a href="#">洗面奶</a>
							<a href="#">补水</a>
							<a href="#">香水</a>
							<a href="#">眼霜</a>
							<a href="#">口红</a>
							<a href="#">护肤套装</a>
							<a href="#">BB霜</a>

						</div>
					</div>
					<div id="shoppingDiv">
						<div id="shoppingCar">
							<span id="shoppingCarLeftMargin">
								<label class="shoppingCarLabel"></label>
								<a href="HeadMainPage?target=lookShopCar"style="color: black;background: whitesmoke;">我的购物车</a>
							</span>
						</div>

					</div>
				</div>
			<% List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
				int TotalQuantity = 0;
				for(int i=0;i<shopCar.size();i++){
					TotalQuantity = TotalQuantity + shopCar.get(i).getQuantity();
				}
			 %>
				<!--右边导航菜单栏-->
			<div id="right">
				<div id="right-chart1" class="iconfont">&#xe712;</div>
				<span id="right-text1">账号</span>
				<div id="right-bag">
					<div id="right-chart2" class="iconfont">&#xe680;</div>
					<a href="HeadMainPage?target=lookShopCar"><span id="right-text2">购物车</span></a>
					<i id="right-chart3" class="iconfont">&#xe600;</i>
				    <i id="num" class="iconfont" style="position:relative;top: 42px;left:7px;color: white;"><%=TotalQuantity %></i>
					<i id="right-chart4" class="iconfont">&#xe61b;</i>
					<i id="right-chart5" class="iconfont">&#xe660;</i>
					<i id="right-chart6" class="iconfont">&#xe608;</i>
					<i id="right-chart7" class="iconfont">&#xe63f;</i>
				</div>
			</div>
			
			
		<div style="background-color: white;height: 50px;">
			<div style="background: black;height:40px;position: relative;top:10px">

		       	<ul class="menu1"style="position: relative;left: 5%;top:-8px">
			
			<li>
				<a class="btn-img">首页</a>
			</li>
			<li>
				<a class="btn-img">极速免税店</a>
			</li>
			<li>
				<a class="btn-img">母婴特卖</a>
			</li>
			<li>
				<a class="btn-img">美妆商城</a>
			</li>
			<li>
				<a class="btn-img">国际轻奢</a>
			</li>
			<li>
				<a class="btn-img">运动服饰</a>
			</li>
			<li>
				<a class="btn-img">鞋包配饰</a>
			</li>
			<li>
				<a class="btn-img">鞋包配饰</a>
			</li>
		</ul>
		    <div style="height: 30px;width: 120px;background: black;float:right;position: relative;right: 70px;top:-10px">
		    	<img src="img1/z_01new-1.jpg"/>
		    	<img src="img1/z02.jpg"/>
		    	<img src="img1/z03.jpg"/>
		    </div>
              </div>
		    </div>
		</div>	    
		 		<!--详情-->
		<div id="mall_shop_content" class="mall_shop_content" style="display: block;background-color: white;">
			<!--  <div class="mall_shop_banner" style="background-image:url(img1/5b7fa148dfc75_1920_350.jpg);height:144px;"> -->
			<img src="img1/5b7fa148dfc75_1920_350.jpg"style="height: 150px;width: 100%;"/>
			</div>
			<div class="middle">
				<div style="background-color:black ;height: 30px;">
				<div class="top_1" style="height:30px;position: relative;top:10px">

					<ul class="menu1" style="position: relative;left: 5%;top:-10px">

						<li>
							<a class="btn-img">首页</a>
						</li>
						<li>
							<a class="btn-img">全部商品</a>
						</li>
					</ul>
					<div style="height: 30px;background: black;float:right;position: relative;right: 70px;top:-10px">
						<ul class="menu1" style="position: relative;left: 5%;">
						<li>
							<a class="btn-img" style="width: 105px;">雅诗兰黛聚美专卖店</a>
						</li>

						<li style="margin-left:20px;width: 100px;">
							<a style="color: white;">
								<img src="img1/love.png"style="height: 15px;width: 15px;"/>
								收藏</a>
						</li>
					</ul>
					</div>
				</div>
			</div>
				
			</div>
		</div>
		<!--团购详情-->
		<div class="layout_1090 white_background">
			<!--面包屑导航-->
			<div class="subpage_menu">
				<div class="subpage_menu_l" style="background: white;text-decoration: none;">
					<a href="jm.html">聚美优品首页
						<</a>
							<a href="#">雅诗兰黛 (Estee Lauder)
								<</a>
									<a href="#">化妆水/爽肤水
										<</a>
											<a style="color:red;">雅诗兰黛鲜活亮采果萃水200ml</span>
				</div>
			</div>
			
			
			<%
				Category category = (Category)request.getAttribute("product");
				int id = category.getCid();
				String cname = category.getCname();
				String cdec = category.getCdec();
				int price = category.getPrice();
				int quantity = category.getQuantity();
				String version = category.getVersion();
				String ps = category.getPsPath();
 			%>
			
			<!--面包屑导航 end-->
			<h1 class="mall_main_title"style="color: black;text-decoration: none;">  
                                <%=cname+"/"+cdec %></h1>
                                
			<div class="center">
				 <div class="pic-sliderwrap">
								<div id="demo">
									<div id="small-box">
										<div id="float-box"></div>
										<img src="<%=ps %>"/>
									</div>
									<div id="big-box">
										<img src="img1/160753_1000_1000.jpg"/>
									</div>
								</div>
							</div>
				<div class="rightP">
					<!--1-->
					<div class="mall_price_detail22"style="text-decoration: none;">
						<em class="yen">¥</em>
						<span class="price_num" style="text-decoration: none;"><%=price %>.00</span>
						<span class="label">聚美价</span>
					</div>
					<!--3-->
					<div class="mall_detail_common mall_product_num mar_t15 clearfix">
						<span class="label">数量</span>
						<div class="num_detail" id="num_detail">
							<em title="减少" class="number_reduce fl" onclick= "reduce()"></em>
							<input type="text" value="1" id="buy_number" class="buy_number fl" maxlength="2">
							<em title="增加" class="number_add fl" onclick="add()"></em>
						</div>
					</div>

					<!--4-->
					<div class="mall_info_button mar_t20 clearfix">
						<!--购物车-->
						<a href="HeadMainPage?target=addShopCar&id=<%=id %>" class="mall_addcart_up"></a>
						<div class="mall_like_all">
							<div class="fav_ibtn_back"></div>
							<a class="mall_like_fav" href="#">
								<span id="ilike_text">收藏</span>
							</a>
						</div>
					</div>
					<!--5-->
					<div class="mall_detail_buynum mar_t15 clearfix">
						<i class="deal_buy_icon"></i>
						<p class="buynum">
							月销<span class="red_num">238</span>
						</p>
					</div>
					<!--6-->
					<div class="mall_detail_common mall_product_service mar_t20 clearfix">
						<span class="label">服务</span>
						<div class="mall_serce_list">
							<a style="color: #ea1d5d">自营</a>
							<a href="#" target="_blank" title="正品保证" class="con">正品保证</a>
							<a href="#" target="_blank" class="con" title="质量保险">质量保险</a>
							<a href="_#" target="_blank" title="30天退货" class="con">本商品支持30天拆封无条件退货</a>
							<a href="#" target="_blank" class="con" title="闪电发货">闪电发货</a>
							<a href="#" target="_blank" class="con" title="满2件或299元包邮(新疆部分区域除外)">本商品满299元或2件包邮（新疆部分区域除外）</a>
						</div>
					</div>
					<!--8-->
					<div class="shopname_self mar_t15"><span class="shopname_icon fl">聚美自营</span><span class="shopname_word fl">本商品由<em class="self_mar">聚美优品</em>拥有和销售</span></div>

				</div>

			</div>

		</div>
		
		
		<script src="http://libs.baidu.com/jquery/1.10.0/jquery.min.js"></script>
		<script type="text/javascript">
		var quantity = 0;
		function add(){
		 quantity =quantity+parseInt( $("#buy_number").val())+1;
		 $("#buy_number").val(quantity);	
		}
		
		window.onload=function  () {
				var objDemo=document.getElementById("demo");
				var objSmallBox=document.getElementById("small-box");
				var objFloatBox=document.getElementById("float-box");
				var objBigBox=document.getElementById("big-box");
				var objBigBoxImge=objBigBox.getElementsByTagName("img")[0];
				
				   objSmallBox.onmouseover = function () {
					objFloatBox.style.display = "block";
					objBigBox.style.display = "block";
					            }
					
				objSmallBox.onmouseout = function () {
					objFloatBox.style.display = "none";
					objBigBox.style.display = "none";
					            }
					
					objSmallBox.onmousemove = function (ev) {

					var _event=ev;
					
					var left=_event.clientX-objDemo.offsetLeft-objSmallBox.offsetLeft-objFloatBox.offsetWidth/2;
					var top=_event.clientY-objDemo.offsetTop-objSmallBox.offsetTop-objFloatBox.offsetHeight/2;
					
					if(left<0){
						left=0;	
					}else if(left>(objSmallBox.offsetWidth-objFloatBox.offsetWidth)){
						left=objSmallBox.offsetWidth-objFloatBox.offsetWidth;
					}
					
					if(top<0){
						top=0;	
					}else if(top>(objSmallBox.offsetHeight - objFloatBox.offsetHeight)){
						top=objSmallBox.offsetHeight - objFloatBox.offsetHeight
					}
					
					
					objFloatBox.style.left= left +"px";
					objFloatBox.style.top= top +"px";
					
					
					var percentX=left / (objSmallBox.offsetWidth-objFloatBox.offsetWidth);
					var percentY=top / (objSmallBox.offsetHeight-objFloatBox.offsetHeight);
					
					objBigBoxImge.style.left=-percentX * (objBigBoxImge.offsetWidth - objBigBox.offsetWidth)+"PX";
					objBigBoxImge.style.top=-percentY * (objBigBoxImge.offsetHeight - objBigBox.offsetHeight)+"px";
				}
			}
			
			
		</script>
		
		
		
	
		
		<style type="text/css">
			*{
				margin: 0px;
				padding: 0px;
				list-style: none;
				text-decoration: none;
			}
			/*头部*/
			.topbu{
				height: 40px;
				width: 100%;
				background: #e3e4e5;
			}
			.w{
				background: #e3e4e5;
                color: #999;
                width: 1210px;
                margin: 0 auto;
                line-height: 30px;
				text-align:center;

			}
			.f1{
				height: 30px;
				width: 200px;
				float: left;
				position: relative;
				background: #e3e4e5;
			}
			.f2{
				height: 30px;
				width:890px;
				background: #e3e4e5;
				float: left;
				position: relative;
				left: 180px;
			}
			.w  a{
				height: 30px;
				color:#999;
				background: #e3e4e5;
				font-size: 12px;
				padding-left: 5px;
				text-decoration: none;
			}
			.w a:hover{
				color: red;
			}
			
				.myclass{
				width: 100%;
				height: 50px;
				background: white;
				position: absolute;
		        top:10px;
			}
			
			/*标签*/
				#middleLogoAndHorizontalNav {
				height: 130px;
				background-color: white;
			}
			
			#logo {
				width: 1210px;
				height: 80px;
				margin: 0px auto;
				background-color: white;
			}
			
			#horizontalNav {
				height: 44px;
				border-bottom: 2px solid #B1191A;
				background-color: white;
			}
			
			#horizontalNavCenter {
				width: 1210px;
				height: 44px;
				margin: 0px auto;
				background-color: white;
			}
			
				#logoImageDiv {
				width: 270px;
				height: 79px;
				padding-top: 19px;
				float: left;
				background-color: white;
			}
			
			#searchDiv {
				width: 734px;
				height: 98px;
				float: left;
				background-color: white;
			}
			
			#searchDiv2 {
				width: 544px;
				height: 36px;
				margin-top: 25px;
				margin-left: 92px;
				background-color: white;
			}
			
			input.searchInput {
				float: left;
				width: 446px;
				height: 24px;
				line-height: 24px;
				color: #666;
				padding: 4px;
				margin-bottom: 4px;
				border-width: 2px 0 2px 2px;
				border-color: deeppink;
				border-style: solid;
				outline: 0;
				font-size: 14px;
				font-family: "microsoft yahei";
				background-color: white;
			}
			
			button.searchButton {
				float: left;
				width: 82px;
				height: 36px;
				background: deeppink;
				border: none;
				line-height: 1;
				color: #fff;
				font-family: "Microsoft YaHei";
				font-size: 16px;
				cursor: pointer;
			}
			
			#searchBelow {
				width: 544px;
				margin-left: 92px;
				float: left;
				background-color: white;
			}
			
			#searchBelow a {
				float: left;
				white-space: nowrap;
				margin-right: 10px;
				background-color: white;
				color: grey;
			}
			
			#searchBelow a:hover{
				color: red;
			}
			
			.style-red {
				color: #C81623;
				background-color: white;
			}
			
			#shoppingDiv {
				width: 206px;
				height: 98px;
				float: left;
				background-color: white;
			}
			
			#shoppingCar {
				width: 140px;
				height: 34px;
				line-height: 34px;
				border: 1px solid #DFDFDF;
				display: block;
				background-color: #F9F9F9;
				margin-top: 25px;
				position: relative;
			}
			
			label.shoppingCarLabel {
				width: 18px;
				height: 16px;
				background: url(img1/shoppingCar.png) no-repeat 0 -58px;
				display: inline-block;
				overflow: hidden;
				position: absolute;
				top: 9px;
				left: 14px;
				
			}
			
			#shoppingCarLeftMargin {
				margin-left: 40px;
				
			}
			
			/*分类*/
				a {
				
				text-decoration: none;
				background: white;
			}
			
			a.btn-img {
				display: block;
				width: 10%;
				background: white;
				height: 15px;
				color:gray;
				font-size: 5px;
				font-family: '微软雅黑';
				text-align: center;
				cursor: pointer;
				white-space:pre;
				margin-left: 8px;
				background: white;
			
			}
			li{
				float:left;
				background: white;
				
			}
			li a:hover {
				background-color: #F7F7F7;
				color: #e4393c;
		        border-right: #F7F7F7;
		   
			}
			
			.ul {
				list-style-type: none;
				padding: 0px;
				margin: 0px;
				background: black;
				height: 15px;
				widows: 60px;
			
			}
			
				.menu1	a {
				
				text-decoration: none;
				background: black;
			}
			
		 .menu1 a.btn-img {
				display: block;
				width: 60px;
			   background: black;
				height: 30px;
				color: white;
				font-size: 14px;
				font-family: '微软雅黑';
				text-align: center;
				cursor: pointer;
				white-space:pre;
				padding:0 22px;
				text-decoration: none;
			
			}
			.menu1 li{
				float:left;
				background: black;
				
			
			}
		  .menu1 li a:hover {
				color: grey;
		        border-right: #F7F7F7;
		        background-color: deeppink;
			}
			
			.menu1{
				list-style-type: none;
				padding: 0px;
				margin: 0px;
		
			}
			
			 /*商品详细信息*/
			/*头*/
			
			.layout_1090 {
				width: 1088px;
				border: 1px solid #e2e2e2;
				margin: 10px auto 0;
				background: #fff;
			}
			
			.white_background {
				background: #fff;
			}
			
			.subpage_menu {
				height: 20px;
				width: 100%;
				padding: 20px 0 10px;
				font-size: 14px;
				overflow: hidden;
				background: white;
				border-bottom: 2px solid gainsboro;
				text-decoration: none;
				list-style: none;
			}
			
			.subpage_menu_l a {
				width: 100%;
				overflow: hidden;
				display: inline;
				height: 20px;
				margin-left: 8px;
				color: #6d6d6d;
				background: white;
				text-decoration: none;
				list-style: none;
			}
			
			.subpage_menu_l a:hover {
				color: red;
			}
			
			.mall_main_title {
				font-size: 20px;
				padding: 12px 40px 20px 20px;
				text-shadow: 0 1px 3px #ccc;
				line-height: 150%;
			}
			
			h1,
			h2,
			h3,
			h4,
			h5,
			h6 {
				font-size: 100%;
				font-weight: 400;
				color: #000000;
				background-color: white;
			}
			
			h1 {
				display: block;
				font-size: 2em;
				-webkit-margin-before: 0.67em;
				-webkit-margin-after: 0.67em;
				-webkit-margin-start: 0px;
				-webkit-margin-end: 0px;
				font-weight: bold;
			}
			/*中间样式的开始*/
			
			.center {
				width: 1088px;
				margin: 0px auto;
				background-color: #FFFFFF;
				height: 505px;
			}
			
			
			#demo {
			display: block;
			width: 350px;
			height: 350px;
			margin: 50px;
			position: relative;
			/*border: 1px solid #ccc;*/
			}
			
			#small-box {
			position: relative;
			z-index: 1;
			}
			
			#float-box {
			display: none;
			width: 160px;
			height: 120px;
			position: absolute;
			background: #ffffcc;
			border: 1px solid #ccc;
			filter: alpha(opacity=50);
			opacity: 0.5;
			cursor: move;
			}
			
			
			#big-box {
			display: inline-block;
			position: absolute;
			top: 0;
			left: 410px;
			width: 350px;
			height: 400px;
			overflow: hidden;
			border: 1px solid #ccc;
			z-index: 1;;
			}
			
			#big-box img {
			position: absolute;
			z-index: 5
			}
			
			.rightP {
				width: 460px;
				height: 340px;
				float: right;
				background-color: #FFFFFF;
				border: 20px;
				margin-left: 20px;
				position: relative;
				top:-450px;
				left: -150px;
			}
			.jqzoom .zoom_icon {
				display: none;
				position: absolute;
				width: 20px;
				height: 20px;
				background: url(img1/bj11.jpg);
				right: 0;
				bottom: 0;
			}
			/*产品详情样式*/
			
			.mall_price_detail22{
				width: 460px;
				height: 55.43px;
				padding-bottom: 10px;
				border-bottom: solid 1px #efefef;
			}
			
			 .yen {
				color: #ed145b;
				font-weight: 700;
				font-family: Arial;
				font-size: 16px;
				font-style: normal;
			}
			
		     .price_num {
				color: #ed145b;
				font-size: 30px;
			}
			
		      .label {
				font-size: 15px;
				font-weight: 700;
				margin-left: 4px;
			}
			
			.mall_detail_koubei {
				color: #666;
				display: none;
				padding-bottom: 15px;
				border-bottom: solid 1px #efefef;
				width: 460px;
				margin-bottom: 15px;
			}
			
			.mall_detail_common .label {
				display: inline-block;
				float: left;
				margin-right: 10px;
				color: #666;
			}
			
			.mall_koubei_detail {
				width: 400px;
				float: left;
			}
			
			.mall_koubei_star i {
				display: inline-block;
				height: 12px;
				background-position: 0 0;
				background-repeat: repeat-x;
				background: url(img1/star1.png) no-repeat;
			}
			
			.mall_koubei_star {
				float: left;
				line-height: 10px;
				margin: 2px 10px 0 0;
				background-position: 0 -14px;
				background-repeat: repeat-x;
				width: 75px;
				height: 12px;
				overflow: hidden;
			}
			
			.mar_t15 {
				margin-top: 15px;
			}
			
			.clearfix:after {
				content: "\00A0";
				display: block;
				visibility: hidden;
				width: 0;
				height: 0;
				clear: both;
				font-size: 0;
				line-height: 0;
				overflow: hidden;
			}
			
			.mall_detail_common .label {
				display: inline-block;
				float: left;
				margin-right: 10px;
				color: #666;
				margin-top: 6px;
			}
			
			.num_detail {
				height: 28px;
				float: left;
				width: 105px;
				display: inline;
				margin-left: 5px;
			}
			
			.num_detail {
				background: url(img1/gouwuche.png)no-repeat;
				background-position: -198px 0;
			}
			
			.number_reduce {
				float: left;
				height: 28px;
				width: 28px;
				cursor: pointer;
			}
			
			em {
				font-style: normal;
				font-weight: 400;
			}
			
			.buy_number {
				width: 49px;
				height: 28px;
				text-align: center;
				line-height: 28px;
				border: 0 none;
				overflow: hidden;
				background: 0 0;
				margin-top: 1px;
				outline: 0;
				font-size: 14px;
			}
			
			.fl {
				float: left;
			}
			
			input {
				outline: 0;
			}
			
			input,
			select,
			textarea {
				font-family: inherit;
				font-size: inherit;
				font-weight: inherit;
			}
			
			.number_add,
			.number_reduce {
				float: left;
				height: 28px;
				width: 28px;
				cursor: pointer;
			}
			
			.clearfix:after {
				content: "\00A0";
				display: block;
				visibility: hidden;
				width: 0;
				height: 0;
				clear: both;
				font-size: 0;
				line-height: 0;
				overflow: hidden;
			}
			
			.mall_addcart_up {
				width: 165px;
				height: 40px;
				float: left;
			}
			/*购物车*/
			.mall_addcart_up {
				background: url(img1/gouwuche.png) no-repeat;
				background-position: 0 -40px;
			}
			
			.mar_t20 {
				margin-top: 20px;
			}
			
			.mall_like_all {
				float: left;
				width: 125px;
				position: relative;
				background-color: #fff;
			}
			
			.mall_like_fav {
				display: block;
				width: 125px;
				height: 40px;
				text-align: center;
				line-height: 40px;
				color: #333;
				text-decoration: none;
				font-size: 14px;
				margin-left: 20px;
				background: url(img1/gouwuche.png) no-repeat;
			}
			
			.mall_like_fav {
				background-position: 0 -120px;
			}
			
			.mall_like_fav:hover{
				 color:red;
				 background: peachpuff;
			}
			.mall_detail_buynum {
				border-top: 1px solid #efefef;
				padding: 10px 0;
			}
			
			.buynum {
				font-size: 12px;
				color: #8e8e8e;
			}
			
			.buynum .red_num {
				color: #fd4d87;
				margin-left: 3px;
				font-size: 14px;
				font-weight: 700;
			}
			
			.mall_product_service {
				padding: 22px 0 0;
				border-top: solid 1px #efefef;
			}
			
			.mall_product_service .label {
				margin-top: 5px;
			}
			
			.mall_detail_common .label {
				display: inline-block;
				float: left;
				margin-right: 10px;
				color: #666;
			}
			
			.mall_serce_list {
				float: left;
				width: 400px;
			}
			
			.shopname_self {
				height: 40px;
				width: 300px;
				background: #feedf3;
			}
			
			.mar_t15 {
				margin-top: 15px;
			}
			
			.shopname_icon {
				display: inline-block;
				width: 32px;
				padding: 5px 3px;
				text-align: center;
				line-height: 1;
				color: #fff;
				height: 30px;
				background: #e91359;
				float: left;
			}
			
			.mall_serce_list {
				float: left;
				width: 400px;
			}
			
			.mall_product_service a {
				display: inline-block;
				padding: 3px 5px;
				color: #666;
				margin: 0 2px 5px;
				color: #888;
				border: solid 1px #eee;
			}
			
			.shopname_self {
				height: 40px;
				width: 300px;
				background: #feedf3;
			}
			
			.shopname_icon {
				display: inline-block;
				width: 32px;
				padding: 5px 3px;
				text-align: center;
				line-height: 1;
				color: #fff;
				height: 30px;
				background: #e91359;
			}
			
			.shopname_word {
				line-height: 34px;
				white-space: nowrap;
				overflow: hidden;
			}
			
			.shopname_word {
				width: 240px;
				display: inline-block;
				margin-left: 10px;
				color: #ed145b;
			}
			
			.fl {
				float: left;
			}
			
			.top_1 {
				width: 1300px;
				margin: 0 auto;
			}
			
			
			
		</style>
		
	</body>

</html>
