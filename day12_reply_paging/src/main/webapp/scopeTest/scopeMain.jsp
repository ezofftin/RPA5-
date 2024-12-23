<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String key = "local변수";
	pageContext.setAttribute("key", "pageScope Value");
	request.setAttribute("key", "requestScope Value");
	session.setAttribute("key", "sessionScope Value");
	application.setAttribute("key", "application Value");
	
/* 	RequestDispatcher rd = 
			request.getRequestDispatcher("nextScope.jsp");
	rd.forward(request, response); */
%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>스크립트 표현식 : <%=key%></li>
		<!-- EL -->
		<!-- 페이지내에 여러 스코프가 있는 경우 가장 유효범위가 작은 스코프가 생략될 수 있다. -->
		<li>${key}</li> <!-- pageScope이 생략된 형태  -->
		<li>${pageScope.key}</li>
		<li>${requestScope.key}</li>
		<li>${sessionScope.key}</li>
		<li>${applicationScope.key}</li>
		<li>${param.key}</li>
	</ul>
	<hr>
	<input type="button" value="페이지 이동" 
		onclick="location.href='nextScope.jsp?key=param값'"/>
</body>
</html>