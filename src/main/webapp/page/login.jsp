<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>国科拜欧采购计划系统</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <!-- 开始必须的CSS样式 -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/style-metro.css" rel="stylesheet" type="text/css" />
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <link href="/css/style-responsive.css" rel="stylesheet" type="text/css" />
    <link href="/css/default.css" rel="stylesheet" type="text/css" id="style_color" />
    <link href="/css/uniform.default.css" rel="stylesheet" type="text/css" />
    <!-- 结束必须的CSS样式 -->
    <!-- 开始页面样式 -->
    <link href="/css/login-soft.css" rel="stylesheet" type="text/css" />
    <!-- 结束页面样式 -->
    <link rel="shortcut icon" href="/image/favicon.ico" />
</head>

<body class="login" onkeydown="keyLogin();">
<!-- 开始LOGO -->
<div class="logo">
   
</div>
<!-- 结束 LOGO -->
<!-- 开始 LOGIN -->
<div class="content">
    <!-- 开始 LOGIN FORM -->
    <form name="myform" id="userLogin" class="form-vertical login-form" onkeydown="if(event.keyCode==13){return false;}">
        <h3 class="form-title">国科拜欧采购计划系统 </h3>
        <span style="color: red;">${login_error}</span>
        <br/>
        <div class="alert alert-error hide">
            <button class="close" data-dismiss="alert"></button>
            <span>请输入用户名和密码.</span>  
        </div>
        <div class="control-group">
            <label class="control-label visible-ie8 visible-ie9">Username</label>
            <div class="controls">
                <div class="input-icon left">
                    <i class="icon-user"></i>
                    <input class="m-wrap placeholder-no-fix" type="text" placeholder="请输入账号" id="username" name="username"/>
                	<span id="nameSpan" style="background-color: red;"></span>
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label visible-ie8 visible-ie9">Password</label>
            <div class="controls">
                <div class="input-icon left">
                    <i class="icon-lock"></i>
                    <input class="m-wrap placeholder-no-fix" type="password" placeholder="请输入密码" id="password" name="password"/>
                </div>
            </div>
        </div>
        
        <div class="form-actions">
            <!-- <label class="checkbox">
                <input id="remember_password" type="checkbox"/> 记住密码
            </label> -->
            <input type="button" onclick="login()" id="btnsubmit" class="btn blue pull-right" value="登陆"/>
                 <!-- <i class="m-icon-swapright m-icon-white"></i> -->
        </div>
    </form>

</div>
<!-- 结束 LOGIN -->
<!-- 开始 COPYRIGHT -->
<div class="copyright">
    2019 &copy; 国科拜欧.
</div>
<!-- 结束 COPYRIGHT -->
<!-- 开始Javascript（放在底部节约加载时间） -->
<!-- 开始核心插件 -->
<script src="/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<!-- 重要! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="/js/jquery.cookie.min.js" type="text/javascript"></script>
<script src="/js/jquery.uniform.min.js" type="text/javascript"></script>
<!-- 结束核心插件 -->
<!-- 开始页面插件 -->
<script src="/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="/js/jquery.backstretch.min.js" type="text/javascript"></script>
<!-- 结束页面插件 -->
<!-- 开始界面脚本-->
<script src="/js/app.js" type="text/javascript"></script>
<script src="/js/login-soft.js" type="text/javascript"></script>
<!-- 结束页面脚本 -->

<script language="JavaScript">
    jQuery(document).ready(function() {
        App.init();
        Login.init();
    });
    function keyLogin(){
    	 if (event.keyCode==13)  //回车键的键值为13
    	   document.getElementById('btnsubmit').click(); //调用登录按钮的登录事件
    }
    
     function login(){
    	var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
			method : "post",
			url : "userLogin.novo",
			data : {
				"username": username,
				"password": password
			},
			async : true,
			success : function(msg) {
				if(msg=="1"){
					 window.location.href = "getDataOfIndex.novo";
				}else if(msg=="2"){
					window.location.href = "sellerGoodsManage.novo";
				}else if(msg=="3"){
					window.location.href = "adminManage.novo";
				}else{
					alert(msg);
				}
				
			}
		});
       
    }
    
    

   
</script>
<!-- 结束JavaScript代码 -->
</body>

</html>