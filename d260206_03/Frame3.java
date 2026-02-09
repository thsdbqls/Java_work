package d260206_03;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import d260206_03.Recv;
import d260206_03.Send;

public class Frame3 {


	public static void main(String[] args) {
		Frame f = new Frame();
		f.setTitle("Chating");
		f.setBounds(0,0,600,300);
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		
		TextArea ta = new TextArea(10,20);
		String msg = "챗팅 프로그림\r\n";
		ta.setText(msg);
		
		// 수정을 할 수 없게 하기
		ta.setEditable(false);
		
		f.add(ta);
		f.add(new Label("메시지 입력"));
		
		Button btn = new Button("전송");
		TextField tf = new TextField(20);
		f.add(tf);
		f.add(btn);
		
		f.revalidate(); f.repaint();
		
		// 챗팅 프로그램에서 메시지창에 값을 입력하고 enter키를 누르면 전송되는 코드도 같이 구현(key event 사용)
		
		// 리스너 등록
		// 리스너를 등록할 때 무엇에 대한 리스너 등록인지 모르고 있다.
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 메시지 보내기 전에 소켓을 연결하는 작업을 생성자에 처리
		
		System.out.println("####클라이언트 프로그램####");
		try(Socket socket=new Socket("172.16.15.67", 1234)){
			System.out.println("서버에 접속했습니다.");

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));	
			//(new Send(bw,msg)).start();//송신쓰레드
			//(new Recv(br)).start();//수신쓰레드
			while(true) {Thread.sleep(100);}
		}catch (Exception e) {
			System.out.println("서버와 접속이 되지 않습니다.");
			System.exit(0);
		}


		
		// tf의 값이 엔터키일 때 메시지를 전송한다
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==e.VK_ENTER) { // 받은 키와 enter키가 같으면
					System.out.println("텍스트박스에서 enter 키를 받았습니다");
					
					// 메시지를 보내기 위해서는 tf의 값을 가져와서
					String sendmsg = tf.getText();
					(new Send(bw,sendmsg)).start();//송신쓰레드
					
					// 메시지의 값을 소켓으로 send 시키고
					new Thread(new Send(bw,sendmsg));
					
					// tf의 값을 빈 값으로 초기화하고
					tf.setText("");
					// 수신
					
					(new Recv(br)).start();//수신쓰레드
					
					// 수신된 값을 textArea에 입력을 한다. + 누적되야함 + 줄 바꿈
					ta.setText(ta.getText() + sendmsg + "\r\n");
					
					// 자동으로 스크롤을 내리를 방법
					ta.setCaretPosition(ta.getText().length());
				}
			}
		});
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sendmsg = tf.getText() +"\r\n";
				
				
			}
		
			});
			
			
	}
	
}

class jFrame() {
	
}
