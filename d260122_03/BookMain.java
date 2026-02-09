package d260122_03;

import java.io.IOException;
import java.util.Scanner;

public class BookMain {
	
	static BookManager bm = new BookManager();
	static Scanner scan = new Scanner(System.in);
	static String searchid;
	
	static String isbn;
	static String title;
	static String name;
	static String publisher;
	static String year;

	public static void main(String[] args) throws IOException {
		
		
		
		
		// 분류
		while(true) {
			int menu = menu();
			switch(menu) {  
				case 1:
					// 입력함수
					insert();
					break;
		
				case 2:
					// 전체 출력
					views();
					break;
					

				case 3:
					// 선택 출력
					view();
					break;
					

				case 4:
					// 수정
					update();
					break;
					

				case 5:
					// 삭제
					delete();
					break;
					

				case 0:
					System.out.println("프로그램이 종료됩니다");
					System.exit(0);
					break;
				}
			}
		
		}
	
	public static int menu() {
		// 메뉴
				System.out.println("+======================+");
				System.out.println("|    1. 입력            |");
				System.out.println("|    2. 전체 출력        |");
				System.out.println("|    3. 선택 출력        |");
				System.out.println("|    4. 수정            |");
				System.out.println("|    5. 삭제            |");
				System.out.println("|    6. 파일 로드        |");
				System.out.println("|    7. 파일 세이브       |");
				System.out.println("|    0. 종료            |");
				System.out.println("+======================+");
				
				// 메뉴 중 1개를 선택
				System.out.println(" 메뉴 중 1개를 선택하세요 ");
				
				// 입력
				
				return scan.nextInt();
	}
	
	public static void insert() {
		System.out.println("책의 ISBN을 작성하세요");
		isbn = scan.next();
		System.out.println("책의 이름을 작성하세요");
		title = scan.next();
		System.out.println("저자의 이름을 작성하세요");
		name = scan.next();
		System.out.println("출판사 이름을 작성하세요");
		publisher = scan.next();
		System.out.println("출판 연도를 작성하세요");
		year = scan.next();
		bm.insert(isbn, title, name, publisher, year);
	}
	
	public static void views() throws IOException {
		bm.select(); 
		System.in.read();
	}
	
	public static void view() throws IOException {
		System.out.println("찾을 이름을 입력하세요");
		searchid=scan.next();  
		bm.selectByName(searchid);
		System.in.read();
	}

	public static void update() {
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		
		System.out.println("수정할 책의 isbn을 입력하세요.");
		
		searchid=scan.nextLine();
		
		// bm 배열에 찾는 id가 있는지 확인
		if(bm.isExist(searchid)) {
			System.out.println("수정할 책의 isbn을 입력하세요");
			isbn = scan.next();
			
			System.out.println("수정할 책의 이름을 입력하세요");
			title = scan.next();
			
			System.out.println("수정할 책의 저자를 입력하세요");
			name = scan.next();

			System.out.println("수정할 책의 출판사 이름을 입력하세요");
			publisher = scan.next();
			
			System.out.println("수정할 책의 출판 년도를 입력하세요");
			year = scan.next();
			
			Book b = bm.getbookByName(searchid);
			
			if(!isbn.equals("")) {
				b.setIsbn(isbn);
			}
			if(!isbn.equals("")) {
				b.setTitle(title);
			}
			if(!name.equals("")) {
				b.setAuthor(name);
			}
			if(!publisher.equals("")) {
				b.setPublisher(publisher);
			}
			if(!year.equals("")) {
				b.setYear(year);
			}
			
			System.out.println(b);
			bm.update(searchid, b); 
		}
		else {
			System.out.println("수정할 전화번호부가 존재하지 않습니다");
		}
		
	}

	public static void delete() {
		System.out.println("삭제할 IBNS를 입력하세요");
		searchid=scan.next();
		// 참 거짓을 분류
		if(bm.isExist(searchid)) {
			bm.delete(null); 
		}
	
	}
	
	public void fileload() {
		System.out.println("로드할 파일을 파일을 입력하세요");
		
		String filename = scan.next();  // 공백이 있으면 안되서 next() 사용
		bm.fileload(filename);
				
	}
	
	public void filesave() {
		System.out.println("로드할 파일을 파일을 입력하세요");
		String filename = scan.next();

		//파일 저장이 실패했을때
		if(!bm.filesave(filename)) {
			System.out.println("파일 저장이 실패하였습니다");	
			return;
		}
		
		System.out.println("파일이 저장이 되었습니다");

	}


}
