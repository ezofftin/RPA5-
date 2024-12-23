package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoveCommand implements ShopCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cmd = (String)request.getAttribute("cmd");
		
		String viewPage = null;
		if(cmd.equals("/adminLogin.do")) {
			viewPage = "ad_login";
		}else if(cmd.equals("/catInput.do")) {
			viewPage = "category_input";
		}
		
		return viewPage;
	}
}
