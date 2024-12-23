<%@page import="model.UserDAO"%>
<%@page import="model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//1. 요청 파라미터 수집하기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	String tel = request.getParameter("tel");
	
	UserDTO user= new UserDTO(id, pw, name, age, email, tel);
	
	System.out.println(user);
	
	// 비즈니스 로직 모델 이용
	UserDAO dao = new UserDAO();
	int n = dao.userInsert(user);
	
	if(n > 0) {
		out.print("가입 성공!!");
		// 재요청
		response.sendRedirect("userList.jsp");
	}else {
		out.print("가입 실패!!");
	}
%>    
    
