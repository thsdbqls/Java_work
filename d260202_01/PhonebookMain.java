package d260202_01;

import java.io.IOException;

public class PhonebookMain {

	public static void main(String[] args) throws IOException {
		// 프로그램을 처음 시작할 때 어떤 db를 사용할 것인지 값을 입력해서 처리한다. 
		// 다른 말로 필요하는 도구를 생성자에 입력하여 처리한다.
		// new PhonebookProgram(new OraclePhonebookDAO());
		new PhonebookProgram(new H2PhonebookDAO());
	}

}