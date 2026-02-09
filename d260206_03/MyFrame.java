package d260206_03;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;

// Main화면
public class MyFrame extends Frame{
	//프레임 구성 시 화면에 대한 부품을 맴버 변수로 나열을 해야 한다
	//Panel panel;
	
	Label idlb;
	Label namelb;
	
	TextField idtf;
	TextField nametf;
	
	Button btn;
	Button cancelbtn;
	
	EventProc event;
	
	public MyFrame() {
		// 설정(프레임의)
		setTitle("Chating");
		setBounds(0,0,200,400);
		setLayout(new FlowLayout());
		setVisible(true);
		
		// 부품생성(프레임에 들어갈 부품)
		idlb = new Label("아이디:");
		namelb = new Label("이믈:");
		
		idtf = new TextField(20);
		nametf = new TextField(20);
		
		btn = new Button("전송");
		cancelbtn = new Button("취소");
		
		// 프레임에 부품 넣기(배치)
		add(idlb);
		add(idtf);
		add(namelb);
		add(nametf);
		add(btn);
		add(cancelbtn);

		// 동작이 발생할 때 처리(리스너 등록 or 이벤트 처리)
		event = new EventProc();  // 이벤트 처리는 여기서 처리 하겠다.
		addWindowListener(event);  // Frame 버튼 처리 (어디서)
		btn.addActionListener(event);  // 버튼을 눌렀을 때 처리
		
		cancelbtn.addActionListener(event);
	}
}
