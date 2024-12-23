package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDAO;


@WebServlet("/mc.do")
public class MemberController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청파라미터 수집
		String userName = request.getParameter("userName");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String addr = request.getParameter("addr");
		String age = request.getParameter("age");		
		
		// service() 호출될 때마다 새로운 ArrayList가 생성됨. 비어있는 리스트 생성
//		ArrayList<Member> list = new ArrayList<>();
		
		// 일종의 DTO와 같다. 회원의 각정보를 묶는 역할
		Member member = new Member(userName, id, pw, addr, age);
		
		// 2. 비즈니스 로직(핵심로직)을 갖는 Model(DAO)을 연결
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list= dao.memberJoin(member);
		
		// 3. 응답로직(프리젠테이션 로직 - View)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		for(Member m: list) {
			out.print("이름 : " + m.getUserName() + "<br/>");
			out.print("아이디 : " + m.getId() + "<br/>");
			out.print("비밀번호: " + m.getPw() + "<br/>");
			out.print("주소 : " + m.getAddr() + "<br/>");
			out.print("나이 : " + m.getAge() + "<br/>");
			out.print("-----------------<br/>");
		}
	}
}
