<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小码商城管理平台</title> <#include "../common/header.ftl"/>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>

</head>
<body>
	<input type="hidden" id="productIdHidden" />
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3"><#assign currentMenu="product_list" /> <#include "../common/menu.ftl" /></div>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>SKU管理</h3>
				</div>

				<div id="productSkuPanel" style="padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px;">

					<table class="table table-hover">
						<thead>
							<tr>
								<th>sku编号</th>
								<th>价格</th> <#list skuPropertyList as data>
								<th>${data}</th> </#list>

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
	</div>

</body>
</html>






