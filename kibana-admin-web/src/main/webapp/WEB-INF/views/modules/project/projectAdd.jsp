<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
	<link href="${ctxStatic}/jpicker/jPicker.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="${ctxStatic}/jpicker/jpicker-1.1.6.js"></script>
	
	<script type="text/javascript">        
	  $(document).ready(
	    function()
	    {
	      $('.colorpicker').jPicker();
	    });
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/project/list">项目列表</a></li>
		<li class="active"><a href="${ctx}/project/add?id=${user.id}">项目<shiro:hasPermission name="sys:user:edit">${not empty user.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/project/save" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${param.id}">
		<sys:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">项目名称:</label>
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
			<label class="control-label">颜色:</label>
			<div class="controls">
			<input type="text" name="color" class="colorpicker" id="color" value="${entity.color}" />
			</div>
		</div>

		<div class="form-actions">
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>