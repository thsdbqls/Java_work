package d260209.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiChatServer {
	
	
	public static void main(String[] args) {
		List<Socket> socketlist=new ArrayList<Socket>();
		
		System.out.println("####서버프로그램 시작####");
		try(ServerSocket server=new ServerSocket(1234)){
			while(true) {
			System.out.println("접속대기중");
			Socket socket=server.accept();
			socketlist.add(socket); //접속한 클라이언트의 소켓을 누적저장
			System.out.println(socket.getRemoteSocketAddress()+" 접속");
			System.out.println("접속인원:"+socketlist.size());
			(new MultiRecv(socket,socketlist)).start();
			}
			
		}catch (Exception e) {}

	}

}




