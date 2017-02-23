<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
	<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-modal/modal.css?t=1" />
	<script type="text/javascript" src="${ctxStatic}/jquery-modal/modal.js"></script>
	<style type="text/css">
	h1 {
    display: block;
    font-size: 2em;
    -webkit-margin-before: 0.67em;
    -webkit-margin-after: 0.67em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
    font-weight: bold;
}
	</style>

</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/dataTable/list">数据表列表</a></li>
		<li class="active"><a href="${ctx}/dataTable/add?id=${user.id}">数据表<shiro:hasPermission name="sys:user:edit">${not empty user.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/dataTable/save" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${param.id}">
		<sys:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
			<input type="text" name="name" id="name" value="${entity.name}" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">数据源:</label>
			<div class="controls">
			<select style="width: 150px" name="datasourceId">
					<option value="-1">全部</option>
					<c:forEach var="item" items="${datasources}">
						<option value="${item.id}" <c:if test="${entity.datasourceId == item.id }">selected</c:if>>
							${item.name}
						</option>
					</c:forEach>
			</select>
			
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">脚本:</label>
			<div class="controls">
						<textarea rows="15" style="width:600px" name="script" id="script" >${entity.script}</textarea>
						<c:if test="${not empty  param.id}">
		<a href="javascript:;" id="add-key" class="aaa" data-title="${entity.name}" data-url="${ctx}/dataTable/dataShow?id=${param.id}">预览数据</a>
		&nbsp;</c:if>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">参数:</label>
			<div class="controls">
						<textarea rows="5" style="width:600px" name="script" id="script" >${entity.params}</textarea>
			</div>
		</div>

		<div class="form-actions">
		
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
	
	<script type="text/javascript">
    $("#add-key").click(function(){
        $("#add-key").createModal({
            background: "#000",//设定弹窗之后的覆盖层的颜色
            width: "1000px",//设定弹窗的宽度
            height: "500px",//设定弹窗的高度
            resizable: true,//设定弹窗是否可以拖动改变大小
            html: ""
        });
    });
	</script>
</body>
</html>