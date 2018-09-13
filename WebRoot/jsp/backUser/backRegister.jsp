<%@ page language="java" import="java.util.*,com.vo.Manager" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'backLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  
  
  <div class="header_container">
			<div id="logo">
				<a id="home"><img src="img/logo_new_v1.jpg" /></a>
				<div class="head_loge_box">
					<a class="top_link1" href=""></a>
					<a class=" top_link2" ></a>
					<a class="top_link3" ></a>
					
				</div>
			</div>
  <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	  		<script type="text/javascript">
	  		 function register(){
			//创建xmlHttpRequest对象，前面没有var，说明是全局变量
			xmlHttpRequest = new XMLHttpRequest();
			//设置回调函数，函数中没有括号
			xmlHttpRequest.onreadystatechange=callback;
			//设置xmlHttpRequest对象的参数以及请求头
			var url="backLoginAndRegister";//请求的url
			xmlHttpRequest.open("post", url);
			//采用post方式请求需要设置请求头
			xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//发送HTTP请求
			var $name = $(".dynamic1").val();
			var $passward = $(".dynamic2").val();
			var data = "target=register&"+ "uname="+$name+"&passward="+$passward;
			xmlHttpRequest.send(data);
		}
			
		function callback(){
			if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
				//异步调用返回的数据
				var data = xmlHttpRequest.responseText;
				$("#promt").html(data);
			}
		}
	  		
         function change_urlknet(eleId){
             var str=document.getElementById(eleId).href;
             var str1=str.substring(0,(str.length-6));
             str1+=RndNum(6);
             document.getElementById(eleId).href=str1;
         }
         function RndNum(k){
             var rnd="";
             for (var i=0;i<k;i++) {
                 rnd+=Math.floor(Math.random()*10);
             }
             return rnd;
         }
        </script>
		</div>
		<div class="sign">
			<div class="logn_wrap">
				<div class="logoPic">
					<a href=""></a>
					<div class="login_bord">
						<div class="loginTit">
							<div class="tosignup">已有账号<a href="/myProductManager/jsp/backUser/backLogin.jsp" style="color: red; text-decoration:none;" >再此登陆</a> </div>
							<h1>
							<Strong>注册聚美</strong>
						</h1>
						</div>
						<div>
						<% Manager promt = (Manager)request.getAttribute("promt");
							if(promt==null){
								promt=new Manager();
								promt.setCname("");
							}
						 %>
						<form id="phone" method="post" action="backLoginAndRegister?target=register">
							<div class="textbox_ui user">
								<input type="text" class="dynamic1" placeholder="请输入的用户账号" name="uname" />
							</div>
							<div class="textbox_ui user">
								<input type="password" class="dynamic2"  name="upassward"/>
							</div>
							<p> 
							<label>
								<font color="red" size="2px"><%=promt.getCname() %></font>
							</label>
							</p>
							<input type="submit" class="loginbtn submit_btn" value="注 册" style=" display: block;width: 100%;"  >
						</form>
							<div class="iconAccout">
                    <div>你也可以使用以下帐号登录</div>
                    <p>
                        <a href="/i/extconnect/?site_name=cb_qq&amp;redirect=http%3A%2F%2Fbj.jumei.com%2F" class="a1" title="QQ">QQ</a>
                        <a href="/i/extconnect/?site_name=alipay&amp;redirect=http%3A%2F%2Fbj.jumei.com%2F" class="a2" title="支付宝">支付宝</a>
                        <a href="/i/extconnect/?site_name=sina_weibo&amp;redirect=http%3A%2F%2Fbj.jumei.com%2F" class="a3" title="新浪微博">新浪微博</a>
                        <a href="/i/extconnect/?referer=360tuan_dh&amp;site_name=site_360&amp;redirect=http%3A%2F%2Fbj.jumei.com%2F" class="a4" title="360">360</a>
                        <a href="/i/extconnect/?site_name=baidu&amp;redirect=http%3A%2F%2Fbj.jumei.com%2F" class="a5" title="百度">百度</a>
                        <span>更多<i></i></span>
                    </p>
                    <p class="icon-p" style="display: none;">
                        <a href="/i/extconnect/?site_name=weixin&amp;redirect=http%3A%2F%2Fbj.jumei.com%2F" class="a6" title="微信">微信</a>
                        <a href="/i/extconnect/?site_name=renren&amp;redirect=http%3A%2F%2Fbj.jumei.com%2F" class="a7" title="人人">人人</a>
                        <a href="/i/extconnect/?site_name=tuan800&amp;redirect=http%3A%2F%2Fbj.jumei.com%2F" class="a9" title="团800">团800</a>
                    </p>
                </div>
						
						<div>
					</div>
				</div>
				
				
				</div>
			
		</div>
		</div>
		</div>
		
		<div id="footer_container" class="footer_white" style="padding-top:5px;background: none;border-top: none;">
    <div class="footer_con" id="footer_copyright">
        <p class="footer_copy_con">
            Copyright © 2010-2015 北京创锐文化传媒有限公司 Jumei.com 保留一切权利。客服热线：400-123-8888 <br>
            京公网安备 11010102001226 号 | <a href="http://www.miibeian.gov.cn" target="_blank" rel="nofollow">京ICP证111033号</a> | 食品流通许可证 SP1101051110165515（1-1）
            | <a href="http://mp5.jmstatic.com/mobile/pc/chuangrui.jpg" target="_blank" rel="nofollow">营业执照</a>
            | <a href="http://f1.jmstatic.com/static_account/dist/v1.0.85067/images/other/zhidu.pdf" target="_blank" rel="nofollow">公示制度</a>
        </p>
        <p>
            <a href="javascript:void(0)" class="footer_copy_logo logo01" rel="nofollow"></a>
            <a href="https://www.itrust.org.cn/yz/pjwx.asp?wm=1693268180" target="_blank" class="footer_copy_logo logo02" rel="nofollow"></a>
            <a href="javascript:void(0)" class="footer_copy_logo logo03" rel="nofollow"></a>
            <a href="javascript:void(0)" class="footer_copy_logo logo04" rel="nofollow"></a>
            <a href="https://ss.cnnic.cn/verifyseal.dll?sn=e12070911010031011307708&amp;ct=df&amp;pa=453163" target="_blank" class="footer_copy_logo logo05" rel="nofollow"></a>
        </p>
        
       
    </div>
