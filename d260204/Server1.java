package d260204;

import static org.junit.Assume.assumeNoException;

import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	public static void main(String[] args) {
		//서버소켓을 만들고 소켓으로 들어오는 것을 감지하면 accept함여 새로운 소켓이 생성된다.
		try {
		System.out.println("서버프로그램 시작!");
		ServerSocket server=new ServerSocket(5555);
		Socket socket=server.accept(); //대기상태
		System.out.println("클라이언트가 서버에 접속했습니다.!!");
		socket.getOutputStream()
		.write(new String("hello client!!").getBytes());
		socket.getOutputStream().flush();
		Thread.sleep(1000);
		socket.close();
		System.out.println("서버프로그램 종료!!");
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}