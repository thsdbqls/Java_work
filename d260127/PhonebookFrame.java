package d260127;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PhonebookFrame extends Frame{
	private PhonebookManager pm = new PhonebookManager();
	
	// 메인메뉴 부폼
	Button menuInsertbtn;
	Button menuAllprintbtn;
	Button menuViewbtn;
	Button menuUpdatebtn;
	Button menuDeletebtn;
	
	//입력 부품
	Label insertNamelb;
	Label insertHplb;
	Label insertEmaillb;
	
	TextField insertNametf;
	TextField insertHptf;
	TextField insertEmailtf;
	
	Button insertInsertbtn = new Button("전화번호부 추가 입력");
	
	//전체 출력 부품
	java.awt.List listBox;
	Label viewIdlb, viewNamelb, viewHplb, viewEmaillb;
	
	//찾기 부품 생성
	Label updateNamelb ,searchIdlb, searchNamelb, searchHplb, searchEmaillb;
	TextField updateNametf;
	Button updatebtn;
	java.awt.List updateSearchListBox;
	
	//수정 부품
	Label UpdateIdlb, UpdateNamelb, UpdateHplb, UpdateEmaillb, UpdateIdtf;
	TextField UpdateNametf, UpdateHptf, UpdateEmailtf;
	Button UpdateSbtn,Updatebtn, cancelbtn;
	java.awt.List UpdateSearchListBox;
	
	//삭제 부품
	Label deletelb;
	TextField deletetf;
	Button deletebtn;
	
	public PhonebookFrame() {   // 생성자
		setTitle("전화번호부 프로그램");
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
		
		// 메인 메뉴 부품 만들기
		menuInsertbtn = new Button("전화번호부 입력");
		menuAllprintbtn = new Button("전화번호부 출력");
		menuViewbtn = new Button("전화번호부 찾기");
		menuUpdatebtn = new Button("전화번호부 수정");
		menuDeletebtn = new Button("전화번호부 삭제");
		
		// 버튼 크기 변경
		menuInsertbtn.setPreferredSize(new Dimension(300,50));
		menuAllprintbtn.setPreferredSize(new Dimension(300,50));
		menuViewbtn.setPreferredSize(new Dimension(300,50));
		menuUpdatebtn.setPreferredSize(new Dimension(300,50));
		menuDeletebtn.setPreferredSize(new Dimension(300,50));
		
		//부품 추가하기(화면에 추가(표시))
		add(menuInsertbtn);
		add(menuAllprintbtn);
		add(menuViewbtn);
		add(menuUpdatebtn);
		add(menuDeletebtn);
		
		//insert기능에 부품을 만들고 add
		insertNamelb = new Label("이름 :");
		insertHplb = new Label("전화번호 :");
		insertEmaillb = new Label("이메일 :");
		
		insertNametf = new TextField();
		insertHptf = new TextField();
		insertEmailtf = new TextField();
		
		insertInsertbtn = new Button("전화번호부 추가 입력");
		
		insertNamelb.setVisible(false);
		insertHplb.setVisible(false);
		insertEmaillb.setVisible(false);
		insertNametf.setVisible(false);
		insertHptf.setVisible(false);
		insertEmailtf.setVisible(false);
		insertInsertbtn.setVisible(false);
		
		add(insertNamelb);
		add(insertNametf);
		add(insertHplb);
		add(insertHptf);
		add(insertEmaillb);
		add(insertEmailtf);
		add(insertInsertbtn);
		
		insertNamelb.setAlignment(Label.RIGHT);
		// 이름 레이블 크기 변경
		insertNamelb.setPreferredSize(new Dimension(100,50));
		// 이름 입력 상자 크기 변경
		insertNametf.setColumns(30);
		
		// 전화번호, 이메일 크기 변경
		insertHplb.setPreferredSize(new Dimension(100,50));
		insertHptf.setColumns(30);
		insertEmaillb.setPreferredSize(new Dimension(100,50));
		insertEmailtf.setColumns(30);
		
		insertInsertbtn.setPreferredSize(new Dimension(300, 50));
		

		
		
		// 추가한 부품을 처리하기 위한 버튼 이밴트 추가
		menuInsertbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				
				insertNamelb.setVisible(true);
				insertHplb.setVisible(true);
				insertEmaillb.setVisible(true);
				insertNametf.setVisible(true);
				insertHptf.setVisible(true);
				insertEmailtf.setVisible(true);
				insertInsertbtn.setVisible(true);

				// 화면을 새로 그리기 위해서는 2개의 함수가 동시 호출
				revalidate();
				repaint();  // 화면을 재 시작
				
				//insertbtn을 눌렀을 때 이벤트 처리
				insertInsertbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(insertNametf.getText());
						System.out.println(insertHptf.getText());
						System.out.println(insertEmailtf.getText());
						
						pm.insert(insertNametf.getText(),
								insertHptf.getText(),
								insertEmailtf.getText());
						
						System.out.println(pm.getList());
						
						insertNametf.setText("");
						insertHptf.setText("");
						insertEmailtf.setText("");
						
						insertNametf.setFocusable(true);
					}
				});
			}
		});
		
		// 전체 출력 기능을 메인 메뉴에 만들고 add
		// 전체 출력 부품 생성 및 설정
		listBox = new List(10);
		
		// 리스트 박스 크기 변경
		listBox.setPreferredSize(new Dimension(500,0));
		Panel panel = new Panel();
		panel.setLayout(new BorderLayout());
		panel.setSize(500,0);
		panel.add(listBox);
		add(panel);
		// 그러나 변경되지 않는다
		// 방법을 찾아봐야 함
		
		//add(listBox);
		listBox.setVisible(false);
		
		//전체 리스트 보기
		menuAllprintbtn.addActionListener
		(new ButtonFuc(this,pm.getList()));
		
		// 전체 리스트 안에서 레이블 설정
		viewIdlb=new Label("아이디"); viewIdlb.setBackground(Color.ORANGE);
		viewNamelb=new Label("이름"); viewNamelb.setBackground(Color.green);
		viewHplb=new Label("전화번호"); viewHplb.setBackground(Color.YELLOW);
		viewEmaillb=new Label("이메일"); viewEmaillb.setBackground(Color.LIGHT_GRAY);

		
		//레이블 크기 정하기
		viewIdlb.setPreferredSize(new Dimension(200,30));
		viewNamelb.setPreferredSize(new Dimension(200,30));
		viewHplb.setPreferredSize(new Dimension(200,30));
		viewEmaillb.setPreferredSize(new Dimension(200,30));
		
		add(viewIdlb);
		add(viewNamelb);
		add(viewHplb);
		add(viewEmaillb);
		
		viewIdlb.setVisible(false);
		viewNamelb.setVisible(false);
		viewHplb.setVisible(false);
		viewEmaillb.setVisible(false);
		
		//전체 리스트에서 하나의 아이템을 선택했을 때 상세보기
		// 1) 리스트를 클릭할 때
		// 2) 리스트의 정보를 가지고 온 후 분리
		// 3)분리된 데이터를 레이블에 표시(레이블을 생성/설정/추가
		listBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				setVisible();
				
				listBox.setVisible(true);
				viewIdlb.setVisible(true);
				viewNamelb.setVisible(true);
				viewHplb.setVisible(true);
				viewEmaillb.setVisible(true);
				
				// 아래의 데이터는 프레임에서 LIstBox 내용이므로 Email 확인 불가
				// String[] datas = listBox.getSelectedItem().split(" ");
				/*
				String data=listBox.getItem((int) e.getItem());
				String[] datas = data.split(" ");
				System.out.println(datas);*/
				
				// listBox에서 id를 구하고
				// 전체 리스트 정보에서 id와 비교하여 같은 아이디를 출력하시오
				//Phonebook p=pm.getList().get((int) e.getItem());
				
				String[] datas = listBox.getSelectedItem().split(" ");
				//System.out.println(datas[0]);
				
				int index = listBox.getSelectedIndex();
				//System.out.println(index);
				
