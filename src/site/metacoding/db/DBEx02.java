package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx02 {
//DEPT���̺��� ��� �����͸� �̾Ƴ���.
	// Select deptno, loc, dname from dept
	public static void main(String[] args) {
		// 1.connection ���� - section ����(port, ip, id,password,protocol)
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB����Ϸ�");
			// 2.���� �޾Ƽ� ���(ALL:SELECT * FROM emp)
			String sql = "Select deptno, loc, dname from dept";// �����ݷ� �ʿ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();// SELECT
//			 pstmt.executeUpdate();//INSERT,UPDATE,DELETE
//			 System.out.println(rs.next());//Ŀ�� ��ĭ ������

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
