<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-cn">



  <head>
  	<meta charset="utf-8">
	<meta content="IE=edge" http-equiv="X-UA-Compatible">
	<meta content="width=device-width, initial-scale=1" name="viewport">
    <title>看板登录</title>

	<link rel="stylesheet" href="http://crm.bucuoa.com/res/js/bootstrap/css/bootstrap.min.css?v=1.83">
	<link rel="stylesheet" type="text/css" href="http://crm.bucuoa.com/res/js/icheck/skins/minimal/blue.css?v=1.83">
	
	<script src="${ctxStatic}/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="http://crm.bucuoa.com/res/js/jquery.cookie.js?v=1.83"></script>
	<script type="text/javascript" src="http://crm.bucuoa.com/res/js/icheck/icheck.min.js?v=1.83"></script>
	<link href="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.min.css" type="text/css" rel="stylesheet" />
	<script src="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.min.js" type="text/javascript"></script>
	<style type="text/css">
		body {
		    background-color: #fff;
		    color: #666666;
		    font-family: "Open Sans",Helvetica,Arial,sans-serif;
		    font-size: 13px;
		    font-weight: 400;
		    line-height: 1.475;
		    margin: 0;
		    padding: 0;
		    width: 100%;
		}
		.login-container{
			width: 400px;
			height: 300px;
			margin: 0 auto;
			border-radius:17px;
			background-color: #fff;
			filter:alpha(opacity=80); 
			-moz-opacity:0.80; 
			opacity:0.80; 
		}
		
		.login-main{
			background-color: #fff;
			padding: 10px;
			padding-top: 15px;
			border-radius:17px;
		}
		.logo-container{
			margin: 0 auto;
			text-align: center;
			font-size: 36px;
			margin-top: 120px;
		}
		
		#errorMsg{
			color: red;
		}
		.logo-font{
			color: #000;
			font-family: monospace;
			font-size: 18px;
		}
		.login-checkbox{
			padding-left: 0!important;
		}
		
		.login-bg{
			position: absolute;
			overflow: hidden;
			z-index: 2
		}
		.login-wrap{
			position: absolute;
			top:10%;
			width: 100%;
			z-index: 10;
		}
		.warning{
			position: fixed;
			top: 0;
			width: 100%;
			height: 50px;
			line-height: 50px;
			background-color: #428bca;
			color: #fff;
			display: none;
		}
		#ios{
			background: url("http://crm.bucuoa.com/res/images/ios.png") no-repeat scroll left center rgba(0, 0, 0, 0);
		    color: #959ca8;
		    display: block;http://crm.bucuoa.com/
		    float: left;
		    padding-left: 20px;
		}
		#android{
			background: url("http://crm.bucuoa.com/res/images/android.png") no-repeat scroll left center rgba(0, 0, 0, 0);
		    color: #959ca8;
		    display: block;
		    float: left;
		    padding-left: 20px;
		}
		.mobile-down{
			padding-left: 20px;
			padding-top: 15px;
		}
		.form-group{
			margin: 0;
			height: 45px;
		}
	</style>
  </head>
  
  <body id="loginBody">
  	<div>
  		<img  id="loginImg" src="http://crm.bucuoa.com/res/images/login/login-14.jpg" height="100%" width="100%" style="position: fixed;">
  	</div>
  	<div class="container login-wrap">
  		<div class="row logo-container">
  				<h2 class="logo-font">&nbsp;</h2>
  			</div>
  		<div class="login-container">
  			<div class="login-main">
  				<div class="text-center">
  					<span>数据看板系统</span>
  				</div>
  				<p>
  				<form action="${ctx}/login" class="form-horizontal" role="form" id="loginForm"  method="post">
  				  <div class="form-group text-center">
  						<span id="errorMsg">&nbsp;</span>
  				  </div>
  					
  				  <div class="form-group">
  				  		 <div class="col-sm-12">
					    	<label for="account" class="col-sm-2 control-label">帐号</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control required" id="username" name="username">
						    </div>
					     </div>
				  </div>

			  	 <div class="form-group">
			  	 	<div class="col-sm-12">
					    <label for="password" class="col-sm-2 control-label">密码</label>
					    <div class="col-sm-9">
					      <input type="password" class="form-control required" id="password" name="password">
					    </div>
					</div>  
				  </div>
				  
				<c:if test="${isValidateCodeLogin}">
					  	 <div class="form-group">
			  	 	<div class="col-sm-12">
					   <label class="col-sm-2 control-label" for="validateCode">验证码</label>
					    <div class="col-sm-9">
					      <sys:validateCode name="validateCode" />
					    </div>
					</div>  
				  </div>
			</c:if>
			
				  <div class="form-group">
				    <div class="col-sm-12">
				      <label class="col-sm-2 control-label"></label>
				      <div class="col-sm-9">
					      <div class="checkbox">
					        <label class="login-checkbox">
					          <input type="checkbox" id="rememberMe" name="rememberMe" ${rememberMe ? 'checked' : ''}/>
					           记住我
					        </label>
					      </div>
				      </div>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="col-sm-12 text-center">
				      <button type="submit" class="btn btn-primary btn-lg" id="loginBtn">登录</button>
				    </div>
				  </div>
  				
				  
  				</form>
  			</div>
  		</div>
  	</div>
  	
  	<div class="warning">
  		<p class="text-center">
  			你的浏览器版本过低,不升级可能无法正常使用看板
  			<a title="ie浏览器" target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/download-ie"><img alt="ie浏览器" width="30" height="30" src="http://crm.bucuoa.com/res/images/ie.png"></a>
  			<a title="火狐浏览器" target="_blank" href="http://www.firefox.com.cn/download/"><img alt="火狐浏览器" width="30" height="30" src="http://crm.bucuoa.com/res/images/hh.png"></a>
  			<a title="360极速浏览器" target="_blank" href="http://chrome.360.cn/"><img alt="360极速浏览器" width="30" height="30" src="http://crm.bucuoa.com/res/images/js.jpg"></a>
  		</p>
  	</div>
  </body>
  <script type="text/javascript">
  $('#loginBtn').removeAttr("disabled");
	
	$('input[type=checkbox]').iCheck({
		checkboxClass: 'icheckbox_minimal-blue',
	    radioClass: 'iradio_minimal-blue',
	    increaseArea: '20%' // optional
	 });
	
	if ($.cookie("remeberme") == "true") {
		checking = 1;
		$('#remeberme').iCheck('check');
		$("#username").val($.cookie("bootCrmName"));
	}
	
	
	$("#remeberme").on('ifChecked', function(event){
		checking = 1;
	});

	
	$("#remeberme").on('ifUnchecked', function(event){
		checking = 1;
	});
	
	
	$(document)
			.ready(
					function() {
						$("#loginForm")
								.validate(
										{
											rules : {
												validateCode : {
													remote : "${pageContext.request.contextPath}/servlet/validateCodeServlet"
												}
											},
											messages : {
												username : {
													required : "请填写用户名."
												},
												password : {
													required : "请填写密码."
												},
												validateCode : {
													remote : "验证码不正确.",
													required : "请填写验证码."
												}
											},
											errorLabelContainer : "#messageBox",
											errorPlacement : function(error,
													element) {
												error.appendTo($("#errorMsg")
														.parent());
											}
										});
					});
	// 如果在框架或在对话框中，则弹出提示并跳转到首页
	if (self.frameElement && self.frameElement.tagName == "IFRAME"
			|| $('#left').length > 0 || $('.jbox').length > 0) {
		alert('未登录或登录超时。请重新登录，谢谢！');
		top.location = "${ctx}";
	}
</script>
  
</html>
