<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<form action="/day02/insert.do" method="get" class="mx-auto w-75 border mt-5 p-5 rounded shadow">
		<h3 class="text-center">회원가입</h3>
		<table class="mt-3">			
			<tbody>
				<tr>
					<td>이름  </td>
					<td><input class="mb-2 ms-2 form-control" type="text" name="name" size="10"/></td>
				</tr>
				<tr>
					<td>아이디 </td>
					<td><input class="mb-2 ms-2 form-control" type="text" name="id" size="10"/></td>
				</tr>
				<tr>
					<td>비밀번호 </td>
					<td><input class="mb-2 ms-2 form-control" type="password" name="pw" size="10"/></td>
				</tr>
				<tr>
					<td>이메일 </td>
					<td><input class="mb-2 ms-2 form-control" type="text" name="email" size="30"/></td>
				</tr>
				<tr>
					<td>나이 </td>
					<td><input class="mb-2 ms-2 form-control" type="text" name="age" size="3"/></td>
				</tr>
				<tr>
					<td>전화번호 </td>
					<td><input class="mb-2 ms-2 form-control" type="text" name="tel" /></td>
				</tr>
			</tbody>
		</table>
		<div class="mt-5 text-center">
			<input type="submit" class="btn btn-primary" value="회원가입">
			<input type="reset" class="btn btn-secondary" value="취소">
		</div>
	</form>
</div>	
</body>
</html>