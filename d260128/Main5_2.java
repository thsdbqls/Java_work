package d260128;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class Main5_2 {

	public static void main(String[] args) throws AWTException {
		Robot robot = new Robot();
		/*
		for(x=100; x<300; x++) {
			robot.mouseMove(x, 200);
			robot.delay(10);
		}
		*/
		robot.mouseMove(100, 230);
		//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		// 더블 클릭
		for(int i=0;i<2;i++) {
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(100);  // 클릭 사이 간격 (100ms 정도)
		}
	}
}

class MouseFrame3 extends Frame {
	private int prex=-1;
	private int prey=-1;
	private int x;
	private int y;

	
	public MouseFrame3() {
		setBounds(0,0,1000,1000);
		setVisible(true);
	}
	
}