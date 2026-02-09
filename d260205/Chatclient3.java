package d260205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Chatclient3 {
	public static void main(String[] args) {
		System.out.println("#####클라이언트 프로그램#####");
		try (Socket socket = new Socket("172.16.15.66",1234)){
			System.out.println("서버에 접속 했습니다");
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			
			// 서버와 메시지를 교환
			while(true) {
				// 수신된 메시지를 기다린다
				// 여기서 반복문으로 계속 기다려야 한다
				String recvmsg = br.readLine();
				System.out.println("서버에서 수신한 메시지:"+recvmsg);

				
				// 서버에 메시지 보내기
				System.out.println("서버에 보낼 메시지 보내기 :");
				String msg = new Scanner(System.in).nextLine();
				bw.write(msg+"\r\n");
				bw.flush();
				Thread.sleep(100);
			}
		} catch (Exception e) {
			System.out.println("서버와 접속이 되지 않습니다");
			System.exit(0);
		}
	}
}
