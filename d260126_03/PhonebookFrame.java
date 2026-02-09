package d260126_03;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PhonebookFrame extends Frame implements WindowListener{

	public PhonebookFrame() {
		Frame f = new Frame();
		setBounds(0, 0, 500, 1000);  //x좌표, y좌표, weidth, height
		setVisible(true);
		setTitle("전화번호 부");
		setLayout(new FlowLayout());
		
		//setLayout(new GridLayout(5,1));  //5행 1열
		CardLayout mainlayout = new CardLayout();
		//setLayout(new CardLayout());
		Panel mainpanel = new Panel();
		add(mainpanel);
		mainpanel.setBackground((Color.BLACK));
		
		// 부품을 만든다
		// 전화번호부 입력 판넬 (부품을 만들고 상위 푸품에 추가)
		Panel insertpanel = new Panel();
		insertpanel.setLayout(new CardLayout());
		mainpanel.add(insertpanel,"insertPanel");
		insertpanel.setBackground((Color.yellow));
		
		// 전화번호부 출력 판넬
		Panel allPrintpanel = new Panel();
		allPrintpanel.setLayout(new CardLayout());
		mainpanel.add(allPrintpanel,"allPrintPanel");
		allPrintpanel.setBackground((Color.ORANGE));
		
		// 찾기, 수정, 삭제
		Panel viewPanel = new Panel();
		viewPanel.setLayout(new CardLayout());
		mainpanel.add(viewPanel,"viewPanel");
		viewPanel.setBackground((Color.BLUE));
		
		// mainPanel에 버튼 부품을 추가하기
		Button insertbtn = new Button("입력 버튼");
		mainpanel.add(insertbtn);
		insertbtn.addActionListener(new ActionListener() {  // 버튼에 대해서 동작을 인지한다.
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼이 눌러졌을 때 카드를 변경
				// System.out.println("입력버튼 클릭");
				mainlayout.show(mainpanel, "insertPanel");
			}
		});
		
		
		//setLayout(new GridLayout(5,1,10,5));   //간격추가
		/*
		for(int i=0; i<10; i++) {
			add(new Button("버튼"+i));
		}
		*/
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
