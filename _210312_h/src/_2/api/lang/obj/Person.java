package _2.api.lang.obj;

public class Person implements Cloneable{

	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//오버라이딩 확인
	@Override
	public boolean equals(Object obj) {
		//자동으로 super를 연결해주지만 내맘대로 편집해도 됨
		//return super.equals(obj);
		
		if(obj instanceof Person) {
			
			Person p = (Person) obj; //Person 캐스팅
			if(p.getName().equals(this.name)) {
				return true;
			}
		}
		
		return false; //이름이 같지 않다.
	}

	//toString() 오버라이딩
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	//protected니까 같은 패키지 안에서 사용될 수 있다.
	//객체가 소멸되는 시점에 마지막에 호출 됨
	// - 가비지 컬렉터가 소멸시키기 때문에 소멸되는 시점은 알 수 없다
	@Override
	protected void finalize() throws Throwable {
		System.out.println(this.name + "객체가 소멸됨");
		super.finalize();
	}

	//clone 기능을 쓰려면 Cloneable을 그냥 꼭 써야된다
	/*
	 * 복사 - 얕은 복사 & 깊은 복사
	 * 얕은 복사 : 주소와 값만 복사
	 * 깊은 복사 : 진짜 하나 더 만들어주는 것
	 */
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
