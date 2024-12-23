<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="mc.do" method="get">
		<table>			
			<tbody>
				<tr>
					<td>이름 : </td>
					<td><input type="text" name="userName" size="10"/></td>
				</tr>
				<tr>
					<td>아이디 : </td>
					<td><input type="text" name="id" size="10"/></td>
				</tr>
				<tr>
					<td>비밀번호 : </td>
					<td><input type="password" name="pw" size="10"/></td>
				</tr>
				<tr>
					<td>주소 : </td>
					<td><input type="text" name="addr" size="30"/></td>
				</tr>
				<tr>
					<td>나이 : </td>
					<td><input type="text" name="age" size="3"/></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="회원가입">
						<input type="reset" value="취소">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>