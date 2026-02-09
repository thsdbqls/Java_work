package d260128_01;

import java.util.List;

public class PhonebookDAOv1 implements PhonebookDAO, PhonebookUserDAO {

	@Override
	public int insert(int id, String name, String hp, String email) {
		// TODO Auto-generated method stub
		System.out.println("버전1에 대한 전체 리스트 출력합니다");
		return 0;
	}

	@Override
	public List<Phonebook> findAll() {
		// TODO Auto-generated method stub
		System.out.println("버전1에 대한 전체 리스트 출력합니다");
		return null;
	}

	@Override
	public Phonebook findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateById(Phonebook p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}


}
