package d260202_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class H2AccountBookUpdateDAO implements Update{
	Connection conn;
	
	// 오라클 데이터베이스에 접근하기 위한 객체이다.
	public  H2AccountBookUpdateDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");                                             
			String url = "jdbc:oracle:thin:@172.16.15.66:1521:xe";
			conn=DriverManager.getConnection(url, "system", "1234");
			if(conn==null) {
				System.out.println("DB 연결을 다시 확인하세요.");
				System.out.println("프로그햄을 종료합니다");
			}
		 
		System.out.println("DB연결 성공!!");
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	/*
	@Override
	public int SelectUpdate(String category, String indate) {
		try {
			
			AccountBook new_pb = findById(pb.getId());

			String sql = "update accountbook set amount=? where category=?, indate=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			// ?가 있으므로 set 함수가 존재한다
			
			ps.setString(1, category);
			ps.setString(2, category);
			ps.setString(3, indate);

			int rs = ps.executeUpdate();
			ps.close();
			return rs;
			
			}catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			
		
	}*/

	@Override
	public int SelectUpdate2(AccountBook ab) {
		try {
		AccountBook new_ab = findById(ab.getCategory());

		String sql = "update accountbook set amount=? where category=? and indate=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		// ?가 있으므로 set 함수가 존재한다
		
		ps.setInt(1, new_ab.getAmount());
		ps.setString(2, new_ab.getCategory());
		ps.setString(3, new_ab.getIndate());

		int rs = ps.executeUpdate();
		ps.close();
		return rs;
		
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
}

