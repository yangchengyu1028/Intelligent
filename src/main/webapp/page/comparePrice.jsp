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
<style>
.active {
	background-color: gray;
}

.alarm {
	color: red;
}

.ycy {
	width: 100px;
	height: 30px;
	line-height: 30px;
	display: inline-block;
	text-align: center;
}

.inp {
	width: 50px;
}

.table th, .table td {
	text-align: center;
	vertical-align: middle !important;
}

.selected {
	background: #F64A38;
}

.subdiv {
	position: fixed;
	width: 100%;
	margin-left: 0%;
	height: 60px;
	box-shadow: -5px -5px 20px 0px #908d8d;
	border-radius: 6px;
	bottom: 10px;
	background-color: white;
}

.positiveNumber {
	color: red;
}

.negative {
	color: green;
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

td div {
	width: 100px;
}
</style>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
	<%
		String id = request.getParameter("id");
	%>
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
								<span class="ycy">通用名</span> <input type="text"
									class="span2 m-wrap" id="comName" value="" />
								<span class="ycy">涨价百分比</span> <input style="width: 50px" type="text"
									class="span2 m-wrap" id="minPercent" value="0" />-
								<input style="width: 50px" type="text"
									class="span2 m-wrap" id="maxPercent" value="" />
								<button style="margin-left: 50px" class="btn blue"
									id="findlikeBtn">查询</button>
								<button class="btn blue" id="showAllBtn">显示全部</button>
								<button class="btn blue" id="addSupplierBtn" data-toggle="modal"
									data-target="#myModa1">添加匹配店铺</button>
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
							<i class="icon-bell"></i>选择商品
						</div>
					</div>
					<div class="portlet-body">
						<table class="table" id="table1">

						</table>

					</div>

					<br>
					<br>
					<!-- Modal -->
					<div class="modal fade pageStyle" id="myModa1" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
						hidden="hidden">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true"></button>
									<h4 class="modal-title" id="myModalLabe">添加匹配店铺</h4>
								</div>
								<div class="modal-body">
									<div class="portlet-body">
										<span class="ycy">供货商</span> <input type="text"
											class="span2 m-wrap" id="name1" placeholder="供货商名称">

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
									<div class="modal-footer">
										<button type="button" class="btn btn-primary" id="backBtn"
											data-dismiss="modal">返回</button>
									</div>

								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="subdiv">
		<h3 style="float: left; margin-left: 50px">
			共<span id="goodsNum"></span>件商品，购买数量为：<span id="totalNum"></span>件，合计:￥<span
				id="totalPrice"></span>元
		</h3>
		<input type="button" class="btn red" value="提交订单"
			style="float: left; margin-left: 320px; margin-top: 15px"
			id="subScheme" /> <input type="button" class="btn red"
			value="平台优选方案A"
			style="float: left; margin-left: 20px; margin-top: 15px" id="schemeA" />
		<input type="button" class="btn red" value="平台优选方案B"
			style="float: left; margin-left: 20px; margin-top: 15px" id="schemeB" />
		<input type="button" class="btn blue" value="重新计算"
			style="float: left; margin-left: 20px; margin-top: 15px"
			id="calculateNum" />
	</div>
	<input type="hidden" value="1" id="hidden1">
	<input type="hidden" value="<%=id%>" id="hidden2" />

	<div id="loading">
		<div class="jobSync">
			<img src="/image/loading1.gif" style="position: relative;left: 60px;"> 
			<div><span style="color: #FFFFFF;font-size: 20px">页面正在加载，请等待几分钟...</span></div>
		</div>
	</div>




	<script>
		var suppList;
		var buyPlanList;
		var data;
		getData();
		/*获取数据*/
		function getData() {
			$('#loading').height($(window).height());
			$('#loading').show();
			var id = $("#hidden2").val();
			$.ajax({
				method : "post",
				url : "getDataOfId.novo",
				data : {
					"id" : id
				},
				async : true,
				success : function(userDate) {
					suppList = userDate.list2;
					buyPlanList = userDate.list1;
					data = userDate.list3;
					getTable();
					getTotalPrice();
					$('#loading').hide();
				}
			});
		}
		function getTable() {
			var html = "<tr><th>商品</th><th>规格</th><th>参考价</th><th>采购数量</th>";
			var html1 = "",html11 = "";
			var html2 = "";
			var num,html3,html4,html5;
			var bool;
			for (var i = 0; i < suppList.length; i++) {
				html += "<th>" + suppList[i].name + "</th>";
			}
			html += "</tr>"
			for (var j = 0; j < buyPlanList.length; j++) {
				var minPrice = 0;
				var num = 0;
				var name;
				for (var k = 0; k < data[j].length; k++) {
					if (data[j][k] != null) {
						if (data[j][k].stock >= buyPlanList[j].buyNum) {
							num++;
							minPrice = data[j][k].price;
							name = data[j][k].supp.name;
							break;
						}
					}

				}
				if (num == 0) {
					for (var k = 0; k < data[j].length; k++) {
						if (data[j][k] != null) {
							minPrice = data[j][k].price;
							break;
						}
					}
					for (var k = 0; k < data[j].length; k++) {
						if (data[j][k] != null) {
							if (data[j][k].price < minPrice) {
								minPrice = data[j][k].price;
								name = data[j][k].supp.name;
							}
						}
					}
				} else {
					for (var k = 0; k < data[j].length; k++) {
						if (data[j][k] != null) {
							if (data[j][k].stock >= buyPlanList[j].buyNum) {
								if (data[j][k].price < minPrice) {
									minPrice = data[j][k].price;
									name = data[j][k].supp.name;
								}
							}
						}
					}
				}
				bool = true;
				for (var r = 0; r < data[j].length; r++) {
					if (data[j][r] != null) {
						bool = false;
					}
				}
				if (bool == true) {
					html2 += "<tr index='"+buyPlanList[j].comName+"' index1='"+buyPlanList[j].evaluate+"'><td><div>"
							+ buyPlanList[j].comName
							+ "</div></td><td><div>"
							+ buyPlanList[j].spec
							+ "</div></td><td><div>"
							+ buyPlanList[j].evaluate
							+ "<p>——<p><span class='priceDifference'></span></div></td><td><div>"
							+ buyPlanList[j].buyNum + "</div></td>";
					for (var m = 0; m < data[j].length; m++) {
						html2 += "<td><div>-</div></td>";
					}
					html2 += "</tr>";
				} else {
					html3 = "<tr index='"+buyPlanList[j].comName+"' index1='"+buyPlanList[j].evaluate+"'><td><div>"
							+ buyPlanList[j].comName
							+ "</div></td><td><div>"
							+ buyPlanList[j].spec
							+ "</div></td><td><div>"
							+ buyPlanList[j].evaluate
							+ "<p>——<p><span class='priceDifference'></span></div></td><td><div>"
							+ buyPlanList[j].buyNum + "</div></td>";
					html4 = "<tr index='"+buyPlanList[j].comName+"' index1='"+buyPlanList[j].evaluate+"'><td><div>"
							+ buyPlanList[j].comName
							+ "</div></td><td><div>"
							+ buyPlanList[j].spec
							+ "</div></td><td><div>"
							+ buyPlanList[j].evaluate
							+ "<p>——<p><span class='priceDifference'></span></div></td><td><div>"
							+ buyPlanList[j].buyNum + "</div></td>";
					html5 = "";
					num = 0;
					var goodsPrice;
					for (var m = 0; m < data[j].length; m++) {
						if (data[j][m] == null) {
							html5 += "<td><div>-</div></td>";
						} else {
							if(data[j][m].updatePrice=="9999.00"){
								goodsPrice=data[j][m].price;
							}else{
								goodsPrice=data[j][m].updatePrice;
							}

							if (data[j][m].supp.name == name) {
								num=1;
								if (data[j][m].stock >= buyPlanList[j].buyNum) {
									html5 += "<td class='selectData selected' index='"+buyPlanList[j].id+"' supplierId='"+data[j][m].id+"' evaluate='"+buyPlanList[j].evaluate+"' price='"+goodsPrice+"'>单价<span>"
											+ goodsPrice
											+ "</span>库存"
											+ data[j][m].stock
											+ "<br/>"
											+ "生产日期:"
											+ data[j][m].productiontime
											+ ";有效期"
											+ data[j][m].expiration_date
											+ "个月;"
											+ data[j][m].expiryDate
											+ "<br/>中包装数:"
											+ data[j][m].goods_packing
											+ "<p>购买数量<input type='text' class='inp' value='"+buyPlanList[j].buyNum+"'></td>"
								} else {
									html5 += "<td class='selectData selected' index='"+buyPlanList[j].id+"' supplierId='"+data[j][m].id+"' evaluate='"+buyPlanList[j].evaluate+"'price='"+goodsPrice+"'>单价<span>"
											+ goodsPrice
											+ "</span>库存"
											+ data[j][m].stock
											+ "<br/>"
											+ "生产日期:"
											+ data[j][m].productiontime
											+ ";有效期"
											+ data[j][m].expiration_date
											+ "个月;"
											+ data[j][m].expiryDate
											+ "<br/>中包装数:"
											+ data[j][m].goods_packing
											+ "<p>购买数量<input type='text' class='inp' value='"+data[j][m].stock+"'></td>"
								}
							} else {
								html5 += "<td class='selectData' index='"+buyPlanList[j].id+"' supplierId='"+data[j][m].id+"' evaluate='"+buyPlanList[j].evaluate+"'price='"+goodsPrice+"'>单价<span>"
										+ goodsPrice
										+ "</span>库存"
										+ data[j][m].stock
										+ "<br/>"
										+ "生产日期:"
										+ data[j][m].productiontime
										+ ";有效期"
										+ data[j][m].expiration_date
										+ "个月;"
										+ data[j][m].expiryDate
										+ "<br/>中包装数:"
										+ data[j][m].goods_packing
										+ "<p>购买数量<input type='text' class='inp'></td>"
							}
						}
					}
					if (num == 1) {
						html11 += html3 + html5 + "</tr>";
					} else {
						html1 += html4 + html5 + "</tr>";
					}
				}
				
			}

			var miandiv = $("#miandiv");

			var miandiv_left = miandiv.offset().left;

			var all = $("div.g4hj984u5h0jerh04r0");

			var all_left = all.offset().left;

			var t1 = $("#table1");

			var t1_left = t1.offset().left;

			var left_dif = t1_left - all_left;

			t1.html(html + html11 + html1 + html2);

			all.width(t1.outerWidth() + left_dif * 2);

			miandiv.width(all.outerWidth() + all_left - miandiv_left);

			$("#table1").on("click", ".selectData", function() {
				if ($(this).hasClass('selected')) {
					$(this).removeClass('selected')
				} else {
					$(this).addClass('selected')
				}
			});

		}
		/*获取选中商品，计算出价格和数量     和价格上下浮动*/
		function getTotalPrice() {
			var priceAttr = [];
			var numAttr = [];
			var idAttr = [];
			var totalNum = 0;
			var totalPrice = 0;
			var goodsNum = 0;
			$('td.selected').each(
					function() {
						priceAttr.push($(this).find("span").html());
						numAttr.push($(this).find("input").val());
						idAttr.push($(this).attr("index"));
						/*计算选中每种商品与估价差异*/
						var differenceValue = $(this).find("span").html()
								- $(this).attr("evaluate");
						if (differenceValue > 0) {
							$(this).parent().find(".priceDifference").html(
									"+" + Math.round(differenceValue * 100)
											/ 100);
							$(this).parent().find(".priceDifference").addClass(
									'positiveNumber');
						} else {
							$(this).parent().find(".priceDifference").html(
									Math.round(differenceValue * 100) / 100);
							$(this).parent().find(".priceDifference").addClass(
									'negative');
						}
					})
			for (var i = 0; i < numAttr.length; i++) {
				goodsNum++;
				totalNum += parseInt(numAttr[i]);
				totalPrice += parseInt(numAttr[i]) * parseFloat(priceAttr[i]);
			}
			$("#goodsNum").html(goodsNum);
			$("#totalNum").html(totalNum);
			$("#totalPrice").html((Math.round(totalPrice * 100) / 100));
		}
		/*重新计算价格数量*/
		$("#calculateNum").click(function() {
			getTotalPrice();
		})
		/*模糊查询*/
		$("#findlikeBtn").click(function() {
			var comName = $("#comName").val();
			var minPercent = $("#minPercent").val();
			var maxPercent = $("#maxPercent").val();
			if(minPercent==""){
				$("#minPercent").val("0");
			}
			if(maxPercent==""){
				maxPercent = 30;
			}
			var normPrice;<!--商品预估价-->
			var minPrice;<!--每行最低价-->
			var decideNum;
			var spreadPrice;<!--差价-->
			$("#table1 tr").each(function(i) {
				$(this).show();
				<!--获取该表格下每一行-->
				if (i != 0) {
					if ($(this).attr("index").indexOf(comName) == -1) {
						$(this).hide();
					}
					normPrice = $(this).attr("index1");
					minPrice = 0;
					decideNum = 0;
					spreadPrice = 0;
					<!--获取该表格下每一行的每一列-->
					$(this).find('td').each(function(j) {
						if(j>3){
							if($(this).attr("price")!=null){
								if(decideNum==0){
									minPrice = $(this).attr("price");
									decideNum = 1;
								}else{
									if($(this).attr("price")<minPrice){
										minPrice = $(this).attr("price");
									}
								}
							}
						}
						
						
					})
					<!--得到该行最小值后 计算涨价百分百--> 
					spreadPrice = Math.round((minPrice-normPrice)/normPrice * 10000)/100;
					if(minPercent==0){
						if(spreadPrice>maxPercent){
							$(this).hide();
						}	
					}else{
						if(spreadPrice>maxPercent||spreadPrice<minPercent){
							$(this).hide();
						}
					}
					
					
				}
			})
		})
		/*显示全部*/
		$("#showAllBtn").click(function() {
			var minPercent = $("#minPercent").val("0");
			var maxPercent = $("#maxPercent").val("30");
			$("#comName").val("");
			$("#table1 tr").each(function(i) {
				$(this).show();
			})
		})

		/*添加匹配店铺*/
		$("#addSupplierBtn").click(function() {
			showAddSupplier();
		})
		/*添加匹配店铺模糊查询*/
		$("#queryBtn").click(function() {
			showAddSupplier();
		})
		$("#backBtn").click(function() {
			$("#name1").val("");
		})
		/*展示未匹配店铺方法*/
		function showAddSupplier() {
			var name1 = $("#name1").val();
			$
					.ajax({
						method : "post",
						url : "addSupplierOfCompare.novo",
						data : {
							"name" : name1
						},
						async : true,
						success : function(list) {
							var str = "";
							for (var i = 0; i < list.length; i++) {
								str += "<tr><td>"
										+ list[i].supplier.name
										+ "</td><td>"
										+ list[i].count
										+ "</td><td><input type='button' onclick='marry("
										+ list[i].id
										+ ")' class='btn red' value='匹配'/></td></tr>"
							}
							$("#tbody1").html(str);
						}
					});
		}

		/*确认匹配店铺，并刷新页面*/
		function marry(id) {
			$('#loading').height($(window).height());
			$('#loading').show();
			$.ajax({
				method : "post",
				url : "matching.novo",
				data : {
					"id" : id
				},
				async : true,
				success : function(msg) {
					if (msg == "success") {
						alert("匹配成功");
					} else {
						alert("匹配失败!")
					}
					showAddSupplier();
					getData();
					$("#table1").on("click", ".selectData", function() {
						if ($(this).hasClass('selected')) {
							$(this).removeClass('selected')
						} else {
							$(this).addClass('selected')
						}
					});
					$('#loading').hide();
				}
			});
		}

		/*提交订单*/
		$("#subScheme").click(function() {
			$('#loading').height($(window).height());
			$('#loading').show();
			var id = $("#hidden2").val();
			var goodsId = [];
			var supplierId = [];
			var buyNum = [];
			$('td.selected').each(function() {
				goodsId.push($(this).attr("index"));
				buyNum.push($(this).find("input").val());
				supplierId.push($(this).attr("supplierId"));
			})
			$.ajax({
				method : "post",
				url : "determineScheme.novo",
				data : {
					"id" : id,
					"goodsId" : goodsId,
					"supplierId" : supplierId,
					"buyNum" : buyNum
				},
				traditional : "true",
				dataType : "json",
				async : true,
				success : function(msg) {
					if (msg == "success") {
						$('#loading').hide();
						window.location.href = "projectManage.novo";

					} else {
						alert("比价失败！")
					}
				}
			});
		})

		$("#schemeA").click(function() {
			getData();
			$("#table1").on("click", ".selectData", function() {
				if ($(this).hasClass('selected')) {
					$(this).removeClass('selected')
				} else {
					$(this).addClass('selected')
				}
			});
		})
		$("#schemeB").click(function() {
			$('#loading').height($(window).height());
			$('#loading').show();
			var id = $("#hidden2").val();
			$.ajax({
				method : "post",
				url : "getDataOfId.novo",
				data : {
					"id" : id
				},
				async : true,
				success : function(userDate) {
					suppList = userDate.list2;
					buyPlanList = userDate.list1;
					data = userDate.list3;
					getTable1();
					getTotalPrice();
					$("#table1").on("click", ".selectData", function() {
						if ($(this).hasClass('selected')) {
							$(this).removeClass('selected')
						} else {
							$(this).addClass('selected')
						}
					});
					$('#loading').hide();
				}
			});
		})
		function getTable1() {
			var html = "<tr><th>商品</th><th>规格</th><th>参考价</th><th>采购数量</th>";
			var html1 = "",html11 = "";
			var html2 = "";
			var num,html3,html4,html5;
			var bool;
			for (var i = 0; i < suppList.length; i++) {
				html += "<th>" + suppList[i].name + "</th>";
			}
			html += "</tr>"
			for (var j = 0; j < buyPlanList.length; j++) {
				var minPrice = 0;
				var num = 0;
				var name;
				for (var k = 0; k < data[j].length; k++) {
					if (data[j][k] != null) {
						if (data[j][k].stock >= buyPlanList[j].buyNum) {
							num++;
							minPrice = data[j][k].price;
							name = data[j][k].supp.name;
							break;
						}
					}

				}
				if (num == 0) {
					for (var k = 0; k < data[j].length; k++) {
						if (data[j][k] != null) {
							minPrice = data[j][k].price;
							break;
						}
					}
					for (var k = 0; k < data[j].length; k++) {
						if (data[j][k] != null) {
							if (data[j][k].price < minPrice) {
								minPrice = data[j][k].price;
								name = data[j][k].supp.name;
							}
						}
					}
				} else {
					for (var k = 0; k < data[j].length; k++) {
						if (data[j][k] != null) {
							if (data[j][k].stock >= buyPlanList[j].buyNum) {
								if (data[j][k].price < minPrice) {
									minPrice = data[j][k].price;
									name = data[j][k].supp.name;
								}
							}
						}
					}
				}
				bool = true;
				for (var r = 0; r < data[j].length; r++) {
					if (data[j][r] != null) {
						bool = false;
					}
				}
				if (bool == true) {
					html2 += "<tr index='"+buyPlanList[j].comName+"'index1='"+buyPlanList[j].evaluate+"'><td><div>"
							+ buyPlanList[j].comName
							+ "</div></td><td><div>"
							+ buyPlanList[j].spec
							+ "</div></td><td><div>"
							+ buyPlanList[j].evaluate
							+ "<p>——<p><span class='priceDifference'></span></div></td><td><div>"
							+ buyPlanList[j].buyNum + "</div></td>";
					for (var m = 0; m < data[j].length; m++) {
						html2 += "<td><div>-</div></td>";
					}
					html2 += "</tr>";
				} else {
					html3 = "<tr index='"+buyPlanList[j].comName+"'index1='"+buyPlanList[j].evaluate+"'><td><div>"
							+ buyPlanList[j].comName
							+ "</div></td><td><div>"
							+ buyPlanList[j].spec
							+ "</div></td><td><div>"
							+ buyPlanList[j].evaluate
							+ "<p>——<p><span class='priceDifference'></span></div></td><td><div>"
							+ buyPlanList[j].buyNum + "</div></td>";
					html4 = "<tr index='"+buyPlanList[j].comName+"'index1='"+buyPlanList[j].evaluate+"'><td><div>"
							+ buyPlanList[j].comName
							+ "</div></td><td><div>"
							+ buyPlanList[j].spec
							+ "</div></td><td><div>"
							+ buyPlanList[j].evaluate
							+ "<p>——<p><span class='priceDifference'></span></div></td><td><div>"
							+ buyPlanList[j].buyNum + "</div></td>";
					html5 = "";
					num = 0;
					var goodsPrice;
					for (var m = 0; m < data[j].length; m++) {
						if (data[j][m] == null) {
							html5 += "<td><div>-</div></td>";
						} else {
							if(data[j][m].updatePrice=="9999.00"){
								goodsPrice=data[j][m].price;
							}else{
								goodsPrice=data[j][m].updatePrice;
							}
							if (goodsPrice <= buyPlanList[j].evaluate) {
								if (data[j][m].supp.name == name) {
									num = 1;
									if (data[j][m].stock >= buyPlanList[j].buyNum) {
										html5 += "<td class='selectData selected' index='"+buyPlanList[j].id+"' supplierId='"+data[j][m].id+"' evaluate='"+buyPlanList[j].evaluate+"'price='"+goodsPrice+"'>单价<span>"
												+ goodsPrice
												+ "</span>库存"
												+ data[j][m].stock
												+ "<br/>"
												+ data[j][m].expiryDate
												+ "<br/>中包装数:"
												+ data[j][m].goods_packing
												+ "<p>购买数量<input type='text' class='inp' value='"+buyPlanList[j].buyNum+"'></td>"
									} else {
										html5 += "<td class='selectData selected' index='"+buyPlanList[j].id+"' supplierId='"+data[j][m].id+"' evaluate='"+buyPlanList[j].evaluate+"'price='"+goodsPrice+"'>单价<span>"
												+ goodsPrice
												+ "</span>库存"
												+ data[j][m].stock
												+ "<br/>"
												+ data[j][m].expiryDate
												+ "<br/>中包装数:"
												+ data[j][m].goods_packing
												+ "<p>购买数量<input type='text' class='inp' value='"+data[j][m].stock+"'></td>"
									}
								} else {
									html5 += "<td class='selectData' index='"+buyPlanList[j].id+"' supplierId='"+data[j][m].id+"' evaluate='"+buyPlanList[j].evaluate+"'price='"+goodsPrice+"'>单价<span>"
											+ goodsPrice
											+ "</span>库存"
											+ data[j][m].stock
											+ "<br/>"
											+ data[j][m].expiryDate
											+ "<br/>中包装数:"
											+ data[j][m].goods_packing
											+ "<p>购买数量<input type='text' class='inp'></td>"
								}
							} else {
								html5 += "<td class='selectData' index='"+buyPlanList[j].id+"' supplierId='"+data[j][m].id+"' evaluate='"+buyPlanList[j].evaluate+"'price='"+goodsPrice+"'>单价<span>"
										+ goodsPrice
										+ "</span>库存"
										+ data[j][m].stock
										+ "<br/>"
										+ data[j][m].expiryDate
										+ "<br/>中包装数:"
										+ data[j][m].goods_packing
										+ "<p>购买数量<input type='text' class='inp'></td>"
							}
						}
					}
					if (num == 1) {
						html11 += html3 + html5 + "</tr>";
					} else {
						html1 += html4 + html5 + "</tr>";
					}
				}
			}

			var miandiv = $("#miandiv");

			var miandiv_left = miandiv.offset().left;

			var all = $("div.g4hj984u5h0jerh04r0");

			var all_left = all.offset().left;

			var t1 = $("#table1");

			var t1_left = t1.offset().left;

			var left_dif = t1_left - all_left;

			t1.html(html + html11 + html1 + html2);

			all.width(t1.outerWidth() + left_dif * 2);

			miandiv.width(all.outerWidth() + all_left - miandiv_left);

			$("#table1").on("click", ".selectData", function() {
				if ($(this).hasClass('selected')) {
					$(this).removeClass('selected')
				} else {
					$(this).addClass('selected')
				}
			});

		}
	</script>

</body>
</html>


</html>