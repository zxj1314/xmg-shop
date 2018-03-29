<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小码商城管理平台</title>
<#include "../common/header.ftl"/>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js" ></script>

<script type="text/javascript">
		//console.error("Hello World")		
	$(function(){
		$("#query").click(function(){
			$("#currentPage").val(1);
			$("#searchForm").submit();
		});
		
		$("#pagination_container").twbsPagination({
			totalPages:${pageResult.totalPage},
			visiblePages:5,
			startPage:${pageResult.currentPage},
			first:"首页",
			prev:"上一页",
			next:"下一页",
			last:"末页",
			onPageClick:function(event,page){
				$("#currentPage").val(page);
				$("#searchForm").submit();
			}
		});
		
		$("table > tbody > tr").click(function () {
			$("table > tbody > tr").removeClass("active");
			
		    $(this).addClass("active");
		    
		    $("#productIdHidden").val($(this).data("id"));
	    });
		
		$(".edit-product").click(function(){
			if($("#productIdHidden").val() && $("#productIdHidden").val() != ""){
				
				$.messager.alert($("#productIdHidden").val())
			}else{
				
				$.messager.alert("请选择需要编辑的商品")
			}
		})
		
		$(".show-product").click(function(){
			if($("#productIdHidden").val() && $("#productIdHidden").val() != ""){
				
				window.location.href = "/product/get/"+$("#productIdHidden").val();
			}else{
				
				$.messager.alert("请选择需要查看的商品")
			}
		})
		
		$(".generate-sku").click(function(){
			if($("#productIdHidden").val() && $("#productIdHidden").val() != ""){
				window.location.href = "/productSku/"+$("#productIdHidden").val();
			}else{
				
				$.messager.alert("请选择需要生成sku的商品")
			}
		})
		
		//showProduct.do
	});
</script>
</head>
<body>
<input type="hidden" id="productIdHidden"/>
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3">
				<#assign currentMenu="product_list" />
				<#include "../common/menu.ftl" />
			</div>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>商品管理</h3>
				</div>
				<div class="row">
					<!-- 提交分页的表单 -->
					<form id="searchForm" class="form-inline" method="post" action="/product/get">
						<input type="hidden" name="currentPage" id="currentPage" value=""/>
						<div class="form-group">
						</div>
						<div class="form-group">
						    <label>关键字</label>
						    <input class="form-control" type="text" name="keyword" value="${(qo.keyword)!''}">
						</div>
						<div class="form-group">
							<button id="query" type="button" class="btn btn-success"><i class="icon-search"></i> 查询</button>
							<a href="javascript:;" class="btn btn-success edit-product">编辑商品</a>
							<a href="javascript:;" class="btn btn-success show-product">查看商品</a>
							<a href="javascript:;" class="btn btn-success generate-sku">生成sku</a>
						</div>
					</form>
				</div>
				<div class="panel panel-default">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>商品编号</th>
								<th>商品名称</th>
								<th>分类</th>
								<th>品牌</th>
								<th>市场价格</th>
								<th>基础价格</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<#list pageResult.list as data>
							<tr data-id="${data.id}">
						        <td>${data.code}</td>
								<td><a href="#">${data.name}</a></td>
								<td>${data.catalog.name}</td>
								<td>${data.brand.chineseName}</td>
								<#--<td>${data.loginTime?string("yyyy-MM-dd HH:mm:SS")}</td>-->
						        <td>${data.marketPrice}</td>
						        <td>${data.basePrice}</td>
							</tr>
							</#list>
						</tbody>
					</table>
					<div style="text-align: center;" id="pagination_container">
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>