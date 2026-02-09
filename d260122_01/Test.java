package d260122_01;

public class Test {

	public static void main(String[] args) {
		// 값이냐? 참조냐?
		// 다른 말로는 복사냐? 참조냐?
		// 결론 : 소문자로 되어 진 형태(int, float, chat, byte, boolean, ...) 이것은 복사이다(값을 복사한다)
		// 객체는 참조다.
		
		// 복사
		int a=10;
		int b=a;
		// 변수는 주소를 대신하는 것으로 a의 값은 10으로 
		// b=a는 a의 주소를 가져오는 것이 아니라 10을 가져오는 것이다
		
		// 참조
		Phonebook p1= new Phonebook();
		System.out.println(p1.hashCode());
		Phonebook p2= new Phonebook();
		System.out.println(p2.hashCode());
		
		p1=p2; // 참조이다
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		Phonebook p3 = new Phonebook("hong","010-1111-1111","hong@gmail.com");
		
		Phonebook p4 = p3;
		System.out.println(p4);
		p3.setName("kim");
		System.out.println(p4);
		
		a=100;
		System.out.println(a);
		System.out.println(b);
		
		PhonebookManager pm = new PhonebookManager();
		// 함수를 통해서 가져오는 객체의 hashcode
		System.out.println(pm.getPhonebookByName("홍길동").hashCode());
		
	}
}
