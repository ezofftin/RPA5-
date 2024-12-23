<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl에서 가장 많이 사용되는 태그 라이브러리 : core(if, for,...)  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
	int aa = 200;
%>   
<!-- 변수 선언 -->
<c:set var="aa" value="100"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
jsp 기존 문법 : <%=aa %><br/>
jstl을 이용한 변수는 el 표현식으로 : ${aa} <br/> 
${aa > 50} <br/>
${aa + 50} <br/>
<hr>
<!-- test= 조건식  -->
<c:if test="${aa%2 == 0}">
짝수
</c:if>
<c:if test="${aa%2 != 0}">
홀수
</c:if>
<hr>
choose : switch문과 비슷 <br>
<c:choose>
	<c:when test="${aa%2 ==0}"> 짝수 </c:when>
	<c:when test="${aa%2 !=0}"> 홀수 </c:when>
	<c:otherwise>일치하는 when이 없습니다!!</c:otherwise>
</c:choose>
<hr>
반복문 <br>
<c:forEach var="i" begin="1" end="6" step="1">
	<font size="${i}">jsp Study</font><br/>
	<h${i}>하이</h${i}>
</c:forEach>



</body>
</html>