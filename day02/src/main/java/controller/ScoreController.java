package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;


// Controller 역할 : 클라이언트의 모든 요청을 받아서 요청에 맞게 안내역할
@WebServlet("/sc.do")
public class ScoreController extends HttpServlet {
						// request, response는 클라이언트의 모든 정보를 갖고 있는 매개변수
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 1. 클라이언트가 입력한 국영수 점수를 얻어오기
		// request.getParameter(html의 name속성값) => 타입이 문자열
		// Integer.parseInt 문자열을 --> 정수로 변환
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
	
		// 2. 입력받은 점수를 이용해서 평균과 총점을 구하기
		Score score = new Score(kor, eng, mat);
		int total = score.getTotal();
		
		System.out.println(total);
		
		String strAvg = score.avg();
		System.out.println(strAvg);
		
		// 3. 클라이언트에 응답(프리젠테이션 로직 : View)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("총점 : " + total + "<br/>");
		out.print("평균 : " + strAvg);
	}
}
