<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小码商城管理平台</title> <#include "../common/header.ftl"/>
<link rel="stylesheet"
	href="/js/plugins/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript"
	src="/js/plugins/ztree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript"
	src="/js/plugins/ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript">
	var setting = {
		async : {
			enable : true,
			url : "/catalog/get",
			autoParam : [ "id" ]
		},
		callback : {
			onClick : zTreeOnClick
		}
	};

	function zTreeOnClick(event, treeId, treeNode) {

		//给新增分类的模态框的父分类名设值
		$("#parentCatalog").val(treeNode.name);
		//给新增分类的模态框的父分类id设值
		$("#parentCatalogId").val(treeNode.id);
		
		//清空分类属性面板内容
		$("#catalogPropertyPanel").empty();
		
		//重新通过分类ID加载分类属性面板内容
		$("#catalogPropertyPanel").load("/catalogProperty/get/"+treeNode.id)
		
	};
	var treeObj;
	$(document).ready(function() {
		
		treeObj = $.fn.zTree.init($("#catalogTree"), setting);
		
	});
	
	//打开分类属性值的模态框
	function showProperty(id){
		$("#propertyValueModal").modal("show");
		
		//情况分类属性值模态框内容
		$("#catalogPropertyValueForm").empty();
		
		//重新通过分类属性ID或者分类属性值模态框内容
		$("#catalogPropertyValueForm").load("/catalogPropertyValue/get/"+id)
		
	}
	
	//添加分类属性值的input元素
	function addValue(){
		var valueDivTemplate = $("#valueDivTemplate").html();
		$("#valueDiv").append(valueDivTemplate);
	}
	
	//删除分类属性值input元素
	function deleteValue(obj,id){
		$(obj).parent().parent().remove();
		if(id != 0){
			$.ajax({
				url:"/catalogPropertyValue/delete/"+id,
				dataType:"json",
			})
		}
	}
	
	//提交分类属性值表单
	function submitValueForm(){
		var form = $("#catalogPropertyValueForm");
		$("#propertyValueModal").modal("hide");
		var $input = $("input[name='value']")
		if($input.val()){
			form.ajaxSubmit(function(data) {
				
			});
		}
		return false;
	}
	
	//打开添加分类属性模态框
	function addCatalogProperty(propertyId){
		//获取当前选择的分类
		var sNodes = treeObj.getSelectedNodes();
		$("#propertyFormContent").load("/catalogProperty/add?id="+propertyId+"&catalogId="+sNodes[0].id);
		
		$("#propertyModal").modal("show");
	}
	
	//保存分类属性
	function saveCatalogProperty(){
		var form = $("#catalogPropertyForm");
		$("#propertyModal").modal("hide");
		form.ajaxSubmit(function(data) {
			if (data.success) {
				$.messager.confirm("提示", "保存成功!", function() {
					window.location.reload();
				});
			} else {
				$.messager.alert("提示", data.msg);
			}
		});
	}
	
	//删除分类属性
	function deleteCatalogProperty(id,catalogId){
		$.messager.confirm("提示", "确定删除吗？", function() {
			//删除分类属性，并重新通过分类ID加载分类属性面板内容
			$("#catalogPropertyPanel").load("/catalogProperty/delete?id="+id+"&catalogId="+catalogId);
		});
		
	}
</script>
</head>
<body>
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3"><#assign currentMenu="catalogProperty" />
				<#include "../common/menu.ftl" /></div>
			<div class="col-sm-9">


				<div class="page-header">
					<h3>分类属性管理</h3>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<ul id="catalogTree" class="ztree"></ul>
					</div>
					<div class="col-sm-8"  id="catalogPropertyPanel">
						
					</div>
				</div>
			</div>
		</div>
		
		<!-- 新增分类属性值模态框 -->
		<div class="modal fade" id="propertyValueModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">分类属性值</h4>
					</div>
					
					<!-- 提交添加分类属性值的表单 -->
					<form action="/catalogPropertyValue/add" method="post" id="catalogPropertyValueForm">
						
					</form>
				</div>
			</div>
		</div>
		
		<!-- 新增分类属性模态框 -->
		<div class="modal fade" id="propertyModal">
			<div class="modal-dialog" >
				<div class="modal-content" id="propertyFormContent"></div>
			</div>
		</div>
	</div>
<!-- 属性值的模板 -->
<script type="text/x-template" id="valueDivTemplate">
	<div style="height: 50px;">
		<input type="text" class="form-control" name="value" style="width: 200px;margin-bottom: 5px;float: left;">
		<h3 style="float: left;margin: 0;">
			<span class="label label-primary" style="cursor: pointer;" onclick="deleteValue(this,0)">-</span>
		</h3>
	</div>
</script>
</body>
</html>







