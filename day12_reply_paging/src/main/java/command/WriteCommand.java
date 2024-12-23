package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import model.BoardDAO;

public class WriteCommand implements Bcommand{

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		dao.write(writer, title, content);
		
//		for(int i=1; i<=123; i++) {
//			dao.write(writer + i, title+"---------"+i, content);
//		}
		
		
	}

}
