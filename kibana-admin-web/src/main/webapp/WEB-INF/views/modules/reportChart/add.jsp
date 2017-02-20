<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>用户管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	
</script>

<style type="text/css">
.item2{width:250px;float:left;margin:10px}
.img02{height:200px;}
.item2 a {
	display: block;
	position: relative;
}

.item2 a span {
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	z-index: 5;
	background-color: #000;
	filter: alpha(opacity = 10); /*IE滤镜，透明度50%*/
	-moz-opacity: 0.1; /*Firefox私有，透明度50%*/
	opacity: 0.2; /*其他，透明度50%*/
	color:#fff
}

.item2 a:hover span {
	display: none
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a
			href="${ctx}/reportChart/list?projectId=${param.projectId}">图表列表</a></li>
		<li class="active"><a href="#">图表<shiro:hasPermission
					name="sys:user:edit">${not empty user.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form id="inputForm" action="${ctx}/reportChart/save" method="post"
		class="form-horizontal">
		<input type="hidden" name="id" value="${param.id}"> <input
			type="hidden" name="id" value="${param.projectId}">

		<sys:message content="${message}" />

		<div class="control-group">
			<label class="control-label">图表类型:</label>
			<div class="controls">
				<div class="item2">
					<a href="#"> <img
						src="${ctxStatic}/image/base/line-chart.png"
						class="img02" title="双击新建折线图" ondblclick="location.href='${ctx}/reportChart/add/line?projectId=${param.projectId}'"/> 
						<span>折线图</span>
					</a>
				</div>
				<div class="item2">
					<a href="#"> <img
						src="${ctxStatic}/image/base/pipe-chart.png"
						class="img02"  title="双击新建饼图" ondblclick="location.href='${ctx}/reportChart/add/pipe?projectId=${param.projectId}'"/> 
						<span>饼图</span>
					</a>
				</div>
				<div class="item2">
					<a href="#"> <img
						src="${ctxStatic}/image/base/bar-chart.png"
						class="img02"  title="双击新矩形图" ondblclick="location.href='${ctx}/reportChart/add/bar?projectId=${param.projectId}'"/> 
						<span>矩形图</span>
					</a>
				</div>
			</div>
		</div>

		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form>
</body>
</html>