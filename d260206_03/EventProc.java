package d260206_03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 모든 이벤트 처리를 해당 객체에서 처리한다
public class EventProc extends WindowAdapter implements ActionListener {
	public EventProc() {
		// TODO Auto-generated constructor stub
	}
	
	//사용할 객체에 접근하기 위해 프레임자체를 this로 넘겨받음
	MyFrame2 frame;
	public EventProc(MyFrame2 frame) {
		this.frame=frame;
	}
	// 프레임의 x 버튼 처리
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	// 버튼에 대한 처리(버튼은 모두 여기서 처리가 된다)
	@Override
	public void actionPerformed(ActionEvent e) {
		//switch (e.getActionCommand()) {
		//case "전송" : System.out.println("전송버튼 클릭"); break;
		//case "취소" : System.out.println("취소버튼 클릭"); break;
		//case "HOME" : System.out.println("HOME버튼 클릭"); break;
		
		
		switch (e.getActionCommand()) {
		case "전송" : 
			// panelB 화면으로 전환
			frame.remove(frame.getPanelA());
			frame.add(frame.getPanelB());
			frame.revalidate(); frame.repaint();
			break;
			
		case "취소" : 
			System.out.println("취소버튼 클릭"); 
			break;
			
		case "HOME" : 
			// panelA 화면으로 전환
			frame.remove(frame.getPanelB());
			frame.add(frame.getPanelA());
			frame.revalidate(); frame.repaint();
			break;
	
		}
	}

	
}
