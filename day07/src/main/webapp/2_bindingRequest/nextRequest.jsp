<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		String strVal = (String)request.getAttribute("strReq");
		Member member = (Member)request.getAttribute("memberR");
%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
nextPage
	<ul>
		<li>${strReq}</li>
		<li>${memberR.userName}</li>
	</ul>
</body>
</html>