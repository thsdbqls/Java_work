package d260209.client;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicReference;

public class Frame4 {
	
	static AtomicReference<Socket> socketRef = new AtomicReference<>();
	
	public static void main(String[] args) {
		Frame f=new Frame();
		f.setTitle("Chating");
		f.setBounds(0,0,600,300);
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		TextArea ta=new TextArea(10,20);
		String msg="kim:hello\r\nhong:hello\r\nkim:hello2\r\nhong:hello2\r\n";
		ta.setText(msg);
		ta.setEditable(false);
		f.add(ta);
		f.add(new Label("메시지입력:"));
		TextField tmsg=new TextField(20);
		f.add(tmsg);
		f.add(new Button("전송"));
		f.revalidate(); f.repaint();
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Socket socket=null;
		try{
			socket=new Socket("172.16.15.66", 1234);
			socketRef.set(socket); 
			System.out.println("서버에 접속했습니다.");
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//수신하는 쓰레드는 무한 반복(br은 수신하기 위해 inputstream이 필요, 
			//수신된 데이터를 textarea(ta)에 표시
			(new Recv(br,ta)).start();		
		}catch (Exception e) {
			System.out.println("서버와 접속이 되지 않습니다.");
			System.exit(0);
		}
		
		//송신은 키보드를 문자열을 입력하고 enter키를 누를 때 송신하는 쓰레드를 실행
		tmsg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==e.VK_ENTER) {
					System.out.println("텍스트 박스에서 엔터키를 눌렀습니다.");
					String sendmsg=tmsg.getText();
					//메시지값을 소켓으로 send 시키고
					BufferedWriter bw = null;
					try {
						bw = new BufferedWriter(new OutputStreamWriter(socketRef.get().getOutputStream()));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					//전달된 메시지(sendmsg)를 bw를 이용하여 보내고, tmsg를 "" 깨끗하게 처리한다. 
					new Send(bw,sendmsg,tmsg).start();
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					tmsg.setText("");
					
				}
			}
		});

	}

		
}