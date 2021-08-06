package _210420.jdbc.example.step2;

public class Members {

	//Members 테이블의 값을 저장하는 용도의 클래스
	//일반적으로 테이블명과 동일한 이름의 변수를 선언한다
	private String id;
	private String pw;
	private String name;
	private String email;
	
	//모든 변수를 받아서 초기화하는 생성자, 기본생성자를 만든다
	public Members() {
	}

	public Members(String id, String pw, String name, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void printMem(String id, String pw, String name, String email) {
		System.out.println("아이디: "+ id);
		System.out.println("비밀번호: " + pw);
		System.out.println("이름: " + name);
		System.out.println("이메일: " + email);
	}
	
}
