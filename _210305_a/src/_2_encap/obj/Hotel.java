package _2_encap.obj;

public class Hotel {
	
	//String처럼 클래스도 멤버변수가 될 수 있다.
	//클래스도 타입이다!!!!!!!!!*****
	
	//멤버변수
	private Employee emp;
	private Chef chef;
	
	//생성자
	public Hotel() {
		this.emp = new Employee();
		this.chef = new Chef();
	}

	//emp setter, getter
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	public Employee getEmp() {
		return emp;
	}
	
	//chef setter, getter
	public void setChef(Chef chef) {
		System.out.println(this.chef);
		System.out.println(chef);
		this.chef = chef;
	}
	
	public Chef getChef() {
		return chef;
	}
	
}
