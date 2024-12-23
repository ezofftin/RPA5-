package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;


@WebServlet("/fw.do")
public class FwController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = "kang";
		String age = "33";
		
		Member member = new Member(userName, age);
		
		// 객체 바인딩
//		setAttribute(String name, Object o)
		//                      키       값
		request.setAttribute("member", member);
		
		// 포워딩은 url주소가 안바뀜
		// 포워딩을 위한 객체(RequestDispatcher)가 필요
//		request.getRequestDispatcher("경로")
		RequestDispatcher rd= request.getRequestDispatcher("fr/forward.jsp");
		
		rd.forward(request, response);
		
	}

}
