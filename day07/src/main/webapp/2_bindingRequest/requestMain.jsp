<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("strReq", "request문자열");
	request.setAttribute("memberR", new Member("강길동", "22"));
%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>${requestScope.strReq}</li>
		<li>${requestScope.memberR.userName}</li>
	</ul>
	<hr>
	<h2>포워딩</h2>
	<%
		RequestDispatcher rd= request.getRequestDispatcher("nextRequest.jsp");
		rd.forward(request, response);
	%>
</body>
</html>