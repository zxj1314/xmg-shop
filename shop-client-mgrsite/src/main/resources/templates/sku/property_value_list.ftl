<div class="modal-body">

		<input type="hidden" name="skuProperty.id" value="${skuProperty.id}"/>
	  <div class="form-group">
	  	<label>
	  		${skuProperty.name}
	  	</label> 
	  	<div id="valueDiv">
		  	<#list list as data>
			    <input type="text" class="form-control" value="${data.value}" style="width: 200px;margin-bottom: 5px;">
		    </#list>
	  	</div>
		<h3><span class="label label-primary" style="cursor: pointer;" onclick="addValue()">+</span></h3>
	  	<div class="modal-footer">
			<button type="button" class="btn btn-primary" onclick="submitValueForm()">关闭</button>
		</div>
	  </div>
</div>


