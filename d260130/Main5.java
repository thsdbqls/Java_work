package d260130;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main5 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// 우리는 오라클 안에 jdbc 안에 드라이버 안에 OracleDriver를 사용할 것이다.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 드라이버를 선택했으면 드라이버 설정을 해야해서 매니저를 사용한다
		Connection conn = 

		// jdbc:oracle:thin(가벼운 작업)
		// :(연결하라는 뜻)
		// @(주소)IP 주소:포트번호:
		// xe(경량(라이트) 버전 DB)
		DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.66:1521:xe", "system", "1234");
		
		System.out.println(conn);
		
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from phonebook");
		
		// 테이블에 있는 값을 가져오기 때문에 거기에 얼마만큼의 값이 있는지 모르기 때문에 반복문을 사용한다.
		while(rs.next()) {
			System.out.println("아이디 : "+rs.getInt("id") + " ");
			System.out.println("이름 : "+rs.getString("name") + " ");
			System.out.println("전화번호 : "+rs.getString("hp") + " ");
			System.out.println("이메일 : "+rs.getString("email") + " ");
			System.out.println();
		}
		rs.close();
		stat.close();
		conn.close();
		
	}

}
