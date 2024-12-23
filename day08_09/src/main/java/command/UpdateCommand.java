package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import model.BoardDAO;

public class UpdateCommand implements Bcommand{

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		dao.update(bid, writer, title, content);
	}
}
