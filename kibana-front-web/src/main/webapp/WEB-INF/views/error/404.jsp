<%@ page contentType="text/html;charset=UTF-8"%>
<%
response.setStatus(404);

// 如果是异步请求或是手机端，则直接返回信息
{
	out.print("页面不存在.");
}

out.print("<!--"+request.getAttribute("javax.servlet.forward.request_uri")+"-->");
 out = pageContext.pushBody();
%>