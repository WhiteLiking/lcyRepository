<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>聚美后台管理页面新</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.css" />

  </head>
  
  <body>
   <div id="logo">
				
					<img id="logoImg" src="img1/20180825132229.png" />
				
					<label id="logoLabel">聚美商城后台管理系统</label>
				
				
			</div>
 
  		<div id="middle">
		  <div id="menu">
			<ul>
			<li class="active">
				<a class="cname1" id="c" onclick="showAndHide(1)">商品管理</a>
				<div>
				<ul id="b">
					<li><a href="Manager?target=jsp/back/addProduct.jsp" target="myIframe">增加商品</a></li>
					<li><a href="Manager?target=jsp/back/deleteProduct.jsp" target="myIframe">删除商品</a></li>
					<li><a href="Manager?target=jsp/back/updateProduct.jsp" target="myIframe">修改商品</a></li>
					<li><a href="Info?target=info" target="myIframe">查看所有商品</a></li>
				</ul>
				</div>
		    </li>
		    
		         <li class="active">
				<a class="cname2" id="c" onclick="showAndHide(2)">订单管理</a>
				<div>
				<ul id="b">
					<li><a href="Info?target=lookAllOrders" target="myIframe">查看订单</a></li>
				</ul>
				</div>
			</li>	
			
			<li class="active">
				<a class="cname3" id="c" onclick="showAndHide(3)">用户管理</a>
				<div>
				<ul id="b">
					<li><a href="UserServlet?action=lookUser&requestPage=1&target=lookUser" target="myIframe">查看用户</a></li>
					<li><a href="UserServlet?action=lookUser&requestPage=1&target=updateUser" target="myIframe">修改用户</a></li>
				</ul>
			   </div>
			 </li>	
			</ul>
		</div>
			<div id="main1">
				<iframe name="myIframe" src="" scrolling="no" width="1350px" height="1350px" frameborder="0"></iframe>
			</div>
		</div>
<script src="js/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
<script src="css/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
			 window.onload = function () {
        
	    }
		function showAndHide(num){
			
			var objects = document.getElementsByClassName("cname"+num);
       		 for (var i = 0; i < objects.length; i++) {
	            var element = objects[i];
					//遍历对象，绑定点击事件方法
	            element.onclick = function () {
	                var temp = this.className;
					//替换out、in对象
	                if (temp.indexOf("out") != -1) {
	                    this.className = temp.replace(/out/, "in");
	                } else if (temp.indexOf("in") != -1) {
	                    this.className = temp.replace(/in/, "out");
	                } else {
	                    this.className = "out";
	                }
	            }
	        }
		}
			/*菜单*/
		function hideAllMenu () {
				$("#menu div").hide();
			}
			$(function() {
				//给#menu>ul>li>a 绑定事件

				$("#menu>ul>li>a").click(function() {
					
					var currentHeight = $("#menu").height();
					
					var clickedDivHeight = $(this).next().height();
					
					
					if($(this).next().is(":hidden")){//点击的li对应的菜单是隐藏的
						currentHeight = currentHeight + clickedDivHeight;
					}
					
					if(currentHeight>500){ //现在的菜单宽度 + 要显示的div宽度 >500
						//先关闭所有的
						hideAllMenu();
						$(this).next().toggle();
					}else{
						$(this).next().toggle();
					}	
				});
			});	
		</script>
		
<style type="text/css">
		  	body {
				font: 14px/100% Arial, Verdana, "宋体";
				background-color:#F9F9F9; 
			}
			
			#logo {
			
				height: 100px;
				line-height: 80px;
				text-align: center;
				background-color:#fff;
			}
			
			#logoImg {
				position:absolute;
				left:30px;
				top:0px;
			}
			
			#logoLabel {
				color:deeppink;
				font-size: 36px;
				
			}
			
			#middle {
				float:left;
				height: 500px;	
			}
				/*菜单开始*/
			#menu {
				width: 200px;
				/*height: 500px;*/
				background-color:white;
				float: left;
				
			}
			#c{
				line-height: 30px;
				width: 200px;
				color: white;
				padding:  5 67px;
				font-size: 16px;
				text-align: center;
				border-bottom: 1px solid white;
				background: deeppink;
				 text-decoration: none;
				
			}
            .active{
            	list-style:none;
            	width: 200px;
				background: white;
				position: relative;
				left: -40px;
				border-bottom: 1px solid white;
    	
            }
            	a:link {
				text-decoration: none;
			}
            #b{
            	line-height: 30px;
            	color:black;
            	list-style: none;
              text-decoration: none;
            }
            #b li{
            	width: 200px;
            	border-bottom: 1px solid gainsboro;
            	 position: relative;
				left: -40px;
            	
            }
            #b>li>a{
            	  text-decoration: none;
            	  position: relative;
				   left: 50px;
            }
             #b>li>a:hover{
             	color: red;
             }
            
            li.active>div {
				display: none;
			}
			
			#menu>ul>li>div {
				display: none;
			}
        
        /*菜单结束*/
        	
			#main1 {
				width: 1000px;
				height: 500px;
				float: left;
			    background: floralwhite;
			    position:relative;
				left:60px;
			    	
			}
			
			
			label.copyright-label {
				color:#337AB7;
				font-size:12px;
				position:relative;
				right:20px;
				top:40px;
			}
        
        
			
			.out {  }   
			.out + ul {  
			    display: block;  
			}  
			
			.in {  }  
			
			.in + ul {  
			    display: none;  
			} 
			 
		</style>	
  </body>
</html>
