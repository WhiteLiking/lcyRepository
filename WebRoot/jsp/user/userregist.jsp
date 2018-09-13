<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhuce.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	<link rel="stylesheet" type="text/css" href="css/denglu/zhuce.css"/>  
	<style type="text/css">
		span.error{
				color: #ef7216;
				background: url(img/QQ图片20180727202332.gif) no-repeat 0px center;
				padding-left: 18px;
			}
			span.success{
				background: url(img/QQ图片20180727202235.gif) no-repeat 0px center;
				padding-left: 18px;
			}
		#inp{
		    margin-bottom: 10px 
		}
		
		/* 聚美头部 */
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
   
   /*  聚美尾部*/
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
   	<div class="header_container">
			<div id="logo">
				<a id="home"><img src="img/logo_new_v1.jpg" /></a>
				<div class="head_loge_box">
					<a class="top_link1" href=""></a>
					<a class=" top_link2" ></a>
					<a class="top_link3" ></a>
					
				</div>
			</div>
			
		</div>
	<div id="body">
			<div id="zhuce">
			    <div class="bgimge">
			  
			     </div>
	   			<div class="col-md-8" >
	   				<div class="loginTit">
							<div class="tosignup">已有账号<a style="color: #ff46af;" href="UserServlet?action=loginUI">在此登录</a></div>
							<h1>
							<Strong>聚美注册</strong>
							</h1>
					</div>
					<form id="registForm" action="UserServlet" method="post" target="mainIFrame">					
							<div id="inp">
								<label for="username">用户名</label><input type="text" name="username" id="username" class="inp" placeholder="请输入用户名" /><span></span>
							<input type="hidden" name="action" value="userRegist"/>
							</div>
							<div id="inp">					
								<label for="setpassword">设置密码</label><input type="password" name="password" id="setpassword" class="inp" placeholder="请输入用户密码" /><span></span>
							</div>
							<div  id="inp">
								<label for="topassword">确认密码</label><input type="password" name="topassword" id="topassword" class="inp" placeholder="请确认密码" /><span></span>						
							</div>
							<div id="inp">
								<label for="age">年龄</label><input class="inp" type="text" name="age" id="age" placeholder="请输入您的年龄" /><span></span>						
							</div>
							<div id="inp">
								<label for="email">性别</label><b class="bint">男</b><input id="inpt"  type="radio" name="sex" value="男" /><b class="bint">女</b><input type="radio" id="inpt"  name="sex" value="女"><span></span>
							</div>
							<div id="inp">
								<label for="email">邮箱</label><input class="inp" type="text" name="email" id="email"  placeholder="请确认您的邮箱"/><span></span>
							</div>
							<div id="inp">
								<label for="phone">手机</label><input class="inp" type="text"  id="phone" name="telephone" placeholder="请输入手机号"/><span></span>
							</div>
			   			    <div id="rgsp">
			     					 <input type="button" id="rgsbtn"  value="同意协议并注册"  >
			    			</div>
			    			 <div id="rgsp">
			    			   <a href="#" target="_blank" id="rgsa">《聚美优品用户协议》</a>
			    			 </div>
			 				
				</form>   
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
		 <script src="js/denglujs/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
		 <script type="text/javascript">
			var usernameInput;
			var setpasswordInput;
			var topasswordInput;
			var ageInput;
			var emailInput;
			var phoneInput;
			var btt;
			window.onload=function(){
				usernameInput = document.getElementById("username");
				usernameInput.onblur = checkUsername;
				usernameInput.onkeyup = checkUsername;
				
				setpasswordInput=document.getElementById("setpassword");
				setpasswordInput.onblur=checkSetpassword;
				setpasswordInput.onkeyup=checkSetpassword;
				
				topasswordInput=document.getElementById("topassword");
				topasswordInput.onblur=checkTopassword;
				topasswordInput.onkeyup=checkTopassword;
				
				ageInput = document.getElementById("age");
				ageInput.onblur = checkAge;
				ageInput.onkeyup = checkAge;
				
				emailInput = document.getElementById("email");
				emailInput.onblur = checkEmail;
				emailInput.onkeyup = checkEmail;
				
				phoneInput = document.getElementById("phone");
				phoneInput.onblur = checkPhone;
				phoneInput.onkeyup = checkPhone;
				
				
				
				 var btn1 = document.getElementById("rgsbtn");
				btn1.onclick = regist;
			}
			function trim(txt){
				var afterTrimTxt=txt.replace(/^\S*/,"").replace(/\S*$/,"");
				return afterTrimTxt;
			}
			function isEmail(email){
				var regExp= /^\w{3,25}@\w+\.(com|net|org)$/;
				var flag=regExp.test(email);
				return flag;
			}
			function isPhone(phone){
				var regExp=/^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/; 
				var ph=regExp.test(phone);
				return ph;
			}
			function isSetpssword(setpassword) { 
   				var regExp= /^[a-zA-Z0-9]{6,22}$/;
 			    var flag =regExp.test(setpassword)	;
 			    return flag;
			}	
			function checkUsername(){
				var username=usernameInput.value;
				var mySpan=usernameInput.nextSibling;
				mySpan.innerHTML="";
				if (!trim(username)=="") {
					mySpan.innerHTML="请输入用户名"
					mySpan.className="error";
				}else if(username.valueOf()==""){
					mySpan.innerHTML="用户名不能为空"
					mySpan.className="error";
				}else{
					mySpan.className="success";
				}
			}
			function checkSetpassword(){
				var setpassword=setpasswordInput.value;
				var mySpan=setpasswordInput.nextSibling;
				mySpan.innerHTML="";
				if(setpassword.valueOf()==""){
					mySpan.innerHTML="密码不能为空";
					mySpan.className="error";
				}else if (isSetpssword(setpassword)) {
					mySpan.className="success";
				} else{
					mySpan.innerHTML="密码格式不正确"
					mySpan.className="error";
				}
				btt=setpassword;
			}
			function checkTopassword(){
				var topassword=topasswordInput.value;
				var mySpan=topasswordInput.nextSibling;
				mySpan.innerHTML="";
				if(topassword.valueOf()==""){
					mySpan.innerHTML="密码不能为空"; 
					mySpan.className="error"
				}else if (isSetpssword(topassword)){
					if(topassword.valueOf()==btt.valueOf()){
						mySpan.className="success";
					}else{
						mySpan.innerHTML="两次密码不相同"; 
						mySpan.className="error"
					}
				}else{
					mySpan.innerHTML="密码格式不对"; 
					mySpan.className="error"
				
				}
			}
			function checkEmail() {

				//一.非空验证
				var email = emailInput.value;

				var mySpan = emailInput.nextSibling;

				mySpan.innerHTML = "";

				if ((!trim(email) == "")|(email.valueOf()=="")) {
					//1.提示 "邮箱不能为空"
					mySpan.innerHTML = "邮箱不能为空";
					//2.美化(加一个表示错误 的图片)
					mySpan.className = "error";
				} else if (!isEmail(email)) {
					//1.提示 "邮箱不能为空"
					mySpan.innerHTML = "邮箱格式不正确";
					//2.美化(加一个表示错误 的图片)
					mySpan.className = "error";
				} else {
					mySpan.className = "success";
				}
			}
			function checkAge() {

				//一.非空验证
				var age = ageInput.value;

				var mySpan = ageInput.nextSibling;

				mySpan.innerHTML = "";

				if (isNaN(age)) { //不是数字
					//1.提示 "年龄必须为数字"
					mySpan.innerHTML = "年龄必须为数字";
					//2.美化(加一个表示错误 的图片)
					mySpan.className = "error";
				} else if (age < 0 || age > 120) {
					//1.提示 "年龄在0-120之间"
					mySpan.innerHTML = "年龄在0-120之间";
					//2.美化(加一个表示错误 的图片)
					mySpan.className = "error";

				} else {
					mySpan.className = "success";
				}
			}
				function checkPhone() {

				//一.非空验证
					var phone = phoneInput.value;
	
					var mySpan = phoneInput.nextSibling;
	
					mySpan.innerHTML = "";
					
					if (!isPhone(phone)) { //不是数字
						//1.提示 "年龄必须为数字"
						mySpan.innerHTML = "手机格式不对";
						//2.美化(加一个表示错误 的图片)
						mySpan.className = "error";
					}else{
						mySpan.className = "success";
					}
				}
				function regist () {
					usernameInput.onblur();
					ageInput.onblur();
					emailInput.onblur();
					setpasswordInput.onblur();
					topasswordInput.onblur();
					phoneInput.onblur();
					//通过span的 error属性 的个数 判断有没有错误的信息
					var errorSpanArr = document.getElementsByClassName("error");
					
					if(errorSpanArr.length>0){//有错误的信息
						//不提交表单
					}else{
						//提交表单
						var registForm = document.getElementById("registForm");
						
						registForm.submit();
					}
				}
		</script>
  </body>
</html>
