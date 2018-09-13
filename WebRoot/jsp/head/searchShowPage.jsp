<%@ page language="java" import="java.util.*,com.vo.Category" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>


  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchShowPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	 <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	  <script type="text/javascript">
	   var search;
		 window.onload=function(){
		  search = document.getElementById("search")
		  search.onfocus=checkIn;
		  search.onblur=checkOut;
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
	</head>
  
  <body>
  
  <div class="header">
			<div class="header_top">
				<div  class="header_top_box">
				  <ul class="header_top_left">
					  <li ><a>欢迎来到聚美优品！</a></li>
				 <c:if test="${empty loginUser}">
		   	 	 <li><a href="UserServlet?action=loginUI" >你好，请登录 </a></li>
			     <li><a href="UserServlet?action=registUI"  style="">免费注册 </a></li>
			    </c:if>
		   	 	  <c:if test="${not empty loginUser}"> 
			      <li><a>欢迎您 , ${loginUser.username}</a></li>
			      <li><a href="UserServlet?action=logOut" style="">退出 </a></li>
			     </c:if>
				   </ul >
					<ul class="header_top_right">
						<li><a>订单查询</a></li>
						<li><a>收藏的品牌</a></li>
						<li><a>我的聚美</a></li>
						<li><a>手机聚美</a></li>
						<li><a>口碑中心</a></li>
						<li><a>更多</a></li>
						
					</ul>
					
				</div>
				</div>
				</div>
				
			<div class="header_center">
				<div class="header_center1">
				<h1 class="logo">
	    <a style="" href="http://www.jumei.com?from=ofs_all_header_left_null_null&amp;lo=3494&amp;mat=34539" id="home" title="聚美优品"></a>
                </h1>
				<h2 class="sub_mall_logo">
	              <a >化妆品</a>
                        </h2>
                        <div class="header_searchbox">
       <!-- ********************************************************************* -->
            <form action="HeadMainPage?target=searchShow" method="post">
            
				<input class="header_search_input" name="searchBox" id="search"/>
				<input type="submit" class="searchButton" value="搜 索" style="background:deeppink;color:white;border: 1px solid deeppink;height: 35px;width:60px;"/>
				
			</form>
	<!-- ***************************************************************************** -->
			</div>
			<div class="cart_box">
				<a href="HeadMainPage?target=lookShopCar">
					<img class="cart_gif" src="img1/img/img/cart.gif"/>
					<span class="text">去购物车结算</span>
					
				</a>
			</div>
			</div>
			
			</div>
		
	
	
	
		<div class="img"><img src="img1/img/img/57b1419da4353_1920.jpg" width="1090px" height="100px"/></div>
		
		
		
	
<!-- ########################################################################################################################### -->
 <%
	   List<Category> listCategory =  ( List<Category>)request.getAttribute("listCategory");
	   if(listCategory==null){
	   		listCategory = new <Category>ArrayList();
	   }
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

	<div id="products_wrap">
		<ul>
			<li class="hai item" pid="1049746" price="399" bid="71" cid="62" search_product_type="global_mall" h_p_m_id="46199" product_type="global_mall">
                <div class="item_wrap clearfix  " style="left: -16px;">
                    <div class="item_wrap_right">
                        <div class="s_l_pic">
                        
                        <font><%=cname %></font>
                            <div class="icon_wrap clearfix">
                                <strong style="color: #ec2b8c">【海外自营】</strong>
                                
                                                            </div>
                                                        <a href="HeadMainPage?target=productMessagePage&cid=<%=cid %>" target="_blank">
                                <img original="" src="<%=ps %>" style="display: inline;" width="262" height="255">
                            </a>
                        </div>

                        <div class="s_l_name">
                            <a href="http://item.jumeiglobal.com/46199.html?from=sr_%E9%9B%85%E8%AF%97%E5%85%B0%E9%BB%9B_1_1" target="_blank">
                                                               <%=cname %>
                            </a>
                        </div>
                        <div class="s_l_view_bg">
                            <div class="search_list_price">
                                <label>¥</label>
                                <span><%=price %></span>
                                                                            <del>¥490</del>
                                                                                                                                                                            </div>
                        </div>
                        <div class="search_deal_buttom_bg clearfix">
                            <div class="search_pl">月销4620</div>
                                                    </div>
                        <div class="search_list_button">
             <a target="_blank" class="track_click  zuhe_zhifu_dingjing" title="去看看" href="HeadMainPage?target=productMessagePage&cid=<%=cid %>"></a>
                                                    </div>
                        <!--功效-->
                                                        <p class="search_list_tags">
                                                                            <span><%=cdec %></span>
                                                                            
                                                                    </p>
                                            </div>
               
               </div>
            </li>
            
            
       
		</ul>
		
		
	</div>
  
  <%} %>
  
  
  
  	<style type="text/css">
			body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, textarea, p, blockquote, th, td {
	margin: 0;
	padding: 0;
    }
			.header_top{
				height: 28px;
				border-bottom: solid 1px #e5e5e5;
				background-color: #f2f2f2;
				position:relative;
				z-index: 10px;
				
			}
			body{
				font-size:12px;
				font-family: Tahoma,Geneva,sans-serif;
				background: #f7f7f7;
			}
			
             .header_top_box {
             	width: 1090px;
	           height: 28px;
	           margin: 0 auto;
	          
	          line-height: 28px;
}
   .header_top_left >li{
  	text-decoration: none;
	float: left;
	margin-left:40px;
	
   }
   ul{
   	list-style-type: none;
   	
   }
   .header_top_right >li{
   	float: right;
	margin-right: 20px;
   	
   }
   .header_top_right a {
	color: #999;
	text-decoration: none;
}
.header_top_left li {
	color: #6c6c6c;
	float: left;
	margin-right: 20px;
}

