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
	<div class="container mt-5 border p-5 shadow rounded w-75">
		<h3 class="text-center">댓글 작성</h3>
		<form action="addReply.do" method="post">
			<input type="text" name="bgroup" value="${dto.bgroup}"/>		
			<input type="text" name="bstep" value="${dto.bstep}"/>		
			<input type="text" name="bindent" value="${dto.bindent}"/>		
			<table class="table table-borderless">
				<tbody>				
					<tr>					
						<td>글번호</td>
						<td><input type="text" class="form-control" 
								name="bid" readonly value="${dto.bid}"/></td>
					</tr>
					<tr>					
						<td>조회수</td>
						<td><input type="text" class="form-control" 
								name="hit" disabled value="${dto.hit}"/></td>
					</tr>
					<tr>					
						<td>댓글 작성자</td>
						<td><input type="text" class="form-control" 
								name="writer"/></td>
					</tr>
					<tr>					
						<td>댓글 제목</td>
						<td><input type="text" class="form-control" name="title"/></td>
					</tr>
					<tr>					
						<td>댓글 내용</td>
						<td><textarea class="form-control" name="content"></textarea></td>
					</tr>
					<tr>					
						<td colspan="2" class="text-center">
							<input type="submit" class="btn btn-primary" 
								value="댓글등록"/>
							<a href="list.do" class="btn btn-info">리스트</a>
						</td>
					</tr>				
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>