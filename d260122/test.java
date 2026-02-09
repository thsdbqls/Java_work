package d260122;

import org.junit.Test;

public class test {
	@Test
	/*
	public void test() {
		PhonebookManager pm = new PhonebookManager();
		pm.insert("홍길동","010-111-1111","hong@gmail.com");
		pm.insert("김길동","010-111-2222","kim@gmail.com");
		pm.select();
	}*/
	
	public static void main(String[] args) {
		PhonebookManager pm = new PhonebookManager();
		pm.insert("홍길동","010-111-1111","hong@gmail.com");
		pm.insert("김길동","010-111-2222","kim@gmail.com");
		pm.insert("유길동","010-111-3333","u@gmail.com");
		pm.insert("김기동","010-111-4444","kim@gmail.com");
//		pm.update("김길동", new Phonebook(null,"010-11111-33333",null));
		
//		Phonebook updatepb = new Phonebook(null,"010-11111-33333",null);
//		pm.update("김길동", updatepb);
		
		pm.delete("김길동");
		//pm.select();
		pm.selectByName("김기동");
	}
}
