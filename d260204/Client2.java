package d260204;

import java.io.InputStream;
import java.net.Socket;

public class Client2 {

	public static void main(String[] args) {
		try {
		System.out.println("클라이언트 프로그램 시작!");
		Socket socket=new Socket("172.16.15.97",5555);
		InputStream in=socket.getInputStream();
		String message="";
		byte[] bmessage=new byte[256];
		int i=0;
		while(true) {
		while(in.available()>0) {
			//message+=in.read(); //숫자가 누적된 형태
			//message+=(char)in.read(); //한글은 2바이트처리이므로 깨진 문자 나옴
			bmessage[i++]=(byte) in.read();
			if(in.available()==0) {
				//System.out.println(message);
				//바이트로 보내온 데이터를 바이트 배열로 받은 후 문자열로 변환을 해야 
				//한글이 깨지지 않음
				System.out.println(new String(bmessage).trim());
				//위의 코드의 문제점은 바이트배열의 최대 크기로 문자열되므로 trim을 해줘야함
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