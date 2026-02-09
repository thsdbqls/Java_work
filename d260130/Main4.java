package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main4 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = 
				DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.66:1521:xe", "system", "1234");
		System.out.println(conn);
		
		Statement stat = conn.createStatement();
		/*stat.execute("drop table phonebook");
		String ctable //= "Create table Phonebook(id int, name varchar2(20), hp varchar2(13), email varchar2(20))";
				= "create table phonebook("
				+ "id integer,"
				+ "name varchar2(10),"
				+ "hp varchar2(13),"
				+ "email varchar2(30)"
				+ ")";*/
		
		
		//String sql = "insert into phonebook values(1,'손유빈','010-1111-1111','hong@gmail')";
//		String sql = "select * from phonebook";
//		System.out.println(stat.executeQuery(sql)); 
		//stat.execute(ctable);
		
		
		for(int i=2; i<=9; i++) {
			String sql = "insert into phonebook values("
			+ i +",'손유빈"+ i +"','010-1111-111"+ i +"','hong"+ i +"@gmail')";
			stat.executeUpdate(sql);
		}

	}
}

