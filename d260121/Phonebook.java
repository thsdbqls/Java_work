package d260121;

import java.awt.event.InputEvent;

public class Phonebook {
	// 변수 = 속성
	String name;
	String hp;
	String email;
	
	// 함수는 기능 , 함수=기능
	public void print() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+hp);
		System.out.println("이메일:"+email);
	}
	
	// 결론 :  클래스=객체
	// 클래스는 변수와 함수로 구성되어 있다
	// 객체는 속성과 기능으로 구성되어 있다.
	
	public void myprint
	(String name, String hp, String email) {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+hp);
		System.out.println("이메일:"+email);
	}
	
	public Phonebook() {}
}
