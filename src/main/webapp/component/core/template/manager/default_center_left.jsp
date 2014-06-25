<%@ include file="/component/core/taglib/taglib.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">
		<div class="panel-title">faceye-feature Manager</div>
	</div>
	<div class="panel-body">
		<div class="list-group">
			
			<a class="list-group-item" href="/security/user/home"><fmt:message key="security.user.manager"></fmt:message></a>
<a class="list-group-item" href="/security/role/home"><fmt:message key="security.role.manager"></fmt:message></a>
<a class="list-group-item" href="/security/resource/home"><fmt:message key="security.resource.manager"></fmt:message></a>
<!--@generate-entity-manager-list-group-item@-->
		</div>
	</div>
</div>

<div class="panel panel-primary">
	<div class="panel-heading">
		<div class="panel-title">
			<s:text name="faceye.security.manage.menu" />
		</div>
	</div>
	<div class="panel-body">
		<div class="list-group">
			
		</div>
	</div>
</div>
