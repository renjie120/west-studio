<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>资产管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	
</script>
</head>
<body>

	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/projectForm/list?projectId=${param.projectId}">报表页面</a></li>
		<shiro:hasPermission name="sys:user:edit">
			<li><a href="${ctx}/projectForm/add?projectId=${param.projectId}">添加</a></li>
		</shiro:hasPermission>
	</ul>

	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
			

				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.data}" var="entity">
				<tr>
					<td>${entity.name}</td>
			
					<td><a href="${ctx}/projectForm/add?id=${entity.id}">修改</a>
						<a href="${ctx}/dataTable/dataShow?id=${entity.tableId}">预览</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>