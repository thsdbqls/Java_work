package d260121;

public class main2 {

	public static void main(String[] args) {
		Phonebook pb1 = new Phonebook();
		
		pb1.name = "hong";
		pb1.hp="010-1111-1111";
		pb1.email = "hong@gmail.com";
		
		Phonebook pb2 = new Phonebook();
		pb2.name = "kim";
		pb2.hp="010-1111-2222";
		pb2.email = "kim@gmail.com";
		
		//pb1 객체에 대한 전체 정보 출력
		pb1.print();
		//pb2 객체에 대한 전체 정보 출력
		pb2.print();
	}

}
