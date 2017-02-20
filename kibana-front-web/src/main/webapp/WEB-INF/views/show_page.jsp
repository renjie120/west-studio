<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>${pageinfo.name}展示</title>
<meta name="decorator" content="default" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">
<script src="http://bank.bucuoa.com/static/jquery/jquery-1.8.3.min.js"></script>

<style type="text/css">
.chart-box {
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    padding: 32px 40px;
     margin:10px 5px auto;
     float:left;
     width: 520px; 
     height: 400px;
}
.table-box {
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    padding: 32px 40px;
     margin:10px 5px auto;
     float:left;
     width: 520px; 
     height: 400px;
     overflow:auto;
}
body{background: #E8EBED;}

.chart-box:hover{box-shadow:0 2px 5px rgba(0,0,0,0.5);transition:box-shadow 0.5s;}
</style>
</head>
<body>
<div id="bg" style="width:90%;height:100%" >

	<c:forEach items="${componnets}" var="entity">
	<c:set var="com_id" value="container_table_${entity.id}" ></c:set>     
	<c:if test="${entity.type=='chart'}">
		<c:set var="com_id" value="container_chart_${entity.id}" ></c:set>     
	</c:if>
	<div class="${entity.type}-box">
		<div style="width: 520px; height: 400px;" id="${com_id}"></div>
		</div>
	
	</c:forEach>
</div>	
	<script src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
<script type="text/javascript">
// 基于准备好的dom，初始化echarts图表
<c:forEach items="${componnets}" var="entity">
<c:if test="${entity.type=='chart'}">
var myChart_${entity.id} = echarts.init(document.getElementById('container_chart_${entity.id}'));
var option_${entity.id} = ${entity.script};
myChart_${entity.id}.setOption(option_${entity.id});
</c:if>

<c:if test="${entity.type=='table'}">
$('#container_table_${entity.id}').load("${ctx}/dataTable/tableShow?id=${entity.id}");
</c:if>
</c:forEach>
</script>
</body>
</html>