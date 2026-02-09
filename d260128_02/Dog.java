package d260128_02;

public class Dog implements Animal{
	public String name;
	public Dog(String name) {
		this.name=name;
	}
	@Override
	public void sound() {
		System.out.println("멍멍!!");
		
	}
	@Override
	public void callName() {
		System.out.println("나의 이름은 " + name + "이야");
		
	}
	
	public void run() {
		System.out.println("앞으로 간다.");
	}
}
