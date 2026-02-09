package d260130;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// 사용할 db의 드라이버를 로드한다
		// 1) Cass.forName(드라이버 위치); 드라이버 라이브러리 로드(import)		
		// 2) 접속 객체를 이용하여 접속한다 Connection		
		// 3) 접속 객체를 이용하여 sql문을 처리할 객체를 만든다 Statement(기제, 성명)
		// 4) SQL처리 객체를 이용하여 SQL을 실행한다 Statement에 있는 함수 이용
		// 위의 연결은 chain처럼 연결되어 있는 구조이다.
		// 드라이버로드 - DB접속 - 문장객체 생성 - 실행
		// 1)
		Class.forName("org.h2.Driver"); // 대문자를 사용하는 것 - static함수
		
		// 2)
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://172.16.15.66:8082/~/test","sa","");  // connection 객체를 만들기 위해서는 Driver매니저를 사용해야 한다
		// jdbc:h2:tcp://172.16.15.97:8082/~/test
		// jdbc:h2:tcp://localhost/~/test
		System.out.println(conn);
		if(conn==null) {
			System.out.println("연결 실패");
			return;
		}
		System.out.println("시험 성공");
		
		// 3)
		Statement stat = conn.createStatement();
		String sql = "insert into Phonebook values(1,'김길동','010-1111-1111','hong@gmail')";
		//stat.executeQuery(select 문의 SQL 문);
		//stat.executeUpdate(insert/update/delete 문의 SQL문);
		int result = stat.executeUpdate(sql);  // 결과가 0이면 실패, 1 이상은 성공을 의미한다
		if(result<0) {
			System.out.println("입력 실패!!");
		}
		System.out.println("입력 성공~~");
	}

}
