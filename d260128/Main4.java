package d260128;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main4 {
	// Frame window에서 키보드를 눌르면 콘솔에 해당 값을 확인하는 코드
	
	public static void main(String[] args) {
		
		KeyFrame f = new KeyFrame();
		
		//각각의 리스너는 별도로 등록해야함
		f.addWindowListener(f);
		f.addKeyListener(f);
	}

}


class KeyFrame extends Frame implements KeyListener, WindowListener{
	Label label;
	public KeyFrame() {
		setBounds(0,0,500,700);
		setVisible(true);
		
		label = new Label();
		label.setSize(new Dimension(50,0));
		label.setFont(new Font("Dialog", Font.PLAIN,24));
		add(label);
		
		revalidate(); repaint();
	}


	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		// ex) 엔터키를 쳤을 때 화면을 지우세요
		System.out.println(e.getKeyChar()+ " "+e.getKeyCode());
		
		label.setText(label.getText()+e.getKeyCode());  // 기존에 가지고 있는것 추가로 누적되게하는 것이다
		
		// ex) 엔터키를 쳤을 때 화면을 지우세요
		if(e.getKeyCode()==10) {
			label.setText("");
		}
		revalidate(); repaint();
	}


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
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}