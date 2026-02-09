package d260202_01;


//데이터를 전달하는 객체(VO(Value Object)객체 또는 DTO(Data Transfer Object)(데이터를 전송하기 위한 객체))
//해당 객체는 데이터베이스 테이블의 필드명과 일치하게 설계
//데이터를 전달하는 객체이므로 기본생성자, 필드 생성자, get, set, toString 함수 작성
public class Phonebook {
	private int id;
	private String name;
	private String hp;
	private String email;
	
	public Phonebook() {
		// TODO Auto-generated constructor stub
	}
	
	public Phonebook(int id, String name, String hp, String email) {
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.email = email;
	}
	
	public Phonebook(String name, String hp, String email) {
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