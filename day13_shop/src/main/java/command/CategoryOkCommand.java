package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminDAO;
import model.AdminDTO;
import model.CategoryDAO;

public class CategoryOkCommand implements ShopCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String code = request.getParameter("code");
		String cname = request.getParameter("cname");
		
		// 유효성 검사
		if(code == null || cname == null ||
				code.trim().equals("") || 
				cname.trim().equals("")) {
			return "category_input";
		}
		
		// DB 등록
		CategoryDAO dao = new CategoryDAO();
		int n = dao.insertCategory(code, cname);
		
		String viewPage = null;
		if(n>0) {
			System.out.println("카테고리 등록 완료");
			viewPage = "catList.do";
		}else {
			System.out.println("카테고리 등록 실패");
			viewPage = "category_input";
		}		
		
		return viewPage;
	}
}




