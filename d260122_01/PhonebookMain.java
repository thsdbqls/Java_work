package d260122_01;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookMain {

	public static void main(String[] args) throws IOException {
		/*
		PhonebookManager pb = new PhonebookManager();
				
		pb.insert("홍길동", "010-1111-1111", "hong@gmail");
		pb.insert("김길동", "010-1111-1111", "hong@gmail");
		pb.insert("손길동", "010-1111-1111", "hong@gmail");
		pb.update("김길동",new Phonebook);
		pb.select();
		*/
		
		// 프로그램에서 사용할 도구는 최상단에 위치하여 유지시킨다.
		PhonebookManager pm = new PhonebookManager();
		Scanner scan = new Scanner(System.in);
		String searchname=null;
		String name=null;
		String hp=null;
		String email=null;
		
		while(true) {
			System.out.println("check:"+System.in.available());
			
			
			
		// 어떻게 프로그램을 만들것인가를 설계
		// 중요한점 : 컴퓨터와 사용자는 대화를 한다.
		// 메뉴를 만들기(기능의 나열)
		System.out.println("+=====================+");
		System.out.println("|     전화번호부 관리     |");
		System.out.println("+=====================+");
		System.out.println("|  1. 전화번호부 입력     |");
		System.out.println("|  2. 전화번호부 전체 출력 |");
		System.out.println("|  3. 전화번호부 찾기     |");
		System.out.println("|  4. 전화번호부 수정     |");
		System.out.println("|  5. 전화번호부 삭제     |");
		System.out.println("+=====================+");
		
		// 메뉴 선택
		//int select=System.in.read();  // 키보드에서 입력되는 값을 받아들인다
		int select=scan.nextInt();
		
		// System.out.println(select); // 아스키코드(ascii)를 받아 들임
		// 문제: 사용자는 ascii코드 보다 숫자 1~5인 값을 이해하기 쉬움
		// 이를 해결할 방법은 ? => 48을 뺀다
		// select=select-48;
		// System.out.println(select);
		
		/* 선택된 번호를 수행한다(경우의 수는 여러개 이므로 if, switch 문 등을 활용 */
		
		switch(select) {
		case 1: 
			System.out.println("전화번호부에 입력할 이름을 입력하세요");
			name = scan.next();
			System.out.println("전화번호부에 입력할 전화번호를 입력하세요");
			hp = scan.next();
			System.out.println("전화번호부에 입력할 이메일을 입력하세요");
			email = scan.next();
			pm.insert(name, hp, email); 
			break;
		case 2: 
			pm.select(); 
			System.in.read();
			break;
		case 3: 
			System.out.println("찾을 이름을 입력하세요");
			searchname=scan.next();  // 문자를 받는 것은 next() 이다
			pm.selectByName(searchname);
			System.in.read();
			break;
		case 4: 
			// 버퍼를 비우는 역활
			// scan한 값이 존해하는 지 확인하는 함수
			if(scan.hasNextLine()) {
				scan.nextLine();
			}
			
			//수정할 사람이 있는지 여부를 확인
			// 만약에 수정할 것이 존재한다면 수정 값을 입력 받은 후 처리 
			System.out.println("수정할 사람의 이름을 입력하세요");

			
			searchname=scan.nextLine(); // 문자열을 공백까지 값으로 받아들이는 함수
			if(pm.isExist(searchname)) {
				/*
				System.out.println("수정할 사람의 내용을 입력하세요.[이름][전화번호][이메일]");
			
				
				//Phonebook p=new Phonebook(scan.next(), scan.next(), scan.next());
				
				String data = scan.nextLine();  // 엔터키까지 입력받는 함수
				String[] datas=data.split("/"); //스플릿을 이용하여 분리한다.
				Phonebook p=new Phonebook(datas[0],datas[1],datas[2]);
				
				System.out.println(p);
				
				//pm.update(searchname, p); 
				/// 
				 */
				
				System.out.println("변경할 이름을 입력하세요[변경사항이 없으면 enter");
				name=scan.nextLine();
				
				System.out.println("변경할 전화번호를 입력하세요[변경사항이 없으면 enter");
				hp=scan.nextLine();
				
				System.out.println("변경할 이메일을 입력하세요[변경사항이 없으면 enter");
				email=scan.nextLine();
				
				//변경 상항이 없을 경우 기존의 데이터를 가지고 와서 입력 처리를 해야 한다.
				Phonebook p=pm.getPhonebookByName(searchname);
				
				// 값이 빈란이 아닐 때 phonebook 객체를 변경해준다
				if(!name.equals("")) { // 빈 란이 아니라고 한다면
					p.setName(name);
				}
				if(!hp.equals("")) { 
					p.setHp(hp);
				}
				if(!email.equals("")) { 
					p.setEmail(email);
				}
				
				System.out.println(p);
				pm.update(searchname, p);  // 이놈은 참조이므로 문제가 발생한다.
			}
			else {
				System.out.println("수정할 전화번호부가 존재하지 않습니다");
			}
			break;
		case 5: 
			searchname=scan.next();
			if(pm.isExist(searchname)) {
				pm.delete(null); 
			}
			break;
		
		case 0:
			System.out.println("프로그램을 종료합니다");
		}
		
		
		}//end while
	}

}
