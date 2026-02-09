package d260128_02;

public abstract class Dog2  {
	public String name;
	
	public abstract void sound();
	public abstract void callName();
	
	public Dog2(String name) {
		this.name=name;
	}
	
	public void run() {
		System.out.println("앞으로 간다.");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
