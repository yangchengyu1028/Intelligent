<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
	<%@ page import="java.util.UUID"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 所有的连接前面加上以下代码 -->
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
UUID uuid = UUID.randomUUID();
%>
<h5>抱歉,系统繁忙,请稍候在试....</h5>
<input type="button" id="btn" value="测试" onclick="test()"/>
<input type="hidden" value="<%=uuid%>" id="hid">

				<script src="js/jquery-1.10.1.min.js" type="text/javascript"></script>                        
				<script src="js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
				<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
				<script src="js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
				<script src="js/bootstrap.min.js" type="text/javascript"></script>
				<script src="js/jquery.slimscroll.min.js" type="text/javascript"></script>
				<script src="js/jquery.blockui.min.js" type="text/javascript"></script>
				<script src="js/jquery.cookie.min.js" type="text/javascript"></script>
				<script src="js/jquery.uniform.min.js" type="text/javascript"></script>
<script>
	
	$("#btn").click(function () {
		var uuid = $("#hid").val();
		$.ajax({
			method : "post",
			url : "testr.novo",
			async : true,
			success : function(msg) {
				
			}
		});
	})

</script>
</body>
</html>