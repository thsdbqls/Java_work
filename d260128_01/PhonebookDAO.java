package d260128_01;

import java.util.List;

public interface PhonebookDAO {
	// 기능설계 (입력, 전체 출력, 선택 출력, 수정, 삭제)
	// insert 함수는 입력 4개가 있고 입력값에 따라 결과는 1:성공 0:실패
	
	public int insert(int id, String name, String hp, String email);
	
	// findAll함수는 입력값이 없고 전체 리스트 데이터를 반환합니다. 데이터가 없을 경우 null
	public List<Phonebook> findAll();  // 전체 출력 기능에서는
	
	public Phonebook findById(int id);
	
	public int updateById(Phonebook p);
	
	public int delete(int id);

}
