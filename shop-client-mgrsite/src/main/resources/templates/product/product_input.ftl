<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小码商城管理平台</title> <#include "../common/header.ftl"/>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/js/plugins/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/js/plugins/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".image-div .js-upload").uploadify(
				{

					buttonText : "选择图片",
					fileObjName : "file",
					fileTypeDesc : "商品图片",
					fileTypeExts : "*.gif; *.jpg; *.png",
					swf : "/js/plugins/uploadify/uploadify.swf",
					uploader : "/product/upload",
					overrideEvents : [ "onUploadSuccess", "onUploadProgress",
							"onSelect" ],
					onUploadSuccess : function(file, data) {
						var $wrapper = this.wrapper;
						var $div = $wrapper.parent('div').parent('div');
						//data = JSON.parse(data);
						$div.find('img').attr('src', data);
						$div.find('input').val(data);
						//$div.find('input').val(data.id);
					}
				});

		
	})

	$(function() {

		var editor = CKEDITOR.replace('desc');

		$('#myTabs a').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		});

		$("#saveButton").click(function() {
			$("#desc").html(editor.getData());
			$("#productSaveForm").ajaxSubmit(function(data) {
				if (data.success) {
					$.messager.confirm("提示", "保存成功", function() {
						window.location.href = "/product/get";
					})
				} else {
					$messager.alert("提示", data.msg);
				}
			})
		});

	});
	
	function changeCatalog(obj){
		var catalogId = $(obj).val();
		if (catalogId){
			//重新加载商品的属性面板
			$('#productPropertyPanel').load(
					'/catalogProperty/propertyValue/get/'
							+ catalogId);
			//重新加载商品sku
			/* $('#productSkuPanel').load(
				'/getSkuPropertyPanel.do?catalogId='
						+ catalogId); */
		}
		else {
			//商品属性面板
			$('#productPropertyPanel').empty();
			//sku面板
			$('#productSkuPanel').empty();
		}
	}
</script>
</head>
<body>
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3">
			<#assign currentMenu="add_product" /> 
			<#include "../common/menu.ftl" /></div>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>商品录入</h3>
				</div>

				<div class="panel panel-default">
					<div id="myTabs">

						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#base" aria-controls="base" role="tab" data-toggle="tab">基本信息</a></li>
							<li role="presentation"><a href="#detail" aria-controls="detail" role="tab" data-toggle="tab">商品详情</a></li>
							<li role="presentation"><a href="#image" aria-controls="image" role="tab" data-toggle="tab">商品相册</a></li>
							<li role="presentation"><a href="#property" aria-controls="property" role="tab" data-toggle="tab">商品属性</a></li>
							<!-- <li role="presentation"><a href="#sku" aria-controls="sku" role="tab" data-toggle="tab">sku</a></li>-->						
						</ul>

						<!-- 提交商品保存表单 -->
						<form action="/product/add" method="post" id="productSaveForm">
							<!-- Tab panes -->
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane active" id="base">
									<!-- 基本信息的页面 -->
									<#include "product_base_info.ftl"/>
								</div>
								<div role="tabpanel" class="tab-pane" id="detail">
									<!-- 商品详情 -->
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group">
												<textarea id="desc" name="productDesc.details" class="ckeditor" rows="10"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div role="tabpanel" class="tab-pane" id="image">
									<div style="padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px;">
										<#macro productImage number>
										<div class="col-lg-3 col-md-6">
											<div class="image-div">
												<div>
													<a href="javascript:;" id="uploadImage-btn${number}" class="js-upload">上传</a>
												</div>
												<img class="uploadImg"> <input type="hidden" name="productImages[${number}].imagePath"> <#-- <input type="hidden" name="productImages[${number}].id"> -->
											</div>
											<div class="input-group">
												<select class="form-control" name="productImages[${number}].sequence"> 
													<#list 1..8 as index>
														<option value="${index}">${index}</option> 
													</#list>
												</select> 
												<span class="input-group-addon"> 
												<label> 
													<input type="radio" class="productImageCover" name="productImages[${number}].cover" value="0"> 
													<span>封面</span>
												</label>
												</span>
											</div>
										</div>
										</#macro>
										<div class="row"><#list 0..7 as number> <@productImage number/> </#list></div>
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
											</tbody>
										</table>
									</div>
								</div>
								<!-- <div role="tabpanel" class="tab-pane" id="sku">
									<div id="productSkuPanel" style="padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px;">
										
									</div>
								</div> -->
							</div>
							<div class="modal-footer">

								<button type="button" class="btn btn-primary" id="saveButton">保存</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>