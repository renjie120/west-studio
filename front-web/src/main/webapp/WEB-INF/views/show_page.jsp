<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>${pageinfo.name}展示</title>
<meta name="decorator" content="default" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">
<script src="${ctxStatic }/jquery/jquery-1.8.3.min.js"></script>

<style type="text/css">
.chart-box {
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	padding: 32px 40px;
	margin: 10px 5px auto;
	float: left;
	
	height: 400px;
	background: #FFFFFF;
	box-shadow: 0 0 6px 0 rgba(0,0,0,.12),0 10px 12px 0 rgba(170,182,206,.2),inset 0 -1px 0 0 rgba(255,255,255,.3);
}

.table-box {
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	padding: 0px 0px;
	margin: 10px 5px auto;
	float: left;

	height: 460px;
	overflow: auto;
	background-color: white;
}

.number-box{
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	    padding: 32px 40px;
	float: left;
	width: 220px;
	height: 100px;
	background: #ffffff;
	margin:2px 2px;
	box-shadow: 0 0 6px 0 rgba(0,0,0,.12),0 10px 12px 0 rgba(170,182,206,.2),inset 0 -1px 0 0 rgba(255,255,255,.3);
}
.ibox-title{
font-size: 14px;
font-weight: 700;
}
.ibox-number{
margin:15px 0;
font-size: 36px;
}
body {
	background: #E8EBED;
}

.chart-box:hover {
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.5);
	transition: box-shadow 0.5s;
}

.number-box:hover {
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.5);
	transition: box-shadow 0.5s;
}

</style>
</head>
<body>
<div>
<c:if test="${not empty pageinfo.schemax }">
<form action="#" >
${pageinfo.schemax }

</form>
</c:if>

</div>
<c:if test="${fn:length(numbers) >0}">
<div id="number-area"  style="width: 90%; 	height: 150px;clear:both;">
		<c:forEach items="${numbers}" var="entity">
			<div class="number-box">
			                <div class="ibox float-e-margins">
			                    <div class="ibox-title">
			                        ${entity.name }
			                    </div>
			                      <div class="ibox-number">
			                    <c:if test="${not empty entity.formatPattern }">
			                     <fmt:formatNumber value="${entity.script }"  pattern="${entity.formatPattern }"/>
			                    </c:if>
			                      <c:if test="${empty entity.formatPattern }">
			                       <fmt:formatNumber value="${entity.script }"  pattern="#,###.##"/>
			                      </c:if>
			                    
			                    </div>
			                </div>
			</div>
            </c:forEach>
   </div>
      <div style="width: 100%; height: 20px"></div>
   
   </c:if>
   
	<div id="bg" style="width: 90%; height: 100%">

		<c:forEach items="${componnets}" var="entity">
			<c:set var="com_id" value="container_table_${entity.id}"></c:set>
			<c:set var="com_width" value="590"></c:set>
			
			<c:if test="${entity.type=='chart'}">
				<c:set var="com_id" value="container_chart_${entity.id}"></c:set>
				<c:set var="com_width" value="520"></c:set>
			</c:if>
			<div class="${entity.type}-box">
			<c:if test="${ empty entity.style}">				
					<div style="width: ${com_width}px; height: 400px;" id="${com_id}"></div>
			</c:if>
			<c:if test="${not empty entity.style}">
					<div style="${entity.style}" id="${com_id}"></div>
			</c:if>
			</div>

		</c:forEach>
	</div>
	<script src="${ctxStatic}/echarts/echarts-all-3.js"></script>
	<script type="text/javascript">
// 基于准备好的dom，初始化echarts图表
<c:forEach items="${componnets}" var="entity">
<c:if test="${entity.type=='chart'}">
var myChart_${entity.id} = echarts.init(document.getElementById('container_chart_${entity.id}'));
var option_${entity.id} = ${entity.script};
myChart_${entity.id}.setOption(option_${entity.id});
</c:if>

<c:if test="${entity.type=='table'}">
$('#container_table_${entity.id}').load("${ctx}/dataTable/tableShow?id=${entity.id}&${params}");
</c:if>
</c:forEach>
</script>
</body>
</html>