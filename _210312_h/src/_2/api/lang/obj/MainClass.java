package _2.api.lang.obj;

public class MainClass {

	public static void main(String[] args){
		
		/*
		 * Object 클래스의 기능
		 * - equlas - 객체의 주소값이 같다면 true
		 * - toString - 주소 값을 문자열로 반환
		 */
		
		Person hong = new Person("홍길동");
		Person kim = new Person("홍길동");
		
		System.out.println(hong.equals(hong));
		System.out.println(kim.equals(hong)); //객체가 다르니까 false
		
		System.out.println(kim.toString());
		
		//finallize는 gc가 호출되는 순서를 보장하지 않기 때문에 권장하지 않는다.
		hong = null; //객체 주소를 지움
		//System.gc(); //가비지 컬렉터를 호출함, 마지막에 실행되므로 순서가 보장이 안됨
		//hong.finalize();
		
		try {
			Person p = (Person)kim.clone();
			System.out.println("kim으로부터 복사된 객체:" + p.getName());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
