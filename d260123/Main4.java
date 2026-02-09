package d260123;

public class Main4 {

	public static void main(String[] args) {
		// 출력 스트림 outputStream : 메모리에서 나오는 스트림
		// 'a'문자는 메모리에 저장된 데이터
		char c='a';
		System.out.write(c);  // 여기서에서 write(쓴다)는 것은 모니터에 쓴다는 것이다
		// System.out은 모니터로 가는 스트림
		//스트림으로 보내는 상태이므로 화면에 나타나지 않음
		
		System.out.flush();  // 이것을 해야 스트림을 화면에 출력한다.
		
		System.out.write('자');  // write는 1byte 처리이므로 한글이 깨짐
		System.out.flush();
		System.out.println('자');  // print는 2byte 처리이므로 한글이 안 깨짐
	}

}
