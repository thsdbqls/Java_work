package d260209_01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 컬렉션(수집) 프레임워크(구조)
// 자바에서 데이터를 수집하는 구조
// 데이터는 형이 반드시 필요하다
// 소분자로 된 형은 기본현(int, float, char, ...) -> 한 개의 모음
// 대문자로 된 형은 클래스형(String, Scanner, ...) -> 데이터의 모임
// 컬렉션 프레임워크는 클래스형의 데이터를 저장하기 위한 클래스
public class Main2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		List<String> list = new ArrayList<String>();
		// Map<k, V> map
		// K=Key, V=value
		Map<String, Socket> map2 = new HashMap<String, Socket>();
		map2.put("acom", new Socket("172.16.15.42",8080));
		map2.put("bcom", new Socket("172.16.15.46",8080));
		map2.put("ccom", new Socket("172.16.15.47",8080));
		map2.put("dcom", new Socket("172.16.15.49",8080));
		
		System.out.println(map2);
		System.out.println(map2.get("ccom").getRemoteSocketAddress());
		System.out.println(map2.size());
		
		map2.remove("ccom");  // 이렇게 하면 ccom에 해당하는 값을 remove(삭제)하는 것이다.
		System.out.println(map2.size());
	}

}
