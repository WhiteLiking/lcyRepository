<%@ page language="java" import="java.util.*,com.vo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML   "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<base href="<%=basePath%>">
<title>修改</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


<link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.css"/>
<style type="text/css">

body {
		background-color:#F9F9F9;
}

div.categoryClass {
	margin-bottom: 15px;
}

#categoryFieldset {
	width: 400px;
	height:360px;
	padding: 30px 50px;
	position:relative;
	top:10px;
	left:200px;
}

fieldset legend {
	font-size:20px;
	font: 16px/100% Arial, Verdana, "宋体";
}

fieldset label {
	margin-right: 50px;
	font: 16px/100% Arial, Verdana, "宋体";
}

/*bootstrap 按钮样式*/
.btn {
  display: inline-block;
  padding: 6px 12px;
  margin-bottom: 0;
  font-size: 14px;
  font-weight: normal;
  line-height: 1.42857143;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  -ms-touch-action: manipulation;
      touch-action: manipulation;
  cursor: pointer;
  -webkit-user-select: none;
     -moz-user-select: none;
      -ms-user-select: none;
          user-select: none;
  background-image: none;
  border: 1px solid transparent;
  border-radius: 4px;
}

.btn-success {
  color: #fff;
  background-color: #5cb85c;
  border-color: #4cae4c;
}

.addCategoryBtn {
	position:absolute;
	right:50px;
	bottom:50px;
}

.categoryLabel
 {
  
  padding: 0px 10px;
  font-size: 16px;
  border-radius: 3px;
}
</style>



</head>

<body>
	
	<%
		User user = (User)request.getAttribute("user");
		String requestPage = request.getParameter("requestPage");
		String searchCondition = request.getParameter("searchCondition");
		String target=request.getParameter("target");		
	 %>
				
	<form action="UserServlet" method="post" target="myIframe">

		
		<fieldset id="categoryFieldset">
		<input type="hidden" name="action" value="updateUser"/>
		<input type="hidden" name="userno" value="<%=user.getUserno()%>"/>
		<input type="hidden" name="requestPage" value="<%=requestPage%>"/>
		<input type="hidden" name="searchCondition" value="<%=searchCondition%>"/>
		<input type="hidden" name="target" value="<%=target%>"/>
			<legend>修改用户</legend>
			<div class="categoryClass">
				<label for="cname">用户名</label><input type="text"  name="username" class="categoryLabel"
					id="pname" value="<%=user.getUsername()%>"/>
				
			</div>
			
			<div class="categoryClass">
				<label for="pname">密码</label><input type="text"  name="password" class="categoryLabel"
					id="pname" value="<%=user.getPassword()%>"/>
			</div>

			<div class="categoryClass">
				<label for="price">年龄</label><input type="text"  name="age" class="categoryLabel"
					id="price" value="<%=user.getAge()%>"/>
			</div>
			
			<div class="categoryClass">
				<label for="productSum">性别</label><input type="text"  name="sex" class="categoryLabel"
					id="productSum" value="<%=user.getSex()%>"/>
			</div>
			
			<div class="categoryClass">
				<label for="dianpuName">邮箱</label><input type="text"  name="email" class="categoryLabel"
					id="dianpuName" value="<%=user.getEmail()%>"/>
			</div>
			
			<div class="categoryClass">
				<label for="pdesc">电话</label><input type="text"  name="telephone" class="categoryLabel"
					id="pdesc" value="<%=user.getTelephone()%>"/>
			</div>

		
			
			<div class="categoryClass">
				<input type="submit" class="btn btn-success addCategoryBtn" value="修改用户" />
			</div>
		</fieldset>
	</form>

<script src="css/bootstrap/js/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
<script src="css/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
