<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String data = request.getParameter("data");
	String userName = request.getParameter("userName");
	String age = request.getParameter("age");

	//Member member =(Member)request.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Controller에서 전송된 값 : <%=data%> <br/>
<%-- 	<%=member.getUserName()%> <br/>
	<%=member.getAge()%> <br/> --%>
	<%=userName %><br/>
	<%=age %><br/>
</body>
</html>