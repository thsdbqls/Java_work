package d260204;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;

public class Client3 {

	public static void main(String[] args) {
		/*
		try {
		System.out.println("클라이언트 프로그램 시작!");
		Socket socket=new Socket("172.16.15.97",5555);
		InputStream in=socket.getInputStream();
		
		while(true) {
			System.out.println("남아 있는 데이터갯수:"+in.available());
			System.out.println("전달받은 데이터:"+in.read());
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		*/
		Socket socket=null;
		InputStream in=null;
			System.out.println("클라이언트 프로그램 시작!");
			try {
			socket=new Socket("172.16.15.97",5555);
			in=socket.getInputStream();
			}catch (Exception e) {}
			
			while(true) {
				//System.out.println(socket.isClosed());
				//System.out.println(socket.isConnected());
				//System.out.println(socket.getKeepAlive());
				//결론:서버소켓이 닫혀도 위의 상태 변화로는 확인 불가
				
				try {
					System.out.println("남아 있는 데이터갯수:"+in.available());
				} catch (IOException e) {
					
				}
				try {
					System.out.println("전달받은 데이터:"+in.read());
				} catch (IOException e) {
					System.out.println(e.getMessage());
					if(e.getMessage().equals("Connection reset")) {
						System.out.println("클라이언트 프로그램 종료!");
						System.exit(0);
					}
				}
				
				
			}
			
			

	}

}