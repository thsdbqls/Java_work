package d260129_01;

public interface Wash {
	public void startButton();
	
	public void stopButton();
	
	public void pauseButton();
	
	public void changeButton(int speed);

	// 이것은 추상클래스가 아니다 {}가 있으니까
	default void dry() {};
	default void clean() {};
}
