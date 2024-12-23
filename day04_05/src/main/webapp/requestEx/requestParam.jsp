<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// post 방식으로 전송되는 한글 깨짐을 방지
	request.setCharacterEncoding("utf-8");

	String[] hbs = request.getParameterValues("hobby");
	
	String str = "";
	if(hbs != null){
		for(int i =0; i<hbs.length; i++){
			str += hbs[i] + " ";
		}
	}
	
	String reply = request.getParameter("reply").replace("\r\n", "<br/>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- get방식 전송은 utf-8 인코딩 필요없음
		post방식 전송은 body안에 담아서 전송을 하고
		utf-8 인코딩 해야 함
	-->
	<ul>
		<li>과목 : <%=request.getParameter("kor") %></li>
		<li>점수 : <%=request.getParameter("score") %></li>
		<li>아이디 : <%=request.getParameter("id") %></li>
		<li>비밀번호 : <%=request.getParameter("pw") %></li>
		<li>성별 : <%=request.getParameter("gender") %></li>
		<li>취미 : <%=str %></li>
		<li>댓글 : <%=reply %></li>
		
	</ul>
</body>
</html>



