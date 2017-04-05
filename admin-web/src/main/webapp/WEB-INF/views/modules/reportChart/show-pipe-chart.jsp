<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh_CN">

<head>
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
    margin: auto;
     width: 800px; 
     height: 500px;
     background:#FFF;
}
body{background: #E8EBED;}

.chart-box:hover{box-shadow:0 2px 5px rgba(0,0,0,0.5);transition:box-shadow 0.5s;}
</style>

</head>
<body>
<div  style="width:100%">
	<div>
		<a href="#" onclick="history.go(-1)">返回</a>
	</div>
	<div class="chart-box">
	<div id="container" style="width: 100%; height:100%" margin: 0 auto"></div>
	</div>
</div>
</body>
<!-- ECharts单文件引入 -->
<script src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
<script type="text/javascript">
// 基于准备好的dom，初始化echarts图表
var myChart = echarts.init(document.getElementById('container'));

var option = ${script};

// 为echarts对象加载数据
myChart.setOption(option);
</script>
</html>