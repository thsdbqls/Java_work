package d260123;

import java.io.IOException;

public class Main1 {

	public static void main(String[] args) throws IOException {
		// 입력 스트림을 이용하여서 메모리에 입력을 할 것이다.
		System.out.println(System.in.available());
		int ch = System.in.read();    // "abc"=\r\n"(enter값 포함(2))
		System.out.println(ch);
		System.out.println((char)ch);
		
		System.out.println(System.in.available());
		ch = System.in.read(); 
		System.out.println((char)ch);
		System.out.println(System.in.available());
		System.out.println("end Program!!");

	}

}
