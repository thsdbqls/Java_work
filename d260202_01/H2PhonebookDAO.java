package d260202_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 시나리오 :
// 회사에서 Oracle을 사용하다가 유지비용 문제로 인해 무료 DB인 h2데이터베이스로 변경하려고 함
public class H2PhonebookDAO implements PhonebookDAO {

		Connection conn;
		
		// 오라클 데이터베이스에 접근하기 위한 객체이다.
		public H2PhonebookDAO() {
			try {
				Class.forName("org.h2.Driver");                                             
				String url = "jdbc:h2:tcp://localhost/~/test";
				conn=DriverManager.getConnection(url, "sa", "");
				if(conn==null) {
					System.out.println("DB 연결을 다시 확인하세요.");
					System.out.println("프로그햄을 종료합니다");
				}
			 
			System.out.println("DB연결 성공!!");
			}catch (Exception e) {
			e.printStackTrace();
			}
		
		}


		@Override
		public int insert(Phonebook pb) {
			try {
			// 이것은 미완성 문장이여서 ?에 무엇이 들어갈 지 몰라서 이대로 올려야 한다.
			String sql = "insert into phonebook values(?,?,?,?)";
			// 그래서 이것을 사용하여 미완성 문장을 올릴 수 있다
			PreparedStatement ps = conn.prepareStatement(sql);
			// ?의 갯수 만큼 문장을 완성해 줘야한다
			// ?를 채워줘야 한다
			ps.setInt(1, pb.getId());
			ps.setString(2, pb.getName());
			ps.setString(3, pb.getHp());
			ps.setString(4, pb.getEmail());
			
			// ()안에 작성않애도 된다 그 이유는 사전에 이미 작성해 놨기 때문이다
			// statement는 ()안에 작성해 줘야한다.
			int result = ps.executeUpdate(); // statement 객체와 차이점은 sql을 여기서 실행하는 것이 아니다.
			System.out.println("결과:"+result);
			
			// 자원을 반환해 줘야한다
			ps.close();
			return result;
			}catch (Exception e) {  // 오류가 발생할 때 0을 출력
				e.printStackTrace();
				return 0;
			}
		}

		@Override
		public List<Phonebook> findAll() {
			try {
				String sql = "select * from phonebook";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				// 리턴할 값은 리스트를 이용하여 반환할 것이다.
				// 결과를 이용하여 리스트를 반환할 예정이므로 코드 순서는 다음과 같다.
				// 1) 빈 리스트 만들기
				// 2) 반복문을 통해 한 개의 객체를 Phonebook에 담고 담은 내용을 list에 add한다
				// 3) 반복문이 끝나고 나서 list를 반환한다.
				List<Phonebook> list = new ArrayList<Phonebook>();
				
				while(rs.next()) {
					   // 변수명 = 객체 이름
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String hp = rs.getString("hp");
					String email = rs.getString("email");
					Phonebook pb = new Phonebook(id,name,hp,email);
					list.add(pb);
				}
				rs.close(); ps.close();
				return list;
				
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}

		@Override
		public Phonebook findById(int id) {
			try {
			String sql = "select * from phonebook where id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);   // 입력값이 있으면 그 값이 반드시 여기에 넣어진다.
			ResultSet rs = ps.executeQuery();

			List<Phonebook> list = new ArrayList<Phonebook>();// 빈 리스트 만들기
			
			if(rs.next()) {
				// list에 add한다
				String name=rs.getString("name");
				String hp=rs.getString("hp");
				String email=rs.getString("email");
				Phonebook pb=new Phonebook(id, name, hp, email);
				rs.close();ps.close();
				return pb;
			}
			rs.close(); ps.close();
			// list를 반환한다.
			return null;  // if문이 되면 pb값이 나오지만 그렇지 않으면 값이 안 나오게 하기 위해 null을 사용한다.
			
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}

		@Override
		// 업데이터에서 주의할 사항
		// 기존의 DB값과 함수로 전달되는 pb 값의 차이를 확인해야 한다
		// 수정은 수정할 사항에 대해서만 수정처리하면 된다
		// null값이면 값을 변경할 필요가 없음
		// id를 이요하여 기존의 갑을 가져오고
		// 전달받은 pb값이 null이 아닐경우 값을 변경하여 처리
		
		public int update(Phonebook pb) {
			try {
				
			// 기존의 값에 새로운 값을 교체하는 작업
			Phonebook new_pb = findById(pb.getId());
			
			if(pb.getName()!= null) new_pb.setName(pb.getName());
			if(pb.getHp()!= null) new_pb.setHp(pb.getHp());
			if(pb.getEmail()!= null) new_pb.setName(pb.getEmail());
			
			String sql = "update phonebook set name =?, hp=?, email=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			// ?가 있으므로 set 함수가 존재한다
			
			ps.setString(1, new_pb.getName());
			ps.setString(2, new_pb.getHp());
			ps.setString(3, new_pb.getEmail());
			ps.setInt(4, new_pb.getId());

			int rs = ps.executeUpdate();
			ps.close();
			return rs;
			
			}catch (Exception e) {
				e.printStackTrace();
				return 0;
			}finally {
				
			}
			
		}

		@Override
		public int delete(int id) {
			try {
				String sql = "delete phonebook where id=?";
				PreparedStatement ps = conn.prepareStatement(sql);

				// ?가 있으므로 set 함수가 존재한다
				ps.setInt(1, id);

				int rs = ps.executeUpdate();
				ps.close();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		@Override
		public int delete() {
			try {
				String sql = "delete from phonebook";
				PreparedStatement ps = conn.prepareStatement(sql);

				// ?가 있으므로 set 함수가 존재한다
				int rs = ps.executeUpdate();
				ps.close();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}

		@Override
		public int count() {
			try {
				// 통계함수 count(*)<-필드명 as cnt(별명)
				String sql = "select count(*) as cnt from phonebook";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				List<Phonebook> list = new ArrayList<Phonebook>();// 빈 리스트 만들기
				
				if(rs.next()) {
					int cnt = rs.getInt("cnt");
					rs.close();ps.close();
					return cnt;
				}
				rs.close(); ps.close();
				// list를 반환한다.
				return -1;  // if문이 되면 pb값이 나오지만 그렇지 않으면 값이 안 나오게 하기 위해 null을 사용한다.
				
				}catch (Exception e) {
					e.printStackTrace();
					return -1;
				}
		}

	}
