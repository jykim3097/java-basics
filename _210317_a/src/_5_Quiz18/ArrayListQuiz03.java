package _5_Quiz18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListQuiz03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		//1. User를 저장할 수 있는 list를 선언해 주세요.
		List<User> list = new ArrayList<>();

		while(true) {

			System.out.println("[1.등록 | 2.회원정보보기 |3.회원정보검색 | 4.회원정보삭제 | 5.종료");
			System.out.print("메뉴를 입력>");
			int menu = scan.nextInt();

			if(menu == 1) {
				//스캐너로 이름, 나이를 입력받고 User에 저장, 리스트에 추가
				System.out.print("이름>");
				String name = scan.next();
				System.out.print("나이>");
				int age = scan.nextInt();

				User u = new User(name, age);
				list.add(u);

			} else if(menu == 2) {
				//list에 길이만큼 회전하면서 User객체의 이름, 나이를 순서대로 출력

				System.out.println("======회원정보======");
				for(int i=0; i<list.size(); i++) {
					System.out.println("이름: "+list.get(i).getName()+", 나이:"+list.get(i).getAge());
				}
				System.out.println();

			} else if(menu == 3) {
				//찾을 이름을 입력받습니다. 이름이 있다면, 이름과 나이를 출력합니다.
				//찾는 이름 없다면 "~~님은 목록에 없습니다" 를 출력합니다.

				System.out.print("이름>");
				String name = scan.next();

				//내 방법
				String tmp = "";
				for(User u : list) {
					if(u.getName().equals(name)) {
						tmp = u.getName() + ", " + u.getAge();
						break;
					}
				}

				if(tmp.equals("")) { //끝까지 돌았는데 못 만났다면 = ( i == size-1)
					System.out.println(name +"님은 목록에 없습니다.");
				} else {
					System.out.println(tmp);
				}

				// 카운트, 불린변수, i가 size-1인 경우(break을 썼기때문에 가능)
				//1. 카운트
				int cnt =0;
				for(int i=0; i<list.size(); i++) {
					if(list.get(i).getName().equals(name)) {
						System.out.println(list.get(i).getName() + ", " + list.get(i).getAge());
					} else {
						cnt++;
					}	
				}

				//2. 불린변수
				boolean flag = false;
				for(int i=0; i<list.size(); i++) {

					if(flag == true) break;

					if(list.get(i).getName().equals(name)) {
						System.out.println(list.get(i).getName() + ", " + list.get(i).getAge());
						flag = true;
					}
				}
				
				if(flag == false) {
					System.out.println(name +"님은 목록에 없습니다.");
				}

				//3. i 활용
				for(int i=0; i<list.size(); i++) {
					if(list.get(i).getName().equals(name)) {
						System.out.println(list.get(i).getName() + ", " + list.get(i).getAge());
						break;
					}
					if(i == list.size()-1) {
						System.out.println(name+"님은 목록에 없습니다.");
					}
				}
				
			} else if(menu == 4) {
				//삭제할 이름을 입력받습니다. 입력받은 이름과 동일하다면 User객체를 삭제.
				System.out.print("이름>");
				String name = scan.next();

				for(int i=0; i<list.size(); i++) {
					if(list.get(i).getName().equals(name)) { //get(i)!
						list.remove(i);
						System.out.println(name + "님이 삭제되었습니다.");
						break;
					}
				}

			} else if(menu == 5) {
				//프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0); //프로그램 완전 종료
			} else {
				System.out.println("다시 입력하세요");
			}	
		}	
	}
}
