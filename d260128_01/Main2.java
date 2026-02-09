package d260128_01;

public class Main2 {

	public static void main(String[] args) {
		
		// 기능 제안 기능
		PhonebookUserDAO dao = new PhonebookDAOv1();
		// 인터페이스는 구현한 객체에서 인터페이스에 정의된 함수(기능)만 사용이 가능하다
		dao.findAll();
		dao.findById(0);
		
		
		
	}

}
