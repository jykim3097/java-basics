package _210420.jdbc.example.step2;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		//EmployeeDAO dao = new EmployeeDAO();
		IMembersDAO dao = new MembersDAO();
		Members vo = null;
		

		while(true) {
			int result = 0;

			System.out.println("==========메뉴선택==========");
			System.out.println("[0.전체회원조회 1.회원조회 2.회원추가 3.회원수정 4.회원삭제 5.exit");

			System.out.print("선택>");
			String menu = scan.next();

			switch (menu) {
			case "0": //select all
				
				dao.selectAll();
				break;
				
			case "1": //select 
				System.out.print("조회할 ID>");
				String s_id = scan.next();

				vo = dao.select(s_id);

				if(vo == null) { // 데이터가 없는 경우
					System.out.println("존재하지 않는 아이디입니다.");
				} else {
					System.out.println("아이디: "+ vo.getId());
					System.out.println("비밀번호: " + vo.getPw());
					System.out.println("이름: " + vo.getName());
					System.out.println("이메일: " + vo.getEmail());
				}

				break;

			case "2": //insert
				//인터페이스에 insert 메서드를 선언하고
				//model 클래스에서는 데이터베이스 insert하는 메서드를 오버라이딩 해서 작성
				//해당 메서드가 1을 반환하면 (성공) > 메인에서 확인 로그

				//insert할 회원정보 입력받기
				System.out.println("회원 정보 입력>");
				System.out.print("ID>");
				String i_id = scan.next();
				System.out.print("PW>");
				String i_pw = scan.next();
				System.out.print("NAME>");
				String i_name = scan.next();
				System.out.print("EMAIL>");
				String i_email = scan.next();

				vo = new Members(i_id, i_pw, i_name, i_email);

				result = dao.insert(vo);
				if(result == 1) { //삽입 성공
					System.out.println("정상적으로 입력되었습니다.");
				} else { //실패
					System.out.println("입력에 실패했습니다. 다시 시도하세요.");
				}

				break;

			case "3": //update
				//id, pw, name, email을 받아서 DB에 UPDATE
				System.out.println("회원 정보 입력>");
				System.out.print("ID>");
				String u_id = scan.next();

				vo = dao.select(u_id);

				if(vo == null) { // 데이터가 없는 경우
					System.out.println("값을 변경할 수 없습니다.");
				} else {
					
					System.out.print("PW>");
					String u_pw = scan.next();
					System.out.print("NAME>");
					String u_name = scan.next();
					System.out.print("EMAIL>");
					String u_email = scan.next();
					
					vo = new Members(u_id, u_pw, u_name, u_email);
					
					result = dao.update(vo);
					
					if(result == 1) {
						System.out.println("변경되었습니다.");
					} else {
						System.out.println("변경 실패");
					}
				}

				break;

			case "4": //delete
				System.out.println("회원 정보 입력>");
				System.out.print("ID>");
				String d_id = scan.next();

				vo = dao.select(d_id);

				if(vo == null) { // 데이터가 없는 경우
					System.out.println("존재하지 않는 회원정보입니다.");
				} else {
					
					result = dao.delete(d_id);
					
					if(result == 1) {
						System.out.println("삭제되었습니다.");
					} else {
						System.out.println("삭제 실패");
					}
				}
				
				break;

			case "5":
				System.out.println("시스템을 종료합니다.");
				return;

			default:
				break;
			}
		}
	}
}
