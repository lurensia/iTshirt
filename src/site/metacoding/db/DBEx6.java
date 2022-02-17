package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//insert
public class DBEx6 {
	public static void main(String[] args) {
		// 1.connection ���� - section ����(port, ip, id,password,protocol)
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB����Ϸ�");
			// 2.���� �޾Ƽ� ���(ALL:SELECT * FROM emp)
			String sql = "INSERT INTO userTbl(id,username,password,gender) VALUES(?,?,?,?)";// �����ݷ� �ʿ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 7);
			pstmt.setString(2, "there");
			pstmt.setString(3, "1234");
			pstmt.setString(4, "��");
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
