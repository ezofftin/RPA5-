<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Client / Server 환경정보</h2>
	<form action="requestInfo.jsp" method="post">
		<input type="submit" value="post방식"/>
		<!-- get 방식 -->
		<a href="requestInfo.jsp?kor=90&eng=88">Get 방식</a>		
	</form>
	<h2>Client 파라미터 요청</h2>
	<form action="requestParam.jsp" method="post">
		과목 : <input type="text" name="kor" value="국어"/><br/>
		점수 : <input type="text" name="score" value="90"/><br/>
		아이디 : <input type="text" name="id" value=""/><br/>
		비밀번호 : <input type="password" name="pw" value=""/><br/>
		<hr/>
		성별 : <input type="radio" name="gender" value="male"/> 남자
		      <input type="radio" name="gender" value="female"/> 여자 <br/>
		<hr/>
		취미 : 
		<input type="checkbox" name="hobby" value="music"/>음악		     
		<input type="checkbox" name="hobby" value="sports"/>스포츠		     
		<input type="checkbox" name="hobby" value="movie"/>영화		     
		<input type="checkbox" name="hobby" value="tour"/>여행		     
		<hr/>
		댓글 :
		<textarea name="reply" cols="20" rows="3"></textarea>      
		<br/>      
		<input type="submit" value="전송" />       
	</form>
</body>
</html>