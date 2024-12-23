package frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AdminLogOutCommand;
import command.AdminLoginOkCommand;
import command.CategoryDeleteCommand;
import command.CategoryListCommand;
import command.CategoryOkCommand;
import command.MoveCommand;
import command.ShopCommand;


@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 인코딩
		request.setCharacterEncoding("utf-8");		
		
		String uri = request.getRequestURI();		
		System.out.println("uri = " + uri);
		String ctxPath = request.getContextPath();
		String cmd = uri.substring(ctxPath.length());
		
		request.setAttribute("cmd", cmd);
		
		ShopCommand command = null;
		String viewPage = null;
		
		if(cmd.equals("/adminLogin.do")) {
			command = new MoveCommand();
			viewPage = command.execute(request, response);
			
			RequestDispatcher rd  = 
					request.getRequestDispatcher("WEB-INF/admin/"+viewPage+".jsp");
			rd.forward(request, response);
		}else if(cmd.equals("/adminLoginOk.do")) {
			command = new AdminLoginOkCommand();
			viewPage = command.execute(request, response);
			
			RequestDispatcher rd  = 
					request.getRequestDispatcher("WEB-INF/admin/"+viewPage+".jsp");
			rd.forward(request, response);
		}else if(cmd.equals("/adminLogout.do")) {
			command = new AdminLogOutCommand();
			viewPage = command.execute(request, response);
			
			RequestDispatcher rd  = 
				request.getRequestDispatcher("WEB-INF/admin/"+viewPage+".jsp");
			rd.forward(request, response);
		}else if(cmd.equals("/catInput.do")) {
			command = new MoveCommand();
			viewPage = command.execute(request, response);
			
			RequestDispatcher rd  = 
					request.getRequestDispatcher("WEB-INF/admin/"+viewPage+".jsp");
			rd.forward(request, response);
		}else if(cmd.equals("/categoryOk.do")) {
			command = new CategoryOkCommand();
			viewPage = command.execute(request, response);
			
			// 재요청
			response.sendRedirect(viewPage);
			
		}else if(cmd.equals("/catList.do")) {
			command = new CategoryListCommand();
			viewPage = command.execute(request, response);
			
			RequestDispatcher rd  = 
					request.getRequestDispatcher("WEB-INF/admin/"+viewPage+".jsp");
			rd.forward(request, response);
		}else if(cmd.equals("/catDelete.do")) {
			command = new CategoryDeleteCommand();
			viewPage = command.execute(request, response);
			
			RequestDispatcher rd  = null;			
			
			// indexOf(문자열) : 해당문자열이 존재하면 처음 위치(인덱스)값을 리턴
			// indexOf(문자열) : 해당문자열이 없으면 -1을 리턴
			if(viewPage.indexOf(".do") != -1) { //.do 문자열이 viewPage에 포함되어 있는 경우
				rd = request.getRequestDispatcher(viewPage); 
			}else { // .do 문자열이 viewPage에 포함되지 않은 경우
				rd = request.getRequestDispatcher("WEB-INF/admin/"+viewPage+".jsp");
			}
			// 재요청
			response.sendRedirect(viewPage);
		}
	}
}
