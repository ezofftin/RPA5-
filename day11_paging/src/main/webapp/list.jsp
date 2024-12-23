<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 목록</h2>
<%
	ArrayList<String> list
		= (ArrayList<String>)request.getAttribute("list");

	// 전체게시글 수
	int totalCnt = list.size();
	
	// 페이지당 게시글 수
	int limit = 10;
	
	// 현재 페이지 번호의 시작
	int currentPage = 1;
	
	// 바인딩 된 경우만 수행되도록 함
	if(request.getAttribute("currentPage") !=null){
		// Integer.parseInt("문자열 숫자")
		currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	}
 	// ################ 게시글 출력 ###################
	// 전체 출력
 	/* 
 	for(int i=0; i<totalCnt; i++){
		out.print(list.get(i) + "<br/>");
	} 
 	*/
 	
 	// 각 페이지의 시작 게시글 번호 
 	int begin = (currentPage-1)*limit;
 	// 각 페이지의 마지막 게시글 번호
 	int end = begin + limit;
 	
 	// Quiz. end는 전체 게시글 수를 초과할 수 없다. 	
 	if(end > totalCnt) end = totalCnt;
 	
 	for (int i=begin; i<end; i++){
 		out.print(list.get(i) + "<br/>");
 	}
 	
 	out.print("<hr/>");
 	
 	// ################ 페이지네이션(페이지 + 네비게이션) ###################
 	int blockSize = 5;
 	
 	int curBlock = 0;
 	if(request.getAttribute("curBlock") !=null){
 		curBlock = Integer.parseInt(request.getAttribute("curBlock").toString());
 	}
 	
 	System.out.println("curBlock="+curBlock);
 	// 전체 페이지수
 	int totalPage = (int)Math.ceil((double)totalCnt/limit);
 	
 	// 블럭의 시작값
 	int blockStart = curBlock*blockSize + 1;
 	
 	// 블럭의 마지막값
 	int blockEnd = blockStart + (blockSize - 1);
 	
 	// blockEnd는 totalPage보다 클 수가 없다.
 	if(blockEnd > totalPage) blockEnd = totalPage;
 	
 	// 이전 페이지 버튼
 	if(blockStart-1 > 0){
 		%>
 		<a href="list.do?currentPage=<%=blockStart-1%>">이전</a>
 		<%
 	} 	
 	// 페이지 번호 출력
 	for(int i = blockStart; i<=blockEnd; i++){
 	%>
 		<a href="list.do?currentPage=<%=i%>"><%=i%></a>
 	<%		
 	} 	
 	// 다음 페이지 버튼
 	if(blockEnd < totalPage){
 		%>
 		<a href="list.do?currentPage=<%=blockEnd+1%>">다음</a>
 		<%
 	}
%>
</body>
</html>










