package _210420.jdbc.example.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class _1_JDBCSelect2 {

	public static void main(String[] args) {
		
		//회원아이디를 받아서 해당회원의 정보만 조회
		Scanner scan = new Scanner(System.in);
		
		System.out.print("조회할 id>");
		int id = scan.nextInt();
		
		//DB에 필요한 변수 선언
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "hr";
		String upw = "hr";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//SQL문에 전달한 값이 있다면 ?로 표시하고, ?는 순서대로 인덱스 번호를 갖게 된다
		String sql = "SELECT * "
				   + "FROM EMPLOYEES "
				   + "WHERE EMPLOYEE_ID = ?"; // ? : 채워 넣을 값
		
		try {
			//드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			
			//?는 순서대로 index를 이용해 채우는 작업을 해야한다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); //인덱스는 1번째부터 시작
			
			//sql 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //존재하는 경우
				String name = rs.getString("last_name");
				int salary = rs.getInt("salary");
				
				System.out.println(name +"님의 급여는 " + salary);
			} else { // 없을 경우
				System.out.println(id+"는 존재하지 않습니다.");
			}
			
		} catch (Exception e) {
			
		}
	}
}
