<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl에서 가장 많이 사용되는 태그 라이브러리 : core(if, for,...)  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<%
	String[] cityArr = {"서울", "인천", "부산", "대구"};
	// 객체 바인딩 : cArr 키, cityArr 값
	pageContext.setAttribute("cArr", cityArr);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
<!-- 		
		<li>서울</li>
		<li>인천</li>
		<li>부산</li>
		<li>대구</li> -->
		<%for(String city : cityArr){ %>
			<li><%=city%></li>
		<%} %>
	</ul>
	<hr>
	<%-- pageContext에 저장된 값을 가져올 때 ${pageScope.키} --%>
	<c:forEach var="city" items="${cArr}"> <%-- ${cArr} == ${pageScope.cArr} --%>
		<li>${city}</li>
	</c:forEach>
	<hr>
	<!-- http://localhost:8088/day07/jstlEx/02_Ex.jsp?user=kim -->
	<c:if test="${param.user != null}">
		${param.user} 님 안녕하세요!!
	</c:if>
	<hr>
	<fmt:formatNumber type="currency" value="${param.number}"/><br/>
	<fmt:formatNumber type="currency" currencyCode="KRW" value="${param.number}"/><br/>
	<fmt:formatNumber type="currency" currencySymbol="$" value="${param.number}"/><br/>
	<fmt:formatNumber type="number" value="${param.number}"/><br/>
	<hr>
	<%
		pageContext.setAttribute("date", new Date());
	%>
	<fmt:formatDate value="${date}"/><br/>
	<fmt:formatDate type="date" pattern="yy/MM/dd" value="${date}"/><br/>
	<fmt:formatDate type="date" pattern="yyyy-MM-dd(E)" value="${date}"/><br/>
	
	
	
	
	
	
	
</body>
</html>