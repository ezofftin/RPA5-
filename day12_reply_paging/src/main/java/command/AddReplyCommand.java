package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import model.BoardDAO;

public class AddReplyCommand implements Bcommand{

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int bgroup = Integer.parseInt(request.getParameter("bgroup"));
		int bstep = Integer.parseInt(request.getParameter("bstep"));
		int bindent = Integer.parseInt(request.getParameter("bindent"));
		
		
		BoardDAO dao = new BoardDAO();
		dao.addReply(bid, writer, title, content, bgroup, bstep, bindent);
	}

}
