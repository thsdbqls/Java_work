package d260123;

import java.io.IOException;

public class Main2 {

	public static void main(String[] args) throws IOException {
		// 키보드로 부터 입력받은 문자를 한자씩 모두 출력
		// 스트림에 아무것도 들어 있지 않을 때는 -1
		// in.read() 함수는 스트림에 값이 없을 때는 키보드 입력 대기 상태
		// 스트림에 값이 존재할 때는 대기상태가 아닌 스트림의 값을 읽어오는 상태
	
		int key=0; 
		
		// 키보드 출력의 방법 1
		/*while((key=System.in.read())!=-1) {
			System.out.println(key+":"+(char)key);
		}*/
		
		// 키보드 출력의 방법 2
		/*while(true) {
			key=System.in.read();
			System.out.println((char)key);
			if(key==1) {break;}
		}*/

		// 키보드 출력의 방법 3
		/*key=System.in.read();
		System.out.print((char)key);
		while(System.in.available()!=0) {
			key = System.in.read();
			System.out.print((char)key);
		}*/
		
		// 가장 많이 사용하는 방식은 1번 방식이다
		

		
		// 위의 코드의 문제점
		// 출력용으로 화면에만 글자가 나타나고 실제 사용할 경우
		// 해당 데이터를 다시는 이용할 수 없는 문제가 발생
		// 이를 해결하기 위해서는 문자열을 누적시켜야 한다.
		
		// 아래의 코드는 String 변수로 인해 발생다는 문제이다(EOF-End Of File)
		/*
		String str="";
		while((key=System.in.read())!=-1) {
			//System.out.print(key+":"+(char)key);
			str+=(char)key;
			
		}
		//str+=(char)key;
		System.out.println("전체 문자열 출력 :"+str);
		System.out.println("문자열 길이"+str.length());
		*/
		
		// 수정된 코드(ctrl+z)
		/*
		//StringBuffer str=new StringBuffer(); or
		StringBuilder str=new StringBuilder();
		while((key=System.in.read())!=-1) {
			str.append((char)key);
			
		}
		System.out.println("전체 문자열 출력 :"+str.toString());
		System.out.println("문자열 길이"+str.length());
		*/
		
		// 한번에 스트림을 처리하는 방법
		byte[] bytes=new byte[100];
		System.in.read(bytes);
		System.out.println(bytes);  // 객체만 출력되는 문제
		
		// byte 배열을 문자열로 변환
		String s = new String(bytes);
		System.out.println(s);
		System.out.println(s.length());
		if(s.trim().equals("abc")) {
			System.out.println("문자열입력 일치");
		}
		else {
			System.out.println("문자열입력 불일치");
		}
		
		
		// 문자열을 바이트로 변환하는 방법
		System.out.println(s.trim().getBytes());
		for(byte b:s.trim().getBytes()) {
			System.out.println(b);
		}
	}

}
