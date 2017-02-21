<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<table id="contentTable"
	class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<c:forEach items="${metaDatas}" var="metadata">
				<th>${metadata}</th>
			</c:forEach>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="entity">
			<tr>
				<c:forEach items="${metaDatas}" var="metadata">
					<c:set var="valuez" value="${entity[metadata]}"></c:set>
					<td>${valuez}</td>
				</c:forEach>
		</c:forEach>
		</tr>
	</tbody>
</table>