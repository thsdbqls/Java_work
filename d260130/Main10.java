package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main10 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = 
				DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.66:1521:xe", "system", "1234");
		System.out.println(conn);
		
		Statement stat = conn.createStatement();
		int rs = 
				stat.executeUpdate("delete phonebook where id=2");
		
		if(rs<1) {
			System.out.println("삭제 실패!!");
		}
		System.out.println("삭제 성공!!!");

	}
}

