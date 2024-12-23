package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import model.BoardDAO;
import model.BoardDTO;

public class ListCommand implements Bcommand{

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		
		////////////// paging 처리 설정 ////////////////
		
		// 전체 게시글 수 구하기
		int totalCnt = dao.getListCount();
		System.out.println("##"+totalCnt);
		
		int curBlock = 0;
		int currentPage = 1;
		int blockSize = 5;
		int limit = 10;		
		
		// 전체 페이지 수
		int totalPage= (int)Math.ceil((double)totalCnt/limit);
		
		/////////////////////////////////////////
		// view에서 넘오는 currentPage 파라미터 값에 따라, 
		// curBlock과 currentPage의 값을 새롭게 셋팅
		if(request.getParameter("currentPage") != null) {
			currentPage 
				= Integer.parseInt(request.getParameter("currentPage"));
			curBlock = (currentPage - 1) / blockSize;
		}		
		/////////////////////////////////////////
		
//		ArrayList<BoardDTO> list = dao.list();
		ArrayList<BoardDTO> list = dao.list(currentPage, limit);
		
		// 블럭 시작 번호
		int blockStart = curBlock*blockSize + 1;		
		// 블럭 마지막 번호
		int blockEnd = blockStart + (blockSize - 1);		
		// blockEnd는 totalPage보다 클 수 없음
		if(blockEnd > totalPage) blockEnd = totalPage;
		
		// 이전
		int prevPage = blockStart - 1;		
		// 다음
		int nextPage = blockEnd + 1;		
		
		// 바인딩		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("blockStart", blockStart);
		request.setAttribute("blockEnd", blockEnd);
		request.setAttribute("prevPage", prevPage);
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("list", list);
		
	}
}


