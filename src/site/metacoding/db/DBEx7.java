package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//insert
public class DBEx7 {
	public static void main(String[] args) {
		// 1.connection 연결 - section 설정(port, ip, id,password,protocol)
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");
			// 2.버퍼 달아서 통신(ALL:SELECT * FROM emp)
			 String sql = "DELETE FROM userTbl WHERE id = ?"; // 끝에 세미콜론 필요 없음.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 7);
			// 실패 -1, 성공 row개수, 아무 변화가 없으면 0
			// ex) delete ->
			int result = pstmt.executeUpdate();// delete,update,insert(내부에 commit 이 존재)

			if (result > 0) {
				System.out.println("성공");
			} else if (result < 0) {
				System.out.println("실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
