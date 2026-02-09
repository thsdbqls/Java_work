package d260205;

import java.io.InputStream;
import java.io.OutputStream;
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
public class ChatServer2 {

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
			
			// 반복을 하면서 챗팅을 주고 받음
			while(true) {
				// 서버가 메시지 보내기
				System.out.println("보낼 메시지 입력:");
				String msg = new Scanner(System.in).nextLine();  // 챗팅 띄워쓰기 가능하게 nextLine을 사용
				out.write(msg.getBytes());
				out.flush();
				Thread.sleep(100);
				
				
				// 수신된 메시지 확인하기
				System.out.println("수신 메시지:");
				
				while(true) {
					// 데이터를 읽기 위해 무한 반복을 사용하게 될 경우
					// 반복문 안에 반드시 if를 이용하여 반복문을 빠져나가기 위한 코드를 작성해야 한다.
					byte[] byterecv = new byte[256];
					int i=0;
					
					// 1byte씩 메시지를 누적 처리를 한다.
					while(in.available()>0) {
						// 들어오는 값이 0보가 클때까지 수신을 하고
						byterecv[i++]=(byte)in.read();
					}
					// 누적 처리가 다 되면 
					// byterecv(리시브)된 바이트의 수신 여부 확인 방법(i를 확인하면 데이터가 들어 있는지 확인할 수 있다)
					if(i>0) {
						// 수신된 데이터를 출력을 하고 반복문을 빠져나감
						System.out.println(new String(byterecv,0,i));  // trim만큼 출력되게 하여 양쪽 공란을 없앤다.
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("서버 미생성");
			System.exit(0);
		}

	}

}