//				String item = listBox.getSelectedItem();
//				int selectedId = Integer.parseInt(item.split(" ")[0]);
				
				int id = Integer.parseInt(listBox.getSelectedItem().split(" ")[0]);

				for (Phonebook p : pm.getList()) {
				    if (p.getId() == id && listBox.getSelectedIndex()!=0) {
			
				
				    		viewIdlb.setText("아이디 : " + p.getId());
				    		viewNamelb.setText("이름 : " + p.getName());
				    		viewHplb.setText("전화변허 : " + p.getHp());
				    		viewEmaillb.setText("이메일 : " + p.getEmail());
				
				
				    		revalidate();
				    		repaint();
				    }
				}
			}
		});
		
		// 찾기 부품 설정
		updateNamelb = new Label("찾을 이름은 : ");
		updateNametf = new TextField();
		updatebtn = new Button("찾기");
				
		updateNamelb.setVisible(false);
		updateNametf.setVisible(false);
		updatebtn.setVisible(false);
		
		updateSearchListBox = new List();
		updateSearchListBox.setVisible(false);
		
		searchIdlb = new Label("아이디 : ");
		searchNamelb = new Label("이름 : ");
		searchHplb = new Label("전화번호 : ");
		searchEmaillb = new Label("이메일 : ");
		
		//레이블 크기 정하기
		searchIdlb.setPreferredSize(new Dimension(100,30));
		searchNamelb.setPreferredSize(new Dimension(100,30));
		searchHplb.setPreferredSize(new Dimension(100,30));
		searchEmaillb.setPreferredSize(new Dimension(100,30));
		
		searchIdlb.setVisible(false);
		searchNamelb.setVisible(false);
		searchHplb.setVisible(false);
		searchEmaillb.setVisible(false);
		
				
		add(updateNamelb);
		add(updateNametf);
		add(updatebtn);
		
		add(updateSearchListBox);
		
		add(searchIdlb);
		add(searchNamelb);
		add(searchHplb);
		add(searchEmaillb);
				
