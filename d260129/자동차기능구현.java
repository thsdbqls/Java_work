package d260129;

// 개발자가 구현을 하게 되고 -> CarFunc에 설계(기획)된 내용으로 구현을 해야한다
// 기능을 구현할 때 입력값(파라미터)이 필요하고 기능에 대한 결과(리턴값)도 필요하다

// CarFunc을 구현하라
public class 자동차기능구현 implements CarFunc{

	@Override
	public void movehandle() {
		// TODO Auto-generated method stub
		System.out.println("핸들을 조작합니다.");
	}

	@Override
	public void controllerAcc() {
		// TODO Auto-generated method stub
		System.out.println("엑셀을 조작합니다.");
	}

	@Override
	public void controllerBreak() {
		// TODO Auto-generated method stub
		System.out.println("브레이크를 조작합니다.");
	}

	@Override
	public void controllerWindow() {
		// TODO Auto-generated method stub
		System.out.println("창문을 조작합니다.");
	}

}
