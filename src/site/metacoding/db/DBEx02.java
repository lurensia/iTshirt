package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx02 {
//DEPT테이블의 모든 데이터를 뽑아내라.
	// Select deptno, loc, dname from dept
	public static void main(String[] args) {
		// 1.connection 연결 - section 설정(port, ip, id,password,protocol)
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");
			// 2.버퍼 달아서 통신(ALL:SELECT * FROM emp)
			String sql = "Select deptno, loc, dname from dept";// 세미콜론 필요없음
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();// SELECT
//			 pstmt.executeUpdate();//INSERT,UPDATE,DELETE
//			 System.out.println(rs.next());//커서 한칸 내리기

			while (rs.next()) {
				System.out.println("deptno :" + rs.getInt("deptno"));
				System.out.println("loc :" + rs.getString("loc"));
				System.out.println("dname :" + rs.getString("dname"));
				
				System.out.println("==================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
