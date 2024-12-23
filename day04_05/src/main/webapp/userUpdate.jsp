<%@page import="model.UserDAO"%>
<%@page import="model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int uno = Integer.parseInt(request.getParameter("uno"));
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	String tel = request.getParameter("tel");
	
	UserDTO dto = new UserDTO();
	dto.setUno(uno);
	dto.setAge(age);
	dto.setEmail(email);
	dto.setTel(tel);
	
	System.out.println(uno);
	UserDAO dao = new UserDAO();
	// 수정할 dto를 dao에 전달
	int n = dao.userUpdate(dto);
	
	if(n > 0) {
		System.out.println("회원 수정 완료!!");
		// 리스트 페이지 이동
		response.sendRedirect("userList.jsp");
	}else {
		System.out.println("회원 수정 실패!!");
	}
%>    
    
