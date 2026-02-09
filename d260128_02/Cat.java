package d260128_02;

public class Cat implements Animal {
	public String name;
	public Cat(String name) {
		this.name=name;
	}
	@Override
	public void sound() {
		System.out.println("야옹~!!");
		
	}
	@Override
	public void callName() {
		System.out.println("나의 이름은 " + name + "이야");
		
	}
	
	public void jump() {
		System.out.println("뛰어 가면서 앞으로 간다.");
	}
}
