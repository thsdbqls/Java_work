package d260122_02;

import java.io.IOException;
import java.util.Scanner;

import d260122_01.Phonebook;
import d260122_01.PhonebookManager;

public class PhonebookProgram {
	
	PhonebookManager pm = new PhonebookManager();
	Scanner scan = new Scanner(System.in);
	String searchname;
	String name;
	String hp;
	String email;
	
	public PhonebookProgram() throws IOException {


				
			while(true) {
				switch(menu()) {   
				case 1: 
					insert();
					break;
				case 2: 
					views();
					break;
				case 3: 
					view();
					break;
				case 4: 
					update();
					break;
				case 5: 
					delete();
					break;
				
				case 0:
					System.out.println("프로그램을 종료합니다");
					System.exit(0);
				}	
				
			}//end while
	}
	
	public int menu() {
		System.out.println("+=====================+");
		System.out.println("|     전화번호부 관리     |");
		System.out.println("+=====================+");
		System.out.println("|  1. 전화번호부 입력     |");
		System.out.println("|  2. 전화번호부 전체 출력 |");
		System.out.println("|  3. 전화번호부 찾기     |");
		System.out.println("|  4. 전화번호부 수정     |");
		System.out.println("|  5. 전화번호부 삭제     |");
		System.out.println("|  0. 프로그램 종료       |");
		System.out.println("+=====================+");
		
		return scan.nextInt();
	}
	
	public void insert() {
		System.out.println("전화번호부에 입력할 이름을 입력하세요");
		name = scan.next();
		System.out.println("전화번호부에 입력할 전화번호를 입력하세요");
		hp = scan.next();
		System.out.println("전화번호부에 입력할 이메일을 입력하세요");
		email = scan.next();
		pm.insert(name, hp, email); 
		
	}
	public void views() throws IOException {
		pm.select(); 
		System.in.read();
	}
	public void view() throws IOException {
		System.out.println("찾을 이름을 입력하세요");
		searchname=scan.next();  
		pm.selectByName(searchname);
		System.in.read();
	}
	public void update() {
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		

		System.out.println("수정할 사람의 이름을 입력하세요");

		
		searchname=scan.nextLine(); // 문자열을 공백까지 값으로 받아들이는 함수
		if(pm.isExist(searchname)) {
									
			System.out.println("변경할 이름을 입력하세요[변경사항이 없으면 enter");
			name=scan.nextLine();
			
			System.out.println("변경할 전화번호를 입력하세요[변경사항이 없으면 enter");
			hp=scan.nextLine();
			
			System.out.println("변경할 이메일을 입력하세요[변경사항이 없으면 enter");
			email=scan.nextLine();
			
			
			Phonebook p=pm.getPhonebookByName(searchname);
			
			
			if(!name.equals("")) { 
				p.setName(name);
			}
			if(!hp.equals("")) { 
				p.setHp(hp);
			}
			if(!email.equals("")) { 
				p.setEmail(email);
			}
			
			System.out.println(p);
			pm.update(searchname, p); 
		}
		else {
			System.out.println("수정할 전화번호부가 존재하지 않습니다");
		}
	}
	public void delete() {
		searchname=scan.next();
		if(pm.isExist(searchname)) {
			pm.delete(null); 
		}
	}
}
