package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO {
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

	// 카테고리 등록
	public int insertCategory(String code, String cname) {
		String sql="INSERT INTO tbl_category "
				+ "VALUES(cat_seq.nextVal,?,?)";
		getConnection();
		int n = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, cname);
			
			n = ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return n;
	}

	// 카테고리 리스트
	public ArrayList<CategoryDTO> categoryList() {
		ArrayList<CategoryDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM tbl_category "
				+ "ORDER BY cat_num DESC";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int catNum = rs.getInt("cat_num");
				String code = rs.getString("code");
				String catName = rs.getString("cat_name");
				
				// dto로 묶기
				CategoryDTO dto 
				  = new CategoryDTO(catNum, code, catName);
				list.add(dto);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
	}

	// 카테고리 삭제
	public int deleteCategory(String catNum) {
		String sql = "DELETE FROM tbl_category "
				+ "WHERE cat_num = ?";
		
		getConnection();
		int n = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, catNum);
			n = ps.executeUpdate();
		
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return n;
	}
	
	
	
	
	
	
	
	
	

}
