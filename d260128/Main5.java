package d260128;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main5 {
	// Frame window에서 키보드를 눌르면 콘솔에 해당 값을 확인하는 코드
	
	public static void main(String[] args) {
		
		MouseFrame f = new MouseFrame();
		
		//각각의 리스너는 별도로 등록해야함
		f.addWindowListener(f);
		f.addMouseListener(f);
		f.addMouseMotionListener(f);
		f.addMouseWheelListener(f);
	}

}


class MouseFrame extends Frame
implements WindowListener,MouseListener,MouseMotionListener,MouseWheelListener{
	private int sx =0;
	private int sy = 0;
	private int ex = 0;
	private int ey = 0;
	
	public MouseFrame() {
		setBounds(0,0,1000,1000);
		setVisible(true);
		
		
		revalidate(); repaint();
	}
	
	@Override
	public void paint(Graphics g){
		g.drawLine(sx,sy,ex,ey);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println("Click => x:"+e.getX()+", y:"+e.getY());  // 마우스의 좌표 X,Y
		sx=ex;
		sy=ey;
		ex=e.getX();
		ey=e.getY();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click => x:"+e.getX()+", y:"+e.getY());  // 마우스의 좌표 X,Y
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("Click => x:"+e.getX()+", y:"+e.getY()); 
		//repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}