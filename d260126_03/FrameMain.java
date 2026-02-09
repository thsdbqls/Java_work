package d260126_03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameMain {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(0, 0, 500, 200);  //x좌표, y좌표, weidth, height
		f.setVisible(true);
		f.setTitle("전화번호 부");
		
		BorderLayout boardlayout = new BorderLayout();
		f.setLayout(boardlayout);
		
		//부품에 대한 설정
		Button btn1 = new Button("전화번호부 입력");
		f.add(btn1,BorderLayout.EAST);
		Button btn2 = new Button("전화번호부 출력");
		f.add(btn1,BorderLayout.WEST);
		Button btn3 = new Button("전화번호부 찾기");
		f.add(btn1,BorderLayout.CENTER);
		Button btn4 = new Button("전화번호부 수정");
		f.add(btn1,BorderLayout.NORTH);
		Button btn5 = new Button("전화번호부 삭제");
		f.add(btn1,BorderLayout.SOUTH);
		
		
		// 프레임에서 어떤 기능을 추가할 때는 add가 붙은 함수를 호출한다.
		
		// window의 버튼이
		f.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
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
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("닫기 버튼을 눌리고 있네요.!!!");
				System.exit(0);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
