<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目成员管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/projectUser/list?projectId=${param.projectId}">项目成员列表</a></li>
		<li class="active"><a href="${ctx}/projectUser/add?projectId=${param.projectid}">项目成员${not empty param.projectId?'修改':'添加'}</a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/projectUser/saveentity" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${param.id}">
		<input type="hidden" name="projectId" value="${param.projectId}${entity.projectId}">
		
		<sys:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">登录名:</label>
			<div class="controls">
			<input type="text" name="username" id="username" value="${entity.username}" />
			</div>
		</div>

		

		<div class="form-actions">
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>