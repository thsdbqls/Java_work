package d260121_01;

public class PhonebookMain {

	public static void main(String[] args) {
		
		// Phonebook 객체
		// 전화번호 객체는 데이터를 한번에 담는 그릇이다
		// 전화번호 객체는 데이터를 한번에 전송하는 객체이다
		// 생성자 함수는 여러개가 가능하다.
		// 생성자, get, set, toString 함수 작성
		
		// PhonebookManager 객체
		// 전화번호 객체를 관리하는 객체는
		// 입력, 출력, 수정, 삭제의 기능을 가지고 있다.
		// 추가적으로 관리하는 객체는 여러개의 전화번호가 있어야 한다
		
		// PhonebookMain 객체
		// 전화번호 객체와 전화번호 관리객체를 실행하는 함수는 main 함수 이다.

//		Phonebook pb=new Phonebook();
//		pb.name="Hong";
		
		Phonebook pb=new Phonebook("hong","010-1111-1111","hong@gmail");
		System.out.println("이름:"+pb.getName());
		System.out.println("전화번호:"+pb.getHp());
		System.out.println("이메일:"+pb.getEmail());
		
		// 이름, 전화번호, 이메일이 변경되었을 경우 set 함수를 이용하여 각각의 내용을 변경
		pb.setHp("010-1111-2222");
		System.out.println("전화번호:"+pb.getHp());
		
		// 한번에 모든 내용을 보고 싶음
		System.out.println(pb);
		System.out.println(pb.toString());
		
		
	}

}
