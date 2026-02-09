package d260204;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer2 {

	public static void main(String[] args) {
		/*
		Status Code 200 OK
		content-type text/html; charset=UTF-8
		 */
		
	
		String html = "HTTP/1.1 200 OK\r\n";
		// 이번에는 json을 사용하여 나타낼 것이다
		html+="Content-Type: application/json\r\n";
		html+="Connection:close\r\n";
		html+="\r\n";   // 
		html+="{\"result\":\"success\"}";
		html+="\r\n";
		html+="\r\n";//
		
		ServerSocket server = null;
		InputStream in= null;
		OutputStream out= null;
		
		System.out.println("웹서버프로그램!!");
		while(true) {
			try {
				// 서버 포트는 8888로
		server = new ServerSocket(8888);
		// 여기로 누가 들어오면 이클립스 모니터에 출력되게
		Socket socket = server.accept();
		System.out.println("접속!");
		
		//소켓에 대한 인풋 스트림과 아웃풋 스트림을 얻을 수 있다. 스트림 생성
		in=socket.getInputStream();  // 메모리로 들어오는 것
		out=socket.getOutputStream();  // 메모리에서 나가는 것
		
		// 아웃스트림에서 데이터를 보낸다(html을 byte형태로)
		out.write(html.getBytes());
		Thread.sleep(1000);   // 이것을 안 써주면 오류가 발생한다.
		socket.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}

}
