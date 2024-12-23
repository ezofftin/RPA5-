package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import model.BoardDAO;

public class DeleteCommand implements Bcommand{

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		BoardDAO dao = new BoardDAO();
		dao.delete(bid);
	}

}
