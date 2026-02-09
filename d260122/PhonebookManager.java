package d260122;

public class PhonebookManager {
	Phonebook[] pb = new Phonebook[100];
	// 배열 변수이름 = new 사용할 배열 갯수
	// 100개의 공간을 확보
	// 100개의 데이터를 관리하는 함수(기능)
	
	private int index=0;
	
	// insert(입력)
	public void insert(String name, String hp, String email) {
		// pb[0]=new Phonebook(name, hp, email);
		// 위의 데이터는 0번째 들어가는 것으로 다른 순서에 안 들어가는 문제 발생, 자동으로 객체를 생성하여 입력해줘야함
		
		pb[index]=new Phonebook(index+1,name, hp, email);
		index=index+1;
	}
	// select(전체 출력)
	public void select() {
		// 아래와 같이 쓰면 pb 배열에 null값이 있으면 오류가 발행하게 된다
		/*for(Phonebook p:pb) {
			System.out.println(p);
		}*/
		
		// null 값이 있으면 거기서 나온다
//		for(int i=0; i<index; i++) {
//			System.out.println(pb[i]);
//		}
		
		// id=0으로 삭제된 코드는 출력되지 않게 처리
		for(int i=0; i<index; i++) {
			if(pb[i].getId()!=0) {
				System.out.println(pb[i]);
			}
		}
		
	}
	// update(수정)(수정하기 위해 필요한 사항)
	public void update(String searchname,Phonebook p) {
		// 특정한 값을 찾아서 값을 수정 해야 한다.
		
		/*
		for(int i=0; i<index; i++) {
			if(searchname.equals(pb[i].getName())) {
				pb[i].setName(p.getName());
				pb[i].setHp(p.getHp());
				pb[i].setEmail(p.getEmail());
				break; // 반복문을 빠져나가는 기능
				*/
		
		for(int i=0; i<index; i++) {
			if(searchname.equals(pb[i].getName())) {
				if(p.getName()!=null) {
					pb[i].setName(p.getName());
				}
				
				if(p.getHp()!=null) {
				pb[i].setHp(p.getHp());
				}
				
				if(p.getEmail()!=null) {
				pb[i].setEmail(p.getEmail());
				}
				
				return;
			}
		}
		
		// 중복이 발생하지 않는 것은 전화번호와 이메일 2개가 있다
		// 이중 1개를 선택한다.
	}
	// delete(삭제)
	public void delete(String name) {
		for(int i=0; i<index; i++) {
			// 데이터 배열에서 이름을 가져와서 입력한 이름과 같은지 확인
			if(pb[i].getName().equals(name)) {
				pb[i].setId(0);  //id가 0이면 삭제
				// 위의 코드로 인해서 파생되는 수정코드는
				// 전체출력일 때 id가 0인 것은 출력을 하지 않도록 처리
			}
		}
	}
	
	
	// 찾기 - select에서 파생되어서 만들어 지는 함수
/*	public coid selectByName(String name) {
		for(int i=0; i<index; i++) {
			if(pb[i].getName().equals(name)) {
				System.out.println(pb[i]);
				break;
			}
		}
		*/
		// 문제점 : 찾는 이름이 삭제된 이름이여서 검색할 때 삭제된 이름의 배열이 출력되는 문제가 발생
	public void selectByName(String name) {
		for(int i=0; i<index; i++) {
			if(pb[i].getName().equals(name)&& pb[i].getId()!=0) {
				System.out.println(pb[i]);
				break;
			}
		}
	}
}
