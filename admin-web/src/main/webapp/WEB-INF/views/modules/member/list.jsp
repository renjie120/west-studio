<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>成员管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	function deletex(id)
	{
		if(confirm("是否删除？"))
			{
				location.href="${ctx}/projectUser/delete?id="+id;
			}
	}
</script>
</head>
<body>

	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/projectUser/list">项目成员列表</a></li>
			<li><a href="${ctx}/projectUser/add?projectId=${param.projectId}">添加项目成员</a></li>
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
					<td>${entity.username}</td>
			
					<td>
					<a href="#" onclick="deletex(${entity.id})" >删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>