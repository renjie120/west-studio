<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/dataView/list">数据视图列表</a></li>
		<li class="active"><a href="${ctx}/dataView/add?id=${user.id}">数据视图<shiro:hasPermission name="sys:user:edit">${not empty user.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/dataView/save" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${param.id}">
		<sys:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">页面名称:</label>
			<div class="controls">
			<input type="text" name="name" id="name" value="${entity.name}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">脚本:</label>
			<div class="controls">
						<textarea rows="5" cols="90" name="script" id="script" >${entity.script}</textarea>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">schema:</label>
			<div class="controls">
			<textarea rows="5" cols="90" name="schema" id="schema" >${entity.schema}</textarea>
			</div>
		</div>
		<div class="form-actions">
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>