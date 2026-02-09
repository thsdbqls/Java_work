package d260128;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame2Listener implements WindowListener, ActionListener{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("버튼을 클릭!!);
		/*System.out.println(e.getActionCommand());
		System.out.println(e.getID());
		System.out.println(e.getSource());
		System.out.println(e.get);*/
		Object src = e.getSource();
		Button b = (Button) src;   //좌표 정보를 얻을 수 있다
		System.out.println(b.getX());
		
		switch (e.getActionCommand()){
		case "입력 메뉴": System.out.println("입력 메뉴 실행!!"); break;
		case "출력 메뉴": System.out.println("출력 메뉴 실행!!");break;
		case "찾기 출력": System.out.println("찾기출력 메뉴 실행!!");break;
		case "수정 메뉴": System.out.println("수정 메뉴 실행!!");break;
		case "삭제 메뉴": System.out.println("삭제 메뉴 실행!!");break;
		case "입력": System.out.println("입력 실행!!");
		
		default: break;
		}
		
	}

}
