package d260123;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main7 {

	public static void main(String[] args) throws IOException {
		// 메모리에 한글 문자열을 입력하고
		// 메모리에 있는 문자열을 파일에 기록하시오
		FileOutputStream fout = new FileOutputStream("c.txt");
		String s="자바프로그래밍!!";
		fout.write(s.getBytes());

		// c.txt 파일의 내용을 한 byte씩 출력하시오
		FileInputStream fin = new FileInputStream("c.txt");
		/*
		while(fin.available()>0) {
			System.out.println((char)fin.read());
		}
		*/
		
		// 한번에 데이터 가져오기 (byte 데이터 -> String 데이터로 변환해야 한다)
		byte[] bytes = new byte[256];
		fin.read(bytes);
		System.out.println(new String(bytes));
	}

}
