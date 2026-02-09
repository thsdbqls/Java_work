package d260122_03;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import d260127.PhonebookManager;

public class BookFrame extends Frame {
	private BookManager pm = new BookManager();
	/*static String isbn;
	static String title;
	static String name;
	static String publisher;
	static String year;*/
	
	java.awt.List listBox;
	
	// 메뉴 부품
	Button menuInsertbtn, menuAllviewbtn, menuSelectviewbtn, 
		   menuUpdatebtn, menuDeletebtn, menuFilesavebtn, menuFileloadbtn;
	
	// 입력 부품
	Label insertIsbnlb, insertTitlelb, insertNamelb, insertPublisherlb, insertYearlb;
	TextField insertIsbntf, insertTitletf, insertNametf, insertPublishertf, insertYeartf;
	Button insertBtn;
	
	public BookFrame() {
		setTitle("도서 책 프로그램");
		setBounds(0,0,400,700);
		setLayout(new FlowLayout());
		setVisible(true);
		
		// 윈도우 닫기 이밴트
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		});
		// 메뉴 부품 설정
		menuInsertbtn = new Button("입력 버튼");
		menuAllviewbtn = new Button("전체 출력 버튼");
		menuSelectviewbtn = new Button("선택 출력 버튼");
		menuUpdatebtn = new Button("업데이트 버튼");
		menuDeletebtn = new Button("삭제 버튼");
		menuFilesavebtn = new Button("파일에 저장하기");
		menuFileloadbtn = new Button("파일에서 가져오기");
		
		menuInsertbtn.setPreferredSize(new Dimension(300,50));
		menuAllviewbtn.setPreferredSize(new Dimension(300,50));
		menuSelectviewbtn.setPreferredSize(new Dimension(300,50));
		menuUpdatebtn.setPreferredSize(new Dimension(300,50));
		menuDeletebtn.setPreferredSize(new Dimension(300,50));
		menuFilesavebtn.setPreferredSize(new Dimension(300,50));
		menuFileloadbtn.setPreferredSize(new Dimension(300,50));
		
		add(menuInsertbtn);
		add(menuAllviewbtn);
		add(menuSelectviewbtn);
		add(menuUpdatebtn);
		add(menuDeletebtn);
		add(menuFilesavebtn);
		add(menuFileloadbtn);
		
		menuInsertbtn.setVisible(true);
		menuAllviewbtn.setVisible(true);
		menuSelectviewbtn.setVisible(true);
		menuUpdatebtn.setVisible(true);
		menuDeletebtn.setVisible(true);
		menuFilesavebtn.setVisible(true);
		menuFileloadbtn.setVisible(true);

		
		// 입력 부풀 설정
		// 입력 isbn
		insertIsbnlb = new Label();
		insertIsbntf = new TextField();
		// 입력 제목
		insertTitlelb = new Label();
		insertTitletf = new TextField();
		// 입력 작가
		insertNamelb = new Label();
		insertNametf = new TextField();
		// 입력 출판사
		insertPublisherlb = new Label();
		insertPublishertf = new TextField();
		// 입력 출판일
		insertYearlb = new Label();
		insertYeartf = new TextField();
		
		
		
		
	}


	public java.awt.List getListBox() {
		return listBox;
	}

	public void setListBox(java.awt.List listBox) {
		this.listBox = listBox;
	}
	
	public void setVisible() {
		
	}
	
}
