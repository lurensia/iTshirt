package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//

public class DBEx04 {
	
	public static void login(String username, String password) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");

			String sql = "SELECT * FROM userTbl where username ='"+username+"'AND password = '12345333' OR 1=1";
			
			Statement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			Session.isLogin = true;

			while (rs.next()) {
				System.out.println("로그인되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		login("ssar","12345333");
		
		System.out.println(Session.isLogin);
	}
}
