<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="errorPage.jsp"%>
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
<body>
<%
       String id = request.getParameter("id");
%>
		<div class="page-container" style="height: 100%">
        <div class="container-fluid">
            <!-- BEGIN PAGE HEADER-->
            <div class="row-fluid">
                <div class="span12">

                    <!-- BEGIN PAGE TITLE & BREADCRUMB-->

                    <h3 class="page-title">
                      	  查看详情 
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
                                <span class="ycy">通用名</span>
                                <input type="text" class="span2 m-wrap" id="comName" value=""/>
                                  
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
                            <div class="caption"><i class="icon-bell"></i>计划采购商品</div>
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
                                        <a href="" data-toggle="tab" id="relevanced" index="1">已匹配商品</a>
                                    </li>
                                    <li>
                                        <a href="" data-toggle="tab" id="norelevance" index="0">未匹配商品</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="portlet-body">
                                <table class="table table-hover">
                                    <thead>
	                                    <tr>
	                                   		<th>ERP编号</th>
											<th>通用名</th>
											<th>规格</th>
											<th>批准文号</th>
											<th>厂家</th>
											<th>剂型</th>
											<th>单位</th>
											<th>条码</th>
											<th>预估价格</th>
											<th>采购数量</th>
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
                        	 
                                 <button class="btn"  data-toggle="modal" data-target="#myModa1" id="exportBtn">
                                   导出Excel表
                                </button>
          
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
                                <!-- <div class="modal fade pageStyle" id="myModa1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" hidden="hidden">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                                <h4 class="modal-title" id="myModalLabe">添加匹配店铺</h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="portlet-body">
                                                <span class="ycy">供货商名称</span>
                              	  				<input type="text" class="span2 m-wrap" id="name1"placeholder="供货商名称">
                                  
                                				<button type="button" class="btn blue" id="queryBtn">搜索</button>
                                                    <table class="table table-hover">
                                                        <tr>
                                                            <td class="span2 m-wrap"><span>供应商</span></td>
                                                            <td class="span4 m-wrap"><span>商品数</span></td>
                                                            <td class="span2 m-wrap"><span>操作</span></td>                                                          
                                                        </tr>
                                                        <tbody id="tbody1">
                                                        
                                                                           
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            
                                        </div>/.modal-content
                                    </div>/.modal-dialog
                                </div>/.modal -->
                           
 
                            
                        </div></div></div></div></div>
    
		<input type="hidden" value="1" id="hidden1">
		<input type="hidden" value="<%=id%>" id="hidden2" />					
                                
						
						            <script>
						          
						            	var comName = $("#comName").val();
						            	var state = $("#hidden1").val();
						            	var pageNo = $("#pageNo").val();
						            	var id = $("#hidden2").val();
									$("#relevanced").click(function () {                                                                         
                                        $("#hidden1").val("1");
                                        $("#pageNo").val("1");
                                        $("#exportBtn").hide();
                                        show();
                                    })
                                    $("#norelevance").click(function () {
                                    	 $("#hidden1").val("0");
                                    	 $("#pageNo").val("1");
                                    	 $("#exportBtn").show();
                                         show();
                                    }) 
                                    show();
									$("#exportBtn").hide();
					            	function getVal() {
						            	comName = $("#comName").val();
						            	state = $("#hidden1").val();
						            	pageNo = $("#pageNo").val();
						            	id = $("#hidden2").val();
									}
                                    function show() {
                                    	getVal();
                                    	$.ajax({
											method : "post",
											url : "planDetails.novo",
											data : {
												"pageNo" : pageNo,
												"pageSize" : "10",
												"comName" : comName,
												"id" : id,
												"state" : state
											},
											async : true,
											success : function(pageBean) {
												var str = "";
													for (var i = 0; i < pageBean.list.length; i++) {
														str += "<tr><td>"
	                                						+ pageBean.list[i].erpNo
	            											+ "</td><td>"
	            											+ pageBean.list[i].comName
	            											+ "</td><td>"
	            											+ pageBean.list[i].spec
	            											+ "</td><td>"
	            											+ pageBean.list[i].licenseNo
	            											+ "</td><td>"
	            											+ pageBean.list[i].produceFact
	            											+ "</td><td>"
	            											+ pageBean.list[i].drug
	            											+ "</td><td>"
	            											+ pageBean.list[i].unit
	            											+ "</td><td>"
	            											+ pageBean.list[i].barCode
	            											+ "</td><td>"
	            											+ pageBean.list[i].evaluate
	            											+ "</td><td>"
	            											+ pageBean.list[i].buyNum
	            											+ "</td></tr>";
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
										getVal();
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
						            
									/*导出excel*/
						            $("#exportBtn").click(function () {
						            	$.ajax({
											method : "post",
											url : "downloadBuyPlan.novo",
											data : {
												"id" : id
											},
											async : true,
											success : function(msg) {
												if(msg=="success"){
													alert("导出成功，请在D:/download/buyplan下查看");
												}else{
													alert("导出失败");
												}
												show();
											}
										});
									})
						            
						            </script> 

</body>
</html>


</html>