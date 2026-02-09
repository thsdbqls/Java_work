package d260202;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");                                             
		String url = "jdbc:oracle:thin:@172.16.15.66:1521:xe";
		Connection conn = DriverManager.getConnection(url, "system", "1234");
		System.out.println(conn);
		
		String sql = "update phonebook set name =?, hp=?, email=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		// ?가 있으므로 set 함수가 존재한다
		
		ps.setString(1, "김민수");
		ps.setString(2, "010-1234-5678");
		ps.setString(3, "kim@gmail.com");
		ps.setInt(4, 5);

		int rs = ps.executeUpdate();
		
		System.out.println("결과:"+rs);
		
		// 자원을 반환해 줘야한다
		ps.close();
		conn.close();
	}

}
