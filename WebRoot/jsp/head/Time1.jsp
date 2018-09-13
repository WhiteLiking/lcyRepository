<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>times</title>
		<script src="js/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var SysSecond;
			var InterValObj;
			$(document).ready(function() {
				SysSecond = parseInt($("#remainSeconds").html()); //这里获取倒计时的起始时间
				InterValObj = window.setInterval(SetRemainTime, 1000); //间隔函数，1秒执行
			});

			//将时间减去1秒，计算分、秒
			function SetRemainTime() {
				if(SysSecond > 0) {
					SysSecond = SysSecond - 1;
					var second = Math.floor(SysSecond % 60); // 计算秒     
					var minite = Math.floor((SysSecond / 60) % 60); //计算分

					$("#remainTime").html(minite + "分" + second + "秒");
				} else { //剩余时间小于或等于0的时候，就停止间隔函数
					window.clearInterval(InterValObj);
					//这里可以添加倒计时时间为0后需要执行的事件
				}
			}
		</script>

	</head>

	<body>

		<div id="remainSeconds" style="display:none">1200000</div>
		<div id="remainTime" style="font-size:18px;color:#f43499"></div>

	</body>

</html>