package d260123;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main8 {

	public static void main(String[] args) throws IOException {
		// Buffer는 완충역활을 한다
		// 아래는 기본구조로서 inputstream에 해당하는 데이터가 존재해야한다.
		// inputStream은 데이터이므로 FileInputStream으로 여기에 위치할 수 있음
		//BufferedInputStream bis = new BufferedInputStream(new InputStream()
		//BufferedInputStream bis = new BufferedInputStream(new FileInputStream()
		
		/*
		BufferedInputStream bis
		= new BufferedInputStream(new InputStream() {
			
			String s = "hello java!!";
			byte[] data = s.getBytes();
			private int index=0;  //위치값
			
			@Override
			public int read() throws IOException {
				if(index >= data.length) {
					return -1;  //EOF
				}
				return data[index++] & 0xff;   // mask 처리 //0xff는 비트 연산자로 오류를 방지한다.
			}
		});
		
		// available은 직접 생성할 경우 정의를 통해 계산 처리를 해야함
		System.out.println(bis.available());
		
		
		// 위의 정의가 되어 있지 않으므로 사용할 ㅜㅅ 없음
		while(bis.available()>0) {
			System.out.print((char)bis.read());
		}

		System.out.print((char)bis.read());
		System.out.print((char)bis.read());
		System.out.print((char)bis.read());
		System.out.print((char)bis.read());
		System.out.print((char)bis.read());
		*/
		
//		new InputStreamReader(null).read(); // 데이터를 변수로 부터 가져온다
//		FileInputStream(null).readAllBytes(); // 파일로 부터 데이터를 가져오고
		
		byte[] bytes = new byte[1024];
		BufferedInputStream bis 
		= new BufferedInputStream(new FileInputStream("c.txt"));
		
		// 값의 리턴을 통해서 bytes 배열에 값을 담는 구조
		bytes = bis.readAllBytes();
		System.out.println(bytes);  // 배열 객체
		System.out.println(new String(bytes));  // 문자로 변환
		System.out.println(Arrays.toString(bytes));   // 배열 안의 값을 리스트로 표현한다.
		
		
		
		// 함수에 바이트 배열의 변수를 입력값으로 주면 bytes변수 안에 값을 담는 구조
		// new InputStreamReader(null).read(bytes);
		
		
		// 여러줄의 데이터를 제어할 때 1번째에 있는 데이터만을 출력하고 싶을 경우 어떻게 처리를 해야 하는 가
		// 이 문제를 해결하기 위해서 라인 단위로 데이터를 읽을 수 있는 스트림이 존재함
		FileReader reader = new FileReader("c.txt");
		reader.read();   // read함수 밖에 읽기할 함수가 없음
		
		// BufferedReader reader2 = new BufferedReader(new Reader());
		// 버퍼더리더는 파일리더가 필요로하고 파일리더는 파일을 필요로 한다.
		BufferedReader reader2 
		= new BufferedReader(new FileReader(new File("c.txt")));
		
		System.out.println(reader2.readLine());  // 줄 단위로 읽는다 - readLine()
		
		// 줄 단위로 계속해서 읽어오는 방법
		String s="";
		while((s=reader2.readLine())!=null) { // 변수 s에 줄 단위로 저장하고 그것이 null 값이 될때까지 반복해라
			System.out.println(s);
		}
		
		
		// 파일에 줄단위로 쓰기
		//BufferedWriter writer = new BufferedWriter(new Writer());
		s="AWS 보안 프로그래밍";
		//BufferedWriter writer = new BufferedWriter(new FileWriter(new File("c.txt")));
		BufferedWriter writer = new BufferedWriter(new FileWriter("c.txt",true));
		writer.newLine();
		writer.append(s);
		writer.close();
		
		// 위의 코드의 문제점은 기존 파일의 내용이 삭제가 됨
		// new BufferedWriter(new FileWriter("c.txt",true)); 를 하면 삭제가 안됨
		// 추가방법 writer.write(s); writer.newLine();
	}

}
