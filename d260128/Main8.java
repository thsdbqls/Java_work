package d260128;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main8 {

	public static void main(String[] args) {
		DialogFrame f = new DialogFrame();
		
		// 윈도우 닫기 버튼은 윈도우에 포함된 객체이다
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 버튼은 프레임 안에 존재하는 객체이다
		f.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.getDialog().setVisible(true);
			}
		});
		
		//다이얼로그 윈도우 닫기 처리
		f.getDialog().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//dialog.dispose();
				f.getDialog().setVisible(false);
			}
			});
	}

}

class DialogFrame extends Frame{
	
	private Button button;
	private TextField text;
	private Dialog dialog;
	
	public DialogFrame() {
		setBounds(0,0,300,300);
		setTitle("");
		setLayout(new FlowLayout());
		setVisible(true);
		
		button = new Button("다이얼로그 실행");
		add(button);
		
		text = new TextField(30);
		add(text);
		
		// 다이얼로그 상자를 띄워주면 됨
		// 3번째 입력값 모달여부가 true: 모달이며 부모프레임이 사용이 안
		dialog = new Dialog(this, "새로운 다이얼로그",true);
		dialog.setBounds(100, 100, 300, 300);
		dialog.setVisible(false);
	}

	public Button getButton() {
		return button;
	}

	public TextField getText() {
		return text;
	}

	public Dialog getDialog() {
		return dialog;
	}
	
	
}