</div>
       
       
       
       
       
       
       
       
        <script>
         function change_urlknet(eleId){
             var str=document.getElementById(eleId).href;
             var str1=str.substring(0,(str.length-6));
             str1+=RndNum(6);
             document.getElementById(eleId).href=str1;
         }
         function RndNum(k){
             var rnd="";
             for (var i=0;i<k;i++) {
                 rnd+=Math.floor(Math.random()*10);
             }
             return rnd;
         }
        </script>
    </div>
</div>
   
   
   
   
   
 <!-- ######################################################################################## -->
  <style type="text/css">
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
   .logn_wrap{
   	width: 960px;
   	margin: 100px auto;
   	height: 480px;
   }
   .logoPic{
   	background: url(img/signPic.png)no-repeat;
   	width: 960px;
   	height: 360px;
   	position: relative;
   }
   .logoPic >a{
   	width:420px ;
   	height: 370px;
   	display: block;
   	
   }
   
   	 .login_bord {
	-webkit-box-shadow: 0 0 4px rgba(0,0,0,.075);
	box-shadow: 0 0 4px rgba(0,0,0,.075);
	background: rgba(255,255,255,.85);
	border: 1px solid #ededed;
	position: absolute;
	min-height: 400px;
	padding: 0 23px;
	width: 340px;
	color: #333;
	top: -60px;
	right: 0;
}
   	.loginTit{
   		line-height: 60px;
   		margin-bottom: 15px;
   		height: 60px;
   		
   	}
   .tosignup{
   	float:right;
   	color: #969696;
   	
   }
   .sign h1 {
	font-family: "Microsoft YaHei","微软雅黑","黑体";
}
.loginTit h1 {
	font-weight: 400;
	font-size: 20px;
	color: #e31256;
}
.dynamic{
	padding-left: 38px;
	width: 252px;
}

/*底部开始*/
元素 {
	padding-top: 5px;
	background: none;
	border-top: none;
}
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
  </body>
</html>
