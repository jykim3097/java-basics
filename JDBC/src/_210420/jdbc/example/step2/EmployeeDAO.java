package _210420.jdbc.example.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO { //Database Access Object
	
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String uid = "hr";
	private String upw = "hr";
	
	//조회기능(id를 받아서 조회)
	public Members select(String id) {
		
		Members vo = null; // 값을 저장해서 변환할 변수
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from members where id = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) { //결과가 있는 경우
				String m_id = rs.getString("id");
				String pw = rs.getNString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				vo = new Members(m_id, pw, name, email);
				System.out.println("-----------------------");
				
			} else { //결과가 없는 경우
				System.out.println("조회할 수 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return vo;
	}
}
