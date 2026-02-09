package d260202;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");                                             
		String url = "jdbc:oracle:thin:@172.16.15.66:1521:xe";
		Connection conn = DriverManager.getConnection(url, "system", "1234");
		System.out.println(conn);
		
		PreparedStatement ps = conn.prepareStatement("select * from phonebook where id = ?");
		// ?가 있으므로 set 함수가 존재한다
		System.out.println("찾는 아이디를 입력하세요");
		int id =(new Scanner(System.in)).nextInt();
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		
		// 아이디가 중복이 되지 않는다고 가정할 경우 결과는 1개이므로 if문을 사용한다.
		if(rs.next()) {
			// 필드명 대신 순서번호 입력 가능
			System.out.println("아이디:"+rs.getInt(1));
			System.out.println("이름:"+rs.getString(2));
			System.out.println("전화번호:"+rs.getString(3));
			System.out.println("이메일:"+rs.getString(4));
			System.out.println("---------------------------------");
			
		}
		System.out.println("____________________________________");
		
		// 자원을 반환해 줘야한다
		ps.close();
		conn.close();
	}

}
