<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<style type="text/css">
#contentTable {
	width: 98%;
	padding: 0;
	margin: 0;
}
thead th{background-image: -webkit-linear-gradient(top,#ffffff,#f5f5f5);}
th {
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px 12px;
}

th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
}

td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	background: #fff;
	font-size: 11px;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}

#contentTable  tbody>tr:nth-child(odd) >td{
	background: #f9f9f9
}

#contentTable  tbody>tr:hover{background-color: #dafdf3;} 
</style>
<table >
<tr><td>${form.name }</td></tr>
</table>
<table id="contentTable"
	class="table table-striped table-bordered table-condensed" style="margin-left: 10px;">
	<thead>
	
		<tr>
			<c:forEach items="${metaDatasNew}" var="metadata">
				<th>			
				${metadata}</th>
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
