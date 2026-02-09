package d260209.client;

import java.awt.TextArea;
import java.awt.TextField;
import java.io.BufferedReader;

public class Recv extends Thread{
	
	BufferedReader br;
	TextArea ta;
	
	public Recv(BufferedReader br, TextArea ta) {
		this.br=br;
		this.ta=ta;
	}

	@Override
	public void run() {
		while(true) {
			try {
			String recvmsg=br.readLine();
			System.out.println("수신메시지:"+recvmsg);
			ta.setText(ta.getText()+recvmsg+"\r\n");
			ta.setCaretPosition(ta.getText().length());
			sleep(100);
			}catch (Exception e) { }
		}
	}
}