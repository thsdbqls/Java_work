package d260204;

import java.io.InputStream;
import java.net.Socket;

public class Client1 {

	public static void main(String[] args) {
		try {
		System.out.println("클라이언트 프로그램 시작!");
		Socket socket=new Socket("172.16.15.97",5555);
		InputStream in=socket.getInputStream();
		String message="";
		while(true) {
		while(in.available()>0) {
			int c=in.read();
			System.out.print((char)c);
			if(in.available()==0) {
				System.out.println();
				System.out.println("클라이언트 프로그램 종료!");
				System.exit(-1);
			}
			
		}			
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}