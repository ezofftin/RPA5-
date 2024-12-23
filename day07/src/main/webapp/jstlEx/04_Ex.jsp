<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%
	Member member = new Member("홍길동", "44");
	
	List<Member> list = new ArrayList<>();
	list.add(member);
	list.add(member);
	list.add(member);
	list.add(member);
	
	request.setAttribute("list", list);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach var="member" items="${list}">
		<tr>
			<td>${member.userName}</td>
			<td>${member.age}</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>












