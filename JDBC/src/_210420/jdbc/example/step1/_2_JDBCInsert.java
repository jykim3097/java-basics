package _210420.jdbc.example.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class _2_JDBCInsert {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("회원정보 입력>");
		
		System.out.print("ID>");
		String id = scan.next();
		
		System.out.print("NAME>");
		String name = scan.next();
		
		System.out.print("EMAIL>");
		String email = scan.next();
		
		//DB연결에 필요한 변수
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "hr";
		String upw = "hr";
		
		//DB연결에 필요한 객체
		Connection conn = null;
		PreparedStatement pstmt = null;
		//rs는 select에서만 필요!
		
		//sql
		String sql = "insert into emps(employee_id, last_name, email, hire_date, job_id) values (?, ?, ?, sysdate, 'IT_BANK')";
		
		try {
			//드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			
			//sql 실행
			// 성공 : 1반환, 실패 : 0반환
			int result = pstmt.executeUpdate();
			
			if(result == 1) { //삽입 성공
				System.out.println("정상적으로 입력되었습니다.");
			} else { //실패
				System.out.println("입력에 실패했습니다. 다시 시도하세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				
			}
		}
	}
}
