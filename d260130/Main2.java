package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// 리스너 오류 발생시 처리 방법
/*
sqlplus system/1234로 접속후에 
sql>alter system set local_listener='(ADDRESS=(PROTOCOL=TCP)(HOST=127.0.0.1)(PORT=1521))' scope=both;
sql>alter system register;
sql>exit
lsnrctl status
*/
import java.sql.Statement;

// 오라클 접속
public class Main2 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = 
				DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.66:1521:xe", "system", "1234");
				//DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
				//DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521:xe", "system", "1234");
		System.out.println(conn);
		
		// phonebook테이블을 생성 후 에 sqlplus에서 테이블 생성되었는지 확인
		// sqlplus > desc phonebook;
		
		Statement stat = conn.createStatement();
		stat.execute("drop table phonebook");
		String ctable //= "Create table Phonebook(id int, name varchar2(20), hp varchar2(13), email varchar2(20)";
				= "create table phonebook("
				+ "id integer,"
				+ "name varchar2(10),"
				+ "hp varchar2(13),"
				+ "email varchar2(30)"
				+ ")";
		
		String sql = "insert into Phonebook values(3,'홍길동','010-1111-1111','hong@gmail')";
		
		stat.execute(ctable);
		System.out.println(stat.executeUpdate(sql)); 
		/*if(result<0) {
			System.out.println("입력 실패!!");
		}
		System.out.println("입력 성공~~");*/
	}

}
