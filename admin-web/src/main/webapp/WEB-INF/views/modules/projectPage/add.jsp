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
		<li><a href="${ctx}/projectPage/list/${param.projectId}${entity.projectId}">项目页面列表</a></li>
		<li class="active"><a href="#">项目页面<shiro:hasPermission name="sys:user:edit">${not empty user.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/projectPage/save" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${param.id}">
		<input type="hidden" name="projectId" value="${param.projectId}${entity.projectId}">
		<sys:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">页面名称:</label>
			<div class="controls">
			<input type="text" name="name" id="name" value="${entity.name}" />
			</div>
		</div>
			
		<div class="control-group">
			<label class="control-label">状态:</label>
			<div class="controls">
				<select style="width: 150px" name="statux">
					<option value="-1">全部</option>
					<c:forEach var="item" items="${fns:getDictList('IS_VALID')}">
						<option value="${item.value}" <c:if test="${entity.statux == item.value }">selected</c:if>>
							${item.label}
						</option>
					</c:forEach>
					</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">配置:</label>
			<div class="controls">
			<textarea rows="6" style="width:600px" name="schemax" id="schemax" >${entity.schemax}</textarea>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">组件:</label>
			<div class="controls">
			<textarea rows="15" style="width:600px" name="componnet" id="componnet" >${entity.componnet}</textarea>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
						<input type="text" name="sortx" id="sortx" value="${entity.sortx}" />
			</div>
		</div>

		<div class="form-actions">
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>