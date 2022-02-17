package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//PrepareStatement 변수 바인딩하기

public class DBEx03 {
	
	public static void login(String username, String password) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");

			String sql = "SELECT * FROM userTbl where username =? AND password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//?의 시작번지는 1이다.
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			Session.isLogin = true;

			while (rs.next()) {
				System.out.println("로그인되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		login("ssar","1234");
		
		System.out.println(Session.isLogin);
	}
}
