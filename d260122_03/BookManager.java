package d260122_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import d260122_01.Phonebook;

public class BookManager {
	//Book[] bk = new Book[100];
	private List<Book> bk = new ArrayList<Book>();
	
	public BookManager() {
		fileload("book.txt");
	}
	
	//int index=0;
	int i=0;
	
	// 입력
	public void insert(String isbn,String title, String author, String publisher, String year) {
		bk.add(new Book(isbn,title, author, publisher, year));
		//index = index+1;
	}
	
	// 전체 출력
	public void select() {
		for(Book b:bk) {
			if(b.getIsbn()!="") {
				System.out.println(b);
			}
		}
		System.out.println("더이상 책은 존재하지 않습니다");
	}
	
	// 선택 출력
	public void selectByName(String isbn) {
		for(Book b:bk) {
			if(b.getTitle().equals(isbn)) {
				System.out.println(b);
			}
		}
		System.out.println("해당 책은 존재하지 않습니다");
	}
	
	// 수정
	public void update(String searchid, Book b) {
		for(Book _b:bk) {
			if(searchid.equals(b.getIsbn())) {
				if(_b.getIsbn()!=null) {
					_b.setIsbn(b.getIsbn());
				}
				if(_b.getTitle()!=null) {
					_b.setTitle(b.getTitle());
				}
				if(_b.getAuthor()!=null) {
					_b.setAuthor(b.getAuthor());
				}
				if(_b.getPublisher()!=null) {
					_b.setPublisher(b.getPublisher());
				}
				if(_b.getYear()!=null) {
					_b.setYear(b.getYear());
				}
			}
		}
	}
	
	// 삭제
	public void delete(String id) {
		/*for(i=0; i<index; i++) {
			if(bk[i].getIsbn().equals(id)) {
				bk[i].setIsbn("");
			}
		}*/
		
		Iterator<Book> it = bk.iterator();
		while(it.hasNext()) {    // 값이 들어오는지 확인
			Book b = it.next();
			if(b.getIsbn().equals(id)) {
				it.remove();
				break;
			}
		}
	}
	
	// 찾는 사람이 배열에 존재하는지 여부를 확인하는 함수
	// boolean
	public boolean isExist(String searchname) {
		for(Book b:bk) {
			if(b.getIsbn().equals(searchname)) {
					return true;
			}
		}
		return false;
	}
	
	public Book getbookByName(String isbn) {
		int i = 0;
		for(Book b:bk) {
			if(b.getIsbn().equals(isbn)) {
				return new Book(b.getIsbn(),b.getTitle(),b.getAuthor(),b.getPublisher(),b.getYear());
			}
		}
		return null;
	}
	
	// 파일에 저장
	public boolean filesave(String filename) {
		try {
			// 저장할 파일 선택
			BufferedWriter bw = new BufferedWriter(new FileWriter("book.txt"));
				for(Book b:bk) {
					int i=0;
					bw.write(
						b.getIsbn()+" "+
						b.getTitle()+" "+
						b.getAuthor() +" "+
						b.getPublisher()+" "+
						b.getYear()
							);
					i++;

					if(i!=(bk.size()-1)) {
						bw.newLine();
					}
				bw.flush();
				bw.close();
				return true;	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;	
			}
		return false;	
	}
	
	// 파일에서 가져오기
	public void fileload(String filename) {
		bk = new ArrayList<Book>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("book.txt"));
			
			String data = "";
			try {
				while((data = br.readLine())!=null) {
					insert(
							data.split(" ")[0],
							data.split(" ")[1], 
							data.split(" ")[2], 
							data.split(" ")[3],
							data.split(" ")[4]
							);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