//		updateNamelb.setAlignment(Label.RIGHT);  // 오른쪽 정렬
//		updateNamelb.setSize(new Dimension(200,0));  // 레이블상자 크기
		updateNametf.setColumns(30);// 입력상자 크기
		
		// 전화번호부 찾기 버튼 클릭했을 때 이벤트 등록
		menuViewbtn.addActionListener(new ActionListener() {
			// 동작에 대한 리스너를 menuViewbtn에 추가한다
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				
				updateNamelb.setVisible(true);
				updateNametf.setVisible(true);
				updatebtn.setVisible(true);
				
				updateNametf.setText("");
				
				revalidate(); repaint();
				
			}
		});
		
		// 찾기 버튼 실행
		updatebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				
				updateNamelb.setVisible(true);
				updateNametf.setVisible(true);
				updatebtn.setVisible(true);
				
				updateSearchListBox.setVisible(true);
				
				updateSearchListBox.removeAll();
				
				String search = updateNametf.getText();
				Phonebook p=pm.selectByName(search);  // 어떤 한 명을 리턴해 줘야 한다
				
				if(p!=null) {
					updateSearchListBox.add(p.getId() + " " + p.getName());
				}
				revalidate(); repaint();
			}
		});
		
		// 검색한 리스트 박스를 클릭할 때
		updateSearchListBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 상세보기를 재활용
				updateNamelb.setVisible(true);
				updateNametf.setVisible(true);
				updatebtn.setVisible(true);
				
				updateSearchListBox.setVisible(true);
				
				viewIdlb.setVisible(true);
				viewNamelb.setVisible(true);
				viewHplb.setVisible(true);
				viewEmaillb.setVisible(true);
				
				int id = Integer.parseInt(updateSearchListBox.getSelectedItem().split(" ")[0]);
				
				for (Phonebook p : pm.getList()) {
				    if (p.getId() == id && listBox.getSelectedIndex()!=0) {
				    	viewIdlb.setText("아이디 : " + p.getId());
				    	viewNamelb.setText("이름 : " + p.getName());
				    	viewHplb.setText("전화변허 : " + p.getHp());
				    	viewEmaillb.setText("이메일 : " + p.getEmail());
				    }
				}
				revalidate();
	    		repaint();
				
			}
		});
		
		
		// 수정 부품 설정
		// 레이블 부품 생성
		UpdateIdlb = new Label("수정할 사람 ID");
		UpdateNamelb = new Label("수정할 이름");
		UpdateHplb = new Label("수정할 전화번호");
		UpdateEmaillb = new Label("수정할 이메일");
		
		// 텍스트 부품 생성
		UpdateIdtf = new Label();
		UpdateNametf = new TextField();
		UpdateHptf = new TextField();
		UpdateEmailtf = new TextField();
		
		// 버튼 부품 생성
		UpdateSbtn = new Button("수정할 사람");
		Updatebtn = new Button("수정");
		cancelbtn = new Button("취소");
		
		// 리스트 부품 생성
		UpdateSearchListBox = new List();
		
		// 보이는 여부
		UpdateSbtn.setVisible(false);
		UpdateSearchListBox.setVisible(false);
		
		UpdateIdlb.setVisible(false);
		UpdateNamelb.setVisible(false);
		UpdateHplb.setVisible(false);
		UpdateEmaillb.setVisible(false);
		
		UpdateIdtf.setVisible(false);
		UpdateNametf.setVisible(false);
		UpdateHptf.setVisible(false);
		UpdateEmailtf.setVisible(false);
		
		Updatebtn.setVisible(false);
		cancelbtn.setVisible(false);
		
		// 텍스트 상자 크기
		UpdateNametf.setColumns(30);
		UpdateHptf.setColumns(30);
		UpdateEmailtf.setColumns(30);
		
		// 버튼 크기
		UpdateSbtn.setSize(new Dimension(50,0));
		
		// 리스트 크기
		UpdateSearchListBox.setSize(new Dimension(100,0));
		
		// 프레임에 붙이기	
		add(UpdateSbtn);
		add(UpdateSearchListBox);
		
		add(UpdateIdlb);
		add(UpdateIdtf);
		
		add(UpdateNamelb);
		add(UpdateNametf);
		add(UpdateHplb);
		add(UpdateHptf);
		add(UpdateEmaillb);
		add(UpdateEmailtf);
		
		add(Updatebtn);
		add(cancelbtn);
		
		// 메뉴의 수정 버튼이 눌리면 수정할 이름 작성 창이 나오며
		menuUpdatebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 찾기의 이름 입력창
				// 찾기의 버튼
				setVisible();
				
				updateNamelb.setVisible(true);
				updateNametf.setVisible(true);
				UpdateSbtn.setVisible(true);
				
				updateNametf.setText("");
				
				revalidate(); repaint();
				
			}
		});
		// 이름을 입력하고 버튼을 누르면 해당 인물의 데이터가 리스트에 나오고
		// 찾기의 버튼 누르면
		UpdateSbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				
				updateNamelb.setVisible(true);
				updateNametf.setVisible(true);
				UpdateSbtn.setVisible(true);
				
				UpdateSearchListBox.setVisible(true);
				UpdateSearchListBox.removeAll();
				
				String search = updateNametf.getText();
				Phonebook p=pm.selectByName(search);  // 어떤 한 명을 리턴해 줘야 한다
				
				if(p!=null) {
					UpdateSearchListBox.add(p.getId() + " " + p.getName());
				}
				
				revalidate(); repaint();
				
			}
		});
		
		// 리스트 박스에서 원하는 것을 클릭하면
		UpdateSearchListBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				
				updateNamelb.setVisible(true);
				updateNametf.setVisible(true);
				UpdateSbtn.setVisible(true);
				
				UpdateSearchListBox.setVisible(true);
				
				// 거기에 수정할 텍스트 박스가 있으며 그것에는 이름, 전화번호, email만 입력되며
				UpdateIdlb.setVisible(true);
				UpdateNamelb.setVisible(true);
				UpdateHplb.setVisible(true);
				UpdateEmaillb.setVisible(true);
				
				UpdateIdtf.setVisible(true);
				UpdateNametf.setVisible(true);
				UpdateHptf.setVisible(true);
				UpdateEmailtf.setVisible(true);

				Updatebtn.setVisible(true);
				cancelbtn.setVisible(true);
				
				String[] datas = UpdateSearchListBox.getSelectedItem().split(" ");
				//int id = Integer.parseInt(listBox.getSelectedItem().split(" ")[0]);
				//String search = UpdateSearchListBox.getSelectedIndex();
				//Phonebook p=pm.getList().get((int) e.getID());
				
				System.out.println(datas[0]);
				UpdateIdtf.setText(datas[0]);
				
				
				revalidate(); repaint();
			}
		});
		
		
		// 수정완료 버튼을 누르면 전체 리스트가 출력된다
		Updatebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				listBox.setVisible(true);
				
				String[] datas = UpdateSearchListBox.getSelectedItem().split(" ");
				
				/*System.out.println(datas[0]);
				System.out.println(datas[1]);
				System.out.println(datas[2]);
				System.out.println(datas[3]);*/
				
				System.out.println(UpdateIdtf.getText());
				System.out.println(UpdateNametf.getText());
				System.out.println(UpdateHptf.getText());
				System.out.println(UpdateEmailtf.getText());
				
				
				System.out.println(datas);
				Phonebook p= pm.getPhonebookByName(datas[1]);
				
				if(!UpdateNametf.getText().equals("")) { 
					p.setName(UpdateNametf.getText());
				}
				if(!UpdateHptf.getText().equals("")) { 
					p.setHp(UpdateHptf.getText());
				}
				if(!UpdateEmailtf.getText().equals("")) { 
					p.setEmail(UpdateEmailtf.getText());
				}
				
				System.out.println(p);
				System.out.println(p.getName());
				System.out.println(p.getHp());
				System.out.println(p.getEmail());
				System.out.println(datas[1]);
				pm.update(datas[1], p);
				
				pm.select(); 
				
				String header=new String("아이디 이름 전화번호 이메일                        ");
				listBox.add(header);
				
				// 전체 리스트가 출력되게 반복을 해야한다 얼마만큼인가 -  pm에 있는 정보를 가져와서 리스트에 넣어준다.
				for(Phonebook pp:pm.getList()) {
					listBox.add(pp.getId()+ " "+ pp.getName() + " " + pp.getHp() +" "+pp.getEmail());
					
				}
				
				updateNametf.setText("");
				
				revalidate(); repaint();
			}
		});
		
		// 취소 버튼을 누르면 메뉴로 이동한다.
		cancelbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				
			}
		});
		
		
		
		
		
		
		// 삭제 부품 설정
		deletelb = new Label("삭제할 사람 이름 : ");
		deletetf = new TextField();
		deletebtn = new Button("삭제");
		
		// 텍스트 상자 크기
		deletetf.setColumns(30);
		
		// 버튼 크기
		deletebtn.setSize(new Dimension(50,0));
		
		add(deletelb);
		add(deletetf);
		add(deletebtn);
		
		deletelb.setVisible(false);
		deletetf.setVisible(false);
		deletebtn.setVisible(false);
		
		// 메뉴 삭제 버튼을 누르면 삭제할 이름을 쓰라고 텍스트박스가 나오며
		menuDeletebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				
				deletelb.setVisible(true);
				deletetf.setVisible(true);
				deletebtn.setVisible(true);
				
				revalidate(); repaint();
			}
		});
		// 텍스트 박스에 이름을 넣고 삭제 버튼을 누르면 전체 리스트에 해당 이름의 값들이 사라진다.
		deletebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				
				deletelb.setVisible(true);
				deletetf.setVisible(true);
				deletebtn.setVisible(true);
				
				listBox.setVisible(true);
				
				listBox.removeAll(); 
				
				System.out.println(deletetf.getText());
				pm.delete(deletetf.getText());
				
				String header=new String("아이디 이름 전화번호                         ");
				listBox.add(header);
				
				// 전체 리스트가 출력되게 반복을 해야한다 얼마만큼인가 -  pm에 있는 정보를 가져와서 리스트에 넣어준다.
				for(Phonebook pp:pm.getList()) {
					listBox.add(pp.getId()+ " "+ pp.getName() + " " + pp.getHp());
					
				}
				
				revalidate(); repaint();
			}
		});
		
	}

	public java.awt.List getListBox() {
		return listBox;
	}

	public void setListBox(java.awt.List listBox) {
		this.listBox = listBox;
	}
	
	
	
	
	public void setVisible() {
		// 입력
		insertNamelb.setVisible(false);
		insertHplb.setVisible(false);
		insertEmaillb.setVisible(false);
		insertNametf.setVisible(false);
		insertHptf.setVisible(false);
		insertEmailtf.setVisible(false);
		insertInsertbtn.setVisible(false);
		
		// 전체 출력
		listBox.setVisible(false);
		
		// 찾기
		viewIdlb.setVisible(false);
		viewNamelb.setVisible(false);
		viewHplb.setVisible(false);
		viewEmaillb.setVisible(false);
		
		updateNamelb.setVisible(false);
		updateNametf.setVisible(false);
		updatebtn.setVisible(false);
		
		updateSearchListBox.setVisible(false);
		
		searchIdlb.setVisible(false);
		searchNamelb.setVisible(false);
		searchHplb.setVisible(false);
		searchEmaillb.setVisible(false);
		
		// 수정
		UpdateSbtn.setVisible(false);
		UpdateSearchListBox.setVisible(false);
		
		UpdateIdlb.setVisible(false);
		UpdateNamelb.setVisible(false);
		UpdateHplb.setVisible(false);
		UpdateEmaillb.setVisible(false);
		
		UpdateIdtf.setVisible(false);
		UpdateNametf.setVisible(false);
		UpdateHptf.setVisible(false);
		UpdateEmailtf.setVisible(false);
		

		Updatebtn.setVisible(false);
		cancelbtn.setVisible(false);
		
		
		// 삭제
		deletelb.setVisible(false);
		deletetf.setVisible(false);
		deletebtn.setVisible(false);
	}
	
}
