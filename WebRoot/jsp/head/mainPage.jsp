<%@ page language="java" import="java.util.*,com.vo.Category,com.vo.ShopCar" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mainPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	 <link rel="stylesheet" type="text/css" href="css/page.css" />
     <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	 <link rel="stylesheet" type="text/css" href="css/myChart.css" />

  </head>
  
  <body>
  
    <div class="topbu">
		  <div class="w">
		  	<div class="f1">
		  		<img src="img1/sy.png"style="background: #e3e4e5;position: relative;top:5px"/>
				    <a href="#"target="_blank">聚美首页</a>
				    <img src="img1/tb.png"style="background: #e3e4e5;position: relative;top:5px"/>
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
			     <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			     <a href="#"target="_blank">正品查询 </a>
			     <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			      <a href="HeadMainPage?target=payment"target="_blank">我的订单 </a>
			        <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			        <a href="HeadMainPage?target=payment"target="_blank">订单查询</a>
			       <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			        <a href="#"target="_blank">收藏的品牌 </a>
			       <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			        <a href="#"target="_blank">我的聚美
			      <img src="img1/jt.png"style="position: relative;top: 6px;"/>
			      </a>
			    </c:if>

			       <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			         <a href="#"target="_blank">手机聚美 </a>
			       <span style="height: 10px;background: #e3e4e5;padding: 5px;"> |</span>
			        <a href="#"target="_blank">更多
			      <img src="img1/jt.png"style="position: relative;top: 6px;"/>
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
							<form action="HeadMainPage?target=searchShow" method="post">
								<input type="text" class="searchInput" id="search" name="searchBox" value="保湿" />
								<input type="submit" class="searchButton" value="搜 索" style="background:deeppink;color:white;border: 1px solid deeppink;height: 25px;width:60px;"/>
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
								<a href="HeadMainPage?target=lookShopCar" style="color: black;background: whitesmoke;">我的购物车</a>
							</span>
						</div>

					</div>
				</div>
				
			    <!--右边导航菜单栏-->
			<div id="right">
				<div id="right-chart1" class="iconfont">&#xe712;</div>
				<span id="right-text1">账号</span>
				<div id="right-bag">
					<div id="right-chart2" class="iconfont">&#xe680;</div>
					<a href="HeadMainPage?target=lookShopCar"><span id="right-text2">购物车</span></a>
					<% List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
						if(shopCar==null){
							shopCar = new <ShopCar>ArrayList();
						}
						int totalShopCarProduct = 0;
						for(int i=0;i<shopCar.size();i++){
							totalShopCarProduct = totalShopCarProduct+shopCar.get(i).getQuantity();
						}
					 %>
				     <i id="right-chart3" class="iconfont">&#xe600;</i>
					 <i id="num" class="iconfont" style="position:relative;top: 42px;left:7px;color: white;"><%=totalShopCarProduct %></i>
					<i id="right-chart4" class="iconfont">&#xe61b;</i>
					<i id="right-chart5" class="iconfont">&#xe660;</i>
					<i id="right-chart6" class="iconfont">&#xe608;</i>
					<i id="right-chart7" class="iconfont">&#xe63f;</i>
				</div>
			</div>
			</div>
		<div style="background-color: white;height: 50px;">
			<div style="background: black;height:40px;position: relative;">

		       	<ul class="menu1"style="position: relative;left: 5%;top:5px">
			
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
		    <div style="height: 30px;width: 120px;background: black;float:right;position: relative;right: 70px;">
		    	<img src="img1/z_01new-1.jpg"/>
		    	<img src="img1/z02.jpg"/>
		    	<img src="img1/z03.jpg"/>
		    </div>
              </div>
		    </div>
		</div>	    
		    
		<div style="height: 500px;width: 100%;">
		
		    
           <div style="width:200px;height:490px;position: relative;left: 5%;float: left;">
           	<div id="menu123">
           		<div style="height: 30px;background-color: white;">
           				<h3>全部分类</h3>
           		</div>
           		
           		<div style="height: 80px;">
           				<h3>推荐品牌</h3>
									<ul>
									<li>
										<a target="_blank" href="#">欧莱雅 </a>
									    <a target="_blank" href="#"> 菲诗小铺 </a>
								        <a target="_blank" href="#"> 雅诗兰黛 </a>
									    <a target="_blank" href="#"> 韩束 </a>
							
									</li>
							           <li>
										 <a target="_blank" href="#"> 倩碧</a>
										 <a target="_blank" href="#"> 雅顿</a>
										  <a target="_blank" href="#">佰草集 </a>
									</li>
                            	</ul>
           		</div>
           		<div style="height: 80px;">
           				<h3>护肤</h3>
									<ul>
									<li>
										<a target="_blank" href="#">洁面</a>
									    <a target="_blank" href="#"> 化妆水</a>
								        <a target="_blank" href="#"> 精华 </a>
									    <a target="_blank" href="#"> 乳液 </a>
									     <a target="_blank" href="#"> 面霜 </a>
							
									</li>
							           <li>
										 <a target="_blank" href="#"> 眼霜</a>
										 <a target="_blank" href="#"> 面膜</a>
										  <a target="_blank" href="#">护肤套装 </a>
									</li>
                            	</ul>
           		</div>
		  
			     <div style="height: 80px;">
           				<h3>彩妆</h3>
									<ul>
									<li>
										<a target="_blank" href="#">卸妆</a>
									    <a target="_blank" href="#"> 防晒</a>
								        <a target="_blank" href="#">BB霜</a>
									    <a target="_blank" href="#"> 粉饼 </a>
									     <a target="_blank" href="#"> 眼影 </a>
							
									</li>
							           <li>
										 <a target="_blank" href="#"> 睫毛膏</a>
										 <a target="_blank" href="#"> 唇彩</a>
										  <a target="_blank" href="#">晒红 </a>
										    <a target="_blank" href="#">彩妆套装 </a>
									</li>
                            	</ul>
           		</div>
		  
			     <div style="height: 80px;">
           				<h3>香氛</h3>
									<ul>
									<li>
										<a target="_blank" href="#">女士香水</a>
									    <a target="_blank" href="#"> 男士香水</a>
								        <a target="_blank" href="#"> 中性香水 </a>
							
									</li>
							           <li>
										 <a target="_blank" href="#"> Q版香水</a>
										  <a target="_blank" href="#">香水套装 </a>
									</li>
                            	</ul>
           		</div>
			  
			</div>	
	       </div>
          	<div class="luanhuang">
          		<div id="photo" class="photo">
			<ul id="pic">
				<li><img src="img1/191778_675_435_002-web.jpg"style="height: 500px;width: 700px;"/></li>
				<li><img src="img1/191786_675_435_002-web.jpg"style="height: 510px;width: 700px;"/></li>
				<li><img src="img1/191790_675_435_002-web.jpg"style="height: 510px;width: 700px;"/></li>
			</ul>
			<ol id="list">
				<li class="active">相宜本草</li>
				<li >自然堂</li>
				<li>曼秀雷敦</li>
			</ol>
			
		         </div>
          		
          	</div>
          
          <div class="xiaotu">
          	<a target="_blank" href=""><img src="img1/191918_212_145_002-web.jpg"style="height: 165px;width:250px;"/></a>
          <a target="_blank" href=""><img src="img1/191906_212_145_002-web.jpg"style="height: 165px;width:250px;"/></a>	
          	<a target="_blank" href=""><img src="img1/191832_212_145_002-web.jpg"style="height: 160px;width:250px;"/></a>
          </div>
   
         </div> 
       </div>
  
  
        <div class="jinxuan"style="text-align: center;height:60px;text-align:30px;font-size: 25px;">
            <div style="position: relative;top:15px;color:grey">
            		精选活动  ACTIVITY
            </div>
        
        </div> 
        
        
        <!-- 主页商品展示！ -->  
  <% 
	   List<Category> listCategory =  ( List<Category>)request.getAttribute("listCategory");
	   for(int i=0;i<listCategory.size();i++){
		   int cid = listCategory.get(i).getCid();
		   String cname = listCategory.get(i).getCname();
		   String cdec = listCategory.get(i).getCdec();
		   int price = listCategory.get(i).getPrice();
		   String version = listCategory.get(i).getVersion();
		   int ground = listCategory.get(i).getGround();
		   int quantity = listCategory.get(i).getQuantity();
		   String ps = listCategory.get(i).getPsPath();
   %>
        	<div class="ongoing">
        		<a href="HeadMainPage?target=productMessagePage&cid=<%=cid %>" target="_blank">
        				<img src="<%=ps%>"/>
        		</a>
        		<div class="left-1">
        			<p class="left-titie"><%=cname%></p>
        			<p class="left-title-1"><%=cdec%></p>
        		    <p class="left-title-2">
        		`    	<em>￥<%=price%></em>
        		    	<b>满<em>88</em>赠洁颜油</b>赠洁颜油 &nbsp;&nbsp;&nbsp;
        		    	<a href="HeadMainPage?target=addShopCar&id=<%=cid %>" > 
        		    	<input type="hidden" value="<%=cid %>" id="<%=cid %>"> 
        		    	<font color="red">加入购物车</font>
        		    	</a>
        		    </p>
        		</div>
        		
		        	<div class="right">
		        		<img src="img1/701.jpg"style="float: right;"/>
		        	</div>
        	</div>
        	<%} %>>
        
        
        
      <!-- ############################################################################## -->
        <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	  <script type="text/javascript">
	  	 //Ajax提示商品加入购物车是否成功
  		 function addShopCar(){
			//创建xmlHttpRequest对象，前面没有var，说明是全局变量
			xmlHttpRequest = new XMLHttpRequest();
			//设置回调函数，函数中没有括号
			xmlHttpRequest.onreadystatechange=callback;
			//设置xmlHttpRequest对象的参数以及请求头
			var url="HeadMainPage?target=addShopCar";//请求的url
			xmlHttpRequest.open("post", url);
			//采用post方式请求需要设置请求头
			xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//发送HTTP请求
			$()
			xmlHttpRequest.send(data);
		}
			
		function callback(){
			if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
				//异步调用返回的数据
				var data = xmlHttpRequest.responseText;
				if($.trim(data)=="false"){
				    alert("加入购物车失败！")
				}else{
					alert("已成功加入购物车，亲！在购物车等你哦")
				}
			}
		}
		
		
		
		  var search;
		 window.onload=function(){
		  search = document.getElementById("search")
		  search.onfocus=checkIn;
		  search.onblur=checkOut;
		  
	      var photo=document.getElementById('photo');
	      var pic=document.getElementById('pic');
	      var list=document.getElementById('list').getElementsByTagName('li');
	      var  index=0;
	      var timer=null;
	 
	      // 定义并调用自动播放函数
	      if(timer){
	          
	          clearInterval(timer,null);
	          //timer=null;
	      }
	 	 timer=setInterval(autoplay,5000);
	      // 定义图片切换函数
	      function autoplay(){
	          index++;
	          if(index>=list.length){
	              index=0;
	          }
	         changeoptions(index);
	    
	      }
	      
	    // 鼠标划过整个容器时停止自动播放
		photo.onmouseover=function(){
	    
	    clearInterval(timer);
		
		}
	     // 鼠标离开整个容器时继续播放至下一张
	    photo.onmouseout=function(){
		   timer=setInterval(autoplay,5000);
		}
	     // 遍历所有数字导航实现划过切换至对应的图片
		for(var i=0;i<list.length;i++){
			 list[i].id=i;
			 list[i].onmouseover=function(){
				 clearInterval(timer);
				 changeoptions(this.id);
				 
				 }
			 }
			function changeoptions(curindex){
				for(var j=0;j<list.length;j++){
	              list[j].className='';
	              pic.style.top=0;
	              
	          }
	          list[curindex].className='active';
	          pic.style.top=-curindex*515+'px';
			  index=curindex;
			} 
	   }
		
		
		function checkIn(){
			if(search.value=="保湿"){
				search.value="";
			}
		}
		function checkOut(){
				if(search.value==""){
					search.value="保湿";
				}
		}
	  	</script>    
        
        
        
    
        	
  <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ -->
  
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
			
			/*全部分类*/
			#menu123 {
				width: 188px;
				height: 480px;
				border: 1px solid deeppink;
				float: left;
				border-top: none;
				position: relative;
				left: 8px;
				background-color: white;
			}
			/*垂直菜单开始*/
			
			#menu123 h3 {
				border-bottom: 1px solid #EEEEEE;
				font-size: 16px;
				width: 187px;
				background-color: white;
			}
			
			#menu123 ul {
				float: left;
				padding: 0px 2px 8px;
				background-color: white;
			}
			
			#menu123 li {
				color: #AEADAE;
				float: left;
				height: 24px;
				line-height: 24px;
				font-size: 12px;
				width: 180px;
				overflow: hidden;
				position: relative
			}
			
			#menu123 li a {
				color: #444444;
			}
			
			#menu123 li a:hover {
				color: #e4393c;
			}
		
			/*垂直菜单结束*/
				
				
			.luanhuang{
				width: 700px;
				height: 500px;
				float: left;
				position: relative;
				left: 90px;
				
				
			}
		
		.photo{
				height: 500px;
				width: 100%;
				overflow: hidden;
				position: relative;

			}
			.photo ul{
				position:absolute;
			}
			.pnoto ul li{
				height: 500px;
			}
			.photo ol {
				position: absolute;
				left: 3px;
				bottom: 0px;
				list-style: none;
				background:none ;
			}
			.photo ol li{
				height: 30px;
				width:60px;
				margin-left: 15px;
				text-align: center;
			    line-height: 30px;
			    float: left;
			    color: white;
			    font-size: 12px;
			    list-style: none;
			    background:no-repeat;
			    
			 
			}
			.photo ol li.active{
				background-color: #6495ED;
				color: #FFFFFF;
				list-style: none;

			}
			.xiaotu{
				width: 210px;
				height:500px;
				float: left;
				position: relative;
				left: 95px;
				
			}
			
			/*精选活动*/
			.img-photo{
				width: 1100;
			
			}
			.ongoing{
				    width: 535px;
					height: 360px;
					margin-right: 20px;
					margin-bottom: 18px;
					box-shadow: 1px 1px 4px #e3e3e3;
					background-color: #FFF;
					float: left;
					list-style: none;
					color: black;
					position: relative;
					left: 120px;
			}
           .left-1{
           	padding-left: 22px;
            padding-top: 20px;
            float: left;
            background: white;
           }
           .left-titie{
           font-size: 16px;
			font-weight: 700;
			color: #333;
			line-height: 16px;
			background: white;
           }
           .left-title-1{
           	color: #7c7c7c;
			font-size: 14px;
			line-height: 28px;
			margin-bottom: 6px;
			background: white;
           }
           .left-title-2{
           	line-height: 16px;
			font-size: 14px;
			color: #222;
			font-weight: 700;
			background: white;
           }
			.left-title-2 em{
				color: #ed145b;
				font-size: 20px;
				font-weight: 700;
				font-style: normal;
				line-height: 16px;
				background: white;
			}
			
	

			
		</style>
		
	
  
  		
  </body>
</html>
