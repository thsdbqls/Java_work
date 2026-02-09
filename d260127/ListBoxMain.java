package d260127;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListBoxMain {
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
		f.setLayout(new FlowLayout());
		// java List 만들기
		java.awt.List list = new List();
		//jlist
		// list에 값 넣기
		list.add("apple");
		list.add("banana");
		list.add("mango");
		// 레이아웃에 리스트 붙이기
		f.add(list);
		
		// 아이템에 클릭을 했을 때 처리를 하기 위해서는 리스너 등록을 해야 한다.
		//list.addActionListener(new );   /리스너는 많다
		list.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {  // ItemEvent e는 많은 것을 한는 것이다
				System.out.println(list.getSelectedIndex());  // 위치를 콘솔에 나타낸다
				System.out.println(e.getItem()); // 위에와 같게 나온다
				
				System.out.println(list.getSelectedItem());   // 값을 콘솔에 나타낸다
				
				System.out.println(list.getName());  // 객체의 이름이 나온다
				System.out.println(e.getSource());  // 상세정보가 나온다
				
			}
		});
		
	}
}
