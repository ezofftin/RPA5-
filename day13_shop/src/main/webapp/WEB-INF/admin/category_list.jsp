<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<c:if test="${requestScope.msg !=null}">
	<script>
		alert("${requestScope.msg}");
	</script>
</c:if>

<%@include file="../inc/ad_header.jsp" %>

<div class="container mt-5 border shadow p-5">
	<h2>카테고리 리스트</h2>
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>코드</th>
				<th>카테고리명</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${requestScope.list}">			
			<tr>
				<td>${dto.catNum}</td>
				<td>${dto.code}</td>
				<td>${dto.catName}</td>
				<td><a href="catDelete.do?catNum=${dto.catNum}" class="btn btn-sm btn-outline-danger">삭제</a></td>
			</tr>		
			</c:forEach>	
		</tbody>
	</table>
</div>
<%@include file="../inc/ad_footer.jsp" %>







