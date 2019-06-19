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
	.div{
		width: 80px;
		height: 10px;
	}
	.ycy1{
		font-size: 30px;
		color: white;
	}
	.ycy2{
		width: 80px;
		margin-top: 5px;
		color: white;
	}
	#tb1,#tb2 {
		width: 100%;
		height: 100%;
		table-layout: fixed;
	}
	#tb1:tr,td child {
		color: white;
	}
	.td1{
		padding-left: 45px;
		color: white;
	}
	.td2{
		text-align: center;
	}
	#map1{
		width: 46%;
		height:500px;
		margin-left: 20px;
		float: left;
		border-top:3px solid #00C1EF;
	}
	#map2{
		width: 46%;
		height:500px;
		margin-left: 20px;
		float: left;
		border-top:3px solid #00C1EF;
		overflow-y:auto;

		
	}
	
	#queryAllBtn{
		font-size: 20px;
		float: right;
		display:inline-block

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
                       <!--  <li>
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
            <li class="start active" id="li1">
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

                    <h3 class="page-title">
                      	  总览 
                    </h3>
                    <!-- END PAGE TITLE & BREADCRUMB-->
                </div>
            </div>
            <div>
				<div style="background-color: #00C1EF;width: 350px;height: 130px;float: left;">
					<table id="tb1">
						<tr height="40%">
							<th width="50%"><span class="ycy1">${reGoodsNum}</span><span class="ycy2">/${noReGoodsNum}</span></th>
						</tr>
						<tr height="40%">
							<td width="50%" class="td1">已关联/未关联</td>
						</tr>
						<tr height="20%">
							<td colspan="2" class="td2" style="background-color: #00A3CB;"><a href="localGoods.novo" style="color: white;">点击查看</a></td>
						</tr>
					</table>
				</div>
				<div style="background-color: #00A75A;width: 350px;height: 130px;float: left;margin-left: 20px">
					<table id="tb2">
						<tr height="40%">
							<th width="50%"><span class="ycy1">${reSupplierNum}</span></th>
						</tr>
						<tr height="40%">
							<td width="50%" class="td1">匹配供应商</td>
						</tr>
						<tr height="20%">
							<td colspan="2" class="td2" style="background-color: #008D4D"><a href="supplierManage.novo" style="color: white;">点击查看</a></td>
						</tr>
					
					</table>
				</div>
			</div>
        </div>
        <br><br>
        <div class="row-fluid">
			<div id="map1">		
			</div>
			<div id="map2" >
				<table class="table table-hover">
					<thead>
						<tr height="30px">
							<th colspan="4"><span style="font-size: 18px">最近预采购记录</span></th>
						</tr>
						<tr height="30px" style="font-size: 15px">
							<th>供应商</th>
							<th>商品数</th>
							<th>金额</th>
							<th>操作</th>
						</tr>
					</thead>
					<tr height="30px" style="font-size: 15px;background-color:#F7EDF7">
						<td colspan="4">时间:
							<span>
								<c:if test="${newScheme!=null }">${newScheme.subTime }</c:if>
								<c:if test="${newScheme==null }">0</c:if>
							</span>商品数:
							<span>
								<c:if test="${newScheme!=null }">${newScheme.reBuyNum }</c:if>
								<c:if test="${newScheme==null }">0</c:if>
							</span>总金额:
							<span>
								<c:if test="${newScheme!=null }">${newScheme.totalPrice }</c:if>
								<c:if test="${newScheme==null }">0</c:if>
							</span>元
						</td>
					</tr>
					<tbody>
						  <c:if test="${csList==null }"></c:if>
						  <c:if test="${csList!=null }">
						  	<c:forEach items="${csList}" var="list">
							<tr>
								<td>${list.supp.name}</td>
								<td>${list.buyNum }</td>
								<td>${list.price }</td>
								<td><input type="button" class="btn blue" onclick="queryDetails(${list.id})" value="查看详情"/></td>
							</tr>
						 </c:forEach>
						  </c:if>
						
					</tbody>
				</table>	
					<input id="queryAllBtn" type="button" class="btn blue"  value="查看全部方案"></input>
			</div>	
</div>
</div>
</div>
</div>
			
	
<!-- END HEAD -->
<!-- BEGIN BODY -->
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
    									
    									
    									var xAttr=[];
    									var yAttr=[];
    									getDiscountingData();
    									function getDiscountingData() {
    										$.ajax({
    											url : 'getDiscountingData.novo',
    											type : 'POST',
    											async : false,
    											// 告诉jQuery不要去处理发送的数据
    											processData : false,
    											// 告诉jQuery不要去设置Content-Type请求头
    											contentType : false,
    											success : function(list) {
    												for(var i=0;i<list.length;i++){
    													xAttr[i]=list[i].subTime.split(" ")[0];
    													yAttr[i]=list[i].totalPrice;
    													
    												}
    											}
    										});
										}
    									var myChart = echarts.init(document.getElementById('map1'));
										var option = {
												
											    title: {
											        text: '采购概况',
											    },
											    tooltip: {
											        trigger: 'axis'
											    },
											    legend: {
											        data:['订单金额','节约金额']
											    },
											    toolbox: {
											        show: true,
											        feature: {
											            dataZoom: {
											                yAxisIndex: 'none'
											            },
											            dataView: {readOnly: false},
											            magicType: {type: ['line', 'bar']},
											            restore: {},
											            saveAsImage: {}
											        }
											    },
											    xAxis:  {
											        type: 'category',
											        boundaryGap: false,
											        data: [xAttr[6],xAttr[5],xAttr[4],xAttr[3],xAttr[2],xAttr[1],xAttr[0]]
											    },
											    yAxis: {
											        type: 'value',
											        axisLabel: {
											            formatter: '{value}'
											        }
											    },
											    series: [
											        {
											            name:'订单金额',
											            type:'line',
											            data:[yAttr[6], yAttr[5], yAttr[4], yAttr[3], yAttr[2], yAttr[1], yAttr[0]],
											            markPoint: {
											                data: [
											                    {type: 'max', name: '最大值'},
											                    {type: 'min', name: '最小值'}
											                ]
											            },
											        },
											        
											        /* {
											            name:'节约金额',
											            type:'line',
											            data:[1, 3, 5, 4, 3, 2, 0],
											        } */
											    ]
											};
										myChart.setOption(option);
										/*查看详情*/
										function queryDetails(id) {
											window.location.href="jumpChildSchemeDetails.novo?id="+id;
										}
						               $("#queryAllBtn").click(function () {
						            	   window.location.href="projectManage.novo";
									   })
									   /*折线图数据*/
									   

									   </script>

</body>
</html>