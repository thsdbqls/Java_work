package d260129_01;

public class SamsungWash implements Wash{
	int speed;

	@Override
	public void startButton() {
		// TODO Auto-generated method stub
		System.out.println("Samsung세탁기가 시작됩니다");
	}

	@Override
	public void stopButton() {
		// TODO Auto-generated method stub
		System.out.println("Samsung세탁기가 정지됩니다");
	}

	@Override
	public void pauseButton() {
		// TODO Auto-generated method stub
		System.out.println("Samsung세탁기가 중지됩니다");
	}

	@Override
	public void changeButton(int speed) {
		
		if(!(speed>=0 && speed<100)) {
			this.speed = 0;
		}
		this.speed = speed;
		System.out.println("Samsung세탁기 속도가 변경됩니다");
	}
	
//	public void dry() {
//		System.out.println("Samsung세탁기가 건조를 합니다");
//	}
	
	public void clean() {
		System.out.println("Samsung세탁기가 세척을 합니다");
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	

}
