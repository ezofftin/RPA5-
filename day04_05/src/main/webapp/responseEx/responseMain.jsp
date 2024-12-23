<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String loginErr= request.getParameter("loginErr");
	
	// 로그인 실패한 경우
	if(loginErr !=null){
		out.print("<p style='color:red; font-size:11px;'>아이디와 비밀번호를 다시 입력하시오!!</p>");
	}
%>
	<form action="responseLogin.jsp" method="post">
		아이디 : <input type="text" name="uid"><br/>
		비밀번호 : <input type="password" name="pw">
		
		<input type="submit" value="로그인">
	</form>

</body>
</html>