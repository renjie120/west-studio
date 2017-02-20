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
<%-- 	<form id="searchForm" action="${ctx}/asset/list" method="post"
		class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />

		<ul class="ul-form">
			<li>ip: <input type="text" name="ip"> &nbsp;&nbsp; 机房:
				<select style="width: 150px" name="isValid">
					<option value="-1">全部</option>
					<c:forEach var="item" items="${fns:getDictList('IS_VALID')}">
						<option value="${item.value}"
							<c:if test="${isValid == item.value }">selected</c:if>>${item.label}</option>
					</c:forEach>
			</select>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
			<li class="clearfix"></li>
		</ul>
	</form> --%>
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
						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>