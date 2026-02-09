package d260209_03;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MouseServer extends JPanel{

	public static void main(String[] args) {
		List<Socket> socketlist=new ArrayList<Socket>();
		
		System.out.println("####서버프로그램 시작####");
		
		try(ServerSocket server=new ServerSocket(1234)){
			System.out.println("접속대기중");
			Socket socket=server.accept();
			while(true) {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Point p =(Point)ois.readObject();
			System.out.println("x:"+p.x+", y"+p.y);
			// x, y 좌표를 이용해서 프레임 (800, 600)을 만들고 클라이언트에서 움직이는 방향으로 선을 그으시오
			
			Frame f = new Frame();
			f.setTitle("서버 프레임");
			f.setLayout(new FlowLayout());
			f.setBounds(0, 0, 800, 600);
			f.setVisible(true);
			
			
			}
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}
}
