package d260121_01;

public class PhonebookManager {
	// 1개의 객체를 100개 관리하는 객체로
	Phonebook[] pb=new Phonebook[100];
	int index=0;
	
	// 관리하기 위한 기능(입력, 출력, 수정, 삭제) - 위의 100개를 관리함
	public void insert(String name, String hp, String email) {
		// 입력을 하기위해서 필요한 값
		
		// 입력 값을 pb에 연결해야 한다
		pb[index]=new Phonebook(name, hp, email);
		index = index+1;
	}
	public void select() {
		// 100개의 배열에 null 값이 존재하면 오류가 발생한다.
		/*
		for(Phonebook p:pb) {
			System.out.println(p);
		}
		*/
		for(int i=0; i<index;i++) {
			System.out.println(pb[i]);
		}
	}
	public void update() {
	
	}
	public void delete() {
	
	}
}
