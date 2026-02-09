package d260128_02;
// 분류 : 동물(상위 개념) - 개 고양이 호랑이(하위 개념)
public interface Animal {
	// 구현 대상은 공통적인것을 한다.
	// 울음소리(기능), 이름에 대해 알려줘(기능)
	public void sound();
	public void callName();
}
