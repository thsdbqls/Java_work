package d260128;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main3 implements WindowListener {

	public static void main(String[] args) {
		MyFrame2 f= new MyFrame2();
		
		//window 리스너 추가
		//f.addWindowListener(this);
		
		// 리스너만 처리하는 클래스를 만들고 처리를 할 것이다
		MyFrame2Listener li = new MyFrame2Listener();
		f.addWindowListener(li);
		
		// 버튼에 대한 리스커를 처리(버튼에 대한 정보를 가져와야 한다) //Action은 버튼을 클릭했을 때를 의미한다
		f.getButton()[0].addActionListener(li);
		
		// 5개의 버튼에 넣어줘야 해서 반복문을 사용ㅇ
		for(Button button:f.getButton()) {
			button.addActionListener(li);
		}
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

class MyFrame2 extends Frame{
	private Button[] button;
	private String[] btnlb={"입력 메뉴","출력 메뉴","찾기 출력","수정 메뉴","삭제 메뉴","입력"};
	
	
// Private는 get, set함수로 가져오고 설정 가능하지만, 객체를 변화시킬 일이 없을 경우 get함수만 사용한다	
	public Button[] getButton() {return button;}

	public String[] getBtnlb() {return btnlb;}

	public MyFrame2() {
		setBounds(0,0,500,700);
		setVisible(true);
		setLayout(new FlowLayout());
		
		
		button = new Button[btnlb.length];
		
		for(int i=0; i<button.length; i++) {
			button[i] = new Button(btnlb[i]);
			add(button[i]);
		}
		
		revalidate(); repaint();
	}
}