package _210420.jdbc.example.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class _1_JDBCSelect {
	public static void main(String[] args) {
		
		/* 
		 * 1. Oracle 드라이버 로딩
		 * 2. 객체 3개 필요 
		 * 	   1) 연결 객체 - connection : DB랑 JAVA가 연결됨
		 * 	   2) statement 객체 - SQL 전송/수신 객체
		 *     3) SQL문 실행 객체
		 * 3. resultSet 객체 - SQL문 조회 결과를 전부 받아옴
		 * 		- 필요한 정보를 하나씩 가져올 수 있음
		 * */
		
		//1. 데이터베이스 연결에 필요한 변수 선언
		//연결주소형식 - 정해진이름:IP주소:PORT번호(프로그램번호)/DB이름
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "hr";
		String upw = "hr";
		String sql = "select employee_id, last_name, hire_date, salary, department_id"
				  + " from employees";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//DB 연결구문은 throws를 던지고 있기 때문에 try구문 안에서 작성한다. 
		//2. 드라이버 로드(호출) - 드라이버 미리 준비시키는 용도
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3. Connection 객체 생성 - DriverManager 클래스가 제공하는 getConnection(주소, 아이디, 비밀번호)
			conn = DriverManager.getConnection(url, uid, upw);
			//System.out.println(conn); //연결확인
			
			//4. Statement 객체 생성 - connection 객체로부터 생성
			// 	 매개변수로 '실행할 sql문'을 받는다 - 보통 변수로 만들어놓음
			pstmt = conn.prepareStatement(sql);
			
			//5. sql문 쿼리 실행문
			//   - select문은 excuteQuery()로 실행 > 조회해서 가져옴
			//	 - insert, update, delete문은 excuteUpdate()로 실행 > 실행하면 끝
			rs = pstmt.executeQuery();
			
			//6. select문의 실행 결과가 하나라도 존재하면, ResultSet의 next()메서드는 true를 반환한다
			while(rs.next()) {
				//한 행에 대해서 처리할 작업
				//문자열 - getString
				//숫자 - getInt
				//날짜 - Date or TimeStamp
				String id = rs.getString("employee_id");
				String name = rs.getNString("last_name");
				Timestamp hire_date = rs.getTimestamp("hire_date");
				int salary = rs.getInt("salary");
				int department_id = rs.getInt("department_id");
				
				System.out.print(id + " ");
				System.out.print(name + " ");
				System.out.print(hire_date + " ");
				System.out.print(salary + " ");
				System.out.print(department_id + " ");
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				
			}
		}
	}
}
