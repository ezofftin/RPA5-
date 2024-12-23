package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminDAO;
import model.AdminDTO;

public class AdminLogOutCommand implements ShopCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 세션 객체 얻기
		HttpSession session = request.getSession();
		session.invalidate();// 세션 초기화(삭제)
		
		return "ad_login";
	}
}
