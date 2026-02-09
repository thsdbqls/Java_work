package d260202;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main1 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// Statement객체는 완성된 SQL에서만 사용
	// 완성되지 않은 문장은 aPrepareStatement 사용
	// preparedStatement(사전에 정의되어진) -> conn.prepare(사전에 완성되지 않은)Statement()
	// 이것은 사전에 완성이 된것                     // 이건은 사전에 완성이 안되어진것
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//                                                xe:데이터베이스 명
	String url = "jdbc:oracle:thin:@172.16.15.66:1521:xe";
	
	Connection conn =
			DriverManager.getConnection(url, "system","1234");
	System.out.println(conn);
	
	// 이것은 미완성 문장이여서 ?에 무엇이 들어갈 지 몰라서 이대로 올려야 한다.
	String sql = "insert into phonebook values(?,?,?,?)";
	// 그래서 이것을 사용하여 미완성 문장을 올릴 수 있다
	PreparedStatement ps = conn.prepareStatement(sql);
	// ?의 갯수 만큼 문장을 완성해 줘야한다
	// ?를 채워줘야 한다
	ps.setInt(1, 5);
	ps.setString(2, "김민수");
	ps.setString(3, "010-1111-1111");
	ps.setString(4, "kim@gmail");
	
	// ()안에 작성않애도 된다 그 이유는 사전에 이미 작성해 놨기 때문이다
	// statement는 ()안에 작성해 줘야한다.
	int result = ps.executeUpdate(); // statement 객체와 차이점은 sql을 여기서 실행하는 것이 아니다.
	System.out.println("결과:"+result);
	
	// 자원을 반환해 줘야한다
	ps.close();
	conn.close();
}
}
