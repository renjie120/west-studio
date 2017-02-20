<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>我的项目</title>
    <link rel="shortcut icon" href="favicon.ico"> <link href="${ctxStatic}/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="${ctxStatic}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <!-- Morris -->
    <link href="${ctxStatic}/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="${ctxStatic}/css/animate.min.css" rel="stylesheet">
    <link href="${ctxStatic}/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
<style type="text/css">

.item2 div {
	display: block;
	position: relative;
}

.item2 div span {
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	z-index: 5;
	filter: alpha(opacity = 20); /*IE滤镜，透明度50%*/
	-moz-opacity: 0.2; /*Firefox私有，透明度50%*/
	opacity: 0.2; /*其他，透明度50%*/
	color:#fff
}

.item2 div:hover span {
	display: none
}
</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
        
        <c:forEach items="${projectlist}" var="project">
            <div class="col-sm-3 item2">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>${project.name}</h5>
                    </div>
                    <div class="ibox-content">

                        <a href="${ctx}/project/index?id=${project.id}">进入项目</a>
                    </div>
					<span style="background-color: #23c6c8;"></span>
                </div>
				
            </div>
        
		 </c:forEach>
        </div>
        </div>

    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.5"></script>
    <script src="js/plugins/flot/jquery.flot.js"></script>
    <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="js/plugins/flot/jquery.flot.pie.js"></script>
    <script src="js/plugins/flot/jquery.flot.symbol.js"></script>
    <script src="js/plugins/peity/jquery.peity.min.js"></script>
    <script src="js/demo/peity-demo.min.js"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>
    <script src="js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="js/plugins/easypiechart/jquery.easypiechart.js"></script>
    <script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="js/demo/sparkline-demo.min.js"></script>

</body>

</html>