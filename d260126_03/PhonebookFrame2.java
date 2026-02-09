package d260126_03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;

public class PhonebookFrame2 extends Frame implements WindowListener{

	public PhonebookFrame2() {
		// 프레임 - 부품
		// 프레임 - 판넬 -부품
		// 프레임(layout)-판넬(layout)-프레임에 판넬 add
		// 판넬(layout)-부품 / 판넬에 부품을 add
		
		
		Frame f = new Frame();
		setBounds(0, 0, 500, 200);  //x좌표, y좌표, weidth, height
		setVisible(true);
		setTitle("전화번호 부");
		
		setLayout(new GridLayout(2,1));  //frame의 레이아웃
		
		
		Panel panel1 = new Panel();
		panel1.setBackground(Color.blue);
		Panel panel2 = new Panel();
		panel2.setBackground(Color.yellow);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		//add(panel1);
		//panel1.add(new Button("버튼1"));
		//panel1.add(new Button("버튼2"));
		//panel1.add(new Button("버튼3"));
		add(panel1);
		add(panel2);
		//panel2.setVisible(false);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
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
