package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;	
	
	// DB에 연결한 접속객체(Connection)를 얻어오는 메소
	public void getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "1234";		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 오라클 서버에 접속된 객체를 반환 받음
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스 연결 성공~~!");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// 자원 반납
	public void dbClose() {
		try {
			if(rs !=null) rs.close();
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 글 등록하기
	public int write(String writer, 
			String title, String content) {
		int n = 0;
//		System.out.println("글등록");
//		String sql = "INSERT INTO board VALUES(bbs_seq.nextVal,"
//				+ "?,?,?,sysdate,0,0,0,0)";		
		// bbs_seq.currVal : 현재 bid 값
		String sql = "INSERT INTO board VALUES(bbs_seq.nextVal,"
				+ "?,?,?,sysdate,0,bbs_seq.currVal,0,0)";		
		getConnection();		
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, title);
			ps.setString(2, writer);
			ps.setString(3, content);
			
			n = ps.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return n;
	}

	//	게시글 리스트
	public ArrayList<BoardDTO> list(int currentPage, int limit) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		
//		String sql = "SELECT * FROM board ORDER BY bid DESC";
//		String sql = "SELECT * FROM board ORDER BY bgroup DESC, bstep ASC";
		String sql = "SELECT * "
					+"FROM (SELECT bbs.*, rownum rnum"
				    + "     FROM (SELECT * FROM board ORDER BY bgroup DESC, bstep ASC) bbs) "
				   + "WHERE rnum BETWEEN ? AND ?";
		getConnection();
		
		try {
			// 페이지의 시작 게시글 번호, 1, 11, 21, 31,....
			int startRow = (currentPage-1)*limit + 1;
			
			// 페이지의 마지막 게시글 번호, 10, 20, 30, 30,...
			int endRow = startRow + limit - 1;
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				Timestamp regDate = rs.getTimestamp("reg_date");
				
				int hit = rs.getInt("hit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				// dto로 묶기
				BoardDTO dto = new BoardDTO(bid, title, writer, content, 
						regDate, hit, bgroup, bstep, bindent);
				list.add(dto);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
	}

	// 글상세 보기
	public BoardDTO view(int bid) {
		// 조회수 처리		
		plusHit(bid);
		
		BoardDTO dto = null;
		
		String sql = "SELECT * FROM board WHERE bid = ?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			
			rs = ps.executeQuery();
			
			// bid 일치하는 한개의 게시글을 rs가 갖고 있으므로
			// while문을 사용할 필요가 없음.
			if(rs.next()) {
				bid = rs.getInt("bid"); // bid에 재할당
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				Timestamp regDate = rs.getTimestamp("reg_date");
				
				int hit = rs.getInt("hit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				// dto로 묶기
				dto = new BoardDTO(bid, title, writer, content, 
						regDate, hit, bgroup, bstep, bindent);				
			}			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dto;
	}
	
	// 조회수 증가
	public void plusHit(int bid) {
		String sql = "UPDATE board SET hit=hit+1 WHERE bid=?";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			
			ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}
	

	// 게시글 삭제
	public void delete(int bid) {
		String sql = "DELETE FROM board WHERE bid = ?";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			
			ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}

	// 게시글 수정
	public void update(int bid, String writer, String title, String content) {
		String sql = "UPDATE board SET title=?"
				+ ", writer=?, content=? WHERE bid = ?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, writer);
			ps.setString(3, content);
			ps.setInt(4, bid);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
// ------------- 댓글 처리 ------------- 
	public BoardDTO replyView(int bid) {
		
		return view(bid);
	}

	// 댓글 등록
	public void addReply(int bid, String writer, String title, 
			String content, int bgroup, int bstep, int bindent) {
		replyOrder(bgroup, bstep);
		
		String sql = "INSERT INTO board VALUES(bbs_seq.nextVal,"
				+ "?,?,?,sysdate,0,?,?,?)";		
		getConnection();
		
		int n = 0;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, title);
			ps.setString(2, writer);
			ps.setString(3, content);
			ps.setInt(4, bgroup);
			ps.setInt(5, bstep + 1);
			ps.setInt(6, bindent + 1);
			
			n = ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}		
	}
	
	// 댓글 정렬
	public void replyOrder(int bgroup, int bstep) {
		// 매개변수 bgroup과 db의 bgroup이 같고
		// db의 bstep이 매개변수 bstep보다 크면 1을 증가시켜준다.
		// 댓글이 없는 경우에는 아래의 sql문은 수행하지 않는다.
		String sql="UPDATE board SET bstep=bstep+1 "
				+ "WHERE bgroup=? AND bstep > ?";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bgroup);
			ps.setInt(2, bstep);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}		
	}
	
	// 전체 레코드(행) 수 구하기
	public int getListCount() {
		int n = 0;
		
		String sql = "SELECT count(*) FROM board";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				n = rs.getInt(1);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		
		return n;
	}
	
	
	
	
}














