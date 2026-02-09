package d260127;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListBoxMain2 {
	public static void main(String[] args) {
		
		// 기본사항 설정
		Frame f = new Frame();
		f.setBounds(0, 0, 300, 500);
		f.setTitle("lisetBox");
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {  // 닫기 버턴
				System.exit(0);    // 프로그램 종료
			}
		});
		
		// 레이아웃 설정
		//f.setLayout(new FlowLayout());
		f.setLayout(new BorderLayout());

		Label label = new Label("아이디 이름 비밀번호");
		label.setBackground(Color.LIGHT_GRAY);
		label.setAlignment(Label.LEFT);
		f.add(label,BorderLayout.NORTH);

		java.awt.List list = new List();

		//list.add(Lable);  // 리스트에 값이 들어가지 않는 상태(flowlayout이여서)
		list.add("1 홍길동 010-1111-1111");
		list.add("2 김길동 010-1111-2222");
		list.add("3 박길동 010-1111-3333");
		f.add(list,BorderLayout.CENTER);
		
		//상세보기 BorderLaout의 south에 구현
		Label idlb=new Label("아이디"); idlb.setBackground(Color.ORANGE);
		Label namelb=new Label("이름"); namelb.setBackground(Color.green);
		Label hplb=new Label("전화번호"); hplb.setBackground(Color.YELLOW);
		
		//레이블 크기 정하기
		idlb.setPreferredSize(new Dimension(200,30));
		namelb.setPreferredSize(new Dimension(200,30));
		hplb.setPreferredSize(new Dimension(200,30));
		
		Panel panel = new Panel();
		panel.setLayout(new FlowLayout());
		panel.add(idlb);
		panel.add(namelb);
		panel.add(hplb);
		f.add(panel,BorderLayout.SOUTH);
		//f.pack();
		//f.invalidate();
		//f.repaint();
		
		// BorderLayout에 아래와 같이 등록했을 때 마지막에 등록된 레이블만 표시된다
		/*
		 f.add(idlb,BorderLayout.south);
		 f.add(namelb,BorderLayout.south);
		 f.add(hplb,BorderLayout.south);
		 */
		
		// 아이템에 클릭을 했을 때 처리를 하기 위해서는 리스너 등록을 해야 한다.
		//list.addActionListener(new );   /리스너는 많다
		list.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//e(이벤트)에서 getItem은 인덱스 번호
				//list에서 getItem은 내용을 의미한다
				System.out.println(list.getSelectedIndex());
				
				System.out.println(list.getSelectedItem());
				System.out.println(list.getItem(list.getSelectedIndex()));
				System.out.println(list.getItem((int) e.getItem()));
				
				System.out.println(list.getSelectedItem().split(" ")[0]);
				System.out.println(list.getSelectedItem().split(" ")[1]);
				System.out.println(list.getSelectedItem().split(" ")[2]);
				
				// 분리한 것을 문자열 배열로 저장하여 각각의 레이블에 넣어준다
				String[] datas = list.getSelectedItem().split(" ");
				idlb.setText("아이디 : " + datas[0]);
				namelb.setText("이름 : " + datas[1]);
				hplb.setText("전화변허 : " + datas[2]);
			}
		});
		
	}
}
