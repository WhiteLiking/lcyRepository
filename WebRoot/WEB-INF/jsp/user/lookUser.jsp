<%@ page language="java" import="java.util.*,com.vo.*,com.page.PageInfo1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<base href="<%=basePath%>">
	<head>
		<meta charset="UTF-8">
		<title>用户查看</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="css/jQuery-confirm/jquery-confirm.css"/>
		<style type="text/css">
	
		
		
		
			body {
				background-color:#F9F9F9;
			}
			
			a:link {
				text-decoration: none;
			}
			
			
		
			tr.tableHead {
				background-color: #337AB7;
				color: #ffffff;
			}
			
			tr.tableHead>th {
				text-align: center;
				background:deeppink;
			}
			
			/*鼠标悬停的 当前行高亮*/
			/*table>tbody>tr:hover {
				background-color:#BAD0EF !important;
			}*/
			
			div.categoryTableDiv {
				width:1060px;
				margin:0px auto;
				position:relative;
				top:80px;
			}
			
			#pageDiv {
				position:absolute;
				right:0px;
			}
			
			/*一级商品种类搜索框*/
			#jdCategorySearch {
				width:500px;
				margin:0px auto;
				position:relative;
				top:50px;
				right:60px;
			}
			
		</style>
	</head>

	<body>
		<%
			PageInfo1 pageInfo1 = (PageInfo1)request.getAttribute("pageInfo1");
		 %>
	
		
		<form id="categoryForm" action="UserServlet?action=getPageByQuery&target=lookUser" method="post">
		
			<div id="jdCategorySearch" class="input-group">
					<input type="search" id="searchCondition" name="searchCondition" value='${requestScope.searchCondition}' class="form-control"/>
					
					<span class="input-group-btn">
						<input type="submit"  value="搜索" class="btn btn-default" />
					</span>
			</div>
	
		</form>
		
		<div class="text-center categoryTableDiv">

			<table id="categoryTable" class="table table-striped table-bordered table-hover">
				<thead>
					<tr class="tableHead">
						<th width="15%">用户名</th>
						<th width="15%">密码</th>
						<th width="10%">年龄</th>
						<th width="10%">性别</th>
						<th width="10%">邮箱</th>
						<th width="10%">电话</th>
						<th width="25%">激活状态</th>
						<th width="30%">激活码</th>
					</tr>
				</thead>

				<tbody>
				
					<c:forEach items="${list}" var="user">
						<tr>
							<td>${user.username}</td>
							<td>${user.password}</td>
							<td>${user.age}</td>
							<td>${user.sex}</td>
							<td>${user.email}</td>
							<td>${user.telephone}</td>
							<c:if test="${user.state==0}">
							<td>未激活</td>							
							</c:if>
							<c:if test="${user.state==1}">
							<td>已激活</td>							
							</c:if>
							<td>${user.code}</td>
						</tr>
					</c:forEach>

														
				</tbody>

			</table>

		
			<div id="pageDiv">
					
				
			<form id="categoryForm2" action="UserServlet?action=getPageByQuery&target=lookUser" method="post">
			<input type="hidden" name="searchCondition" value="${requestScope.searchCondition}"/>
	<a id="first" class="btn btn-default btn-sm" href="UserServlet?action=getPageByQuery&target=lookUser&searchCondition=${requestScope.searchCondition}&requestPage=1">首页</a>
    
    
    <a id="previous" class="btn btn-default btn-sm" href="UserServlet?action=getPageByQuery&target=lookUser&searchCondition=${requestScope.searchCondition}&requestPage=<%=pageInfo1.getPreviousPage()%>"> 上一页</a>
      <a id="next" class="btn btn-default btn-sm" href="UserServlet?action=getPageByQuery&target=lookUser&searchCondition=${requestScope.searchCondition}&requestPage=<%=pageInfo1.getNextPage()%>"> 下一页</a>
    
    
     <a id="last" class="btn btn-default btn-sm" href="UserServlet?action=getPageByQuery&target=lookUser&searchCondition=${requestScope.searchCondition}&requestPage=<%=pageInfo1.getTotalPageCount()%>">尾页</a>
    
   <span class="mySpan">
    <span>当前第<%=pageInfo1.getCurrentPage()%>页</span>
    
   <span>共<%=pageInfo1.getTotalRecordCount()%>条记录 </span>
    
    <span>共<%=pageInfo1.getTotalPageCount()%>页</span>
    
    <span>每页<%=pageInfo1.getPerPageRecordCount()%>条</span>
   
    
    <span>跳到第 </span>	
    	<select id="requestPage" name="requestPage">
    		<%
    			int TotalPageCount = pageInfo1.getTotalPageCount();
    			
    			int currentPage = pageInfo1.getCurrentPage();
    			for(int i=1;i<=TotalPageCount;i++){
    				
    				if(currentPage==i){
    					out.println("<option selected='selected'>" + i + "</option>");
    				}else{
    					out.println("<option>" + i + "</option>");
    				}
    				
    			}
    		 %>
    		
    	</select>
    	
    <span>页 </span>
   </span>
    	
    	
		</form>
			
			</div>
		</div>
		
		

		<script src="css/bootstrap/js/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
		<script src="css/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<script src="css/jQuery-confirm/jquery-confirm.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			
			$(function(){
				//对id为categoryTable表格进行隔行换色
				$("#categoryTable>tbody>tr:even").css("background-color","#fff");
				
				//给跳到第几页下拉列表框绑定事件
				$("#requestPage").change(function(){
					
					//提交请求
					$("#categoryForm2").submit();
				});
				
				//第一页时 "首页"和上一页不能用
				
				var currentPage = <%=pageInfo1.getCurrentPage()%>;
				var totalPageCount = <%=pageInfo1.getTotalPageCount()%>;
				if(currentPage==1){
					$("#first").addClass("disabled");
					$("#previous").addClass("disabled");
				}
				 if(currentPage==totalPageCount){
					//最后一页时 "下一页"和"尾页"不能能用
					$("#next").addClass("disabled");
					$("#last").addClass("disabled");
				} 
			});
			
		</script>
	</body>

</html>