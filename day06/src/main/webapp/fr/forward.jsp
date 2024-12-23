<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// fwController의 Request를 공유하기 때문에 
// member를 가져올 수 있음.
// 바인딩된 값을 꺼내오면 타입은 Object
// Member 타입의 형변환 필요
Member member =(Member)request.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=member.getUserName()%> <br/>
	<%=member.getAge()%> <br/>
</body>
</html>