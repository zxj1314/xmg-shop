<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小码商城管理平台</title> <#include "../common/header.ftl"/>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript">
	$(function(){
		$("#saveButton").click(function() {
			$("#productSkuSaveForm").ajaxSubmit(function(data) {
				if (data.success) {
					$.messager.confirm("提示", "保存成功", function() {
						window.location.href = "/productList.do";
					})
				} else {
					$messager.alert("提示", data.msg);
				}
			})
		});
	})

	//var num 
	function clickProperty(obj){
		//sku属性id
		var propertyId =  $(obj).data("id")
		
		if($(obj).attr("class") == "label label-success"){
			
			//取消选中sku属性
			$(obj).attr("class","label label-default");
			
			removeSkuProperty(propertyId);
		}else{
			
			//选中sku属性
			$(obj).attr("class","label label-success");
			
			selectSkuProperty(propertyId);
		}
		
	}
	
	//选中sku属性后生成属性值表格
	function selectSkuProperty(skuPropertyId){
		$.ajax({ 
			url: "/getSkuPropertyValueTable.do?skuPropertyId="+skuPropertyId, 
			dataType:"html",
			success: function(html){
		    	$("#skuProValDiv").append(html);
			}
		});
	}
	
	//取消选中sku属性后删除属性表格
	function removeSkuProperty(skuPropertyId){
		$("#skuProValTable"+skuPropertyId).remove();
	}
	
	//添加一行
	function addSkuPropertyTr(skuPropertyId){
		var $tr = $("#propertyTrTemplate").html();
		$("#skuProValTable"+skuPropertyId).find("tbody").append($tr);
	}
	
	//删除一行
	function deleteSkuPropertyTr(obj){
		$(obj).closest("tr").remove();
	}
	
	//生成sku
	function genarateSku(){
		var skuDiv = $("#skuDiv");
		skuDiv.empty();
		
		//获取选择的sku属性
		var skuProSpan = $(".label-success");
		if(skuProSpan.length == 0){
			alert("请选择sku属性");
			return;
		}
		
		//定义一个sku属性数组
		var skuProArray = [];
		for(var i=0;i < skuProSpan.length;i++){
			var skuProId = $(skuProSpan[i]).data("id");
			var skuProName = $(skuProSpan[i]).text();
			skuProArray.push({"id":skuProId,"name":skuProName});
		}
		
		//获取sku属性值
		var skuProValInput = $(".sku-pro-val");
		if(skuProValInput.length == 0){
			alert("请填写sku属性值");
		}
		
		//定义一个sku属性值数组
		var skuProArrayValArray = [];
		for(var i = 0;i < skuProValInput.length;i++){
			//拿到sku属性值
			var skuProVal = $(skuProValInput[i]).val();
			var skuProId = $(skuProValInput[i]).closest("table").attr("id");
			//提前字符串中的ID
			skuProId = skuProId.replace("skuProValTable","");
			skuProArrayValArray.push({"value":skuProVal,"skuProperty":{"id":skuProId}});
		}
		
		var obj = {
				"productId":${product.id},
				"skuPropertieList":skuProArray,
				"skuPropertyValueList":skuProArrayValArray
		};
		
		 $.ajax({
	            type: "POST",
	            contentType: "application/json",
	            url: "/generateSkuList.do",
	            data: JSON.stringify(obj),
	            dataType: 'html',
	            success: function(data){
	            	$("#skuDiv").empty();
	            	$("#skuDiv").append(data);
	            }
	        })
	        
	        
	}

</script>
</head>
<body>
	<input type="hidden" id="productIdHidden" />
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3"><#assign currentMenu="product_list" /> <#include "../common/menu.ftl" /></div>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>生成SKU</h3>
				</div>
				<!-- 提交商品SKU表单 -->
				<form action="/productSkuSave.do" method="post" id="productSkuSaveForm">
					<table class="table table-bordered">
						<tr>
							<td><b>商品名：</b>${product.name}</td>
							<td><b>商品编号：</b>${product.code}</td>
						</tr>
					</table>
					<input name="product.id" value="${product.id}" type="hidden"/>
					
					<div id="skuProDiv">
						<#list skuPropertyList as data>
							<span style="cursor: pointer; font-size: 13px;margin-right: 10px;" class="label label-default" onclick="clickProperty(this)" data-id="${data.id}">
								${data.name}
							</span>
						</#list>
					</div>
					<div id="skuProValDiv" style="margin-top: 20px;"></div>
	
					<h2>
						<button type="button" class="btn btn-default" onclick="genarateSku()">生成SKU数据</button>
					</h2>
					<div id="skuDiv"></div>
					
					<div class="modal-footer">

						<button type="button" class="btn btn-primary" id="saveButton">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 每一行的模板 -->
	<script type="text/x-template" id="propertyTrTemplate">
		<tr>
			<td>
				<button class="btn btn-default" type="button"  onclick="deleteSkuPropertyTr(this)">
					— 移除
				</button>
			</td>
			<td><input type="text" class="form-control"/></td>
			<td><input type="file"/></td>
		</tr>
	</script>
</body>
</html>






