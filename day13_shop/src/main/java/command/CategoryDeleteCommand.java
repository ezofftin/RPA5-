package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminDAO;
import model.AdminDTO;
import model.CategoryDAO;

public class CategoryDeleteCommand implements ShopCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String catNum = request.getParameter("catNum");
		
		// 유효성 검사
		if(catNum == null || catNum.trim().equals("")) {
			return "category_list";
		}
		
		// DB 삭제
		CategoryDAO dao = new CategoryDAO();
		int n = dao.deleteCategory(catNum);
		
		String viewPage = null;
		if(n>0) {
//			System.out.println("카테고리 삭제 완료");
			request.setAttribute("msg", "카테고리 삭제 완료!!");
			viewPage = "catList.do";
		}else {
//			System.out.println("카테고리 삭제 실패");
			request.setAttribute("msg", "카테고리 삭제 실패!!");
			viewPage = "category_list";
		}		
		
		return viewPage;
	}
}




