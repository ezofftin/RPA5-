<%@page import="model.UserDAO"%>
<%@page import="model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//삭제할 회원의 uno 파라미터를 수집
	int uno = Integer.parseInt(request.getParameter("uno"));
		
	System.out.println(uno);
	UserDAO dao = new UserDAO();
	// 삭제할 uno를 dao에 전달
	int n = dao.deleteUser(uno);
	
	if(n > 0) {
		System.out.println("회원 삭제 성공!!");
		// 재요청
		response.sendRedirect("userList.jsp");
	}else {
		System.out.println("회원 삭제 실패!!");
	}
%>    
    
