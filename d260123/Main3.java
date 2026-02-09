package d260123;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main3 {

	public static void main(String[] args) throws IOException {
		// 사용자 정의 스트림
		byte[] bytes = {1,2,3,4,5,6,7,8,9};   // byte형의 배열 데이터
		
		// 데이터 -> 스트림으로 변경
		// new InputStream()을 입력하면 자동으로 작성된다.
		/*
		InputStream in = new InputStream() {
			
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		*/
		
		InputStream in=new ByteArrayInputStream(bytes);   // 근본은 inputstream 인데 들어가는 것은 byte가 들어간다.
		int data;
		while((data=in.read())!=-1) {
			System.out.println(data);
		}
		//정리 : 변수는 메모리에 저장된 값, 스트림은 큐에 저장된 값
	}

}
