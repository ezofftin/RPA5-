package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/update.do")
public class UserUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 삭제할 회원의 uno 파라미터를 수집
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
			response.sendRedirect("/day03/list.do");
		}else {
			System.out.println("회원 수정 실패!!");
		}
   }

}
