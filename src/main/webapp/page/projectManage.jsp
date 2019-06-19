<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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
	.active{
		background-color: gray;
	}
	.alarm{
		color:red;
	}
	.ycy{
	width: 70px;
	height: 30px;
	font-size:15px;
	line-height: 20px;
	display: inline-block;
	text-align: center;
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
                <img src="../image/menu-toggler.png" alt="" />
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
            <li class="" id="li3">
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
             <li class="start active"id="li5">
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

                    <h3 class="page-title">
                      	  方案管理
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
                                <span class="ycy">添加时间</span>
                                <input type="date" class="span2 m-wrap" id="addTime" value=""/>
                                <span class="ycy">提交时间</span>
                                <input type="date" class="span2 m-wrap" id="subTime" value=""/>
                                  
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
                            <div class="caption"><i class="icon-bell"></i>采购方案</div>
                        </div>
                        <div class="portlet-body">
                            <!--BEGIN TABS-->
                            <div class="tabbable tabbable-custom">
                                <ul class="nav nav-tabs">
                                    <li class="active">
                                        <a href="" data-toggle="tab" id="nosubmit" index="0">未导出方案</a>
                                    </li>
                                    <li>
                                        <a href="" data-toggle="tab" id="submit" index="1">已导出方案</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="portlet-body">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                    	<th>方案名称</th>
                                   		<th>添加时间</th>
                                    	<th>提交时间</th>
                                        <th>采购/计划商品</th>
                                        <th>采购金额</th>
                                        <th>供应商</th>
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
                            	<div class="btn-group">
									<button class="btn" data-target="#myModa1" data-toggle="modal" id="addSchemeBtn">
										新建方案
									</button>
								</div>
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
                                <div class="modal fade pageStyle" id="myModa1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" hidden="hidden">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                                <h4 class="modal-title" id="myModalLabe">新建方案</h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="portlet-body">
                                                <span class="ycy">计划时间</span>
                              	  				<input type="date" class="span2 m-wrap" id="planTime">
                              	  				<span class="ycy">管理时间</span>
                              	  				<input type="date" class="span2 m-wrap" id="manageTime">
                                  
                                				<button type="button" class="btn blue" id="queryBtn">搜索</button>
                                                    <table class="table table-hover">
                                                        <thead>
					                                    <tr>
					                                    	<th>名称</th>
					                                   		<th>计划时间</th>
					                                    	<th>处理时间</th>
					                                        <th>计划商品数</th>
					                                        <th>操作</th>
					                                    </tr>
					                                    </thead>
                                                        <tbody id="tbody1">
                                                        
                                                                           
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal-dialog -->
                                </div><!-- /.modal -->
                           
 
                            
                        </div></div></div></div></div>
    </div>
    </div>
     <input type="hidden" value="0" id="hidden1"/>
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
    									function goBaiouPlan(){
    										window.location.href="baiouBuyerPlan.novo";
    									}
    									function goBaiouProject(){
    										window.location.href="baiouProjectManage.novo";
    									}
						
    									var subTime = $("#subTime").val();
 						            	var addTime = $("#addTime").val();
 						            	var state = $("#hidden1").val();
 						            	var pageNo = $("#pageNo").val();
    									$("#nosubmit").click(function () {                                                                         
                                            $("#hidden1").val("0");
                                            $("#pageNo").val("1");
                                            $("#addBtn").show();
                                            show();
                                        })
                                        $("#submit").click(function () {
                                        	 $("#hidden1").val("1");
                                        	 $("#pageNo").val("1");
                                        	 $("#addBtn").hide();
                                             show();
                                        }) 
                                        show();
						            	function getVal() {
						            		subTime = $("#subTime").val();
						            		addTime = $("#addTime").val();
							            	state = $("#hidden1").val();
							            	pageNo = $("#pageNo").val();
										}
                                        function show() {
                                        	getVal();
                                        	$.ajax({
												method : "post",
												url : "getUserBuyScheme.novo",
												data : {
													"pageNo" : pageNo,
													"pageSize" : "10",
													"planTime" : subTime,
													"addTime" : addTime,
													"state" : state
												},
												async : true,
												success : function(pageBean) {
													var str = "";
													if (state == "0"){
														for (var i = 0; i < pageBean.list.length; i++) {
															var s = pageBean.list[i].supplier;
															str += "<tr><td>"
		                                						+ pageBean.list[i].name
		                                						+ "</td><td>"
		                                						+ pageBean.list[i].addTime
		            											+ "</td><td>"
			            										if(pageBean.list[i].subTime==null||pageBean.list[i].subTime==""){str += "-"}
			            										else{str += pageBean.list[i].subTime}
			            									str	+= "</td><td>"
		            											+ pageBean.list[i].reBuyNum+"/"+pageBean.list[i].planBuyNum
		            										    + "</td><td>"
		            											+ pageBean.list[i].totalPrice
			            										+ "</td><td>"
		            											for(var j =0;j<pageBean.list[i].supplier.length;j++){
		            												if(j==0){
		            													str += pageBean.list[i].supplier[j].name
		            												}else{
		            													str += "|" + pageBean.list[i].supplier[j].name
		            												}
		            												
		            											}
		            										str	+= "</td><td><input type='button' onclick='query("
		            											+ pageBean.list[i].id
		            											+ ")' class='btn' value='查看详情'/>&nbsp&nbsp<input type='button' onclick='sub("
		            											+ pageBean.list[i].id
		            											+ ")' class='btn' value='确认导出'/></td></tr>";
														}
													}else{
														for (var i = 0; i < pageBean.list.length; i++) {
															var s = pageBean.list[i].supplier;
															str += "<tr><td>"
		                                						+ pageBean.list[i].name
																+ "</td><td>"
		                                						+ pageBean.list[i].addTime
		            											+ "</td><td>"
		            											+ pageBean.list[i].subTime
		            											+ "</td><td>"
			            										+ pageBean.list[i].reBuyNum+"/"+pageBean.list[i].planBuyNum
			            										+ "</td><td>"
			            										+ pageBean.list[i].totalPrice
				            									+ "</td><td>"
		            											for(var j =0;j<pageBean.list[i].supplier.length;j++){
		            												if(j==0){
		            													str += pageBean.list[i].supplier[j].name
		            												}else{
		            													str += "|" + pageBean.list[i].supplier[j].name
		            												}
		            												
		            											}
				            								str	+= "</td><td><input type='button' onclick='query("
		            											+ pageBean.list[i].id
		            											+ ")' class='btn' value='查看详情'/></td></tr>";
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
                                			getVal();
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
										
										
										/*新建方案*/
										$("#addSchemeBtn").click(function () {
											$("#planTime").val("");
											$("#manageTime").val("");
											show1();
										})
										$("#queryBtn").click(function () {
											show1();
										})
										function show1() {
											var planTime = $("#planTime").val();
											var manageTime = $("#manageTime").val();
											$.ajax({
												method : "post",
												url : "addScheme.novo",
												data : {
													"planTime": planTime,
													"manageTime": manageTime
												},
												async : true,
												success : function(list) {
													var str = "";
													for(var i=0;i<list.length;i++){
														str += "<tr><td>"
															+ list[i].name
															+"</td><td>"
															+ list[i].planTime
															+"</td><td>"
															+ list[i].manageTime
															+"</td><td>"
															+ list[i].totalGoods
															+"</td><td><input type='button' onclick='addScheme("
															+ list[i].id
															+ ")' value='点击比价' class='btn red' data-dismiss='modal'/></td></tr>"
													}
													$("#tbody1").html(str);
												}
											});
										}
										
										function addScheme(id) {
											$("#miandiv").load("page/comparePrice.jsp",{"id":id},function(){
											})
										}
										/* 方案查看详情 */
										function query(id) {
											window.location.href="jumpSchemeDetails.novo?id="+id;
										}
										/*方案提交*/
										function sub(id) {
											 
											$.ajax({
												method : "post",
												url : "submitScheme.novo",
												data : {
													"id" : id
												},
												async : true,
												success : function(msg) {
													
													show();
												}
											});
										}
										
										
                                    </script>

</body>
</html>


</html>