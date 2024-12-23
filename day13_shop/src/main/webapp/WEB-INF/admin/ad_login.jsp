<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5 border shadow p-5">
	<h1>관리자 로그인</h1>
	<form action="adminLoginOk.do" method="post">
		<div class="mt-3 mb-3">
			<label for="id">아이디</label>
			<input type="text" class="form-control" id="id" placeholder="아이디"
				name="id">
			<c:if test="${requestScope.loginErr == 'idErr'}">
				<p class="text-danger">관리자 아이디를 입력하세요</p>
			</c:if>				
		</div>
		<div class="mb-3">
			<label for="id">비밀번호</label>
			<input type="text" class="form-control" id="pwd" placeholder="비밀번호"
				name="pwd">
			<c:if test="${requestScope.loginErr == 'pwdErr'}">
				<p class="text-danger">비밀번호를 확인하세요!!</p>
			</c:if>				
		</div>
		<div class="text-center">
			<button type="submit" class="btn btn-primary">로그인</button>
		</div>
	</form>
</div>

</body>
</html>