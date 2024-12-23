<%@page import="model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
	List<String> list = new ArrayList<String>();
	list.add("java");
	list.add("python");
	list.add("C#");
	list.add("Spring");
	list.add("JSP");
	
	// 객체 바인딩
	request.setAttribute("list", list);
	
	// Member객체를 request에 바인딩 하시오.
	Member member = new Member("강호동", "33");
	request.setAttribute("member", member);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <c:forEach var="lang" items="${requestScope.list}"> --%>
<c:forEach var="lang" items="${list}">
	${lang}
</c:forEach>
<table>
	<tr>
<%-- ${requestScope.member.userName} == ${requestScope.member.getUserName()} --%>
		<td>${requestScope.member.userName}</td>
		<!-- requestScope 생략 -->
		<td>${member.age}</td> 
	</tr>
</table>
</body>
</html>





