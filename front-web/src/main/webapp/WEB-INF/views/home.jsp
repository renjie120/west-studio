<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>京东看板系统-我的项目</title>
    <link rel="shortcut icon" href="favicon.ico"> 

   <base target="_blank">
    
    <link href="${ctxStatic}/bootstrap/2.3.1/css_${not empty cookie.theme.value ? cookie.theme.value : 'cerulean'}/bootstrap.min.css" type="text/css" rel="stylesheet" />
        <link href="${ctxStatic}/css/style.min.css?v=4.0.0" type="text/css" rel="stylesheet" />
    
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
<div id="main" style="width: auto;">
<div id="header" class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="brand"><span id="productName">京东看板</span></div>
				<ul id="userControl" class="nav pull-right">
			
					<li id="userInfo" class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" title="个人信息">您好, ${username }&nbsp;<span id="notifyNum" class="label label-info hide"></span></a>
					</li>
					<%-- <li><a href="${ctx}/logout" title="退出登录">退出</a></li> --%>
					<li>&nbsp;</li>
				</ul>
				
				<div class="nav-collapse">
					<ul id="menu" class="nav" style="*white-space:nowrap;float:none;">

								<li class="menu active">
										<a class="menu" href="javascript:"  ><span>我的项目</span></a>
								</li>
						
					</ul>
				</div><!--/.nav-collapse -->
			</div>
	    </div>
   <div style="height:60px;width:100%;clear:both"></div>
    <div class="container-fluid"  >
        <div class="row">
        
        <c:forEach items="${projectlist}" var="project">
            <div class="col-sm-3 item2" style="width:22%;float:left;margin-left:10px">
                <div class="ibox float-e-margins">
                    <div class="ibox-title" style="min-height: 28px;">
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


</div>
</body>

</html>