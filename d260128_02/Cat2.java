package d260128_02;

public abstract class Cat2 {
	public String name;
	
	public abstract void sound();
	public abstract void callName();
	
	public Cat2() {
		// TODO Auto-generated constructor stub
	}
	
	public Cat2(String name) {
		this.name=name;
	}

	public void jump() {
		System.out.println("뛰어 가면서 앞으로 간다.");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
