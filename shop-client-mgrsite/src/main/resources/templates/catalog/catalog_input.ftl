<div class="panel panel-default">
	<div class="panel-body">
		<form action="/catalog/save" method="post" id="catalogEditForm">
			<input type="hidden" name="id" value="${catalog.id}"/>
			<div class="modal-body">
				<div class="form-group">
					<label for="exampleInputEmail1">分类编号</label> <input
						class="form-control" name="code" value="${catalog.code}"/>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">分类名</label> <input
						class="form-control" name="name" value="${catalog.name}"/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						data-dismiss="modal"  onclick="deleteCatalog(${catalog.id})">删除</button>
					<button type="button" class="btn btn-primary" id="eidtButton" onclick="eidtCatalog()">保存</button>
				</div>
			</div>
		</form>
	</div>
</div>