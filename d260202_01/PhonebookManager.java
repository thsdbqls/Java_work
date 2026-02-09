package d260202_01;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PhonebookManager {
	
	PhonebookDAO dao;
	
	private Phonebook[] pb=new Phonebook[100];
	private int index=0;
	
	public PhonebookManager() {

	}
	
	
	
	public PhonebookManager(PhonebookDAO dao) {

		this.dao = dao;

	}



	public void insert(String name, String hp, String email) {
		int id = dao.count()+1;
		dao.insert(new Phonebook(id, name, hp, email));
	}


	public void select() {
		for(Phonebook p:dao.findAll()) {
			
				System.out.println(p);
			
		}
		
	}
	public void update(int id,Phonebook p) {
		if(p.getName().equals("")) {p.setName(null);}
		if(p.getHp().equals("")) {p.setHp(null);}
		if(p.getEmail().equals("")) {p.setEmail(null);}
		p.setId(id);
		
		dao.update(p);
	}

	public void delete(int id) {
		dao.delete(id);
	}
	
	public void selectById(int id) {
		System.out.println(dao.findById(id));
	}
	
	//찾는 사람이 배열에 존재하는 여부 확인하는 함수
	public boolean isExist(int id) {
		if(dao.findById(id)==null) {
			return false;
		}
		return true;
	}
	
}