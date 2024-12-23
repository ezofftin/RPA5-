package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AddReplyCommand;
import command.Bcommand;
import command.DeleteCommand;
import command.ListCommand;
import command.ReplyCommand;
import command.UpdateCommand;
import command.ViewCommand;
import command.WriteCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,			
			HttpServletResponse response) 
					throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("utf-8");		
		// 클라이언트의 요청 얻어오기
		String uri = request.getRequestURI();		
//		/day08/board/writeForm.do
		System.out.println("uri = " + uri);
		String ctxPath = request.getContextPath();
//		ctxPath = /day08
		System.out.println("ctxPath = " + ctxPath);
		
		String cmd = uri.substring(ctxPath.length());
//		cmd = /board/writeForm.do
		System.out.println("cmd = " + cmd);
		
		Bcommand command = null;
		
		if (cmd.equals("/writeForm.do")) {
			RequestDispatcher rd = 
					request.getRequestDispatcher("WEB-INF/board/write_form.jsp");
			rd.forward(request, response);
		}else if (cmd.equals("/write.do")) {
			command = new WriteCommand();
			command.execute(request, response);			
			//	재요청
			response.sendRedirect("list.do");			
		}else if(cmd.equals("/list.do")) {
			command = new ListCommand();
			command.execute(request, response);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("WEB-INF/board/list.jsp");
			rd.forward(request, response);
		}else if (cmd.equals("/view.do")) {
			command = new ViewCommand();
			command.execute(request, response);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("WEB-INF/board/view.jsp");
			rd.forward(request, response);
					
		}else if (cmd.equals("/delete.do")) {
			command = new DeleteCommand();
			command.execute(request, response);
			
			response.sendRedirect("list.do");
		}else if (cmd.equals("/update.do")) {
			command = new UpdateCommand();
			command.execute(request, response);
			
			response.sendRedirect("list.do");
		}else if (cmd.equals("/replyView.do")) {
			command = new ReplyCommand();
			command.execute(request, response);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("WEB-INF/board/reply_form.jsp");
			rd.forward(request, response);
		}else if (cmd.equals("/addReply.do")) {
			command = new AddReplyCommand();
			command.execute(request, response);
			
			response.sendRedirect("list.do");
		}
	}
}
