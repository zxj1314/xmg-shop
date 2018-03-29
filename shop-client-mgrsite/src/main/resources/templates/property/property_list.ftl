<div class="panel panel-default">
	<div class="panel-body">
		<h3>分类属性：</h3>
			<div class="modal-body">
				<table class="table table-hover">
					<tr>
						<th>属性名</th>
						<th>属性类型</th>
						<th>操作</th>
					</tr>
					<tbody id="propertyTbody">
					<#list list as data>
						<tr>
							<td>${data.name}</td>
							<td>
								${data.propertyType}
								<#if data.type == 2>
									<a href="javascript:showProperty(${data.id});">查看属性值</a>
								</#if>
							</td>
							<td>
								<a href="javascript:addCatalogProperty(${data.id})">编辑</a>
								/
								<a href="javascript:deleteCatalogProperty(${data.id},${data.catalogId})">删除</a>
							</td>
						</tr>
					</#list>
					</tbody>
				</table>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="addCatalogProperty(-1)">新增分类属性</button>
				</div>
			</div>
	</div>
</div>