package _210420.jdbc.example.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class _3_JDBCUpdate {

	public static void main(String[] args) {
		//자동 커밋!
		
		/*
		 * 스캐너를 이용해서 emps에서 수정할 id를 받아서 
		 * 이름, 이메일, 급여를 수정하는 JDBC 프로그램을 작성
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("id 입력>");
		String id = scan.next();
		
		System.out.println("변경할 회원 정보>");
		System.out.print("name 입력>");
		String name = scan.next();
		
		System.out.print("email 입력>");
		String email = scan.next();
		
		System.out.print("salary 입력>");
		String salary = scan.next();
		
		//DB연결에 필요한 변수
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "hr";
		String upw = "hr";
		
		//DB연결에 필요한 객체
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update emps set last_name = ?, email = ?, salary = ? where employee_id = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, salary);
			pstmt.setString(4, id);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("변경되었습니다.");
			} else {
				System.out.println("변경 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
