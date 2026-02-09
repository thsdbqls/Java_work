package d260126_02;

import java.io.Serializable;
// 스트림형태의 객체는 직렬화 처리를 통해 네트워크에서도 사용이 가능하다
public class Phonebook implements Serializable {
	private final int id;
	private final String name;
	private final String hp;
	private final String email;
	
//	public Phonebook() {
//		// TODO Auto-generated constructor stub
//	}

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

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public String getHp() {
		return hp;
	}

//	public void setHp(String hp) {
//		this.hp = hp;
//	}

	public String getEmail() {
		return email;
	}

//	public void setEmail(String email) {
//		this.email = email;
//	}

	@Override
	public String toString() {
		return "Phonebook [id=" + id + ", name=" + name + ", hp=" + hp + ", email=" + email + "]";
	}
	
	
}
