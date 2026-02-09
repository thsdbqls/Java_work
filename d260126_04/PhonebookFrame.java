package d260126_04;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PhonebookFrame extends Frame{
	PhonebookManager pm = new PhonebookManager();
	
	public PhonebookFrame() {
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
		
		// 부품 만들기
		Button insertbtn = new Button("전화번호부 입력");
		Button allprintbtn = new Button("전화번호부 출력");
		Button viewbtn = new Button("전화번호부 찾기");
		Button updatebtn = new Button("전화번호부 수정");
		Button deletebtn = new Button("전화번호부 삭제");
		
		// 버튼 크기 변경
		insertbtn.setPreferredSize(new Dimension(300,50));
		allprintbtn.setPreferredSize(new Dimension(300,50));
		viewbtn.setPreferredSize(new Dimension(300,50));
		updatebtn.setPreferredSize(new Dimension(300,50));
		deletebtn.setPreferredSize(new Dimension(300,50));
		
		//부품 추가하기(화면에 추가(표시))
		add(insertbtn);
		add(allprintbtn);
		add(viewbtn);
		add(updatebtn);
		add(deletebtn);
		
		// 추가한 부품을 처리하기 위한 버튼 이밴트 추가
		insertbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Label namelb = new Label("이름 :");
				Label hplb = new Label("전화번호 :");
				Label emaillb = new Label("이메일 :");
				
				TextField nametf = new TextField();
				TextField hptf = new TextField();
				TextField emailtf = new TextField();
				
				Button insertbtn = new Button("전화번호부 추가 입력");
				add(namelb);
				add(nametf);
				add(hplb);
				add(hptf);
				add(emaillb);
				add(emailtf);
				add(insertbtn);
				
				namelb.setAlignment(Label.RIGHT);
				// 이름 레이블 크기 변경
				namelb.setPreferredSize(new Dimension(100,50));
				// 이름 입력 상자 크기 변경
				nametf.setColumns(30);
				
				// 전화번호, 이메일 크기 변경
				hplb.setPreferredSize(new Dimension(100,50));
				hptf.setColumns(30);
				emaillb.setPreferredSize(new Dimension(100,50));
				emailtf.setColumns(30);
				
				insertbtn.setPreferredSize(new Dimension(300, 50));
				
				// 화면을 새로 그리기 위해서는 2개의 함수가 동시 호출
				revalidate();
				repaint();  // 화면을 재 시작
				
				//insertbtn을 눌렀을 때 이벤트 처리
				insertbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(nametf.getText());
						System.out.println(hptf.getText());
						System.out.println(emailtf.getText());
						
						pm.insert(nametf.getText(),
								hptf.getText(),
								emailtf.getText());
						
						System.out.println(pm.getList());
						
						nametf.setText("");
						hptf.setText("");
						emailtf.setText("");
						
						nametf.setFocusable(true);
					}
				});
			}
		});
	}
}
