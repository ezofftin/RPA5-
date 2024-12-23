package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminDAO;
import model.AdminDTO;

public class AdminLoginOkCommand implements ShopCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		AdminDAO dao = new AdminDAO();
		int n = dao.adminCheck(id, pwd);
		
		String viewPage = null;
		
		// 세션 객체 얻기
		HttpSession session = request.getSession();
		if(n == dao.ADMIN_LOGIN_SUCCESS) {
			AdminDTO dto = dao.getAdminInfo(id);			
			String name = dto.getName();
			
			session.setAttribute("name", name);
		}else if(n == dao.ADMIN_LOGIN_PWD_FAIL) {
			request.setAttribute("loginErr", "pwdErr");
		}else if(n == dao.ADMIN_LOGIN_ID_NOT) {
			request.setAttribute("loginErr", "idErr");
		}
		
		// 로그인 실패
		if(request.getAttribute("loginErr") != null) {
			viewPage = "ad_login";
		}else { // 로그인 성공
			viewPage = "ad_main";
		}
		
		return viewPage;
	}
}




