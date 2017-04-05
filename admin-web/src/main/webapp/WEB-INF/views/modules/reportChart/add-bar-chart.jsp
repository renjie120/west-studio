<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
	<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-modal/modal.css" />
	<script type="text/javascript" src="${ctxStatic}/jquery-modal/modal.js"></script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/reportChart/list?projectId=${entity.projectId}${param.projectId}">图表列表</a></li>
		<li class="active"><a href='#'>柱状图<shiro:hasPermission name="sys:user:edit">${not empty entity.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/reportChart/save" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${param.id}">
		<input type="hidden" name="chartType" value="bar">
		<input type="hidden" name="projectId" value="${entity.projectId}${param.projectId}">
		
		<sys:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">图表名称:</label>
			<div class="controls">
			<input type="text" name="name" id="name" value="${entity.name}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据:</label>
			<div class="controls">
			
			<select style="width: 150px" name="dataTableId">
					<option value="-1">全部</option>
					<c:forEach var="item" items="${dataTables}">
						<option value="${item.id}" <c:if test="${entity.dataTableId == item.id }">selected</c:if>>
							${item.name}
						</option>
					</c:forEach>
			</select>
			
			<c:if test="${not empty entity.dataTableId}">
		<a href="javascript:;" id="add-key" class="aaa" data-title="数据预览" data-url="${ctx}/dataTable/dataShow?id=${entity.dataTableId}">预览数据</a>
		&nbsp;</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">y轴名称:</label>
			<div class="controls">
			<input type="text" name="yAxisText" id="yAxisText" value="${entity.yAxisText}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据单位:</label>
			<div class="controls">
			<input type="text" name="dataUnit" id="dataUnit" value="${entity.dataUnit}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">配置:</label>
			<div class="controls">
			<textarea rows="5" cols="90" name="config" id="config" >${entity.config}</textarea>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">描述:</label>
			<div class="controls">
			<textarea rows="5" style="width:500px"  name="description" id="description" >${entity.description}</textarea>
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