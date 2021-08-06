package _210420.jdbc.example.step2;

public interface IMembersDAO {

	//사용방법 정의
	
	//0.모든 회원 정보 조회
	void selectAll();
	
	//1. 입력받은 id의 정보 조회
	Members select(String id);
	
	//2. 입력받은 멤버 클래스 insert
	int insert(Members vo);
	
	//3. 입력받은 멤버 클래스로 수정(update)
	int update(Members vo);
	
	//4. 입력받은 id의 정보 삭제
	int delete(String id);
}
