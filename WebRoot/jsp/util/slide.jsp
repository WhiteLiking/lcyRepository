<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'slide.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
/******************************************************************************/
			//定义一个变量赋值1，默认图片从第一张开始播放
			var nowshow = 1;
			//主函数
			window.onload=function(){
				//调用图片幻灯片的函数
				show();
			}
			
/***************************方法***********************************************/				
			//定义一个函数
			function show(index){
				//当这个函数有参数传入时（即当有鼠标放在下方数字上时），关闭定时器，并让当前图片显示，
				if(Number(index)){
					clearTimeout(sid);
					nowshow = index;
				}
				//循环
				for(var i=1;i<9;i++){
					if(i==nowshow){
						document.getElementById("img"+nowshow).style.display = 'block';
					}else{
						document.getElementById("img"+i).style.display = 'none';
					}
				}
				//当播放到最后一张图片时，又从第一张开始循环播放
				if(nowshow==8){
					nowshow = 1;
				}else{
					nowshow++;
				}
				//利用定时函数，没两秒播放一次
				sid = setTimeout('show()',2000); 
			}

		</script>

  </head>
  
  <body>
   
   	<div>
		<div>
			<img src="img/1.jpg" id="img1"/>
			<img src="img/2.jpg" id="img2"/>
			<img src="img/3.jpg" id="img3"/>
			<img src="img/4.jpg" id="img4"/>
			<img src="img/5.jpg" id="img5"/>
			<img src="img/6.jpg" id="img6"/>
			<img src="img/7.jpg" id="img7"/>
			<img src="img/8.jpg" id="img8"/>
		</div>
		<div>
			<a onmouseover="show(1)"><span>1</span></a>
			<a onmouseover="show(2)"><span>2</span></a>
			<a onmouseover="show(3)"><span>3</span></a>
			<a onmouseover="show(4)"><span>4</span></a>
			<a onmouseover="show(5)"><span>5</span></a>
			<a onmouseover="show(6)"><span>6</span></a>
			<a onmouseover="show(7)"><span>7</span></a>
			<a onmouseover="show(8)"><span>8</span></a>
		</div>
	</div>
		
  </body>
</html>
