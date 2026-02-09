package d260122_01;

public class PhonebookManager {
	// 배열 넣기
	Phonebook[] pb = new Phonebook[100];
	int index = 0;
	
	public PhonebookManager() {
		insert("홍길동", "010-1111-1111", "hong@gmail");
		insert("김길동", "010-1111-1111", "hong@gmail");
		insert("손길동", "010-1111-1111", "hong@gmail");
		//System.out.println(pb[0].hashCode());
	}
	
	// 입력
	public void insert(String name, String hp, String email) {
		pb[index] = new Phonebook(index+1, name, hp, email);
		index = index+1;
	}
	// 출력
	public void select() {
		for(int i=0; i<index; i++) {
			if(pb[i].getId()!=0) {
				System.out.println(pb[i]);
			}
		}
	}
	// 수정(찾을 이름, 생성자)
	public void update(String searchname, Phonebook p) {
		for(int i=0; i<index; i++) {
			if(searchname.equals(p.getName())) {
				if(p.getName()!=null) {
					// 입력할 이름의 위치는 가져온 이름의 위치
					p.setName(p.getName());
				}
				if(p.getHp()!=null) {
					// 입력할 전화번호의 위치는 가져온 전화번호의 위치
					p.setHp(p.getHp());
				}
				if(p.getEmail()!=null) {
					// 입력할 이메일의 위치는 가져온 이메일의 위치
					p.setEmail(p.getEmail());
				}
				return;
			}
		}
	}
	// 삭제
	public void delete(String name) {
		for(int i=0; i<index; i++) {
			if(pb[i].getName().equals(name)) {
				// id는 0으로
				pb[i].setId(0);
			}
		}
	}
	// 찾기
	public void selectByName(String name) {
		int i = 0;
		for(i=0; i<index; i++) {
			if(pb[i].getName().equals(name)&& pb[i].getId()!=0) {
				System.out.println(pb[i]);
				break;
			}
			
			// i, index를 조건문으로 처리해도 가능함 (for int 로 정의될때)
		}
		//System.out.println("i:"+i);
		//System.out.println("index:"+index);
		if(index==i) {
			System.out.println("전화번호 부가 존재하지 않습니다");
		}
	}
	
	// 찾는 사람이 배열에 존재하는지 여부를 확인하는 함수
	// boolean
	public boolean isExist(String searchname) {
		for(int i=0; i<index; i++) {
			if(pb[i].getName().equals(searchname)) {
				return true;
			}
		}
		return false;
	}
	
	
	public Phonebook getPhonebookByName(String name) {
		int i = 0;
		for(i=0; i<index; i++) {
			if(pb[i].getName().equals(name)&& pb[i].getId()!=0) {
				// 참조에 의한 전달이므로 문제의 소지가 발생한다
				//return pb[i];
				
				// 이를 해결하기 위한 방법은 객체의 복사 방법을 사용
				return new Phonebook(pb[i].getName(),pb[i].getHp(),pb[i].getEmail());
				// 이렇게 하면 복사를 한것이여서 그 값을 날려먹어도 기본의 값은 그대로 있기 때문에 상관없다
				
				
			}
		}
		
			return null;
	}
	
	
}
