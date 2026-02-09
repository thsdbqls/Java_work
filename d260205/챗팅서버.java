package d260205;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class 챗팅서버 {

	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket()){

		Socket socket = server.accept();
		
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		
		// 반복해야 챗팅이 되니까 반복문
		while(true) {
			// 서버 먼저 입력
			System.out.println("보낼 메시지:");
			String msg = new Scanner(System.in).nextLine();
			out.write(msg.getBytes());
			out.flush();
			Thread.sleep(100);
			
			//송신 받기
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
