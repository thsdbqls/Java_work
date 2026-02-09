package d260209_03;

import java.io.Serializable;
//반드시 확인사항: 네트워크상에 객체를 보낼때는 직렬화를 반드시 구현
public class Point implements Serializable{
	
	// 직렬 전송 시 반드시 필요하다
	private static final long serialVersionUID = 1L;
	
	public int x;
	public int y;
	
	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
}