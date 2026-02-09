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

// 챗팅(1:1) - 무전기 형식
// 서버와 클라이언트 간의 동작할 순서를 전해야 한다
// 클라이언트가 서버에 접속을 하고 서버가 먼저 말을 걸지 아니면 클라이언트가 먼저 말을 걸지 정해야 한다.
// 클라이언트 접속 - (서버가 클라이언트에게 메시지 -> 클라이언트가 서버에게 메시지) 반복

// 문제점)
// 1) 만약 10자의 데이터를 보냈음에도 버퍼의 전체 크기만큼 데이터를 수신받아야 하는 문제
// 2) in.read()로 처리할 경우 바이트로 변경해야 하는 문제가 있음
// 3) 한자리씩 처리해야 하기때문에 while문을 사용하여 코드가 무거워지는 문제가 있음
public class ChatServer3 {

	public static void main(String[] args) {
		System.out.println("#####서버 프로그램 시작#####");
		// 서버 소캣 만들기
		try(ServerSocket server = new ServerSocket(1234)) {
			// 소캣 만들기
			Socket socket = server.accept();
			System.out.println(socket.getRemoteSocketAddress()+"접속");
			System.out.println("챗팅 시작");
			
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			
			// 반복을 하면서 챗팅을 주고 받음
			while(true) {
				// 서버가 메시지 보내기
				System.out.println("보낼 메시지 입력:");
				String msg = new Scanner(System.in).nextLine();  // 챗팅 띄워쓰기 가능하게 nextLine을 사용
				bw.write(msg+"\r\n");
				bw.flush();
				Thread.sleep(100);
				
				
				// 수신된 메시지 확인하기
				String recvmsg = br.readLine();   // 들어올때 까지 기다리낟
				System.out.println("수신 메시지:"+recvmsg);
				
			}
		} catch (Exception e) {
			System.out.println("서버 미생성");
			System.exit(0);
		}

	}

}
