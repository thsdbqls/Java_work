package d260129;

// 자동차의 기능을 사용할때
public class 아반테  {
	// 자동차의 기능은 맴버 변수로 구현한다
	자동차기능구현 기능; // 아직까지는 기능이 사용이 되는 상태는 아니다
	String name;
	int cc;
	int year;
	//CarFunc 기능;
	
	public 아반테() {
		기능 = new 자동차기능구현();
	}
	
	public 아반테(자동차기능구현 기능, String name, int cc, int year) {
		기능 = new 자동차기능구현();
		this.기능 = 기능;
		this.name = name;
		this.cc = cc;
		this.year = year;
	}

	// 인터페이스가 맴버 변수일 경우 get기능을 사용할 수 없음
	public 자동차기능구현 get기능() {
		return 기능;
	}
	
	public void set기능(자동차기능구현 기능) {
		this.기능 = 기능;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void display() {
		System.out.println("자동차소유주:"+name);
		System.out.println("자동차년식:"+year);
		System.out.println("자동차배기량:"+cc);
	}
	
}
