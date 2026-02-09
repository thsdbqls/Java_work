package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main9 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = 
				// 이것을 이용하여 객체를 다시 리턴을 받는다
				DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.66:1521:xe", "system", "1234");
		System.out.println(conn);
		
		// 문장을 처리하기 위해서 이것을 만든다
		Statement stat = conn.createStatement();
		int rs = 
				// 만든 문자을 실행을 한다
				stat.executeUpdate("update phonebook set hp = '010-1234-1234' where id=2");
		
		if(rs<1) {
			System.out.println("업데이트 실패!!");
		}
		System.out.println("업데이트 성공!!!");

	}
}

