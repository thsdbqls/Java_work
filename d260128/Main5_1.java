package d260128;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main5_1 {

	public static void main(String[] args) {
		MouseFrame2 f = new MouseFrame2(); 
		
		f.addMouseMotionListener(f);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}

class MouseFrame2 extends Frame implements MouseMotionListener {
	private int prex=-1;
	private int prey=-1;
	private int x;
	private int y;

	
	public MouseFrame2() {
		setBounds(0,0,1000,1000);
		setVisible(true);


	}
	
	@Override
	public void paint(Graphics g){
		g.drawLine(prex,prey,x,y);
		prex = x;
		prey = y;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println(e.getX()+" "+e.getY());
		x=e.getX();
		y=e.getY();
		//repaint();
		
		Graphics g = getGraphics();
		g.drawLine(prex, prey, x, y);
		prex = x;
		prey = y;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}