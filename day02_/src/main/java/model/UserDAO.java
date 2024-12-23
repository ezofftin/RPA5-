package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
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
   
   // 회원 정보 저장
   public int userInsert(UserDTO dto) {
	   
	   String sql = "INSERT INTO users "
	   		+ "VALUES(user_seq.nextVal,?,?,?,?,?,?)";
	   
	  getConnection();
	   
	   int n = -1;
	   try {
		   ps = conn.prepareStatement(sql);
		   
		   ps.setString(1, dto.getId());
		   ps.setString(2, dto.getPw());
		   ps.setString(3, dto.getName());
		   ps.setInt(4, dto.getAge());
		   ps.setString(5, dto.getEmail());
		   ps.setString(6, dto.getTel());
		
		   n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		   
	    return n;
   	}
}
