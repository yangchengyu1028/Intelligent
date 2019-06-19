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
<title>国科拜欧采购计划系统-商家后台</title>
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
.ycy {
	width: 60px;
	height: 30px;
	line-height: 30px;
	display: inline-block;
	text-align: center;
}

.active {
	background-color: gray;
}

.alarm {
	color: red;
}

.div {
	width: 80px;
	height: 10px;
}

.table th, .table td {
	text-align: center;
	vertical-align: middle !important;
}

#loading {
	width: 100%;
	position: fixed;
	top: 0px;
	left: 0;
	overflow: hidden;
	display:;
	background: rgba(60, 60, 60, 0.6);
	z-index: 2;
}

.jobSync {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
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
						data-toggle="dropdown"> <span class="username">${sessionScope.supplier.name}</span>
							<i class="icon-angle-down"></i>
					</a>
						<ul class="dropdown-menu">
							<!-- <li>
                            <a href="#"><i class="icon-user"></i> 我的资料</a>
                        </li> -->
							<li><a href="outloginOfSeller.novo"><i class="icon-key"></i>
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
				<li class="start active" id="li3"><a
					href="javascript:goshops();"> <i class="icon-cogs"></i> <span
						class="title">商品目录管理</span>
				</a></li>
				<!-- <li class=""id="li4">
                <a href="javascript:goshop();">
                    <i class="icon-list"></i>
                    <span class="title">下游买家管理</span>
                </a>
            </li>
             <li class=""id="li6">
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
			<div class="page-container" style="height: 100%">
				<div class="container-fluid">
					<!-- BEGIN PAGE HEADER-->
					<div class="row-fluid">
						<div class="span12">

							<!-- BEGIN PAGE TITLE & BREADCRUMB-->

							<h3 class="page-title">商品目录管理</h3>
							<!-- END PAGE TITLE & BREADCRUMB-->
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<!-- BEGIN ALERTS PORTLET-->
							<div class="portlet">
								<div class="portlet-title">
									<div class="caption">
										<i class="icon-cogs"></i>查询
									</div>
									<div class="tools">
										<a href="javascript:;" class="collapse"></a>
									</div>
								</div>
								<div class="portlet-body">
									<div class="">
										<span class="ycy">内部编码</span> <input type="text"
											class="span2 m-wrap" id="erpNo" value=""> <span
											class="ycy">商品名称</span> <input type="text"
											class="span2 m-wrap" id="comName" value=""> <span
											class="ycy">厂家</span> <input type="text" class="span2 m-wrap"
											id="produceFact" value=""> <span class="ycy">批文</span>
										<input type="text" class="span2 m-wrap" id="licenseNo"
											value=""><br> <span class="ycy">规格</span> <input
											type="text" class="span2 m-wrap" id="spec" value="">

										<button type="submit" class="btn blue" id="findlikeBtn">查询</button>
									</div>
								</div>
							</div>

							<!-- END ALERTS PORTLET-->
						</div>
					</div>
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
									<i class="icon-bell"></i>商品列表
								</div>
								<div class="tools">
									<!--<a href="" class="collapse"></a>
                                <a href="#portlet-config" data-toggle="modal" class="config"></a>-->
								</div>
							</div>
							<div class="portlet-body">
								<!--BEGIN TABS-->
								<div class="tabbable tabbable-custom">
									<ul class="nav nav-tabs">
										<li class="active"><a href="" data-toggle="tab"
											id="relevanced" index="1">可出售商品</a></li>
										<li><a href="" data-toggle="tab" id="norelevance"
											index="0">不可出售商品</a></li>
									</ul>
								</div>
								<div class="portlet-body">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>平台编码</th>
												<th>商品内部编码</th>
												<th>商品名称</th>
												<th>规格</th>
												<th>厂家</th>
												<th>批准文号</th>
												<th>效期</th>
												<th>标准价格</th>
												<th>出售价格</th>
												<th>库存</th>
												<th>状态</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="tbody">

										</tbody>
									</table>
								</div>
							</div>
							<br> <br>
							<div class="row-fluid">
								<div class="span6">

									<div class="btn-group">
										<button class="btn dropdown-toggle" data-toggle="dropdown">
											导入商品 <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><button data-target="#myModa1" data-toggle="modal"
													class="btn" style="width: 172px; padding-right: 100px">导入数据</button></li>
											<li><button id="export1" class="btn" style="width: 172px; padding-right: 100px">导出模板</button></li>
										</ul>
									</div>
									<div class="btn-group">
										<button class="btn dropdown-toggle" data-toggle="dropdown">
											导入不可售商品 <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><button data-target="#myModa2" data-toggle="modal"
													class="btn" style="width: 172px; padding-right: 100px">导入数据</button></li>
											<li><button id="export2" class="btn" style="width: 172px; padding-right: 100px">导出模板</button></li>
										</ul>
									</div>

								</div>

								<div class="span6" style="padding-left: 0%; padding-right: 0%">
									<button class="btn" id="firstpage_btn">首页</button>
									<button class="btn" id="pre_btn">上一页</button>
									<input type="text"
										style="margin-top: 1%; width: 30px; margin-left: 1%"
										id="pageNo" value="1" />/ <span id="totalPage">5</span>
									<button class="btn" id="jumppage_btn">GO</button>
									<button class="btn" id="nextpage_btn">下一页</button>
									<button class="btn" id="endpage_btn">尾页</button>
								</div>



								<!-- Modal -->
								<div class="modal fade pageStyle" id="myModa" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
									hidden="hidden" style="width: 500px">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true"></button>
												<h4 class="modal-title" id="myModalLabe">修改价格</h4>
											</div>
											<div class="modal-body">
												<div class="portlet-body">
													<table class="table table-hover">
														<tbody>
															<tr>
																<td class="span2 m-wrap"><span>商品出售价格</span></td>
																<td class="span2 m-wrap"><span id="offeringPrice"></span></td>
															</tr>
															<tr>
																<td class="span2 m-wrap"><span>修改后价格</span></td>
																<td class="span4 m-wrap"><input type="text"
																	value="" class="span8 m-wrap" id="updatePrice"
																	placeholder="请输入价格"></td>
															</tr>

														</tbody>
													</table>
												</div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" id="subBtn"
													>提交</button>
												<button type="button" class="btn btn-primary" id="backBtn" data-dismiss="modal">取消</button>
											</div>

										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
								<!-- /.modal -->
								<!-- Modal -->
						<div class="modal fade pageStyle" id="myModa1" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
							hidden="hidden">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabe">导入Excel</h4>
									</div>
									<div class="modal-body">
										<form action="" method="POST" 
											ENCTYPE="multipart/form-data">
											<input type="file" name="uploadFile1" id="uploadFile1" /> 
											<br />
											<input type="button" class="btn" value="上传" id="btnOk1" /> <input
												type="button" class="btn" id="backBtn1" data-dismiss="modal" value="返回" />
											<span id="spanUp1" style="color: red;"></span>
										</form>
									</div>

								</div>
								<!-- /.modal-content -->

						</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
							<!-- Modal -->
						<div class="modal fade pageStyle" id="myModa2" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
							hidden="hidden">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabe">导入Excel</h4>
									</div>
									<div class="modal-body">
										<form  method="POST" 
											ENCTYPE="multipart/form-data">
											<input type="file" name="uploadFile2" id="uploadFile2" /> 
											<br />
											<input type="button" class="btn" value="上传" id="btnOk2" /> <input
												type="button" class="btn" id="backBtn2" data-dismiss="modal" value="返回" />
											<span id="spanUp2" style="color: red;"></span>
										</form>
									</div>

								</div>
								<!-- /.modal-content -->

						</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<input type="hidden" value="1" id="hidden1" />

	<div id="loading">
		<img class='jobSync' src="/image/loading1.gif" alt="" width="4%">
	</div>

	<!-- END FOOTER -->
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
		jQuery(document).ready(function() {

			App.init(); // initlayout and core plugins

			Index.init();

			Index.initJQVMAP(); // init index page's custom scripts

			Index.initCalendar(); // init index page's custom scripts

			Index.initCharts(); // init index page's custom scripts

			Index.initChat();

			Index.initMiniCharts();

			Index.initDashboardDaterange();

			Index.initIntro();

		});
		function goshop() {
			window.location.href = "SellerBuyerManage.novo";
		}
		function goshops() {
			window.location.href = "sellerGoodsManage.novo";
		}

		var pageNo;
		var erpNo = $("#erpNo").val();
		var comName = $("#comName").val();
		var produceFact = $("#produceFact").val();
		var licenseNo = $("#licenseNo").val();
		var spec = $("#spec").val();
		var state = $("#hidden1").val();
		var totalPage;
		$("#again").hide();
		$("#relevanced").click(function() {
			$("#hidden1").val("1");
			$("#pageNo").val("1");
			show();
		})
		$("#norelevance").click(function() {
			$("#hidden1").val("0");
			$("#pageNo").val("1");
			show();
		})
		$("#all").click(function() {
			if ($(this).is(':checked')) {
				for (var i = 0; i < checkboxes.length; i++) {
					checkboxes[i].checked = true;
				}
			} else {
				for (var i = 0; i < checkboxes.length; i++) {
					checkboxes[i].checked = false;
				}
			}
		});
		/* 利用ajax页面展示，模糊查询及分页 */
		function getVal() {
			pageNo = $("#pageNo").val();
			erpNo = $("#erpNo").val();
			comName = $("#comName").val();
			produceFact = $("#produceFact").val();
			licenseNo = $("#licenseNo").val();
			spec = $("#spec").val();
			state = $("#hidden1").val();
		};

		show();
		function show() {
			getVal();
			$
					.ajax({
						method : "post",
						url : "getProduct.novo",
						data : {
							"pageNo" : pageNo,
							"pageSize" : "10",
							"sellerProId" : erpNo,
							"comName" : comName,
							"produceFact" : produceFact,
							"licenseNo" : licenseNo,
							"spec" : spec,
							"state" : state
						},
						async : true,
						success : function(pageBean) {
							var str = "";
							var price;
							if (state == "1") {
								for (var i = 0; i < pageBean.list.length; i++) {
									if (pageBean.list[i].updatePrice == "9999.00") {
										price = pageBean.list[i].price
									} else {
										price = pageBean.list[i].updatePrice
									}
									str += "<tr><td>"
											+ pageBean.list[i].id
											+ "</td><td>"
											+ pageBean.list[i].sellerProId
											+ "</td><td>"
											+ pageBean.list[i].comName
											+ "</td><td>"
											+ pageBean.list[i].spec
											+ "</td><td>"
											+ pageBean.list[i].produceFact
											+ "</td><td>"
											+ pageBean.list[i].licenseNo
											+ "</td><td>"
											+ pageBean.list[i].expiryDate
											+ "</td><td>"
											+ pageBean.list[i].price
											+ "</td><td>"
											+ price
											+ "</td><td>"
											+ pageBean.list[i].stock
											+ "</td><td>可售</td><td>"
											+ "<input type='button' onclick='updatePrice("
											+ price
											+ ","
											+ pageBean.list[i].id
											+ ")' value='修改价格'data-target='#myModa' data-toggle='modal' class='btn'/>"
											+ "&nbsp&nbsp<input type='button' onclick='updateState1("
											+ pageBean.list[i].id
											+ ")' value='设置不可售'class='btn'/></td></tr>"

								}
							} else {
								for (var i = 0; i < pageBean.list.length; i++) {
									if (pageBean.list[i].updatePrice == "9999.00") {
										price = pageBean.list[i].price
									} else {
										price = pageBean.list[i].updatePrice
									}
									str += "<tr><td>"
											+ pageBean.list[i].id
											+ "</td><td>"
											+ pageBean.list[i].sellerProId
											+ "</td><td>"
											+ pageBean.list[i].comName
											+ "</td><td>"
											+ pageBean.list[i].spec
											+ "</td><td>"
											+ pageBean.list[i].produceFact
											+ "</td><td>"
											+ pageBean.list[i].licenseNo
											+ "</td><td>"
											+ pageBean.list[i].expiryDate
											+ "</td><td>"
											+ pageBean.list[i].price
											+ "</td><td>"
											+ price
											+ "</td><td>"
											+ pageBean.list[i].stock
											+ "</td><td>不可售</td><td>"
											+ "<input type='button' onclick='updatePrice("
											+ price
											+ ","
											+ pageBean.list[i].id
											+ ")' value='修改价格'data-target='#myModa' data-toggle='modal' class='btn'/>"
											+ "&nbsp&nbsp<input type='button' onclick='updateState2("
											+ pageBean.list[i].id
											+ ")' value='设置可售'class='btn'/></td></tr>"
								}
							}
							$("#tbody").html(str);
							$("#pageNo").val(pageBean.pageNo);
							$("#pre_btn").html(
									"<a href='javascript:left("
											+ pageBean.pageNo + ")'>上一页</a>")
							$("#nextpage_btn")
									.html(
											"<a href='javascript:right("
													+ pageBean.pageNo + ","
													+ pageBean.totalPage
													+ ")'>下一页</a>");
							$("#totalPage").text(pageBean.totalPage);
						}
					});
		}

		$("#findlikeBtn").click(function() {
			pageNo = 1;
			$("#pageNo").val(pageNo);
			show();
		})
		$("#firstpage_btn").click(function() {
			pageNo = 1;
			$("#pageNo").val(pageNo);
			show();
		});
		function left(page) {
			if (page > 1) {
				page -= 1;
			} else {
				page = 1;
			}
			$("#pageNo").val(page);
			show();
		};

		function right(page, total) {
			totalPage = total;
			if (page < total) {
				page += 1;
			} else {
				page = total;
			}
			$("#pageNo").val(page);
			show();
		};
		$("#jumppage_btn").click(function() {
			var page = $("#pageNo").val();
			var total = $("#totalPage").text();

			var reg = /^([1-9][0-9]*)$/;
			if (!reg.test(pageNo)) {
				alert("请输入正确的页码");
				return;
			}

			if (page < 1) {
				page = 1;
			}
			if (page > parseInt(total)) {
				page = total;
			}

			$("#pageNo").val(page);

			show();
		});
		$("#endpage_btn").click(function() {
			getVal();
			$("#pageNo").val($("#totalPage").text());
			show();
		})
		function updatePrice(price, id) {
			$("#offeringPrice").html(price)
			$("#subBtn").click(function() {
				var updatePrice = $("#updatePrice").val();
				if (updatePrice == "" || updatePrice == null) {
					updatePrice = "9999.00";
				}
				$.ajax({
					method : "post",
					url : "updatePrice.novo",
					data : {
						"id" : id,
						"updatePrice" : updatePrice
					},
					async : true,
					success : function(msg) {
						$("#updatePrice").val("");
						window.location.reload();
					}
				});
			})
			$("#backBtn").click(function() {
				$("#updatePrice").val("");
			})

		}
		function updateState1(id) {
			$.ajax({
				method : "post",
				url : "closeGoods.novo",
				data : {
					"id" : id
				},
				async : true,
				success : function(msg) {
					show();
				}
			});
		}
		function updateState2(id) {
			$.ajax({
				method : "post",
				url : "openGoods.novo",
				data : {
					"id" : id
				},
				async : true,
				success : function(msg) {
					show();
				}
			});
		}
		
		<!--导出商品excel模板-->
		$("#export1").click(function () {
			var url="exportSellGoodsExcel.novo";
		     window.open(url);
		});
		
		<!--导出不可售商品excel模板-->
		$("#export2").click(function () {
			var url="exportNoSellGoodsExcel.novo";
		     window.open(url);
		});
		/* 导入商品Excel */
		$("#btnOk1").click(
				function() {
					var epath = $('#uploadFile1').val();
					var formData = new FormData();
					var name = $("#uploadFile1").val();
					formData.append("file", $("#uploadFile1")[0].files[0]);
					

					if (epath == "") {
						alert('导入文件不能为空!');
						return;
					}
					if (epath.substring(epath.lastIndexOf(".") + 1)
							.toLowerCase() != "xls"
							& epath.substring(epath.lastIndexOf(".") + 1)
									.toLowerCase() != "xlsx") {
						alert('导入文件类型必须为excel!');
						return;
					}
					$("#spanUp1").html("正在导入数据，请稍后...")
					
					
					$.ajax({
						url : 'importSellGoodstExcel.novo',
						type : 'POST',
						async : true,
						data : formData,
						// 告诉jQuery不要去处理发送的数据
						processData : false,
						// 告诉jQuery不要去设置Content-Type请求头
						contentType : false,
						success : function(responseStr) {
							if(responseStr=="1"){
								show();
								$("#spanUp1").html("导入完成，请返回查看!")
							}else{
								$("#spanUp1").html("导入失败，请检查表格中是否存在空的单元格!")
							} 
						}
					});
				})
				/* 导入不可售商品Excel */
			$("#btnOk2").click(
				function() {
					var epath = $('#uploadFile2').val();
					var formData = new FormData();
					var name = $("#uploadFile2").val();
					formData.append("file", $("#uploadFile2")[0].files[0]);
					

					if (epath == "") {
						alert('导入文件不能为空!');
						return;
					}
					if (epath.substring(epath.lastIndexOf(".") + 1)
							.toLowerCase() != "xls"
							& epath.substring(epath.lastIndexOf(".") + 1)
									.toLowerCase() != "xlsx") {
						alert('导入文件类型必须为excel!');
						return;
					}
					$("#spanUp2").html("正在导入数据，请稍后...")
					
					$.ajax({
						url : "importNoSellGoodstExcel.novo",
						type : 'POST',
						async : true,
						data : formData,
						// 告诉jQuery不要去处理发送的数据
						processData : false,
						// 告诉jQuery不要去设置Content-Type请求头
						contentType : false,
						success : function(responseStr) {
							if(responseStr=="1"){
								show();
								$("#spanUp2").html("导入完成，请返回查看!")
							}else{
								$("#spanUp2").html("导入失败，请检查表格中是否存在空的单元格!")
							} 
						}
					});
				})
	</script>

</body>
</html>

