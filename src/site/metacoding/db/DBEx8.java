package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//insert
public class DBEx8 {
	public static void main(String[] args) {
		// 1.connection ���� - section ����(port, ip, id,password,protocol)
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB����Ϸ�");
			// 2.���� �޾Ƽ� ���(ALL:SELECT * FROM emp)
			//id 1�� username�� coding���� ����
			 String sql = "UPDATE userTbl SET username = ? WHERE id = ?"; // ���� �����ݷ� �ʿ� ����.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "cording");
			pstmt.setInt(2, 1);
			
			// ���� -1, ���� row����, �ƹ� ��ȭ�� ������ 0
			// ex) delete ->
			int result = pstmt.executeUpdate();// delete,update,insert(���ο� commit �� ����)

			if (result > 0) {
				System.out.println("����");
			} else if (result < 0) {
				System.out.println("����");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
