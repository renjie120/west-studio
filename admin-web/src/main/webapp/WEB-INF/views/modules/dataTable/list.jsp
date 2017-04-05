<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>资产管理</title>
<meta name="decorator" content="default" />

</head>
<body>

	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/dataTable/list">数据表列表</a></li>
		<shiro:hasPermission name="sys:user:edit">
			<li><a href="${ctx}/dataTable/add?projectId=${projectId}">添加数据表</a></li>
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
			
					<td><a href="${ctx}/dataTable/add?id=${entity.id}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>