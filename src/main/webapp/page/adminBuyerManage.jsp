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
<!-- 所有的连接前面加上以下代码 -->
<base href="<%=basePath%>">
    <meta charset="utf-8" />
    <title>国科拜欧采购计划系统-管理后台</title>
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
	.active{
		background-color: gray;
	}
	.alarm{
		color:red;
	}
	.div{
		width: 80px;
		height: 10px;
	}
	.ycy{
	width: 70px;
	height: 30px;
	line-height: 30px;
	display: inline-block;
	text-align: center;
}
	.table th, .table td { 
text-align: center;
vertical-align: middle!important;
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
                <img src=".。/image/menu-toggler.png" alt="" />
            </a>
            <!-- END RESPONSIVE MENU TOGGLER -->
            <!-- BEGIN TOP NAVIGATION MENU -->
            <ul class="nav pull-right">
                <li class="dropdown user">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="username">${sessionScope.admin.name}</span>
                        <i class="icon-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- <li>
                            <a href="#"><i class="icon-user"></i> 我的资料</a>
                        </li> -->
                        <li>
                            <a href="outloginOfAdmin.novo"><i class="icon-key"></i> 退出登陆</a>
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
				<li class="" id="li3"><a
					href="javascript:goshops();"> <i class="icon-cogs"></i> <span
						class="title">商品目录管理</span>
				</a></li>
				<li class=""id="li4">
	                <a href="javascript:goSeller();">
	                    <i class="icon-list"></i>
	                    <span class="title">商家列表</span>
	                </a>
	           	</li>
	            <li class="start active"id="li6">
	                <a href="javascript:goBuyer();">
	                    <i class="icon-book"></i>
	                    <span class="title">买家列表</span>
	                </a>
	            </li>
            <!--<li class=""id="li7">
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

                    <h3 class="page-title">
                      	  买家管理 
                    </h3>
                    <!-- END PAGE TITLE & BREADCRUMB-->
                </div>
            </div>
            <!-- END PAGE HEADER-->
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
                                <span class="ycy">买家名称</span>
                                <input type="text" class="span2 m-wrap" id="name" value=""/>
                                  
                                <button type="submit" class="btn blue" id="findlikeBtn">查询</button>
                            </div>
                         </div>
                    </div>
                    
                    <!-- END ALERTS PORTLET-->
                </div>
            </div>
                <!-- END DASHBOARD STATS -->
                <div class="clearfix"></div>
                <div class="row-fluid">
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12" style="padding-left: 2%;padding-right:2%">

                    <!-- BEGIN PORTLET-->
                    <div class="portlet paddingless">
                        <div class="portlet-title line">
                            <div class="caption"><i class="icon-bell"></i>下游买家</div>
                            <div class="tools">
                                <!--<a href="" class="collapse"></a>
                                <a href="#portlet-config" data-toggle="modal" class="config"></a>-->
                            </div>
                        </div>
                        <div class="portlet-body">
                            <!--BEGIN TABS-->
                            <div class="tabbable tabbable-custom">
                                <ul class="nav nav-tabs">
                                    <li class="active">
                                        <a href="" data-toggle="tab" id="relevanced" index="1">入驻买家</a>
                                    </li>
                                    <li>
                                        <a href="" data-toggle="tab" id="norelevance" index="0">未入驻买家</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="portlet-body">
                                <table class="table table-hover">
                                    <thead>
	                                    <tr>
	                                   		<th>买家</th>
	                                    	<th>平台编号</th>
	                                        <th>联系方式(账号)</th>
	                                        <th>密码</th>
	                                        <th>操作</th>
	                                    </tr>
                                    </thead>
                                    <tbody id="tbody">
                                    
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <br><br>
                        <div class="row-fluid">
                        	 <div class="span6">
                                 <input type='button'  value='添加入驻买家' class="btn"  data-target='#myModa1' data-toggle='modal' />
                             </div>
                        
                            <div class="span6" style="padding-left: 0%;padding-right:0%">
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
										<h4 class="modal-title" id="myModalLabe">新对接买家</h4>
									</div>
									<div class="modal-body">
										<div class="portlet-body">
											<table class="table table-hover">
                                                        <tbody>
                                                        <tr>
                                                            <td class="span2 m-wrap"><span>买家</span></td>
                                                            <td class="span4 m-wrap"><input type="text" class="span8 m-wrap" id="name1" placeholder="公司名称" ></td>
                                                        </tr>
                                                       <tr>
                                                            <td class="span2 m-wrap"><span>联系电话(账号)</span></td>
                                                            <td class="span4 m-wrap"><input type="text" class="span8 m-wrap" id="mobile1" placeholder="联系方式"></td>
                                                        </tr>
                                                        <tr>
                                                            <td class="span2 m-wrap"><span>密码</span></td>
                                                            <td class="span4 m-wrap"><input type="text" class="span8 m-wrap" id="password1" placeholder="密码"></td>
                                                        </tr>
                                                        
                                                        </tbody>
                                                    </table>
                                             </div>
									</div>
									<div class="modal-footer">
                                                <button type="button" class="btn btn-default" id="subBtn1">提交</button>
                                                <button type="button" class="btn btn-primary" id="backBtn1" data-dismiss="modal">取消</button>
                               		</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
                           
 
                            
                        </div></div></div></div></div>
    </div>
    </div>
    
		<input type="hidden" value="1" id="hidden1">
		<input type="hidden" value="" id="hidden2" />
		
						

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
                                    	
                                    	
                                      /*   bkLib.onDomLoaded(function() { nicEditors.allTextAreas() }); */
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
                                        function goSeller() {
                                			window.location.href = "adminSellerManage.novo";
                                		}
                                		function goBuyer() {
                                			window.location.href = "adminBuyerManage.novo";
                                		}
                                		function goshops() {
                                			window.location.href = "adminManage.novo";
                                		}
                                        var pageNo = $("#pageNo").val();
                                        var name = $("#name").val();
                                        var state = $("#hidden1").val();
                                        var totalPage = $("#totalPage").text();
                                        $("#relevanced").click(function () {                                                                         
                                            $("#hidden1").val("1");
                                            $("#pageNo").val("1");
                                            show();
                                        })
                                        $("#norelevance").click(function () {
                                        	 $("#hidden1").val("0");
                                        	 $("#pageNo").val("1");
                                             show();
                                        })
                                    	 /* 利用ajax页面展示，模糊查询及分页 */
                                    	show();
										function getVal() {
											pageNo = $("#pageNo").val();
											name = $("#name").val();
											state = $("#hidden1").val();
										};
										function show() {
											getVal();
											$.ajax({
												method : "post",
												url : "getBuyerOfAdmin.novo",
												data : {
													"pageNo" : pageNo,
													"pageSize" : "10",
													"realName" : name,
													"state" : state
												},
												async : true,
												success : function(pageBean) {
													var str = "";
													if(state=="1"){
														for (var i = 0; i < pageBean.list.length; i++) {
															str += "<tr><td>"
	                                						+ pageBean.list[i].realName
	            											+ "</td><td>"
	            											+ pageBean.list[i].id
	            											+ "</td><td>"
	            											+ pageBean.list[i].phone
	            											+ "</td><td>"
	            											+ pageBean.list[i].password
	            											+ "</td><td><input type='button' onclick='cancel("
	            											+ pageBean.list[i].id
	            											+ ")' class='btn' value='注销'/>&nbsp<input type='button' onclick='relevanceDetails("
	            											+ pageBean.list[i].id
	            											+ ")' class='btn' value='绑定商家'/></td></tr>";
														}
													}else{
														for (var i = 0; i < pageBean.list.length; i++) {
															str += "<tr><td>"
	                                						+ pageBean.list[i].realName
	                                						+ "</td><td>"
	            											+ pageBean.list[i].id
	            											+ "</td><td>"
	            											+ pageBean.list[i].phone
	            											+ "</td><td>"
	            											+ pageBean.list[i].password
	            											+ "</td><td><input type='button' onclick='matching("
	            											+ pageBean.list[i].id
	            											+ ")' class='btn' value='入驻'/></td></tr>";
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
											
											if (page < total) {
												page += 1;
											} else {
												page = total;
											}
											$("#pageNo").val(page);
											show();
										};
										$("#jumppage_btn").click(function() {
											pageNo = $("#pageNo").val();
											totalPage = $("#totalPage").text();
											var reg = /^([1-9][0-9]*)$/;
											if (!reg.test(pageNo)) {
												alert("请输入正确的页码");
												return;
											}
											if (pageNo > parseInt(totalPage)) {
												pageNo = totalPage;
											} else if (pageNo < 1) {
												pageNo = 1;
											}
											$("#pageNo").val(pageNo);
											show();
										});
										$("#endpage_btn").click(function() {
											getVal();
											$("#pageNo").val($("#totalPage").text());
											show();
										})
										
										/*取消匹配*/
										function cancel(id) {
											if(confirm("确定注销该买家么?")){
												$.ajax({
													method : "post",
													url : "cancelBuyerOfAdmin.novo",
													data : {
														"id": id
													},
													async : true,
													success : function(msg) {
														if(msg=="success"){
															alert("注销成功");
															show();
														}else{
															alert("注销失败");
														}
														
													}
												});
											}else{
												return;
											}
										}
										
										/*匹配*/
										function matching(id) {
											if(confirm("确定入驻该买家么?")){
												$.ajax({
													method : "post",
													url : "matchingBuyerOfAdmin.novo",
													data : {
														"id": id
													},
													async : true,
													success : function(msg) {
														if(msg=="success"){
															alert("入驻成功");
															show();
														}else{
															alert("入驻失败");
														}
														
													}
												});
											}else{
												return;
											}
										}
										function relevanceDetails(id) {
											window.location.href = "adminBuyerDetails.novo?id="+id;
										}
										<!--添加买家-->
										$("#subBtn1").click(function () {
											var name1 = $("#name1").val();
											var mobile1 = $("#mobile1").val();
											var password1 = $("#password1").val();
											$.ajax({
												method : "post",
												url : "addBuyerOfAdmin.novo",
												data : {
													"name": mobile1,
													"realName": name1,
													"phone": mobile1,
													"password":password1
												},
												async : true,
												success : function(msg) {
													if(msg=="1"){
														alert("添加成功");
														show();
													}else{
														alert("添加失败");
													}
													$("#name1").val("");
													$("#mobile1").val("");
													$("#password1").val("");
												}
											});
										});
										
										$("#backBtn1").click(function () {
											$("#name1").val("");
											$("#mobile1").val("");
											$("#password1").val("");
										})
                                    </script>

</body>
</html>


</html>