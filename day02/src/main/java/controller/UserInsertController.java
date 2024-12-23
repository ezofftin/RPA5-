package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/insert.do")
public class UserInsertController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 파라미터 수집하기
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
		
		// 응답로직(프리젠테이션 로직 - View)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(n > 0) {
			out.print("가입 성공!!");
			response.sendRedirect("/day02/list.do");
		}else {
			out.print("가입 실패!!");
		}
	}
}
