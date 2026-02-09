package d260128_01;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// 인터페이스 = 객체
		// 메인과 PhonebookDAOv1을 연결한다.
		PhonebookDAO dao = new PhonebookDAOv1();
		System.out.println("메뉴를 입력하세요.");
		
		switch ((new Scanner(System.in)).next()){
		case "입력" : dao.insert(0, null, null, null); break; 
		case "전체 출력" : dao.findAll(); break; 
		case "선택 출력" : dao.findById(0); break; 
		case "수정" : dao.updateById(null); break; 
		case "삭제" : dao.delete(0); break; 
		default:

		}
	}
}
