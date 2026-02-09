package d260209_01;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;



public class MonitoringServer {

	public static void main(String[] args) {
		//String[] ips = new String[16];
		
		// 정보는 정해져 있으므로 배열로 처리한다
		String[] ips = {"172.16.15.53","172.16.15.54","172.16.15.55","172.16.15.56",
				"172.16.15.57","172.16.15.58","172.16.15.59","172.16.15.60",
				"172.16.15.65","172.16.15.66","172.16.15.67","172.16.15.68",
				"172.16.15.73","172.16.15.74","172.16.15.75","172.16.15.76",
				"172.16.15.97"
		};

		// 위의 정보를 이용하여 프레임에 버튼을 만들기
		Frame f = new Frame();
		f.setBounds(0,0,400,300);
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		
		Button[] btn = new Button[ips.length];
		
		for(int i=0; i<ips.length; i++) {
			btn[i] = new Button(ips[i]);
			f.add(btn[i]);
			btn[i].setBackground(Color.RED);
		}
		f.revalidate(); f.repaint();
		
		// 윈도우 닫기 리스너
		f.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		});
		
		// 시나리오
		// 소켓을 이용하여 클라이언트가 출석을 누르면 모니터링 화면에 해당하는 ip에 녹색배경으로 변경되도록 처리한다
		// 퇴실 버튼을 누르면 빨간색 배경으로 변경되어 현재의 출석상태를 확인하는 서버/클라이언트 프로그램 작성
		
		Map<String, Socket> map = new HashMap<String, Socket>();
		try(ServerSocket server = new ServerSocket(1234)){
			while(true) {
				Socket socket = server.accept();  // 서버에 접속된 클라이언트 값
				System.out.println(socket.getRemoteSocketAddress());
				
				// /172.16.15.66:54059 이 결과에서 ip 주소문만 분리한다
				System.out.println(socket.getInetAddress().getHostAddress());
				
				System.out.println(socket.getInetAddress().getHostName());
				
				// Map에 다가 저장해야 한다 / 맵에 socket을 저장하고
				map.put(socket.getInetAddress().getHostAddress(), socket);
				
				//map에 저장된 소켓과 accept한 socket이 같은 소켓인가를 확인해야 한다
				// System.out.println("참조여부:" + (map.get(socket)==socket));  // 두 객체가 같으면 레퍼런스(참조) 그렇지 않으면
				// Thread.sleep(3000);
				// System.exit(0);
				// ip 주소와 일치하는 버튼을 찾아서 해당하는 버튼의 배경색을 녹색으로 변경한다
				for(Button b:btn) {
					if(b.getLabel().equals(socket.getInetAddress().getHostAddress())) {
						b.setBackground(Color.green);
						
						// 문자열
						String ip = socket.getInetAddress().getHostAddress();
						new Recv(map,ip,b).start();  // map, ip주소, 버튼은 배경 변경하기 위해 전달
						
						break;
					}
					
				}
				
				// 별도의 수신 쓰레드를 생성해 줘야 한다(Recv), 수신 쓰레드는 퇴실 또는 소켓이 끊겼을 때 자동으로 해제(버튼 색 빨강색으로)
				//  new Recv(map,socket).start(); // 쓰레드를 생성하고 while문으로 올라 갈 경우 socket이 close가 발생한다
				// new Recv(map,map.get(socket)).start();
				// new Recv(map, socket.getInetAddress().getHostAddress()).start();
			}
		}catch (Exception e) {}
	}

}