.header_center {
				
	           height: 110px;
	           background: #fff;
	          margin: 0 auto;
	          position: relative;
	          border-bottom: solid 2px #f2f2f2;
             }
.header_center .logo {
	float: left;
	margin-top: 13px;
}.header_wide_lv2 .header_center .logo a {
	width: 126px;
	background: url(../images/fs_logo.jpg) no-repeat 0 0;
}.header_center .logo a {
	width: 165px;
	height: 85px;
	display: block;
	background: url(http://p0.jmstatic.com/templates/jumei/images/logo_new_v1.jpg) no-repeat 0 0;
	text-indent: -999em;
}
.header_center .sub_mall_logo {
	float: left;
	margin-top: 38px;
	
	
}
.sub_mall_logo{
	font-size:30px;
	color: #ed145b;
	
}
.header_searchbox{
	position:absolute;
	margin-top:30px ;
	margin-left: 300px;
	width: 512px;
}
.header_search_input{
	float: left;
	width: 408px;
	height: 34px;
    border: solid 2px #ED145B;
	
	
}
.header_search_btn{
	float:right;
	width: 100px;
	height: 38px;
	background-color: #ed145b;
	 border: solid 2px #ED145B;
}

.cart_box{
	
	position: absolute;
	margin-top: 30px;
	margin-left: 900px;
	height: 50px;
	line-height: 50px;
}
.cart_box .text {
	width: 86px;
	height: 32px;
	line-height: 32px;
	color: #666;
	overflow: hidden;
	float: left;
	padding-left: 6px;
	background: #f8f8f8;
}
a{
	display: block;
}
.img{
	width: 1090px;
	margin: 0 auto;
	
}
.header_center1{
	width: 1090px;
	margin: 0 auto;
	
}

#products_wrap {

	margin: 0 -32px 0 0;
	
	width: 1090px;
	margin: 0 auto;
	background-color: #FFFFFF;
	
	
}

#products_wrap ul li {
	
	margin: 0 20px 0 0;
	+margin: 0 20px 0 0;
	*overflow: hidden;
	/*background-color: #FFFFFF;*/


}
#products_wrap ul li {
	position: relative;
	float: left;
	display: inline;
	height: 434px;
	width: 262px;
	margin: 7px 5px;
	_display: inline-block;
	background-color: #FFFFFF;
}


.search_list_button .zuhe_zhifu_dingjing {
	width: 90px;
	height: 30px;
	background: url(img1/img/img/zuhe_zhifu_dingjing.jpg) no-repeat left center;
	display: inline-block;
	cursor: pointer;
}
a {
	color: #ed145b;
	text-decoration: none;
}

		</style>
  </body>
</html>
