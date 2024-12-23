<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> lists = new ArrayList<String>();
	lists.add("사과");
	lists.add("오렌지");
	session.setAttribute("lists", lists);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<String> list= (ArrayList<String>)session.getAttribute("lists");
	for(String str : list){
		out.print(str + "<br/>");
	}
%>
<hr>
<a href="nextSession.jsp">다음 페이지</a>

</body>
</html>