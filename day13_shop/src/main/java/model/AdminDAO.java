package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	public static final int ADMIN_LOGIN_SUCCESS = 1;
	public static final int ADMIN_LOGIN_PWD_FAIL = 0;
	public static final int ADMIN_LOGIN_ID_NOT = -1;
	
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
	
	// 관리자 체크
	public int adminCheck(String id, String pwd) {
		String sql = "SELECT password FROM tbl_admin WHERE id = ?";
		
		getConnection();
		
		String dbPwd;
		int n = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) { // 입력한 id가 존재
				dbPwd = rs.getString("password");
				if(dbPwd.equals(pwd)) { // 비밀번호 일치하면
					n = ADMIN_LOGIN_SUCCESS;
				}else { // 비번 불일치
					n = ADMIN_LOGIN_PWD_FAIL;
				}
			}else { // 아이디 없음
				n = ADMIN_LOGIN_ID_NOT;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return n;
	}

	// 관리자 정보 가져오기
	public AdminDTO getAdminInfo(String id) {
		String sql = "SELECT * FROM tbl_admin WHERE id = ?";
		AdminDTO dto = null;
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
						
			if(rs.next()) {
				dto = new AdminDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dto;
	}

}
