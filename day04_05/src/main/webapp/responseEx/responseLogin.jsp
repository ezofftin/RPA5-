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
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	
	// id : test, pw : 1234 인 경우 인증 성공
	if(uid.equals("test") && pw.equals("1234")){
		// 재요청
		response.sendRedirect("/day04_05/index.jsp");
	}else{
		// System.out.println("로그인 실패!!");
		response.sendRedirect("responseMain.jsp?loginErr=1");
	}
%>
</body>
</html>