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
    <link href="/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/style-metro.css" rel="stylesheet" type="text/css" />
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <link href="/css/style-responsive.css" rel="stylesheet" type="text/css" />
    <link href="/css/default.css" rel="stylesheet" type="text/css" id="style_color" />
    <link href="/css/uniform.default.css" rel="stylesheet" type="text/css" />
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link href="/css/jquery.gritter.css" rel="stylesheet" type="text/css" />
    <link href="/css/daterangepicker.css" rel="stylesheet" type="text/css" />
    <link href="/css/fullcalendar.css" rel="stylesheet" type="text/css" />
    <link href="/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="/css/pageStyle.css" rel="stylesheet" type="text/css" media="screen" />
    <!-- END PAGE LEVEL STYLES -->
    <link rel="shortcut icon" href="/image/favicon.ico" />
<style>
.ycy{
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
vertical-align: middle!important;
}

	#loading{
            width:100%;
            position:fixed;
            top:0px;
            left:0;
            overflow:hidden;
            display: ;
            background:rgba(60,60,60,0.6);
            z-index:2;
        }
	.jobSync{
            position: absolute;
            top:50%;
            left:50%;
            transform: translate(-50%,-50%);
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
            <a class="brand" href="index.html">
              
            </a>
            <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
                <img src="/image/menu-toggler.png" alt="" />
            </a>
            <!-- END RESPONSIVE MENU TOGGLER -->
            <!-- BEGIN TOP NAVIGATION MENU -->
            <ul class="nav pull-right">
                <li class="dropdown user">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="username">${sessionScope.user.realName}</span>
                        <i class="icon-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- <li>
                            <a href="#"><i class="icon-user"></i> 我的资料</a>
                        </li> -->
                        <li>
                            <a href="outlogin.novo"><i class="icon-key"></i> 退出登陆</a>
                        </li>
                    </ul>
                </li>
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
                <div class="sidebar-toggler hidden-phone"></div>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
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
            <li class="" id="li1">
                <a href="javascript:gomain();">
                    <i class="icon-home"></i>
                    <span class="title">首页</span>
                   <!--  <span class="arrow "></span> -->
                </a>
            </li>
            <li class="" id="li2">
                <a href="javascript:goplan();">
                    <i class="icon-book"></i>
                    <span class="title">采购计划</span>
                </a>
            </li>
            <li class="start active" id="li3">
                <a href="javascript:goshop();">
                    <i class="icon-cogs"></i>
                    <span class="title">商品目录管理</span>
                </a>
            </li>
            <li class=""id="li4">
                <a href="javascript:goshops();">
                    <i class="icon-list"></i>
                    <span class="title">供应商管理</span>
                </a>
            </li>
             <li class=""id="li5">
                <a href="javascript:goproject();">
                    <i class="icon-th"></i>
                    <span class="title">方案管理</span>
                </a>
            </li>
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
                            <div class="caption"><i class="icon-cogs"></i>查询</div>
                            <div class="tools">
                                <a href="javascript:;" class="collapse"></a>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="">
								<span class="ycy">ERP编号</span> <input type="text" class="span2 m-wrap"
									id="erpNo" value=""> <span class="ycy">条形码</span> <input
									type="text" class="span2 m-wrap" id="barCode" value="">
								<span class="ycy">商品名称</span> <input type="text" class="span2 m-wrap"
									id="comName" value=""> <span class="ycy">厂家</span> <input
									type="text" class="span2 m-wrap" id="produceFact" value="">
								<span class="ycy">批文</span> <input type="text" class="span2 m-wrap"
									id="licenseNo" value=""><br> <span class="ycy">规格</span> <input
									type="text" class="span2 m-wrap" id="spec" value=""> <span class="ycy">剂型</span>
								<input type="text" class="span2 m-wrap" id="drug" value="">
								<span class="ycy">标记</span> <select class="span1 m-wrap" id="signError">
									<option value="">全部</option>
									<option value="0">未标记</option>
									<option value="1">已核对</option>
									<option value="2">无数据</option>
									<option value="3">平台数据重复</option>
									<option value="4">自有数据重复</option>
									<option value="5">数据错误</option>
									<option value="6">暂不处理</option>
									<option value="7">其他</option>
								</select>
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
								<li class="active"><a href="" data-toggle="tab"id="relevanced" index="1">已关联商品</a></li>
								<li><a href="" data-toggle="tab" id="norelevance" index="3">未关联商品</a>
								</li>
							</ul>
						</div>
						<div class="portlet-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>选择</th>
										<th>ERP编号</th>
										<th>商品名称</th>
										<th>规格</th>
										<th>厂家</th>
										<th>批准文号</th>
										<th>剂型</th>
										<th>单位</th>
										<th>标记内容</th>
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
							<input type="checkbox" id="all"> <span>全选</span>
							<div class="btn-group">
								<button class="btn dropdown-toggle" data-toggle="dropdown">
									导入商品目录 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><button data-target="#myModa1" data-toggle="modal"
											class="btn" style="width: 172px; padding-right: 100px">导入商品</button></li>
									<li><button id="export1"
											class="btn" style="width: 172px; padding-right: 100px">导出模板</button></li>
								</ul>
							</div>
							<button class="btn" data-target="#myModa3" data-toggle="modal"
											class="btn">批量标记所选</button>
							<button class="btn" id="alldelBtn">删除商品</button>

						</div>

						<div class="span6" style="padding-left: 0%; padding-right: 0%">
							<button class="btn" id="firstpage_btn">首页</button>
							<button class="btn" id="pre_btn">上一页</button>
							<input type="text"
								style="margin-top: 1%; width: 30px; margin-left: 1%" id="pageNo"
								value="1" />/ <span id="totalPage">5</span>
							<button class="btn" id="jumppage_btn">GO</button>
							<button class="btn" id="nextpage_btn">下一页</button>
							<button class="btn" id="endpage_btn">尾页</button>
						</div>

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
										
										    <form action="" method="POST" id="fromImport"
											ENCTYPE="multipart/form-data">
											<input type="file" name="uploadFile" id="uploadFile" /> <br />
											<input type="button" class="btn" value="上传" id="btnOk" /> <input
												type="button" class="btn" id="backBtn1" data-dismiss="modal" value="返回" />
											<span id="spanUp" style="color: red;"></span>
										</form>

									</div>

								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->

						<!-- Modal -->
						<div class="modal fade pageStyle" id="myModa3" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
							hidden="hidden" style="width: 500px">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabe">标记错误类型</h4>
									</div>
									<div style="height: 500px">
										<div style="float: left;width: 100px;">
											<p style="padding-top: 20px;padding-left:20px;font-size: 20px">错误类型</p>
										</div>
										<div style="float: left;width: 800px">
											<br>
											<input type="radio" class="span8 m-wrap" name="radio1" value="1" checked="checked">已核对<br>
											<input type="radio" class="span8 m-wrap" name="radio1" value="2">无数据<br>
											<input type="radio" class="span8 m-wrap" name="radio1" value="3">平台数据重复<br>
											<input type="radio" class="span8 m-wrap" name="radio1" value="4">自有数据重复<br>
											<input type="radio" class="span8 m-wrap" name="radio1" value="5">数据错误<br>
											<input type="radio" class="span8 m-wrap" name="radio1" value="6">暂不处理<br>
											<input type="radio" class="span8 m-wrap" name="radio1" value="7" id="radio1">其他原因<br>	
										</div>
									</div>
									<div class="modal-footer">
                                                <button type="button" class="btn btn-default" id="subBtn3">提交</button>
                                                <button type="button" class="btn btn-primary" id="backBtn3" data-dismiss="modal">取消</button>
                               		</div>

								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
						
						<div class="modal fade pageStyle" id="myModa4" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
							hidden="hidden">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabe">商品关联</h4>
									</div>
									<div>
										<span>通用名</span> <input type="text" class="span2 m-wrap" id="comName4" value="">
										<span>批文</span> <input type="text" class="span2 m-wrap" id="licenseNo4" value="">
										<span>厂家</span> <input type="text" class="span2 m-wrap" id="produceFact4" value="">
										<span>规格</span> <input type="text" class="span2 m-wrap" id="spec4" value="">
										<button class="btn blue" id="findlikeBtn4">查询</button>
									</div>
									<div>
										<table class="table table-hover">
											<thead>
											<tr>
                                            	<th>操作</th>
												<th>ERP编号</th>
												<th>通用名</th>
												<th>规格</th>
												<th>批准文号</th>
												<th>厂家</th>
												<th>剂型</th>
												<th>单位</th>
                                            </tr>
                                            </thead>
                                           <tbody id="tbody3">
                                           
                                            </tbody>
                                        	<tbody id="tbody4">
                                           
                                            </tbody>
                                        </table>
									</div>
									<div class="modal-footer">                                              
                                                <button type="button" class="btn btn-primary" id="backBtn4" data-dismiss="modal">返回</button>
                               		</div>

								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
						
						
						<!-- Modal -->
						<div class="modal fade pageStyle" id="myModa5" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
							hidden="hidden" style="width: 500px">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabe">标记错误类型</h4>
									</div>
									<div style="height: 500px">
										<div style="float: left;width: 100px;">
											<p style="padding-top: 20px;padding-left:20px;font-size: 20px">错误类型</p>
										</div>
										<div style="float: left;width: 800px">
											<br>
											<input type="radio" class="span8 m-wrap" name="radio5" value="1" checked="checked">已核对<br>
											<input type="radio" class="span8 m-wrap" name="radio5" value="2">无数据<br>
											<input type="radio" class="span8 m-wrap" name="radio5" value="3">平台数据重复<br>
											<input type="radio" class="span8 m-wrap" name="radio5" value="4">自有数据重复<br>
											<input type="radio" class="span8 m-wrap" name="radio5" value="5">数据错误<br>
											<input type="radio" class="span8 m-wrap" name="radio5" value="6">暂不处理<br>
											<input type="radio" class="span8 m-wrap" name="radio5" value="7" id="radio1">其他原因<br>	
										</div>
									</div>
									<div class="modal-footer">
                                                <button type="button" class="btn btn-default" id="subBtn5">提交</button>
                                                <button type="button" class="btn btn-primary" id="backBtn5" data-dismiss="modal">取消</button>
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
	<input type="hidden" value="" id="hidden2" />
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
	function gomain(){
		window.location.href="getDataOfIndex.novo";
	}		
	function goplan(){
		window.location.href="buyerPlan.novo";		
	}
	function goshops(){
		window.location.href="supplierManage.novo";
	}
	function goshop(){
		window.location.href="localGoods.novo";
	}
	function goproject(){
		window.location.href="projectManage.novo";
	}

		
		var pageNo;
		var erpNo = $("#erpNo").val();
		var barCode = $("#barCode").val();
		var comName = $("#comName").val();
		var produceFact = $("#produceFact").val();
		var licenseNo = $("#licenseNo").val();
		var spec = $("#spec").val();
		var drug = $("#drug").val();
		var signError = $("#signError option:selected").val();
		var relaState = $("#hidden1").val();
		var totalPage;
		var checkboxes = document.getElementsByName("check");
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
			barCode = $("#barCode").val();
			comName = $("#comName").val();
			produceFact = $("#produceFact").val();
			licenseNo = $("#licenseNo").val();
			spec = $("#spec").val();
			drug = $("#drug").val();
			signError = $("#signError option:selected").val();
			relaState = $("#hidden1").val();
		};

		show();
		function show() {
			getVal();
					$.ajax({
						method : "post",
						url : "getGoods.novo",
						data : {
							"pageNo" : pageNo,
							"pageSize" : "10",
							"erpNo" : erpNo,
							"barCode" : barCode,
							"comName" : comName,
							"produceFact" : produceFact,
							"licenseNo" : licenseNo,
							"spec" : spec,
							"drug" : drug,
							"signError" : signError,
							"relaState" : relaState
						},
						async : true,
						success : function(pageBean) {
							var str = "";
							if (relaState == "1") {
								for (var i = 0; i < pageBean.list.length; i++) {
									str += "<tr index='"+pageBean.list[i].id
                                    						+"'><td><input type='checkbox' name='check' value='"+pageBean.list[i].id+"' />"
											+ "</td><td>"
											+ pageBean.list[i].erpNo
											+ "</td><td>"
											+ pageBean.list[i].comName
											+ "</td><td>"
											+ pageBean.list[i].spec
											+ "</td><td>"
											+ pageBean.list[i].produceFact
											+ "</td><td>"
											+ pageBean.list[i].licenseNo
											+ "</td><td>"
											+ pageBean.list[i].drug
											+ "</td><td>"
											+ pageBean.list[i].unit
											
											+ "</td><td>"
										if(pageBean.list[i].signError=="0"){str += "未标记"}	
										else if(pageBean.list[i].signError=="1"){str += "已核对"}	
										else if(pageBean.list[i].signError=="2"){str += "无数据"}
										else if(pageBean.list[i].signError=="3"){str += "平台数据重复"}
										else if(pageBean.list[i].signError=="4"){str += "自有数据重复"}
										else if(pageBean.list[i].signError=="5"){str += "数据错误"}
										else if(pageBean.list[i].signError=="6"){str += "暂不处理"}
										else{str += "其他原因"}
										str += "</td><td>已关联"
											+ "</td><td>"
											+ "<div class='btn-group'><input type='button' onclick='relevance("
											+ pageBean.list[i].id
											+ ")'class='btn btn-danger'value='修改' data-target='#myModa4' data-toggle='modal'/>"
											+ "<button type='button' class='btn btn-default btn-xs dropdown-toggle' data-toggle='dropdown'>"
											+ "<span class='caret' style='height: 8px;'></span>"
											+ "</button>"
											+ "<ul class='dropdown-menu' role='menu'>"
											+ "<li><input type='button' onclick='sign("
											+ pageBean.list[i].id
											+ ")' value='标记错误数据'data-target='#myModa5' data-toggle='modal' class='btn' style='width: 172px;padding-right: 100px'/></li>"
											+ "<li><input type='button' onclick='delsign("
											+ pageBean.list[i].id
											+ ")' value='删除标记' class='btn' style='width: 172px;padding-right: 100px'/></li>"
											+ "<li><input type='button' onclick='comparePrice("
											+ pageBean.list[i].id
											+ ")' class='btn' value='比价' style='width: 172px;padding-right: 140px'/></li>"
											+ "</ul></div></td></tr>";
								}
							} else {
								for (var i = 0; i < pageBean.list.length; i++) {
									str += "<tr index='"+pageBean.list[i].id
                                    						+"'><td><input type='checkbox' name='check' value='"+pageBean.list[i].id+"' />"
											+ "</td><td>"
											+ pageBean.list[i].erpNo
											+ "</td><td>"
											+ pageBean.list[i].comName
											+ "</td><td>"
											+ pageBean.list[i].spec
											+ "</td><td>"
											+ pageBean.list[i].produceFact
											+ "</td><td>"
											+ pageBean.list[i].licenseNo
											
											+ "</td><td>"
											+ pageBean.list[i].drug
											+ "</td><td>"
											+ pageBean.list[i].unit
											+ "</td><td>"
										if(pageBean.list[i].signError=="0"){str += "未标记"}	
										else if(pageBean.list[i].signError=="1"){str += "已核对"}	
										else if(pageBean.list[i].signError=="2"){str += "无数据"}
										else if(pageBean.list[i].signError=="3"){str += "平台数据重复"}
										else if(pageBean.list[i].signError=="4"){str += "自有数据重复"}
										else if(pageBean.list[i].signError=="5"){str += "数据错误"}
										else if(pageBean.list[i].signError=="6"){str += "暂不处理"}
										else{str += "其他原因"}
										str	+= "</td><td><input type='button' onclick='relevance("
											+ pageBean.list[i].id
											+ ")' value='未关联'data-target='#myModa4' data-toggle='modal' class='btn'/>"
											+ "</td><td>"
											+ "<div class='btn-group'><input type='button' onclick='relevance("
											+ pageBean.list[i].id
											+ ")'class='btn btn-danger'value='关联' data-target='#myModa4' data-toggle='modal'/>"
											+ "<button type='button' class='btn btn-default btn-xs dropdown-toggle' data-toggle='dropdown'>"
											+ "<span class='caret' style='height: 8px;'></span>"
											+ "</button>"
											+ "<ul class='dropdown-menu' role='menu'>"
											+ "<li><input type='button' onclick='sign("
											+ pageBean.list[i].id
											+ ")' value='标记错误数据'data-target='#myModa5' data-toggle='modal' class='btn' style='width: 172px;padding-right: 100px'/></li>"
											+ "<li><input type='button' onclick='delsign("
											+ pageBean.list[i].id
											+ ")' value='删除标记' class='btn' style='width: 172px;padding-right: 100px'/></li>"
											+ "</ul>"
											+ "</div>" + "</td></tr>";
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

		$("#findlikeBtn").click(function () {
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
			
			if(page<1){
				page=1;
			}
			if(page>parseInt(total)){
				page=total;
			}
			
			$("#pageNo").val(page);
			
			show();
		});
		$("#endpage_btn").click(function() {
			getVal();
			$("#pageNo").val($("#totalPage").text());
			show();
		})
		
		/* 导入Excel */
			$("#btnOk").click(function() {
				var epath = $('#uploadFile').val();
				var formData = new FormData();
				var name = $("#uploadFile").val();
				formData.append("file", $("#uploadFile")[0].files[0]);
								
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
				$("#spanUp").html("正在写入数据库，请稍后...")
				$.ajax({
					url : 'localGoodsExcel.novo',
					type : 'POST',
					async : true,
					data : formData,
					// 告诉jQuery不要去处理发送的数据
					processData : false,
					// 告诉jQuery不要去设置Content-Type请求头
					contentType : false,
					success : function(responseStr) {
						if(responseStr=="1"){
							$("#spanUp").html("导入完成，请返回查看!")
							
						}else{
							$("#spanUp").html("导入失败，请检查表格中是否存在空的单元格!")
						}
						show();
					}
				});
			});

				
				$("#backBtn1").click(function () {
					$('#uploadFile').val("")
					$("#spanUp").html("")
					
				})
				
				$("#subBtn1").click(function () {
					var comName = $("#comName1").val(); 
					var spec = $("#spec1").val(); 
					var produceFact = $("#produceFact1").val(); 
					var licenseNo = $("#licenseNo1").val(); 
					var barCode = $("#barCode1").val(); 
					var drug = $("#drug1").val(); 
					var unit = $("#unit1").val(); 
					var buyNum = $("#buyNum1").val(); 
					/* 正则判断 */
					$.ajax({
						method : "post",
						url : "addUserProduct.novo",
						data : {
							"comName" : comName,
							"spec": spec,
							"produceFact": produceFact,
							"licenseNo": licenseNo,
							"barCode": barCode,
							"drug": drug,
							"unit": unit,
							"buyNum": buyNum
						},
						async : true,
						success : function(msg) {
							if(msg=="success"){
								alert("添加成功");
							}else{
								alert("添加失败");
							}
							show();
						
						}
					});
				})
				
				/* 批量标记商品 */
				$("#subBtn3").click(function () {
					var checkID = [];
					var radio = $("input[name='radio1']:checked").val();
					 $("input[name='check']:checked").each(function(i){
	                      checkID[i] = $(this).val();
	                });
					 $.ajax({
							method : "post",
							url : "allSignError.novo",
							data : {
								"checkID" : checkID,
								"radio": radio
							},
							traditional: "true",
							dataType: "json",
							async : true,
							success : function(msg) {
								if(msg=="success"){
									alert("标记成功");
								}else{
									alert("标记失败");
								}
								show();
							}
						});
				})
				/* 删除商品 */
				$("#alldelBtn").click(function () {
					var checkID = [];
					 $("input[name='check']:checked").each(function(i){
	                      checkID[i] = $(this).val();
	                });
					if(checkID === undefined || checkID.length == 0){
						alert("请先选择你要选出的数据!")
						return;
					}
					if(confirm("确定删除么?")){
						$.ajax({
							method : "post",
							url : "delUserProduct.novo",
							data : {
								"checkID" : checkID
							},
							traditional: "true",
							dataType: "json",
							async : true,
							success : function(msg) {
							
								show();
							}
						});
					}else{
						return;
					}
				})
				
				/* 修改、选择、搜索关联商品 */
				function relevance(id) {
					$("#tbody4").html("");
					$("#tbody3").html("");
					$("#hidden2").val(id);
					$.ajax({
						method : "post",
						url : "relevance.novo",
						data : {
							"id" : id
						},
						async : true,
						success : function(list) {
							var str = "";
							if(list[0].relaState=="1"){
								str += "<tr><td>自有数据"
								+ "</td><td>" + list[0].erpNo
								+ "</td><td>" + list[0].comName
								+ "</td><td>" + list[0].spec
								+ "</td><td>" + list[0].licenseNo
								+ "</td><td>" + list[0].produceFact
								+ "</td><td>" + list[0].drug
								+ "</td><td>" + list[0].unit
								+ "</td></tr>"
								 + "<tr><td>标准数据"
									+ "</td><td>" 
									+ "</td><td>" + list[0].goods.comName
									+ "</td><td>" + list[0].goods.spec
									+ "</td><td>" + list[0].goods.licenseNo
									+ "</td><td>" + list[0].goods.produceFact
									+ "</td><td>" 
									+ "</td><td>" 
									+ "</td></tr>";
							}else if(list[0].relaState=="0"){
								str += "<tr><td>自有数据"
									+ "</td><td>" + list[0].erpNo
									+ "</td><td>" + list[0].comName
									+ "</td><td>" + list[0].spec
									+ "</td><td>" + list[0].licenseNo
									+ "</td><td>" + list[0].produceFact
									+ "</td><td>" + list[0].drug
									+ "</td><td>" + list[0].unit
									+ "</td></tr>"
							}else{
								str += "<tr><td>自有数据"
									+ "</td><td>" + list[0].erpNo
									+ "</td><td>" + list[0].comName
									+ "</td><td>" + list[0].spec
									+ "</td><td>" + list[0].licenseNo
									+ "</td><td>" + list[0].produceFact
									+ "</td><td>" + list[0].drug
									+ "</td><td>" + list[0].unit
									+ "</td></tr>"
								for (var i = 0; i <list[1].length; i++) {
									str += "<tr><td><input type='button' value='关联' onclick='relevancing("
										+ list[1][i].id
										+ ")' class='btn' /></td><td>" 
										+ "</td><td>" + list[1][i].comName
										+ "</td><td>" + list[1][i].spec
										+ "</td><td>" + list[1][i].licenseNo
										+ "</td><td>" + list[1][i].produceFact
										+ "</td><td>" 
										+ "</td><td>" 
										+ "</td></tr>";
								}
							}
							$("#tbody3").html(str);
						}
						
					});
				}  
				
				/* 修改关联商品模态框中的模糊查询  */
				$("#findlikeBtn4").click(function () {
					var comName4 = $("#comName4").val();
					var produceFact4 = $("#produceFact4").val();
					var licenseNo4 = $("#licenseNo4").val();
					var spec4 = $("#spec4").val();
					
					 $.ajax({
							method : "post",
							url : "relevanceQuery.novo",
							data : {
								"comName4" : comName4,
								"produceFact4": produceFact4,
								"licenseNo4": licenseNo4,
								"spec4": spec4
							},
							async : true,
							success : function(list) {
								var str = "";
								for (var i = 0; i <list.length; i++) {
									str += "<tr><td><input type='button' value='关联' onclick='relevancing("
										+ list[i].id
										+ ")' class='btn' /></td><td>" 
										+ "</td><td>" + list[i].comName
										+ "</td><td>" + list[i].spec
										+ "</td><td>" + list[i].licenseNo
										+ "</td><td>" + list[i].produceFact
										+ "</td><td>" 
										+ "</td><td>" 
										+ "</td></tr>";
								}
								$("#tbody4").html(str);
								
							}
						});
					
				})
				$("#backBtn4").click(function () {
					$("#comName4").val("");
					$("#produceFact4").val("");
					$("#licenseNo4").val("");
					$("#spec4").val("");
					$("#hidden2").val("");
				})
				function relevancing(id) {
					var ownId = $("#hidden2").val();
					$.ajax({
						method : "post",
						url : "relevancing.novo",
						data : {
							"id": id,
							"ownId": ownId
						},
						async : true,
						success : function(msg) {
							if(msg=="success"){
								alert("关联成功");
								relevance(ownId);
								$("#comName4").val("");
								$("#produceFact4").val("");
								$("#licenseNo4").val("");
								$("#spec4").val("");
							}else{
								alert("关联失败");
							}
							
						}
					});
				}
				
				/*单个标记错误数据与删除*/
				function sign(id) {
					$("#subBtn5").click(function () {
						
						var radio = $("input[name='radio5']:checked").val();
						$.ajax({
							method : "post",
							url : "signError.novo",
							data : {
								"id": id,
								"radio": radio
							},
							async : true,
							success : function(msg) {
								if(msg=="success"){
									alert("标记成功");
									show();
								}else{
									alert("标记失败");
								}
								
							}
						});
						
					})
				}
				
				/*单个商品删除标记*/
				function delsign(id) {
					if(confirm("确定删除么?")){
						$.ajax({
							method : "post",
							url : "delSignError.novo",
							data : {
								"id": id
							},
							async : true,
							success : function(msg) {
								if(msg=="success"){
									show();
								}
							}
						});
					}else{
						return;
					}
				}
				
				$("#subBtn2").click(function () {
					var erpNo1 = $("#erpNo1").val();
					var comName1 = $("#comName1").val();
					var spec1 =$("#spec1").val();
					var produceFact1 =$("#produceFact1").val();
					var licenseNo1 =$("#licenseNo1").val();
					var barCode1 =$("#barCode1").val();
					var drug1 =$("#drug1").val();
					var unit1 =$("#unit1").val();
					if(erpNo1==null||comName1==null||spec1==null||produceFact1==null||licenseNo1==null){
						alert("ERP编号、通用名、规格、厂家和批准文号均不能为空");
						return;
					}
					$.ajax({
						method : "post",
						url : "addOfOne.novo",
						data : {
							"erpNo": erpNo1,
							"comName": comName1,
							"spec": spec1,
							"produceFact": produceFact1,
							"licenseNo": licenseNo1,
							"barCode": barCode1,
							"drug": drug1,
							"unit": unit1
						},
						async : true,
						success : function(msg) {
							if(msg=="success"){
								alert("添加成功");
								show();
							}else{
								alert("添加失败");
							}
							
						}
					});
				})
				
				$("#backBtn2").click(function () {
					$("#erpNo1").val("");
					$("#comName1").val("");
					$("#spec1").val("");
					$("#produceFact1").val("");
					$("#licenseNo1").val("");
					$("#barCode1").val("");
					$("#drug1").val("");
					$("#unit1").val("");
				})
				<!--单个本地商品与匹配店铺该商品进行比价查看-->
				function comparePrice(id) {
					window.location.href = "localGoodsComparePrice.novo?id="+id;
				}
				
				<!--导出商品excel模板-->
				$("#export1").click(function () {
					var url="exportLocalGoodsExcel.novo";
				     window.open(url);
				});
				
	</script>

</body>
</html>

