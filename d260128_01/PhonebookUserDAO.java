package d260128_01;

import java.util.List;

public interface PhonebookUserDAO {

	public List<Phonebook> findAll();  
	public Phonebook findById(int id);
	
	public void turnOn();

}
