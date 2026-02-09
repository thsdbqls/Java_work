package d260128;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;

public class Main1 {

	public static void main(String[] args) {
		// awt에서 Frame 부품 정리
		// TextField, Lable, Button, List
		// TextArea : 여러 줄 텍스트 박스를 만든다
		// CheckboxGroup : 여러 개중 한 개를 선택하는 것
		// Checkbox :여러 개를 선택하는 것
		// Choice : 선택상자로 여러개 또는 한개를 선택할 수 있다
		// Scrollbar : 스크로바
		
		Frame f = new  Frame();
		f.setTitle("부품 만들기");
		f.setLayout(new FlowLayout());
		f.setBackground(Color.LIGHT_GRAY);
		f.setBounds(0, 0, 500, 700);
		f.setVisible(true);
		
		
		TextArea tbox = new TextArea(10, 30);  // TextArea(즐 수, 입력 자리 수)
		f.add(tbox);
		tbox.setText("초기값");  // 입력하는 것
		System.out.println(tbox.getText());  // 가져오는 것
		
		Checkbox cb1 = new Checkbox("사과");
		Checkbox cb2 = new Checkbox("딸기",true);  // 기본 선택
		f.add(cb2); f.add(cb1);
		System.out.println(cb1.getState());  // cb1의 상태를 확인 (선택이 안되어 있으니 false)
		System.out.println(cb2.getState());  // 
		System.out.println(cb2.getName()); // 체크박스의 이름이 출력
		System.out.println(cb2.getLabel()); // 체크박스 값이 출력
		
		CheckboxGroup gen = new CheckboxGroup();
		Checkbox male = new Checkbox("남자",  gen, true);
		Checkbox female = new Checkbox("여자",  gen, false);
		f.add(male);
		f.add(female);
		
		System.out.println(gen.getSelectedCheckbox());
		System.out.println(gen.getSelectedCheckbox().getLabel());
		
		//초이스는 다중 선택이 불가하다(사용하려면 list를 사용해야 한다)
		Choice choice = new Choice();
		choice.add("Java");
		choice.add("파이썬");
		choice.add("html");
		f.add(choice);
		
		System.out.println(choice.getSelectedIndex());
		System.out.println(choice.getSelectedItem());
		
		
		f.revalidate();
		f.repaint();
		

	}

}
