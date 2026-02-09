package d260205;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Chatclient1 {
	public static void main(String[] args) {
		System.out.println("#####클라이언트 프로그램#####");
		try (Socket socket = new Socket("172.16.15.66",1234)){
			System.out.println("서버에 접속 했습니다");
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			// 서버와 메시지를 교환
			while(true) {
				// 수신된 메시지를 기다린다
				// 여기서 반복문으로 계속 기다려야 한다
				while(true) {
					// 들어오는 값이 0보다 커지는 순간이 오면
					if(in.available()>0) {
						// 데이터를 다 byte로 받아들이고
						// readAllByte는 수신에 문제가 있음(스트림이 close되어야 해당 함수가 실행이 된다)
						byte[] recvmsg = new byte[256];
						in.read(recvmsg);
						System.out.println("서버에서 수신한 메시지:");
						System.out.println(new String(recvmsg));
						break;
					}
				}
				
				// 서버에 메시지 보내기
				System.out.println("서버에 보낼 메시지 보내기 :");
				String msg = new Scanner(System.in).nextLine();
				out.write(msg.getBytes());
				out.flush();
				Thread.sleep(100);
			}
		} catch (Exception e) {
			System.out.println("서버와 접속이 되지 않습니다");
			System.exit(0);
		}
	}
}
