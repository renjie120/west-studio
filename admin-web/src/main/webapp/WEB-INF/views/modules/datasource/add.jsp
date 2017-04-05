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
		<li><a href="${ctx}/datasource/list">数据源列表</a></li>
		<li class="active"><a href="${ctx}/datasource/add?id=${user.id}">数据源<shiro:hasPermission name="sys:user:edit">${not empty user.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/datasource/save" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${param.id}">
		<sys:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
			<input type="text" name="name" id="name" value="${entity.name}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类型:</label>
			<div class="controls">
			<select style="width: 150px" name="datasourceType">
					<option value="-1">全部</option>
					<c:forEach var="item" items="${fns:getDictList('SYS_DATASOURCE_TYPE')}">
					<c:if test="${item.description != '0'}">
						<option value="${item.value}" <c:if test="${entity.datasourceType == item.value }">selected</c:if>>
							${item.label}
						</option>
					</c:if>
					</c:forEach>
			</select>
			
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">url:</label>
			<div class="controls">
			<input type="text" name="url" id="url" value="${entity.url}" style="width:600px"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">登录名:</label>
			<div class="controls">
				<input type="text" name="uerName" id="uerName" value="${entity.uerName}" class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密码:</label>
			<div class="controls">
			<input type="text" name="password" id="password" value="${entity.password}" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">driver:</label>
			<div class="controls">
			<input type="text" name="driver" id="driver" value="${entity.driver}" />
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

		<div class="form-actions">
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>