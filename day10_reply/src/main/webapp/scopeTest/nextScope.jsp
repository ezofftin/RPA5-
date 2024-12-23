<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>스크립트 표현식</li>
		<!-- EL -->
		<!-- 페이지내에 여러 스코프가 있는 경우 유효범위가 
		     가장 작은 스코프가 생략될 수 있다. -->
		<li>${key}</li> 
		<li>${pageScope.key}</li>
		<li>${requestScope.key}</li>
		<li>${sessionScope.key}</li>
		<li>${applicationScope.key}</li>
		<li>${param.key}</li>
	</ul>
</body>
</html>