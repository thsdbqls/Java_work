package d260202_03;

import java.util.Date;

// 5명이 모여서 기능을 설계
// 모의한 기능을 가지고 메뉴를 작성한다.(수입 입력, 지출 입력, 현재 잔액, 품목에 대한 지출 합계 등)(문서로 작성하면서 각각의 기능의 입력값과 출력값을 상세하게 명세한다) 
// 인터페이스를 이용하여 각자 맡은 코드를 나누어서 작성을 하고
// 작성한 것을 다시 결합하면 된다(인터페이스 상속)

// 팀장의 역활은 모든 프로그램을 합쳐서 조율하는 작업을 한다.

// Oracle, h2에 대해 DAO를 처리하여라.
public class AccountBook {
	private int id;  //아이디
	private String type;  // 수입 또는 지출
	private String amount;  // 금액
	private String category;  // 분류(물품, 등으로 나누는 것)(
	private String indate;  // 사용 날짜( java.util or java.sql )
	//private java.util.Date date  // 입력 받을때 편하다 그러나 데이터에는 java.sql을 사용해야한다.
	
	public AccountBook() {
		// TODO Auto-generated constructor stub
	}
	public AccountBook(int id, String type, String amount, String category, String indate) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.category = category;
		this.indate = indate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "AccountBook [id=" + id + ", type=" + type + ", amount=" + amount + ", category=" + category
				+ ", indate=" + indate + "]";
	}

	
	
}

