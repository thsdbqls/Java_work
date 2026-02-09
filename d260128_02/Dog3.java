package d260128_02;

public class Dog3 extends Dog2  {
	public String name;
	
	public Dog3(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void sound() {
		System.out.println("멍멍!!");
		
	}
	@Override
	public void callName() {
		System.out.println("my name is " + getName());
		
	}
		
}
