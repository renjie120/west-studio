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
		<li class="active"><a href="${ctx}/dataView/list">数据视图列表</a></li>
		<shiro:hasPermission name="sys:user:edit">
			<li><a href="${ctx}/dataView/add?projectId=${projectId}">添加数据视图</a></li>
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
					<td>${entity.name}</td>
			
					<td><a href="${ctx}/dataView/add?id=${entity.id}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>