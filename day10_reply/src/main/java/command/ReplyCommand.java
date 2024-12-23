package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import model.BoardDAO;
import model.BoardDTO;

public class ReplyCommand implements Bcommand{

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.replyView(bid);
		
		// 바인딩
		request.setAttribute("dto", dto);
	}

}
