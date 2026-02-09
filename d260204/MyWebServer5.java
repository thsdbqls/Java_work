package d260204;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// socket을 이용하여 접속한 컴퓨터의 정보(ip)를 확인한다
// path 및 query 확인
// http://localhost:8888/view?page=5
//http://localhost:8888/insert
//http://localhost:8888/update or delete

public class MyWebServer5 {

	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(8888)) {
			System.out.println("서버프로그램 실행중....");
			
			while(true) {
			Socket socket = server.accept();
			System.out.println("접속한 IP:" + socket.getRemoteSocketAddress());
			
			// 버퍼더리더를 이용하여 인풋스트림 리더를 이용하여 소켓의 getInputStream()을 가져올 수 있다
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String line = null;
			try {
				while((line=br.readLine())!=null) {
					
					// 필요로 하는 정보를 추출해야 한다(path, query)
					if(line.startsWith("GET")) {
						String url = line.split(" ")[1];
						System.out.println(url);
						
						// ?를 기준으로 왼쪽에 있는 분리된 값
						String path = url.split("?")[0];
						System.out.println(path);
						
						// ?를 기준으로 오른쪽에 분리된 데이터
						String query = url.split("?")[1];
						System.out.println(query);
					}
					
					// 읽은 후 줄이 비어 있을 경우 반복문을 나가라
					// 꼭 사용해야 하는 코드 이다
					if(line.isEmpty()) {
						break;
					}
					System.out.println(line);
				}
			} catch (Exception e) {
				System.out.println("읽다가 오류!!");
			}
			
			
			//response는 outputstream을 통해 정보를 전달
			String body="접속성공";
			String header =""
					+ "HTTP/1.1 200 OK\r\n"
					+ "Content-Type: text/html;charset=UTF-8\r\n"
					// 길이는 반드시 표시해 줘야 한다.
					+ "Content-Length: "+ body.getBytes().length + "\r\n"  // 길이는 byte형태로 바꾼다음에 구하는것이 좋다
					+ "connection: close\r\n"
					+ "\r\n";
			
			socket.getOutputStream().write(header.getBytes());
			socket.getOutputStream().write(body.getBytes());
			
			socket.close();
			
			}
			}
			catch (Exception e) {
			// TODO: handle exception
		}

	}

}
