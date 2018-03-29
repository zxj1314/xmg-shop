<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小码商城管理平台</title> <#include "../common/header.ftl"/>
<link rel="stylesheet"
	href="/js/plugins/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript"
	src="/js/plugins/ztree/js/jquery.ztree.core.js"></script>
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
		
		$("#catalogPanel").load("/catalog/add/"+treeNode.id)
	};

	$(document).ready(function() {
		$.fn.zTree.init($("#catalogTree"), setting);

		$("#addButton").click(function() {
			
			$("#myModal").modal("show");
			$("#code").val("");
			$("#name").val("");
		});

		$("#saveButton").click(function() {
			var form = $("#catalogSaveForm");
			$("#myModal").modal("hide");
			form.ajaxSubmit(function(data) {
				if (data.success) {
					$.messager.confirm("提示", "保存成功!", function() {
						window.location.reload();
					});
				} else {
					$.messager.alert("提示", data.msg);
				}
			});
			return false;
		});

	});
	
	//修改分类
	function eidtCatalog(){
		var form = $("#catalogEditForm");
		form.ajaxSubmit(function(data) {
			if (data.success) {
				$.messager.alert("提示", "修改成功");
			} else {
				$.messager.alert("提示", data.msg);
			}
		});
	}
	
	//删除分类
	function deleteCatalog(id){
		$.get("/catalog/delete/"+id,
		  function(data){
			if (data.success) {
				$.messager.confirm("提示", "删除成功!", function() {
					window.location.reload();
				});
			} else {
				$.messager.alert("提示", data.msg);
			}
		  }
		);
	}
	
</script>
</head>
<body>
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3"><#assign currentMenu="catalog" />
				<#include "../common/menu.ftl" /></div>
			<div class="col-sm-9">


				<div class="page-header">
					<h3>分类管理</h3>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<button type="button" class="btn btn-primary" id="addButton">添加分类</button>
						<ul id="catalogTree" class="ztree"></ul>
					</div>
					<div class="col-sm-8" id="catalogPanel">
						
					</div>
				</div>
			</div>
		</div>
		
		<!-- 添加分类模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">添加分类</h4>
					</div>
					<form action="/catalog/save" method="post" id="catalogSaveForm">
						<div class="modal-body">
							<div class="form-group">
								<label for="exampleInputEmail1">上级分类</label> <input
									type="hidden" name="parentCatalogId" id="parentCatalogId" /> <input
									class="form-control" value="顶级分类" readonly="readonly"
									id="parentCatalog">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">分类编号</label> <input
									class="form-control" name="code" id="code"/>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">分类名</label> <input
									class="form-control" name="name" id="name">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary" id="saveButton">保存</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>







