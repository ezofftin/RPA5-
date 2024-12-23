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
		<li>전송방식 : <%=request.getMethod() %></li>
		<li>국어 : <%=request.getParameter("kor") %></li>
		<li>영어 : <%=request.getParameter("eng")%></li>
		<!-- http://localhost:8088/day04/requestEx/requestInfo.jsp -->
		<li>URL : <%=request.getRequestURL() %></li>      
		<!-- http://localhost:8088를 제외한 나머지 주소 : /day04/requestEx/requestInfo.jsp -->
        <li>URI : <%=request.getRequestURI() %></li>
        <li>프로토콜 : <%=request.getProtocol() %></li>
        <li>서버명 : <%=request.getServerName() %></li>
        <li>서버포트번호 : <%=request.getServerPort() %></li>
        <li>쿼리스트링 : <%=request.getQueryString() %></li>
        <li>클라이언트의 IP주소 : <%=request.getRemoteAddr() %></li>
	</ul>
</body>
</html>