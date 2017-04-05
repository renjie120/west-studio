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
		<li class="active"><a href="${ctx}/project/list">我的项目</a></li>
		<shiro:hasPermission name="sys:user:edit">
			<li><a href="${ctx}/project/add">添加</a></li>
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
					<td><a href="${ctx}/project/add?id=${entity.id}" title="修改${entity.name}">${entity.name}</a></td>
					<td>
						<a href="${ctx}/reportChart/list?projectId=${entity.id}" target="mainFrame" onclick="top.addTab2($(this))" data-href="/reportChart/list?id=${entity.id}" title="设计${entity.name}图表"><img src="${ctxStatic}/image/chart.gif" width="25" /></a>
						<a href="${ctx}/projectForm/list?projectId=${entity.id}" target="mainFrame" onclick="top.addTab2($(this))" data-href="/projectForm/list?id=${entity.id}"  title="设计${entity.name}报表"><img src="${ctxStatic}/image/form.gif" width="20"/></a>
						<a href="${ctx}/projectPage/list/${entity.id}" target="mainFrame" onclick="top.addTab2($(this))" data-href="/projectPage/list/${entity.id}"  title="设计${entity.name}页面"><img src="${ctxStatic}/image/page.gif" width="20"/></a>
						<a href="${ctx}/projectUser/list?projectId=${entity.id}" target="mainFrame" onclick="top.addTab2($(this))" data-href="/projectUser/list?projectId=${entity.id}"  title="${entity.name}成员"><img src="${ctxStatic}/image/user_icon.jpg" width="20"/></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>