package d260121_01;

public class Phonebook {
	
	private int id;
	private String name;
	private String hp;
	private String email;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Phonebook(String name, String hp, String email, int id) {
		super();
		this.name = name;
		this.hp = hp;
		this.email = email;
		this.id = id;
	}

	// 생성자 함수, get 함수, set 함수, toString 함수 생성
	public Phonebook() {} // 기본 생성자
	
	// 필드 생성자
	public Phonebook(String name, String hp, String email) {
		this.name=name;
		this.hp=hp;
		this.email=email;
	}
	
	// 한 개의 값을 가지고 오는 함수인 get 함수 작성
	public String getName() {
		return name;
	}
	public String getHp() {
		return hp;
	}
	public String getEmail() {
		return email;
	}
	
	// 값 변경을 하는 함수인 set 함수 작성
	public void setName(String name) {
		this.name=name;
	}
	public void setHp(String hp) {
		this.hp=hp;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	@Override
	public String toString() {
		return "Phonebook [id=" + id + ", name=" + name + ", hp=" + hp + ", email=" + email + "]";
	}
}
