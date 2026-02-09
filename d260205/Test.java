package d260205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		/*
		ServerSocket server = new ServerSocket(8080);
		if(server==null) {
			
		}
		System.out.println(server);
		*/

		/*
		//try에서 서버 소캣에서 오류가 발생하면 catch가 잡아서 "서버 소캣 생성 오류"가 나온다.
		try(ServerSocket server = new ServerSocket(8080)) {
			System.out.println(server);
			
			while(true) {
				if(server==null) System.out.println("중간에 서버 소켓 오류가 생겼습니다");
			}
		} catch (Exception e) {
			System.out.println("서버 소캣 생성 오류");
		}*/
		
		/*
		Process p = Runtime.getRuntime().exec("notepad");
		Thread.sleep(3000);
		System.out.println(p.pid());

		// p.destroy() // 강제 종료하는 것
		// 이것이 안되서 아래것을 사용한다.
		ProcessHandle.of(p.pid()).ifPresent(ph->{
			ph.destroy();
		});
		*/

		/*
		Process p = Runtime.getRuntime().exec("cmd /c ipconfig");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"MS949"));
		
		String line;
		while((line = br.readLine())!=null) {
			System.out.println(line);
		}
		*/
		/*
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
		pb.inheritIO();  // 콘솔에 결과 출력
		pb.start();
		*/
		
		ProcessBuilder pb = new ProcessBuilder("notepad");
		Process process =  pb.start();
		 Thread.sleep(3000);   // 3초 기다리라
		//pb.wait(3000);  // wait : 대기 상태
		process.destroy();
	}

}
