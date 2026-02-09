package d260202_01;

public class TestMain {

	public static void main(String[] args) {
		// 테스트 진행
		// 만든 객체를 인터페이스를 활용하여 테스트 진행
		PhonebookDAO dao = new H2PhonebookDAO();
		//PhonebookDAO dao = new OraclePhonebookDAO();
		// 전체 삭제
		//System.out.println(dao.delete());
		
		// 입력
		/*
		dao.insert(new Phonebook(1, "홍길동1","010-1111-1111", "hong1@gmail"));
		dao.insert(new Phonebook(2, "홍길동2","010-1111-1112", "hong2@gmail"));
		dao.insert(new Phonebook(3, "홍길동3","010-1111-1113", "hong3@gmail"));
		*/
		
		// 전체 출력
		//System.out.println(dao.findAll());

		// 선택 출력
		System.out.println(dao.findById(2));
		/*
		// 수정
		dao.update(new Phonebook(2, null, "010-1234-5678", null));
		
		// 선택 삭제
		dao.delete(2);*/
		
		// 카운트
		dao.count();
	}

}
