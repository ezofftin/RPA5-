<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("intValue", 1000);
	pageContext.setAttribute("strValue", "페이지 문자열");
	pageContext.setAttribute("member", new Member("홍길동", "33"));
%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int intValue = (int)pageContext.getAttribute("intValue");
	String strValue = (String)pageContext.getAttribute("strValue");
	Member member = (Member)pageContext.getAttribute("member");
%>
	<ul>
		<li>intVal : <%=intValue %></li>
		<li>strVal : <%=strValue %></li>
		<li>member : <%=member.getUserName()%>, <%=member.getAge()%></li>
	</ul>
	<hr>
	<ul>
		<li>intVal : ${pageScope.intValue}</li>
		<!-- pageScope생략 -->
		<li>intVal : ${intValue}</li> 
		<li>strVal : ${strValue}</li>
		<li>member : ${member.userName}, ${member.age} </li>
	</ul>
	<hr>
	<a href="nextPage.jsp">다음 페이지</a>
</body>
</html>



