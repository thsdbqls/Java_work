package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("username:");
		String username = (new Scanner(System.in)).next();
		System.out.println("Password:");
		char[] password = System.console().readPassword();
		String url = "jdbc:oracle:thin:@172.16.15.66:1521:xe";
		Connection conn =
				                                                   //  password는 문자로 되니까 String 으로 변경한다
		DriverManager.getConnection(url, username, new String(password));
		
		// 페스워드나 유저네임이 맞지 않아서 null이 되는것이다
		if(conn==null) {
			System.out.println("계속해서 또는 3번 입력받을 수 있게끔 처리하시오.");
			System.exit(0);
		}
		System.out.println("SQL>");
	}

}
