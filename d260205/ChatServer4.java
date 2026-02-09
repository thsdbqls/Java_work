package d260205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 서버에서 notepad명령어를 내리면 클라이언트 pc에서 notepad가 열리게 처리
public class ChatServer4 {

	public static void main(String[] args) {
		System.out.println("#####서버 프로그램 시작#####");
		// 서버 소캣 만들기
		try(ServerSocket server = new ServerSocket(1234)) {
			// 소캣 만들기
			Socket socket = server.accept();
			System.out.println(socket.getRemoteSocketAddress()+"접속");
			System.out.println("서버 시작");
						
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			

			while(true) {
				System.out.println("명령 입력:");
				String msg = new Scanner(System.in).nextLine()+"\r\n";
				out.write(msg);
				out.flush();
				Thread.sleep(100);

			}
		} catch (Exception e) {
			System.out.println("서버 미생성");
			System.exit(0);
		}

	}

}
