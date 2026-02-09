package d260204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class MyWebServer4 {

	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(8888)) {
			System.out.println("서버프로그램 실행중....");
			
			while(true) {
			Socket socket = server.accept();
			InputStream in= null;
			OutputStream out= null;
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			// 인풋스트림은 1byte
			// 1byte이 inputstream을 2byte인 InputStreamReader로 변환하고 사용하기 쉽게 BufferedReader로 생성한다.
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String data=br.readLine();
			System.out.println(data);
			
			// 들어오는 데이터 값은 요청 방식에 따라 GET / POST / PUT /DELETE 방식이 있음
			if(data.startsWith("GET")) {
				
				if(data.contains("favicon.ico")){
					//favicon.ico 이미비를 전송
					
					// 밖으로 빠져나가는 것은
				}
				else {
					
					// 사용할 파일은 경로를 입력해 줘야 합니다
					FileInputStream fis = new FileInputStream("D:/25work/workspace/d260121/src/d260204/upload.html");
					byte[] body = fis.readAllBytes();  // 값을 다 byte로 바꾼다.
					
					String header =""
							+ "HTTP/1.1 200 OK\r\n"
							+ "Content-Type: text/html\r\n"
							// 길이는 반드시 표시해 줘야 한다.
							+ "Content-Length: "+ body.length + "\r\n"  // 길이를 확인 해야 한다.
							+ "connection: close\r\n"
							+ "\r\n";

					
					out.write(header.getBytes());
					out.write(body);
					// 작성한 것을 웹으로 보내준다.
					out.flush();
					fis.close();
				}
				
			}
			else if(data.startsWith("POST")) {
				// 1) 들어오는 데이터를 읽어보자
				// 라인을 읽은 후 완료되었을 때 null값 확인보다는 empty함수를 사용하는 것이 맞음
				/*
				String line="";
				//while((line=br.readLine())!=null) {
				while(!(line = br.readLine()).isEmpty()) {
					System.out.println(line);
				}
				System.out.println("라인을 모두 빠져나왔습니다.");
				*/
				
				// 2) 읽은 데이터 중에서 파일의 데이터만을 추출하여 파일 스트림에 입력
				
				
                int length = 0;
                String boundary = null;
                String line="";

                // 한줄을 읽어서 비어있지 않으면
                // 한줄을 계속해서 읽는 상태에서 한줄에 대한 정보만 존재하며
                // 이전 데이터는 사라짐을 인식하고 있는 상태에서 코드를 확인을 한다
                while (!(line = br.readLine()).isEmpty()) {
                	System.out.println("-------:"+line);
                	// 컨탠츠 길이를 받아서
                    if (line.startsWith("Content-Length")) {
                    	// 파일의 데이터 길이 추출
                        length = Integer.parseInt(line.split(":")[1].trim());  // trim을 이용하여 스페이스를 제거한다
                        System.out.println("파일 길이:"+length);
                    }
                    
                    // 컨텐츠 타입을 찾아서
                    if (line.startsWith("Content-Type")) {
                    	//boundary=를 기준으로 우측의 값ㅇ르 가져온다.
                        boundary = line.split("boundary=")[1];
                        System.out.println("바운더리 확인:"+boundary);
                    }
                }
                // Accept-Language 데이터까지만 읽은 후 반복문을 빠져나옴
                
                // 길이 만큼 읽어 들인것을 body에 넣어주고
                byte[] body = in.readNBytes(length);
                System.out.println("파일에 전송된 데이터");
                System.out.println(new String(body));
                
                byte[] sep = "\r\n\r\n".getBytes();
                System.out.println("파일 구분자");
                System.out.println(new String(sep));

                // body와 구분자를 찾아서 시작하는 곳과 끝나는 곳을 찾는다.
                int start = indexOf(body, sep) + sep.length;
                int end = indexOf(body, ("--" + boundary).getBytes()) - 2;
                System.out.println("쓸 파일의 위치 번호");
                System.out.println("시작위치: "+start);
                System.out.println("끝 위치: "+end);
                
                // 파일의 데이터를 찾았는지 확인
                System.out.println("파일에 쓸 데이터: "+ new String(Arrays.copyOfRange(body, start, body.length)));
                System.out.println("파일에 쓸 데이터: "
                		+ new String(Arrays.copyOfRange(body, start, body.length-boundary.length())));
                
                end = body.length-boundary.length();
                
                // 파일에 필요한 데이터 만을 쓰는 작업을 한다
                // 파일을 저장하는 작업
                try(FileOutputStream fos = new FileOutputStream("upload.txt")) {
					String s = new String(Arrays.copyOfRange(body, start, body.length-boundary.length()));
					fos.write(s.getBytes());
					fos.flush();
					fos.close();
				} catch (Exception e) {
					System.out.println("오류발생");
				}


                //클라이언트(웹브라우저)에게 response데이터를 보내는 작업(잘 받았다는 표시)
                out.write((
                    "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n"+
                    "Connection: close\r\n" 
                    +"\r\n" +
                    "업로드 완료"
                    +"\r\n\r\n"
                ).getBytes());  // 이것이 파일을 쓰는것이다.
                // */
			}
			// 다른 사람이 사용해야 하기 때문에 사용한 소켓은 닫아줘야한다.
			socket.close();
		} 
		}
			catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	// 위치(번호)를 확인하는 함수
	static int indexOf(byte[] data, byte[] target) {
        for (int i = 0; i < data.length - target.length; i++) {
            boolean ok = true;
            for (int j = 0; j < target.length; j++)
                if (data[i + j] != target[j]) ok = false;
            if (ok) return i;
        }
        return -1;
    }

}
