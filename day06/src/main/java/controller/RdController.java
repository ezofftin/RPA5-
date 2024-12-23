package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;

@WebServlet("/rd.do")
public class RdController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sData = "Hello World!!";
		
		String userName = "kang";
		String age = "33";
		//Member member = new Member(userName, age);
		
		// sendRedirect()은 request 공유되지 않는다.
		// 바인딩을 할 수 없음.
//		request.setAttribute("member", member);
		
		response.sendRedirect("fr/redirect.jsp?data="+sData+"&userName="+userName+"&age="+age);
	}

}
