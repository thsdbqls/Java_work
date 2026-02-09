package d260130;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main6 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// select * from phonebook where id=1
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn =
		DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.66:1521:xe", "system", "1234");
		
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from phonebook where id=2");
		System.out.println(rs);
		
		if(rs.next()) {
			System.out.println("아이디 : "+rs.getInt("id") + " ");
			System.out.println("이름 : "+rs.getString("name") + " ");
			System.out.println("전화번호 : "+rs.getString("hp") + " ");
			System.out.println("이메일 : "+rs.getString("email") + " ");
			System.out.println();
		}
		
		System.out.println(rs);
		rs.close();
		stat.close();
		conn.close();
	}

}
