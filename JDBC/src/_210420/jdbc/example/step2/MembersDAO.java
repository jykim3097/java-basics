package _210420.jdbc.example.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MembersDAO implements IMembersDAO{

	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String uid = "hr";
	private String upw = "hr";

	Connection conn = null;
	PreparedStatement pstmt = null;

	@Override
	public void selectAll() {

		ResultSet rs = null;

		Members vo = null; // 값을 저장해서 변환할 변수

		String sql = "select * from members";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			if( rs == null) {
				System.out.println("회원정보가 없습니다.");
			}
			while(rs.next()) { //결과가 있는 경우
				String m_id = rs.getString("id");
				String pw = rs.getNString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");

				vo = new Members(m_id, pw, name, email);
				vo.printMem(m_id, pw, name, email);
				System.out.println("-----------------------");
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
	}

	//조회기능(id를 받아서 조회)
	@Override
	public Members select(String id) {

		ResultSet rs = null;

		Members vo = null; // 값을 저장해서 변환할 변수

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
				System.out.println("존재하지 않는 회원 정보입니다. ");
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


	@Override
	public int insert(Members vo) {

		int result = 0;
		String sql = "insert into members values (?, ?, ?, ?)";

		try {
			//드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());

			//sql 실행
			// 성공 : 1반환, 실패 : 0반환
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {

			}
		}

		return result;
	}


	@Override
	public int update(Members vo) {

		int u_result = 0;
		String sql = "update members set pw = ?, name = ?, email = ? where id = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getId());

			u_result = pstmt.executeUpdate();

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

		return u_result;
	}


	@Override
	public int delete(String id) {
		
		int result = 0;
		//String sql = "update members set pw = ?, name = ?, email = ? where id = ?";
		String sql = "DELETE FROM MEMBERS WHERE ID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			result = pstmt.executeUpdate();

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

		return result;
	}


}
