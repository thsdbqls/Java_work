package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main8 {

	public static void main(String[] args){
		Connection conn = null;
		String url = null;
		String username = null;
		char[] password = null;
		int cnt = 0;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 확인하세요");
			return;
		}
		
		do {
		System.out.println("username:");
		username = (new Scanner(System.in)).next();
		System.out.println("Password:");
		password = System.console().readPassword();
		url = "jdbc:oracle:thin:@172.16.15.66:1521:xe";
		try {
			// 오류가 발생하면 바로 프로그램을 종료시킨다
			// 그것을 해결하기 위해 try~catch문을 사용한다
			
			conn = DriverManager.getConnection(url, username, new String(password));
		} catch (SQLException e) {
			System.out.println("아이디 또는 패스워드를 확인하세요.");
		}
		cnt++;
		
		if(conn!=null) break;
		
		}
		
		// conn의 값이 null값이나 cnt가 4보다 작을 때 반복한다
		while(cnt<4);
		// 페스워드나 유저네임이 맞지 않아서 null이 되는것이다
		if(conn==null) {
			System.out.println("다시 실행하여 주시기 바랍니다.");
			System.exit(0);
		}
		System.out.println("SQL>");
	}

}
