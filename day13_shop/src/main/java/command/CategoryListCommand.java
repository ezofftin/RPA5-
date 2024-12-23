package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminDAO;
import model.AdminDTO;
import model.CategoryDAO;
import model.CategoryDTO;

public class CategoryListCommand implements ShopCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// DB에서 리스트 가져오기
		CategoryDAO dao = new CategoryDAO();
		ArrayList<CategoryDTO> list 
			= dao.categoryList();
		
		request.setAttribute("list", list);
		
		return "category_list";
	}
}
