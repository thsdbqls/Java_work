package d260121;

public class Main {

	public static void main(String[] args) {
		Phonebook pb1=null;
		System.out.println(pb1);
//		pb1.name="hong";
//		System.out.println(pb1.name);
		pb1 = new Phonebook(); //Phonebook()는 생성자 함수
		// 생성자 함수는 자동으로 생성되는 함수이다.
		
		System.out.println(pb1);
		pb1.name="hong";
		System.out.println(pb1.name);
		pb1.print();
		pb1.myprint("hong", "010-1111-1111", "hong");
	}

}
