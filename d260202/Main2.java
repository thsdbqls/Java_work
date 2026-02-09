package d260202;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main2 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//                                                xe:데이터베이스 명
		String url = "jdbc:oracle:thin:@172.16.15.66:1521:xe";
		Connection conn = DriverManager.getConnection(url, "system", "1234");
		System.out.println(conn);
		
		PreparedStatement ps = conn.prepareStatement("select * from phonebook");
		//PreparedStatement ps = conn.prepareStatement("select id,name,email,hp from phonebook");
		ResultSet rs = ps.executeQuery();
		
		System.out.println("결과:"+rs);
		System.out.println("______________________________________________________");
		System.out.println("|아이디 |   이름    |          전화번호        |    이메일   |");
		System.out.println("-------------------------------------------------------");
		
		while(rs.next()) {
			// 필드명 대신 순서번호 입력 가능
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println("---------------------------------");
			
		}
		System.out.println("____________________________________");
		
		// 자원을 반환해 줘야한다
		ps.close();
		conn.close();
	}

}
