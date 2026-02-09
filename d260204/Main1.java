package d260204;

import static org.junit.Assume.assumeNoException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main1 {

	public static void main(String[] args){
		//url객체를 url주소를 각각 분리하여 저장하는 역할
		/*
		URL url=new URL("http://192.168.0.1:8080/index.html?page=1");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getQuery());
		*/
		
		//url객체에서 지원하는 openstream은 직접적으로 사용할 수 없음
		/*
		URL url=new URL("http://dwit.or.kr");
		InputStream in=url.openStream();
		int c;
		while((c=in.read())!=-1) {
			System.out.print((char)c);
		}
		in.close();
		System.out.println("프로그램 종료!!");
		*/
		
		//위의 문제를 해결하기 위해 URLConnection객체를 활용
		try {
		//URL url=new URL("https://dwit.or.kr");
		URL url=new URL("https://jsonplaceholder.typicode.com/posts");
		URLConnection uc=url.openConnection();
		InputStream in=uc.getInputStream();
		int c;
		while((c=in.read())!=-1) {
			System.out.print((char)c);
		}
		in.close();
		System.out.println("프로그램 종료!!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}