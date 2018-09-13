<%@ page language="java" import="java.util.*,com.vo.Orders" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
	
	</script>

  </head>
  
  <body>
    <%  
    	Orders or = (Orders)session.getAttribute("ord");
    	int oid = or.getOid();
    	String userno = or.getUserno();
     %>
    <legend>修改订单</legend>
		<form action="Info?target=updateOrder&oid=<%=oid %>&userno=<%=userno %>)" method="post" >
		
		<b>商品名称：</b><input type="text" value="输入名称" name="oname"/><br />
		<b>商品单价：</b><input type="text" value="输入单价" name="price"/><br />
		<b>商品数量：</b><input type="text" value="输入数量" name="quantity"/><br />
		<b>收件人：</b><input type="text" value="输入收件人" name="name"/><br />
		<b>电话：</b><input type="text" value="电话" name="telephone"/><br />
		<b>收件地址：</b><input type="text" value="收件地址" name="address"/><br />
		<input type="submit" value="确认修改" /><font color="red" id="tip"></font>
		</form>
		</fieldset>
		
		
		<script type="text/javascript">
			var a ;
			window.onload=function(){
				a= document.getElementsByTagName("input")
				a[0].onfocus=checkIn0;
				a[0].onblur=checkOut0;
				a[1].onfocus=checkIn1;
				a[1].onblur=checkOut1;
				a[2].onfocus=checkIn2;
				a[2].onblur=checkOut2;
				a[3].onfocus=checkIn3;
				a[3].onblur=checkOut3;
				a[4].onfocus=checkIn4;
				a[4].onblur=checkOut4;
				a[5].onfocus=checkIn5;
				a[5].onblur=checkOut5;
			}

/************************************************************************/			
			function checkIn0(){
				if(a[0].value=="输入名称"){
					a[0].value="";
				}
			}
			function checkOut0(){
				if(a[0].value==""){
					a[0].value="输入名称";
				}
			}
/*************************************************************************/
			function checkIn1(){
				if(a[1].value=="输入单价"){
					a[1].value="";
				}
			}
			function checkOut1(){
				if(a[1].value==""){
					a[1].value="输入单价";
				}
			}
/*************************************************************************/
			function checkIn2(){
				if(a[2].value=="输入数量"){
					a[2].value="";
				}
			}
			function checkOut2(){
				if(a[2].value==""){
					a[2].value="输入数量";
				}
			}
/*************************************************************************/
			function checkIn3(){
				if(a[3].value=="输入收件人"){
					a[3].value="";
				}
			}
			function checkOut3(){
				if(a[3].value==""){
					a[3].value="输入收件人";
				}
			}
/**************************************************************************/
			function checkIn4(){
				if(a[4].value=="电话"){
					a[4].value="";
				}
			}
			function checkOut4(){
				if(a[4].value==""){
					a[4].value="电话";
				}
			}
/**************************************************************************/
				function checkIn5(){
				if(a[5].value=="收件地址"){
					a[5].value="";
				}
			}
			function checkOut5(){
				if(a[5].value==""){
					a[5].value="收件地址";
				}
			}
/**************************************************************************/
		</script>
  </body>
</html>
