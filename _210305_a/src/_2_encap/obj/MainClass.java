package _2_encap.obj;

public class MainClass {
	
	public static void main(String[] args) {
		
		//Hotel 안에 있는 Employee의 working() 실행
		Hotel hotel = new Hotel();
		hotel.getEmp().working();
		
		hotel.setChef(new Chef());
		hotel.getChef().cooking();
	}
}
