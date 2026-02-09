package d260128;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main6 {

	public static void main(String[] args) throws IOException, AWTException {
		Robot robot = new Robot();
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		System.err.println(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
		ImageIO.write(screenFullImage, "png", new File("screenshot.png"));
		System.out.println("화면 캡쳐 완료!! 'screenshot.png' 파일이 생성되었습니다");
		// Toolkit.getDefaultToolkit(); => 컴퓨터에 대한 정보를 획득할 수 있는 객체이다
	}

}
