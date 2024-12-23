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
      <h3 class="text-center">글 상세보기</h3>
      <form action="update.do" method="post">
      <table class="table table-borderless">
         <tbody>   
            <tr>               
               <td>글번호</td>
               <td><input class="form-control" name="bid" 
               			type="text" readonly value="${dto.bid}"></td>
            </tr>
            <!-- html 속성 disabled vs. readonly
				readonly : 읽기 O, 수정 X, 전달:submit O <=== 글번호
				disabled : 읽기 X, 수정 X, 전달:submit X <=== 조회수
			-->	
            <tr>               
               <td>조회수</td>
               <td><input class="form-control" type="text" disabled value="${dto.hit}"></td>
            </tr>
            <tr>               
               <td>작성자</td>
               <td><input class="form-control" name="writer" type="text" value="${dto.writer}"></td>
            </tr>
            <tr>               
               <td>제목</td>
               <td><input class="form-control" name="title" type="text" value="${dto.title}" ></td>
            </tr>
            <tr>               
               <td>내용</td>
               <td><textarea class="form-control" name="content">${dto.content}</textarea></td>
            </tr>
            <tr>               
               <td colspan="2" class="text-center">
                  <input class="btn btn-primary" type="submit"
                     value="수정하기"/>
                  <a href="delete.do?bid=${dto.bid}" class="btn btn-danger">삭제</a>
                  <a href="replyView.do?bid=${dto.bid}" class="btn btn-success">댓글작성</a>
                  <a href="list.do" class="btn btn-info">리스트</a>
               </td>
            </tr>
         </tbody>
      </table>
      </form>
   </div>
</body>
</html>


<!-- 
<div class="container mt-5 border p-5 shadow rounded w-75">
      <h3 class="text-center">글 상세보기</h3>
      <form action="" method="post">
      <table class="table table-borderless">
         <tbody>   
            <tr>               
               <td>글번호</td>
               <td><input class="form-control" name="bid" type="text" readonly></td>
            </tr>
            <tr>               
               <td>조회수</td>
               <td><input class="form-control" type="text" disabled ></td>
            </tr>
            <tr>               
               <td>작성자</td>
               <td><input class="form-control" name="writer" type="text" ></td>
            </tr>
            <tr>               
               <td>제목</td>
               <td><input class="form-control" name="title" type="text" ></td>
            </tr>
            <tr>               
               <td>내용</td>
               <td><textarea class="form-control" name="content"></textarea></td>
            </tr>
            <tr>               
               <td colspan="2" class="text-center">
                  <input class="btn btn-primary" type="submit"
                     value="수정하기"/>
                  <a href="" class="btn btn-danger">삭제</a>
                  <a href="" class="btn btn-success">댓글작성</a>
                  <a href="list.do" class="btn btn-info">리스트</a>
               </td>
            </tr>
         </tbody>
      </table>
      </form>
   </div>


 -->

