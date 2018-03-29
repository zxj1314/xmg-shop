<ul id="menu" class="list-group">
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#usermanage_detail"><span>用户管理</span></a>
		<ul class="panel-collapse collapse" id="usermanage_detail">
			<li class=""><a href="/real_auth_list.do">商城用户管理</a></li>
			<li class=""><a href="/recharge_offline_list.do">系统管理员管理</a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#permissionmanage_detail"><span>安全管理</span></a>
		<ul class="panel-collapse collapse" id="permissionmanage_detail">
			<li class="systemDictionary"><a href="/systemDictionary_list.do"><span>系统数据字典目录</span></a></li>
			<li class="systemDictionaryItem"><a href="/systemDictionaryItem_list.do"><span>系统数据字典明细</span></a></li>
			<li><a href="/permission_list.do"><span>权限管理</span></a></li>
			<li><a href="#"><span>角色管理</span></a></li>
			<li><a href="#"><span>菜单管理</span></a></li>
			<li class="ipLog"><a href="/ipLog.do"><span>登录历史</span></a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#product_list">
			<span>商品管理</span>
		</a>
		<ul class="in" id="product_list">
			<li class="brand_list"><a href="/brand">商品品牌</a></li>
			<li class="add_product"><a href="/product/add">商品录入</a></li>
			<li class="product_list"><a href="/product/get">商品列表</a></li>
			<li class="catalog"><a href="/catalog">分类管理</a></li>
			<li class="catalogProperty"><a href="/catalogProperty">分类属性管理</a></li>
			<li class="skuProperty"><a href="/skuProperty">sku属性管理</a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#systemmanage_detail">
			<span>平台管理</span>
		</a>
		<ul class="panel-collapse collapse" id="systemmanage_detail">
			<li class="companyBank"><a href="/companyBank_list.do">平台账号管理</a></li>
			<li><a href="/real_auth_list.do">系统账户流水</a></li>
			<li><a href="/bid_request_list.do"> <span>系统设置</span></a></li>
			<li><a href="/bid_request_list.do"> <span>企业资讯</span></a></li>
			<li><span><a href="#">友情链接</a></span></li>
			<li><span><a href="#">广告设置</a></span></li>
		</ul>
	</li>
</ul>

<#if currentMenu??>
<script type="text/javascript">
	$(".in li.${currentMenu}").addClass("active");
</script>
</#if>