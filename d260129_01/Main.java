package d260129_01;

public class Main {

	public static void main(String[] args) {
		SamsungWash ssw = new SamsungWash();
		LGWash lw = new LGWash();
		
		Wash wash = new SamsungWash();  // or LGWash로 바꾸고 싶다.
		wash.clean();
		// 문제사항은 인터페이스로 세탁기를 변경할 경우 기본 기능만을 사용하고
		// 회사의 고유 기능은 사용할 수 없는 문제가 발생한다
		
		LowWash lowwash = new LGWash();
		lowwash.startButton();
		lowwash.stopButton();
	}

}
