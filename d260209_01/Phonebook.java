package d260209_01;

public class Phonebook {
	private int id;
	private String name;
	public Phonebook() {
		
	}
	
	public Phonebook(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
