<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 所有的连接前面加上以下代码 -->
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>国科拜欧采购计划系统</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />
<link href="/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="/css/style-metro.css" rel="stylesheet" type="text/css" />
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<link href="/css/style-responsive.css" rel="stylesheet" type="text/css" />
<link href="/css/default.css" rel="stylesheet" type="text/css"
	id="style_color" />
<link href="/css/uniform.default.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="/css/jquery.gritter.css" rel="stylesheet" type="text/css" />
<link href="/css/daterangepicker.css" rel="stylesheet" type="text/css" />
<link href="/css/fullcalendar.css" rel="stylesheet" type="text/css" />
<link href="/css/jqvmap.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="/css/jquery.easy-pie-chart.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="/css/pageStyle.css" rel="stylesheet" type="text/css"
	media="screen" />
<!-- END PAGE LEVEL STYLES -->
<link rel="shortcut icon" href="/image/favicon.ico" />
<style>
.active {
	background-color: gray;
}

.alarm {
	color: red;
}

.ycy {
	width: 70px;
	height: 30px;
	font-size: 15px;
	line-height: 20px;
	display: inline-block;
	text-align: center;
}

.table th, .table td {
	text-align: center;
	vertical-align: middle !important;
}
</style>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<%
		String id = request.getParameter("id");
	%>
	<!-- BEGIN HEADER -->
	<div class="header navbar navbar-inverse navbar-fixed-top">
		<!-- BEGIN TOP NAVIGATION BAR -->
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- BEGIN LOGO -->
				<a class="brand" href="index.html"> </a> <a href="javascript:;"
					class="btn-navbar collapsed" data-toggle="collapse"
					data-target=".nav-collapse"> <img src="/image/menu-toggler.png"
					alt="" />
				</a>
				<!-- END RESPONSIVE MENU TOGGLER -->
				<!-- BEGIN TOP NAVIGATION MENU -->
				<ul class="nav pull-right">
					<li class="dropdown user"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <span class="username">${sessionScope.user.realName}</span>
							<i class="icon-angle-down"></i>
					</a>
						<ul class="dropdown-menu">
							<!--  <li>
                            <a href="#"><i class="icon-user"></i> 我的资料</a>
                        </li> -->
							<li><a href="outlogin.novo"><i class="icon-key"></i>
									退出登陆</a></li>
						</ul></li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
				<!-- END TOP NAVIGATION MENU -->
			</div>
		</div>
		<!-- END TOP NAVIGATION BAR -->
	</div>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			<ul class="page-sidebar-menu">
				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
				<li>
					<form class="sidebar-search">
						<!-- <div class="input-box">
                        <a href="javascript:;" class="remove"></a>
                        <input type="text" placeholder="搜索功能" />
                        <input type="button" class="submit" value=" " />
                    </div> -->
					</form>
				</li>
				<li class="" id="li1"><a href="javascript:gomain();"> <i
						class="icon-home"></i> <span class="title">首页</span> <!--  <span class="arrow "></span> -->
				</a></li>
				<li class="" id="li2"><a href="javascript:goplan();"> <i
						class="icon-book"></i> <span class="title">采购计划</span>
				</a></li>
				<li class="start active" id="li3"><a
					href="javascript:goshop();"> <i class="icon-cogs"></i> <span
						class="title">商品目录管理</span>
				</a></li>
				<li class="" id="li4"><a href="javascript:goshops();"> <i
						class="icon-list"></i> <span class="title">供应商管理</span>
				</a></li>
				<li class="" id="li5"><a href="javascript:goproject();"> <i
						class="icon-th"></i> <span class="title">方案管理</span>
				</a></li>
				<!-- <li class=""id="li6">
                <a href="javascript:goBaiouPlan();">
                    <i class="icon-book"></i>
                    <span class="title">拜欧采购计划</span>
                </a>
            </li>
            <li class=""id="li7">
                <a href="javascript:goBaiouProject();">
                    <i class="icon-th"></i>
                    <span class="title">拜欧方案管理</span>
                </a>
            </li> -->
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div class="page-content" id="miandiv">
			<div class="page-container g4hj984u5h0jerh04r0">
				<div class="container-fluid">
					<!-- BEGIN PAGE HEADER-->
					<div class="row-fluid">
						<div class="span12">

							<!-- BEGIN PAGE TITLE & BREADCRUMB-->

							<h3 class="page-title">比价</h3>
							<!-- END PAGE TITLE & BREADCRUMB-->
						</div>
					</div>
					<!-- END PAGE HEADER-->


					<!-- END DASHBOARD STATS -->
					<div class="clearfix"></div>
					<div class="row-fluid"></div>
				</div>
				<div class="row-fluid">
					<div class="span12" style="padding-left: 2%; padding-right: 2%">

						<!-- BEGIN PORTLET-->
						<div class="portlet paddingless">
							<div class="portlet-title line">
								<div class="caption">
									<i class="icon-bell"></i>选择商品
								</div>
							</div>
							<div class="portlet-body">
								<table class="table" id="table1">

								</table>

							</div>

							<br> <br>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<input type="hidden" value="1" id="hidden1">
	<input type="hidden" value="<%=id%>" id="hidden2" />

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<script src="/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<script src="/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="/js/jquery.blockui.min.js" type="text/javascript"></script>
	<script src="/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="/js/jquery.uniform.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="/js/app.js" type="text/javascript"></script>
	<script src="/js/index.js" type="text/javascript"></script>
	<script src="/js/echarts.common.min.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->



	<script>
		function gomain() {
			window.location.href = "getDataOfIndex.novo";
		}
		function goplan() {
			window.location.href = "buyerPlan.novo";
		}
		function goshops() {
			window.location.href = "supplierManage.novo";
		}
		function goshop() {
			window.location.href = "localGoods.novo";
		}
		function goproject() {
			window.location.href = "projectManage.novo";
		}
		var suppList;
		var userProductEntity;
		var data;
		getData();
		/*获取数据*/
		function getData() {

			var id = $("#hidden2").val();
			$.ajax({
				method : "post",
				url : "getDataByLocalGoodsId.novo",
				data : {
					"id" : id
				},
				async : true,
				success : function(userDate) {
					suppList = userDate.list1;
					userProductEntity = userDate.userProductEntity;
					data = userDate.list2;
					getTable();

				}
			});
		}
		function getTable() {
			var html1 = "", html11 = "";
			var html2 = "";
			var html = "<tr><th>商品</th><th>规格</th>";

			for (var i = 0; i < suppList.length; i++) {
				html += "<th>" + suppList[i].name + "</th>";
			}
			html += "</tr><tr><td>" + userProductEntity.comName + "</td><td>"+ userProductEntity.spec + "</td>";
			for (var j = 0; j < data.length; j++) {
				if (data[j] == null) {
					html += "<td></td>";
				} else {
					var price;
					if (data[j].updatePrice == "9999.00") {
						price = data[j].price
					} else {
						price = data[j].updatePrice
					}
					html += "<td>通用名：" + data[j].comName + "<br/>价格：" + price
							+ "<br/>库存：" + data[j].stock + "<br/>规格："
							+ data[j].spec + "</td>";
				}

			}
			html += "</tr>";
			$("#table1").html(html);
			<!--var
			miandiv = $("#miandiv");

			var miandiv_left = miandiv.offset().left;

			var all = $("div.g4hj984u5h0jerh04r0");

			var all_left = all.offset().left;

			var t1 = $("#table1");

			var t1_left = t1.offset().left;

			var left_dif = t1_left - all_left;

			t1.html(html + html11 + html1 + html2);

			all.width(t1.outerWidth() + left_dif * 2);

			miandiv.width(all.outerWidth() + all_left - miandiv_left);
			-->

		}
	</script>

</body>
</html>
