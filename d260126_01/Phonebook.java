package d260126_01;

public class Phonebook {
	private int id;
	private String name;
	private String hp;
	private String email;
	
	public Phonebook() {
		// TODO Auto-generated constructor stub
	}

	public Phonebook(int id, String name, String hp, String email) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.email = email;
	}
	

	public Phonebook(String name, String hp, String email) {
		super();
		this.name = name;
		this.hp = hp;
		this.email = email;
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

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Phonebook [id=" + id + ", name=" + name + ", hp=" + hp + ", email=" + email + "]";
	}
	
	
}
