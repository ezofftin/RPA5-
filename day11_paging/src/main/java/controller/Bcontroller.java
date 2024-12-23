package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class Bcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		String uri = request.getRequestURI();
		String cmd = uri.substring(ctx.length());
		
		String viewPage = "list.jsp";
		
		if(cmd.equals("/list.do")) {
			ArrayList<String> list 
				= new ArrayList<>();
			
			for(int i=0; i<123; i++) {
				list.add((i+1) + " | 게시판 테스트 글 목록 ...............");
			}
			
			int currentPage=1;
			int curBlock = 0;
			int blockSize = 5;
			
			// null 체크 : 처음 시작할 때는 뷰(jsp)에서 currentPage를 전송하지 않는다.
			// currentPage가 전송될 때만 수행되게 함.
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
				curBlock = (currentPage - 1)/blockSize;
			}
			
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("curBlock", curBlock);
			request.setAttribute("list", list);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
