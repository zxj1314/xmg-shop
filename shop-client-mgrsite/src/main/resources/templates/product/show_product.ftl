<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小码商城管理平台</title> <#include "../common/header.ftl"/>
<link href="/js/plugins/fancybox/jquery.fancybox.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/js/plugins/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/js/plugins/fancybox/jquery.fancybox.pack.js"></script>
<script type="text/javascript">
$(function() {
	
	$('.fancybox').fancybox();
});

</script>
</head>
<body>
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3"><#assign currentMenu="product_list" /> <#include "../common/menu.ftl" /></div>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>${product.name}商品详情</h3>
				</div>

				<div class="panel panel-default">
					<div id="myTabs">

						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#base" aria-controls="base" role="tab" data-toggle="tab">基本信息</a></li>
							<li role="presentation"><a href="#detail" aria-controls="detail" role="tab" data-toggle="tab">商品详情</a></li>
							<li role="presentation"><a href="#image" aria-controls="image" role="tab" data-toggle="tab">商品相册</a></li>
							<li role="presentation"><a href="#property" aria-controls="property" role="tab" data-toggle="tab">商品属性</a></li>
							<li role="presentation"><a href="#sku" aria-controls="sku" role="tab" data-toggle="tab">sku</a></li>
						</ul>

						<!-- 提交商品保存表单 -->
						<form action="/productSave.do" method="post" id="productSaveForm">
							<!-- Tab panes -->
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane active" id="base">
									<!-- 基本信息的页面 -->
									<div style="padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px;">
										<div class="row">
											<div class="col-lg-6">
												<div class="form-group">
													<label>商品名称</label> <input class="form-control" name="product.name" value="${product.name}" readonly="readonly">
												</div>
											</div>
											<div class="col-lg-6">
												<div class="form-group">
													<label>商品编号</label> <input class="form-control" name="product.code" value="${product.code}" readonly="readonly">
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-lg-6">
												<div class="form-group">
													<label>商品品牌</label> <input class="form-control" value="${product.brand.chineseName}" readonly="readonly">
												</div>
											</div>
											<div class="col-lg-6">
												<div class="form-group">
													<label>商品分类</label> <input class="form-control" value="${product.catalog.name}" readonly="readonly">
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-lg-6">
												<div class="form-group">
													<label>市场售价</label> <input class="form-control" name="product.marketPrice" value="${product.marketPrice}" readonly="readonly">
												</div>
											</div>
											<div class="col-lg-6">
												<div class="form-group">
													<label>基础售价</label> <input class="form-control" name="product.basePrice" value="${product.basePrice}" readonly="readonly">
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-lg-12">
												<div class="form-group">
													<label>商品关键字</label> <input class="form-control" placeholder="以逗号分隔" name="product.keyword" value="${product.keyword}" readonly="readonly">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12">
												<div class="form-group">
													<label>商品标签</label>
													<textarea class="form-control" rows="3" placeholder="以逗号分隔" name="product.impressions" readonly="readonly">
														${product.impressions!""}
													</textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div role="tabpanel" class="tab-pane" id="detail">
									<!-- 商品详情 -->
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group">
												<textarea id="desc" name="productDesc.details" class="ckeditor" rows="10">
													${productDesc.details!""}
												</textarea>
											</div>
										</div>
									</div>
								</div>
								<div role="tabpanel" class="tab-pane" id="image">
									<div style="padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px;">
										
										<div class="row">
											<#list productImageList as image>
												<div class="col-lg-3 col-md-6">
													<div class="image-div">
														<a class="fancybox" href='${image.imagePath}' title=''>
															<img class="uploadImg" src='${image.imagePath}'>
														</a>
													</div>
													<#-- <div class="input-group">
														<select class="form-control"> 
														<#list 1..8 as index>
															<option value="${index}">${index}</option> 
														</#list>
														</select> 
														<span class="input-group-addon"> 
														<label> 
															<input type="radio" class="productImageCover" name="productImages[${number}].cover" value="0"> <span>封面</span>
														</label>
														</span>
													</div> -->
												</div>
											</#list>
										</div>
									</div>
								</div>
								<div role="tabpanel" class="tab-pane" id="property">
									<div style="padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px;">
										<table class="table table-bordered catalog-property-table">
											<thead>
												<tr>
													<th>名称</th>
													<th>值</th>
												</tr>
											</thead>
											<tbody id="productPropertyPanel">
												<#list propertyList as vo>
												    <tr>
												        <td>
												        	${vo.name}
												        </td>
												        <td>
												            ${vo.value}
												        </td>
												    </tr>
												</#list>
											</tbody>
										</table>
									</div>
								</div>
								<div role="tabpanel" class="tab-pane" id="sku">
									<div id="productSkuPanel" style="padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px;">
										
										<table class="table table-hover">
											<thead>
												<tr>
													<th>sku编号</th>
													<th>价格</th>
													<#list skuPropertyList as data>
														<th>${data}</th>
													</#list>
													
												</tr>
											</thead>
											<tbody id="tbody">
												<#list productSkuList as data>
												<tr data-id="${data.id}">
											        <td>${data.code}</td>
											        <td>${data.price}</td>
											        <#list data.productSkuPropertyList as data2>
											        	<td>${data2.value}</td>
											        </#list>
												</tr>
												</#list>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>